/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package test.fixtures.inheritance;

import java.util.*;

public class MyLeafBlockingReactiveWrapper  extends test.fixtures.inheritance.MyNodeBlockingReactiveWrapper
    implements MyLeaf.Reactive {
    private final MyLeaf _delegate;
    private final reactor.core.scheduler.Scheduler _scheduler;

    public MyLeafBlockingReactiveWrapper(MyLeaf _delegate, reactor.core.scheduler.Scheduler _scheduler) {
        super(_delegate, _scheduler);
        this._delegate = _delegate;
        this._scheduler = _scheduler;
    }

    @java.lang.Override
    public void dispose() {
        _delegate.close();
    }

    @java.lang.Override
    public reactor.core.publisher.Mono<Void> doLeaf() {
        return reactor.core.publisher.Mono.<Void>fromRunnable(() -> {
                try {
                    _delegate.doLeaf();
                } catch (Throwable _e) {
                    throw reactor.core.Exceptions.propagate(_e);
                }
            }).subscribeOn(_scheduler);
    }

}