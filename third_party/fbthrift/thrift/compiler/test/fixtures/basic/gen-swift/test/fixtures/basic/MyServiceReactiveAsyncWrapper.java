/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package test.fixtures.basic;

import java.util.*;

public class MyServiceReactiveAsyncWrapper 
  implements MyService.Async {
  private MyService.Reactive _delegate;

  public MyServiceReactiveAsyncWrapper(MyService.Reactive _delegate) {
    
    this._delegate = _delegate;
  }

  public MyServiceReactiveAsyncWrapper(org.apache.thrift.ProtocolId _protocolId, reactor.core.publisher.Mono<? extends com.facebook.swift.transport.client.RpcClient> _rpcClient, Map<String, String> _headers, Map<String, String> _persistentHeaders) {
    this(new MyServiceReactiveClient(_protocolId, _rpcClient, _headers, _persistentHeaders));
  }

  @java.lang.Override
  public void close() {
    _delegate.dispose();
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> ping() {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.ping());
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> ping(
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.ping( rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<Void>> pingWrapper(
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.pingWrapper( rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<String> getRandomData() {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.getRandomData());
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<String> getRandomData(
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.getRandomData( rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<String>> getRandomDataWrapper(
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.getRandomDataWrapper( rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> sink(final long sink) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.sink(sink));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> sink(
    final long sink,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.sink(sink, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<Void>> sinkWrapper(
    final long sink,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.sinkWrapper(sink, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> putDataById(final long id, final String data) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.putDataById(id, data));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> putDataById(
    final long id,
    final String data,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.putDataById(id,data, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<Void>> putDataByIdWrapper(
    final long id,
    final String data,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.putDataByIdWrapper(id,data, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Boolean> hasDataById(final long id) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.hasDataById(id));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Boolean> hasDataById(
    final long id,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.hasDataById(id, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<Boolean>> hasDataByIdWrapper(
    final long id,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.hasDataByIdWrapper(id, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<String> getDataById(final long id) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.getDataById(id));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<String> getDataById(
    final long id,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.getDataById(id, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<String>> getDataByIdWrapper(
    final long id,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.getDataByIdWrapper(id, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> deleteDataById(final long id) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.deleteDataById(id));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> deleteDataById(
    final long id,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.deleteDataById(id, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<Void>> deleteDataByIdWrapper(
    final long id,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.deleteDataByIdWrapper(id, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> lobDataById(final long id, final String data) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.lobDataById(id, data));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<Void> lobDataById(
    final long id,
    final String data,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
      return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.lobDataById(id,data, rpcOptions));
  }

  @java.lang.Override
  public com.google.common.util.concurrent.ListenableFuture<com.facebook.swift.transport.client.ResponseWrapper<Void>> lobDataByIdWrapper(
    final long id,
    final String data,
    com.facebook.swift.transport.client.RpcOptions rpcOptions) {
    return com.facebook.swift.transport.util.FutureUtil.toListenableFuture(_delegate.lobDataByIdWrapper(id,data, rpcOptions));
  }

}
