#
# Autogenerated by Thrift
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#  @generated
#
from cpython cimport bool as pbool, int as pint, float as pfloat

cimport folly.iobuf as _fbthrift_iobuf

cimport thrift.py3.builder


cimport module.types as _module_types

cdef class MyStruct_Builder(thrift.py3.builder.StructBuilder):
    cdef public pint MyIntField
    cdef public str MyStringField
    cdef public object MyDataField
    cdef public _module_types.MyEnum myEnum
    cdef public pbool oneway
    cdef public pbool readonly
    cdef public pbool idempotent


cdef class MyDataItem_Builder(thrift.py3.builder.StructBuilder):
    pass


cdef class MyUnion_Builder(thrift.py3.builder.StructBuilder):
    cdef public _module_types.MyEnum myEnum
    cdef public object myStruct
    cdef public object myDataItem


