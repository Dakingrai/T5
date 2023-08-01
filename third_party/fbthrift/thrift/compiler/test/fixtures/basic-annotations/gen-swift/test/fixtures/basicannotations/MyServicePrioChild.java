/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package test.fixtures.basicannotations;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.facebook.swift.transport.client.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@SwiftGenerated
@com.facebook.swift.service.ThriftService("MyServicePrioChild")
public interface MyServicePrioChild extends java.io.Closeable, test.fixtures.basicannotations.MyServicePrioParent {
    @com.facebook.swift.service.ThriftService("MyServicePrioChild")
    public interface Async extends java.io.Closeable, test.fixtures.basicannotations.MyServicePrioParent.Async {
        @java.lang.Override void close();

        @ThriftMethod(value = "pang")
        ListenableFuture<Void> pang();

        default ListenableFuture<Void> pang(
            RpcOptions rpcOptions) {
            throw new UnsupportedOperationException();
        }

        default ListenableFuture<ResponseWrapper<Void>> pangWrapper(
            RpcOptions rpcOptions) {
            throw new UnsupportedOperationException();
        }
    }
    @java.lang.Override void close();

    @ThriftMethod(value = "pang")
    void pang() throws org.apache.thrift.TException;

    default void pang(
        RpcOptions rpcOptions) throws org.apache.thrift.TException {
        throw new UnsupportedOperationException();
    }

    default ResponseWrapper<Void> pangWrapper(
        RpcOptions rpcOptions) throws org.apache.thrift.TException {
        throw new UnsupportedOperationException();
    }

    @com.facebook.swift.service.ThriftService("MyServicePrioChild")
    interface Reactive extends reactor.core.Disposable, test.fixtures.basicannotations.MyServicePrioParent.Reactive {
        @ThriftMethod(value = "pang")
        reactor.core.publisher.Mono<Void> pang();

        default reactor.core.publisher.Mono<Void> pang(RpcOptions rpcOptions) {
            throw new UnsupportedOperationException();
        }

        default reactor.core.publisher.Mono<ResponseWrapper<Void>> pangWrapper(RpcOptions rpcOptions) {
            throw new UnsupportedOperationException();
        }

    }
}
