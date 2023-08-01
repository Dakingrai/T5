/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include <algorithm>
#include <limits>
#include <numeric>
#include <random>
#include <vector>

#include <folly/Benchmark.h>
#include <folly/experimental/EliasFanoCoding.h>
#include <folly/experimental/Select64.h>
#include <folly/experimental/test/CodingTestUtils.h>
#include <folly/init/Init.h>

using namespace folly::compression;

namespace {

uint8_t slowDefaultNumLowerBits(size_t upperBound, size_t size) {
  if (size == 0 || upperBound < size) {
    return 0;
  }
  // floor(log(upperBound / size));
  return uint8_t(folly::findLastSet(upperBound / size) - 1);
}

} // namespace

TEST(EliasFanoCoding, defaultNumLowerBits) {
  // Verify that slowDefaultNumLowerBits and optimized
  // Encoder::defaultNumLowerBits agree.
  static constexpr size_t kNumIterations = 750;
  auto compare = [](size_t upperBound, size_t size) {
    using Encoder = EliasFanoEncoderV2<size_t>;
    EXPECT_EQ(
        int(slowDefaultNumLowerBits(upperBound, size)),
        int(Encoder::defaultNumLowerBits(upperBound, size)))
        << upperBound << " " << size;
  };
  auto batch = [&compare](size_t initialUpperBound) {
    for (size_t upperBound = initialUpperBound, i = 0; i < kNumIterations;
         ++i, --upperBound) {
      // Test "size" values close to "upperBound".
      for (size_t size = upperBound, j = 0; j < kNumIterations; ++j, --size) {
        compare(upperBound, size);
      }
      // Sample "size" values between [0, upperBound].
      for (size_t size = upperBound; size > 1 + upperBound / kNumIterations;
           size -= 1 + upperBound / kNumIterations) {
        compare(upperBound, size);
      }
      // Test "size" values close to 0.
      for (size_t size = 0; size < kNumIterations; ++size) {
        compare(upperBound, size);
      }
    }
  };
  batch(std::numeric_limits<size_t>::max());
  batch(kNumIterations + 1312213123);
  batch(kNumIterations);

  std::mt19937 gen;
  std::uniform_int_distribution<size_t> distribution;
  for (size_t i = 0; i < kNumIterations; ++i) {
    const auto a = distribution(gen);
    const auto b = distribution(gen);
    compare(std::max(a, b), std::min(a, b));
  }
}

class EliasFanoCodingTest : public ::testing::Test {
 public:
  void doTestEmpty() {
    typedef EliasFanoEncoderV2<uint32_t, size_t> Encoder;
    typedef EliasFanoReader<Encoder> Reader;
    testEmpty<Reader, Encoder>();
  }

  template <
      size_t kSkipQuantum,
      size_t kForwardQuantum,
      typename ValueType,
      typename SkipValueType,
      bool kUpperFirst>
  void doTest() {
    typedef EliasFanoEncoderV2<
        ValueType,
        SkipValueType,
        kSkipQuantum,
        kForwardQuantum,
        kUpperFirst>
        Encoder;
    using Reader = EliasFanoReader<Encoder, instructions::Default, false>;
    testAll<Reader, Encoder>({0});
    testAll<Reader, Encoder>(generateRandomList(100 * 1000, 10 * 1000 * 1000));
    testAll<Reader, Encoder>(generateRandomList(
        100 * 1000, 10 * 1000 * 1000, /* withDuplicates */ true));
    testAll<Reader, Encoder>(generateSeqList(1, 100000, 100));
    // max() cannot be read, as it is assumed an invalid value.
    // TODO(ott): It should be possible to lift this constraint.
    testAll<Reader, Encoder>({0, 1, std::numeric_limits<uint32_t>::max() - 1});
  }

  template <size_t kSkipQuantum, size_t kForwardQuantum, typename ValueType>
  void doTestAll() {
    // Note: SkipValue of uint8/16 aren't well-supported. For now we only test
    // ValueType for uint32/64.
    static_assert(
        std::is_same<ValueType, uint32_t>::value ||
        std::is_same<ValueType, uint64_t>::value);
    // TODO(ott): improve test coverage for SkipValue of uint8/16 once such
    // types are well supported.
    doTest<kSkipQuantum, kForwardQuantum, ValueType, uint32_t, true>();
    doTest<kSkipQuantum, kForwardQuantum, ValueType, uint32_t, false>();
    doTest<kSkipQuantum, kForwardQuantum, ValueType, uint64_t, true>();
    doTest<kSkipQuantum, kForwardQuantum, ValueType, uint64_t, false>();
  }
};

TEST_F(EliasFanoCodingTest, Empty) {
  doTestEmpty();
}

