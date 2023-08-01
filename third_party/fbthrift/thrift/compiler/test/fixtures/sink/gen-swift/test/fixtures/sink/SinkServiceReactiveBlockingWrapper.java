/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package test.fixtures.sink;

import java.util.*;

public class SinkServiceReactiveBlockingWrapper 
  implements SinkService {
  private final SinkService.Reactive _delegate;

  public SinkServiceReactiveBlockingWrapper(SinkService.Reactive _delegate) {
    
    this._delegate = _delegate;
  }

  public SinkServiceReactiveBlockingWrapper(org.apache.thrift.ProtocolId _protocolId, reactor.core.publisher.Mono<? extends com.facebook.swift.transport.client.RpcClient> _rpcClient, Map<String, String> _headers, Map<String, String> _persistentHeaders) {
    this(new SinkServiceReactiveClient(_protocolId, _rpcClient, _headers, _persistentHeaders));
  }

  @java.lang.Override
  public void close() {
    _delegate.dispose();
  }


}