/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package test.fixtures.enumstrict;


import com.facebook.thrift.IntRangeSet;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({ "unused" })
public enum MyBigEnum implements com.facebook.thrift.TEnum {
  UNKNOWN(0),
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  ELEVEN(11),
  TWELVE(12),
  THIRTEEN(13),
  FOURTEEN(14),
  FIFTEEN(15),
  SIXTEEN(16),
  SEVENTEEN(17),
  EIGHTEEN(18),
  NINETEEN(19);

  private static final Map<Integer, MyBigEnum> INDEXED_VALUES = new HashMap<Integer, MyBigEnum>();

  static {
    for (MyBigEnum e: values()) {
      INDEXED_VALUES.put(e.getValue(), e);
    }
  }

  private final int value;

  private MyBigEnum(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static MyBigEnum findByValue(int value) { 
    return INDEXED_VALUES.get(value);
  }
}