TEST_F(EliasFanoCodingTest, Simple) {
  doTestAll<0, 0, uint32_t>();
  doTestAll<0, 0, uint64_t>();
}

TEST_F(EliasFanoCodingTest, SkipPointers) {
  doTestAll<128, 0, uint32_t>();
  doTestAll<128, 0, uint64_t>();
}

TEST_F(EliasFanoCodingTest, ForwardPointers) {
  doTestAll<0, 128, uint32_t>();
  doTestAll<0, 128, uint64_t>();
}

TEST_F(EliasFanoCodingTest, SkipForwardPointers) {
  doTestAll<128, 128, uint32_t>();
  doTestAll<128, 128, uint64_t>();
}

TEST_F(EliasFanoCodingTest, BugLargeGapInUpperBits) { // t16274876
  typedef EliasFanoEncoderV2<uint32_t, uint32_t, 2, 2> Encoder;
  typedef EliasFanoReader<Encoder, instructions::Default> Reader;
  constexpr uint32_t kLargeValue = 127;

  // Build a list where the upper bits have a large gap after the
  // first element, so that we need to reposition in the upper bits
  // using skips to position the iterator on the second element.
  std::vector<uint32_t> data = {0, kLargeValue};
  for (uint32_t i = 0; i < kLargeValue; ++i) {
    data.push_back(data.back() + 1);
  }
  auto list = Encoder::encode(data.begin(), data.end());

  {
    Reader reader(list);
    ASSERT_TRUE(reader.skipTo(kLargeValue - 1));
    ASSERT_EQ(kLargeValue, reader.value());
    ASSERT_EQ(0, reader.previousValue());
  }

  list.free();
}

namespace bm {

typedef EliasFanoEncoderV2<uint32_t, uint32_t, 128, 128> Encoder;

std::vector<uint64_t> data;
std::vector<size_t> order;

std::vector<uint64_t> encodeSmallData;
std::vector<uint64_t> encodeLargeData;

std::vector<std::pair<size_t, size_t>> numLowerBitsInput;

typename Encoder::MutableCompressedList list;

void init() {
  std::mt19937 gen;

  data = generateRandomList(100 * 1000, 10 * 1000 * 1000, gen);
  list = Encoder::encode(data.begin(), data.end());

  order.resize(data.size());
  std::iota(order.begin(), order.end(), size_t());
  std::shuffle(order.begin(), order.end(), gen);

  encodeSmallData = generateRandomList(10, 100 * 1000, gen);
  encodeLargeData = generateRandomList(1000 * 1000, 100 * 1000 * 1000, gen);

  std::uniform_int_distribution<size_t> distribution;
  for (size_t i = 0; i < 10000; ++i) {
    const auto a = distribution(gen);
    const auto b = distribution(gen);
    numLowerBitsInput.emplace_back(std::max(a, b), std::min(a, b));
  }
}

void free() {
  list.free();
}

} // namespace bm

BENCHMARK(Next, iters) {
  dispatchInstructions([&](auto instructions) {
    bmNext<EliasFanoReader<bm::Encoder, decltype(instructions)>>(
        bm::list, bm::data, iters);
  });
}

size_t Skip_ForwardQ128(size_t iters, size_t logAvgSkip) {
  dispatchInstructions([&](auto instructions) {
    bmSkip<EliasFanoReader<bm::Encoder, decltype(instructions)>>(
        bm::list, bm::data, logAvgSkip, iters);
  });
  return iters;
}

BENCHMARK_NAMED_PARAM_MULTI(Skip_ForwardQ128, 1, 0)
BENCHMARK_NAMED_PARAM_MULTI(Skip_ForwardQ128, 2, 1)
BENCHMARK_NAMED_PARAM_MULTI(Skip_ForwardQ128, 4_pm_1, 2)
BENCHMARK_NAMED_PARAM_MULTI(Skip_ForwardQ128, 16_pm_4, 4)
BENCHMARK_NAMED_PARAM_MULTI(Skip_ForwardQ128, 64_pm_16, 6)
BENCHMARK_NAMED_PARAM_MULTI(Skip_ForwardQ128, 256_pm_64, 8)
BENCHMARK_NAMED_PARAM_MULTI(Skip_ForwardQ128, 1024_pm_256, 10)

BENCHMARK(Jump_ForwardQ128, iters) {
  dispatchInstructions([&](auto instructions) {
    bmJump<EliasFanoReader<bm::Encoder, decltype(instructions)>>(
        bm::list, bm::data, bm::order, iters);
  });
}

BENCHMARK_DRAW_LINE();

size_t SkipTo_SkipQ128(size_t iters, size_t logAvgSkip) {
  dispatchInstructions([&](auto instructions) {
    bmSkipTo<EliasFanoReader<bm::Encoder, decltype(instructions)>>(
        bm::list, bm::data, logAvgSkip, iters);
  });
  return iters;
}

