#
# Autogenerated by Thrift
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#  @generated
#

cimport cython
from cpython.version cimport PY_VERSION_HEX
from libc.stdint cimport (
    int8_t as cint8_t,
    int16_t as cint16_t,
    int32_t as cint32_t,
    int64_t as cint64_t,
)
from libcpp.memory cimport shared_ptr, make_shared, unique_ptr, make_unique
from libcpp.string cimport string
from libcpp cimport bool as cbool
from cpython cimport bool as pbool
from libcpp.vector cimport vector
from libcpp.set cimport set as cset
from libcpp.map cimport map as cmap
from libcpp.utility cimport move as cmove
from cython.operator cimport dereference as deref
from cpython.ref cimport PyObject
from thrift.py3.exceptions cimport (
    cTApplicationException,
    ApplicationError as __ApplicationError,
    cTApplicationExceptionType__UNKNOWN)
from thrift.py3.server cimport ServiceInterface, RequestContext, Cpp2RequestContext
from thrift.py3.server import RequestContext, pass_context
from folly cimport (
  cFollyPromise,
  cFollyUnit,
  c_unit,
)
from thrift.py3.common cimport (
    cThriftServiceContext as __fbthrift_cThriftServiceContext,
    cThriftMetadata as __fbthrift_cThriftMetadata,
    ServiceMetadata,
    extractMetadataFromServiceContext,
    MetadataBox as __MetadataBox,
)

if PY_VERSION_HEX >= 0x030702F0:  # 3.7.2 Final
    from thrift.py3.server cimport THRIFT_REQUEST_CONTEXT as __THRIFT_REQUEST_CONTEXT

cimport folly.futures
from folly.executor cimport get_executor
cimport folly.iobuf as _fbthrift_iobuf
import folly.iobuf as _fbthrift_iobuf
from folly.iobuf cimport move as move_iobuf
from folly.memory cimport to_shared_ptr as __to_shared_ptr

cimport module.types as _module_types
import module.types as _module_types

cimport module.services_reflection as _services_reflection

import asyncio
import functools
import sys
import traceback
import types as _py_types

from module.services_wrapper cimport cMyRootInterface
from module.services_wrapper cimport cMyNodeInterface
from module.services_wrapper cimport cMyLeafInterface



@cython.auto_pickle(False)
cdef class Promise_cFollyUnit:
    cdef cFollyPromise[cFollyUnit] cPromise

    @staticmethod
    cdef create(cFollyPromise[cFollyUnit] cPromise):
        cdef Promise_cFollyUnit inst = Promise_cFollyUnit.__new__(Promise_cFollyUnit)
        inst.cPromise = cmove(cPromise)
        return inst

cdef object _MyRoot_annotations = _py_types.MappingProxyType({
})


@cython.auto_pickle(False)
cdef class MyRootInterface(
    ServiceInterface
):
    annotations = _MyRoot_annotations

    def __cinit__(self):
        self._cpp_obj = cMyRootInterface(
            <PyObject *> self,
            get_executor()
        )

    @staticmethod
    def pass_context_do_root(fn):
        return pass_context(fn)

    async def do_root(
            self):
        raise NotImplementedError("async def do_root is not implemented")

    @classmethod
    def __get_reflection__(cls):
        return _services_reflection.get_reflection__MyRoot(for_clients=False)

    @staticmethod
    def __get_metadata__():
        cdef __fbthrift_cThriftMetadata meta
        cdef __fbthrift_cThriftServiceContext context
        ServiceMetadata[_services_reflection.cMyRootSvIf].gen(meta, context)
        extractMetadataFromServiceContext(meta, context)
        return __MetadataBox.box(cmove(meta))

    @staticmethod
    def __get_thrift_name__():
        return "module.MyRoot"

cdef object _MyNode_annotations = _py_types.MappingProxyType({
})


@cython.auto_pickle(False)
cdef class MyNodeInterface(
MyRootInterface
):
    annotations = _MyNode_annotations

    def __cinit__(self):
        self._cpp_obj = cMyNodeInterface(
            <PyObject *> self,
            get_executor()
        )

    @staticmethod
    def pass_context_do_mid(fn):
        return pass_context(fn)

    async def do_mid(
            self):
        raise NotImplementedError("async def do_mid is not implemented")

    @classmethod
    def __get_reflection__(cls):
        return _services_reflection.get_reflection__MyNode(for_clients=False)

    @staticmethod
    def __get_metadata__():
        cdef __fbthrift_cThriftMetadata meta
        cdef __fbthrift_cThriftServiceContext context
        ServiceMetadata[_services_reflection.cMyNodeSvIf].gen(meta, context)
        extractMetadataFromServiceContext(meta, context)
        return __MetadataBox.box(cmove(meta))

    @staticmethod
    def __get_thrift_name__():
        return "module.MyNode"

cdef object _MyLeaf_annotations = _py_types.MappingProxyType({
})


@cython.auto_pickle(False)
cdef class MyLeafInterface(
MyNodeInterface
):
    annotations = _MyLeaf_annotations

    def __cinit__(self):
        self._cpp_obj = cMyLeafInterface(
            <PyObject *> self,
            get_executor()
        )

    @staticmethod
    def pass_context_do_leaf(fn):
        return pass_context(fn)

    async def do_leaf(
            self):
        raise NotImplementedError("async def do_leaf is not implemented")

    @classmethod
    def __get_reflection__(cls):
        return _services_reflection.get_reflection__MyLeaf(for_clients=False)

    @staticmethod
    def __get_metadata__():
        cdef __fbthrift_cThriftMetadata meta
        cdef __fbthrift_cThriftServiceContext context
        ServiceMetadata[_services_reflection.cMyLeafSvIf].gen(meta, context)
        extractMetadataFromServiceContext(meta, context)
        return __MetadataBox.box(cmove(meta))

    @staticmethod
    def __get_thrift_name__():
        return "module.MyLeaf"