BENCHMARK_NAMED_PARAM_MULTI(SkipTo_SkipQ128, 1, 0)
BENCHMARK_NAMED_PARAM_MULTI(SkipTo_SkipQ128, 2, 1)
BENCHMARK_NAMED_PARAM_MULTI(SkipTo_SkipQ128, 4_pm_1, 2)
BENCHMARK_NAMED_PARAM_MULTI(SkipTo_SkipQ128, 16_pm_4, 4)
BENCHMARK_NAMED_PARAM_MULTI(SkipTo_SkipQ128, 64_pm_16, 6)
BENCHMARK_NAMED_PARAM_MULTI(SkipTo_SkipQ128, 256_pm_64, 8)
BENCHMARK_NAMED_PARAM_MULTI(SkipTo_SkipQ128, 1024_pm_256, 10)

BENCHMARK(JumpTo_SkipQ128, iters) {
  dispatchInstructions([&](auto instructions) {
    bmJumpTo<EliasFanoReader<bm::Encoder, decltype(instructions)>>(
        bm::list, bm::data, bm::order, iters);
  });
}

BENCHMARK_DRAW_LINE();

BENCHMARK(Encode_10) {
  auto list = bm::Encoder::encode(
      bm::encodeSmallData.begin(), bm::encodeSmallData.end());
  list.free();
}

BENCHMARK(Encode) {
  auto list = bm::Encoder::encode(
      bm::encodeLargeData.begin(), bm::encodeLargeData.end());
  list.free();
}

BENCHMARK_DRAW_LINE();

BENCHMARK(defaultNumLowerBits, iters) {
  using Encoder = EliasFanoEncoderV2<size_t>;

  size_t i = 0;
  while (iters--) {
    const auto& p = bm::numLowerBitsInput[i];
    folly::doNotOptimizeAway(Encoder::defaultNumLowerBits(p.first, p.second));
    if (++i == bm::numLowerBitsInput.size()) {
      i = 0;
    }
  }
}

BENCHMARK(slowDefaultNumLowerBits, iters) {
  size_t i = 0;
  while (iters--) {
    const auto& p = bm::numLowerBitsInput[i];
    folly::doNotOptimizeAway(slowDefaultNumLowerBits(p.first, p.second));
    if (++i == bm::numLowerBitsInput.size()) {
      i = 0;
    }
  }
}

#if 0
// Intel(R) Xeon(R) CPU E5-2678 v3 @ 2.50GHz, Clang 8.0.
// $ eliasfano_test --benchmark --bm_min_usec 200000
============================================================================
folly/experimental/test/EliasFanoCodingTest.cpp relative  time/iter  iters/s
============================================================================
Next                                                         2.58ns  388.22M
Skip_ForwardQ128(1)                                          4.81ns  207.72M
Skip_ForwardQ128(2)                                          5.96ns  167.75M
Skip_ForwardQ128(4_pm_1)                                     7.40ns  135.16M
Skip_ForwardQ128(16_pm_4)                                    8.20ns  121.97M
Skip_ForwardQ128(64_pm_16)                                  12.04ns   83.06M
Skip_ForwardQ128(256_pm_64)                                 16.84ns   59.39M
Skip_ForwardQ128(1024_pm_256)                               17.67ns   56.61M
Jump_ForwardQ128                                            25.37ns   39.41M
----------------------------------------------------------------------------
SkipTo_SkipQ128(1)                                           7.27ns  137.59M
SkipTo_SkipQ128(2)                                          10.99ns   91.01M
SkipTo_SkipQ128(4_pm_1)                                     13.53ns   73.93M
SkipTo_SkipQ128(16_pm_4)                                    20.58ns   48.59M
SkipTo_SkipQ128(64_pm_16)                                   32.08ns   31.18M
SkipTo_SkipQ128(256_pm_64)                                  38.66ns   25.87M
SkipTo_SkipQ128(1024_pm_256)                                42.32ns   23.63M
JumpTo_SkipQ128                                             47.95ns   20.86M
----------------------------------------------------------------------------
Encode_10                                                  103.99ns    9.62M
Encode                                                       7.60ms   131.53
----------------------------------------------------------------------------
defaultNumLowerBits                                          3.59ns  278.69M
slowDefaultNumLowerBits                                     10.88ns   91.90M
============================================================================
#endif

int main(int argc, char** argv) {
  testing::InitGoogleTest(&argc, argv);
  folly::init(&argc, &argv);
  gflags::ParseCommandLineFlags(&argc, &argv, true);

  auto ret = RUN_ALL_TESTS();
  if (ret == 0 && FLAGS_benchmark) {
    bm::init();
    folly::runBenchmarks();
    bm::free();
  }

  return ret;
}