cdef api void call_cy_MyRoot_do_root(
    object self,
    Cpp2RequestContext* ctx,
    cFollyPromise[cFollyUnit] cPromise
):
    cdef Promise_cFollyUnit __promise = Promise_cFollyUnit.create(cmove(cPromise))
    __context = RequestContext.create(ctx)
    if PY_VERSION_HEX >= 0x030702F0:  # 3.7.2 Final
        __context_token = __THRIFT_REQUEST_CONTEXT.set(__context)
        __context = None
    asyncio.get_event_loop().create_task(
        MyRoot_do_root_coro(
            self,
            __context,
            __promise
        )
    )
    if PY_VERSION_HEX >= 0x030702F0:  # 3.7.2 Final
        __THRIFT_REQUEST_CONTEXT.reset(__context_token)

async def MyRoot_do_root_coro(
    object self,
    object ctx,
    Promise_cFollyUnit promise
):
    try:
        if ctx and getattr(self.do_root, "pass_context", False):
            result = await self.do_root(ctx,)
        else:
            result = await self.do_root()
    except __ApplicationError as ex:
        # If the handler raised an ApplicationError convert it to a C++ one
        promise.cPromise.setException(cTApplicationException(
            ex.type.value, ex.message.encode('UTF-8')
        ))
    except Exception as ex:
        print(
            "Unexpected error in service handler do_root:",
            file=sys.stderr)
        traceback.print_exc()
        promise.cPromise.setException(cTApplicationException(
            cTApplicationExceptionType__UNKNOWN, repr(ex).encode('UTF-8')
        ))
    else:
        promise.cPromise.setValue(c_unit)

cdef api void call_cy_MyNode_do_mid(
    object self,
    Cpp2RequestContext* ctx,
    cFollyPromise[cFollyUnit] cPromise
):
    cdef Promise_cFollyUnit __promise = Promise_cFollyUnit.create(cmove(cPromise))
    __context = RequestContext.create(ctx)
    if PY_VERSION_HEX >= 0x030702F0:  # 3.7.2 Final
        __context_token = __THRIFT_REQUEST_CONTEXT.set(__context)
        __context = None
    asyncio.get_event_loop().create_task(
        MyNode_do_mid_coro(
            self,
            __context,
            __promise
        )
    )
    if PY_VERSION_HEX >= 0x030702F0:  # 3.7.2 Final
        __THRIFT_REQUEST_CONTEXT.reset(__context_token)

async def MyNode_do_mid_coro(
    object self,
    object ctx,
    Promise_cFollyUnit promise
):
    try:
        if ctx and getattr(self.do_mid, "pass_context", False):
            result = await self.do_mid(ctx,)
        else:
            result = await self.do_mid()
    except __ApplicationError as ex:
        # If the handler raised an ApplicationError convert it to a C++ one
        promise.cPromise.setException(cTApplicationException(
            ex.type.value, ex.message.encode('UTF-8')
        ))
    except Exception as ex:
        print(
            "Unexpected error in service handler do_mid:",
            file=sys.stderr)
        traceback.print_exc()
        promise.cPromise.setException(cTApplicationException(
            cTApplicationExceptionType__UNKNOWN, repr(ex).encode('UTF-8')
        ))
    else:
        promise.cPromise.setValue(c_unit)

cdef api void call_cy_MyLeaf_do_leaf(
    object self,
    Cpp2RequestContext* ctx,
    cFollyPromise[cFollyUnit] cPromise
):
    cdef Promise_cFollyUnit __promise = Promise_cFollyUnit.create(cmove(cPromise))
    __context = RequestContext.create(ctx)
    if PY_VERSION_HEX >= 0x030702F0:  # 3.7.2 Final
        __context_token = __THRIFT_REQUEST_CONTEXT.set(__context)
        __context = None
    asyncio.get_event_loop().create_task(
        MyLeaf_do_leaf_coro(
            self,
            __context,
            __promise
        )
    )
    if PY_VERSION_HEX >= 0x030702F0:  # 3.7.2 Final
        __THRIFT_REQUEST_CONTEXT.reset(__context_token)

async def MyLeaf_do_leaf_coro(
    object self,
    object ctx,
    Promise_cFollyUnit promise
):
    try:
        if ctx and getattr(self.do_leaf, "pass_context", False):
            result = await self.do_leaf(ctx,)
        else:
            result = await self.do_leaf()
    except __ApplicationError as ex:
        # If the handler raised an ApplicationError convert it to a C++ one
        promise.cPromise.setException(cTApplicationException(
            ex.type.value, ex.message.encode('UTF-8')
        ))
    except Exception as ex:
        print(
            "Unexpected error in service handler do_leaf:",
            file=sys.stderr)
        traceback.print_exc()
        promise.cPromise.setException(cTApplicationException(
            cTApplicationExceptionType__UNKNOWN, repr(ex).encode('UTF-8')
        ))
    else:
        promise.cPromise.setValue(c_unit)

