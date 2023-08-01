#
# Autogenerated by Thrift
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#  @generated
#
cdef class Empty_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.Empty

    def __iter__(self):
        pass

cdef class ASimpleStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.ASimpleStruct

    def __iter__(self):
        yield "boolField", self.boolField

cdef class ASimpleStructNoexcept_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.ASimpleStructNoexcept

    def __iter__(self):
        yield "boolField", self.boolField

cdef class MyStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.MyStruct

    def __iter__(self):
        yield "MyBoolField", self.MyBoolField
        yield "MyIntField", self.MyIntField
        yield "MyStringField", self.MyStringField
        yield "MyStringField2", self.MyStringField2
        yield "MyBinaryField", self.MyBinaryField
        yield "MyBinaryField2", self.MyBinaryField2
        yield "MyBinaryField3", self.MyBinaryField3
        yield "MyBinaryListField4", self.MyBinaryListField4
        yield "MyMapEnumAndInt", self.MyMapEnumAndInt

cdef class SimpleUnion_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.SimpleUnion

    def __iter__(self):
        yield "intValue", self.intValue
        yield "stringValue", self.stringValue

cdef class ComplexUnion_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.ComplexUnion

    def __iter__(self):
        yield "intValue", self.intValue
        yield "opt_intValue", self.opt_intValue
        yield "stringValue", self.stringValue
        yield "opt_stringValue", self.opt_stringValue
        yield "intValue2", self.intValue2
        yield "intValue3", self.intValue3
        yield "doubelValue", self.doubelValue
        yield "boolValue", self.boolValue
        yield "union_list", self.union_list
        yield "union_set", self.union_set
        yield "union_map", self.union_map
        yield "opt_union_map", self.opt_union_map
        yield "enum_field", self.enum_field
        yield "enum_container", self.enum_container
        yield "a_struct", self.a_struct
        yield "a_set_struct", self.a_set_struct
        yield "a_union", self.a_union
        yield "opt_a_union", self.opt_a_union
        yield "a_union_list", self.a_union_list
        yield "a_union_typedef", self.a_union_typedef
        yield "a_union_typedef_list", self.a_union_typedef_list
        yield "MyBinaryField", self.MyBinaryField
        yield "MyBinaryField2", self.MyBinaryField2
        yield "MyBinaryListField4", self.MyBinaryListField4
        yield "ref_field", self.ref_field
        yield "ref_field2", self.ref_field2
        yield "excp_field", self.excp_field

cdef class AnException_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.AnException

    def __iter__(self):
        yield "code", self.code
        yield "req_code", self.req_code
        yield "message2", self.message2
        yield "req_message", self.req_message
        yield "exception_list", self.exception_list
        yield "exception_set", self.exception_set
        yield "exception_map", self.exception_map
        yield "req_exception_map", self.req_exception_map
        yield "enum_field", self.enum_field
        yield "enum_container", self.enum_container
        yield "a_struct", self.a_struct
        yield "a_set_struct", self.a_set_struct
        yield "a_union_list", self.a_union_list
        yield "union_typedef", self.union_typedef
        yield "a_union_typedef_list", self.a_union_typedef_list

cdef class AnotherException_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.AnotherException

    def __iter__(self):
        yield "code", self.code
        yield "req_code", self.req_code
        yield "message", self.message

cdef class containerStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.containerStruct

    def __iter__(self):
        yield "fieldA", self.fieldA
        yield "req_fieldA", self.req_fieldA
        yield "opt_fieldA", self.opt_fieldA
        yield "fieldB", self.fieldB
        yield "req_fieldB", self.req_fieldB
        yield "opt_fieldB", self.opt_fieldB
        yield "fieldC", self.fieldC
        yield "req_fieldC", self.req_fieldC
        yield "opt_fieldC", self.opt_fieldC
        yield "fieldD", self.fieldD
        yield "fieldE", self.fieldE
        yield "req_fieldE", self.req_fieldE
        yield "opt_fieldE", self.opt_fieldE
        yield "fieldF", self.fieldF
        yield "fieldG", self.fieldG
        yield "fieldH", self.fieldH
        yield "fieldI", self.fieldI
        yield "fieldJ", self.fieldJ
        yield "fieldK", self.fieldK
        yield "fieldL", self.fieldL
        yield "fieldM", self.fieldM
        yield "fieldN", self.fieldN
        yield "fieldO", self.fieldO
        yield "fieldP", self.fieldP
        yield "fieldQ", self.fieldQ
        yield "fieldR", self.fieldR
        yield "req_fieldR", self.req_fieldR
        yield "opt_fieldR", self.opt_fieldR
        yield "fieldS", self.fieldS
        yield "fieldT", self.fieldT
        yield "fieldU", self.fieldU
        yield "fieldV", self.fieldV
        yield "req_fieldV", self.req_fieldV
        yield "opt_fieldV", self.opt_fieldV
        yield "fieldW", self.fieldW
        yield "fieldX", self.fieldX
        yield "req_fieldX", self.req_fieldX
        yield "opt_fieldX", self.opt_fieldX
        yield "fieldY", self.fieldY
        yield "fieldZ", self.fieldZ
        yield "fieldAA", self.fieldAA
        yield "fieldAB", self.fieldAB
        yield "fieldAC", self.fieldAC
        yield "fieldAD", self.fieldAD
        yield "fieldAE", self.fieldAE
        yield "fieldSD", self.fieldSD

cdef class MyIncludedStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.MyIncludedStruct

    def __iter__(self):
        yield "MyIncludedInt", self.MyIncludedInt
        yield "MyIncludedStruct", self.MyIncludedStruct
        yield "ARefField", self.ARefField
        yield "ARequiredField", self.ARequiredField

cdef class AnnotatedStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.AnnotatedStruct

    def __iter__(self):
        yield "no_annotation", self.no_annotation
        yield "cpp_unique_ref", self.cpp_unique_ref
        yield "cpp2_unique_ref", self.cpp2_unique_ref
        yield "container_with_ref", self.container_with_ref
        yield "req_cpp_unique_ref", self.req_cpp_unique_ref
        yield "req_cpp2_unique_ref", self.req_cpp2_unique_ref
        yield "req_container_with_ref", self.req_container_with_ref
        yield "opt_cpp_unique_ref", self.opt_cpp_unique_ref
        yield "opt_cpp2_unique_ref", self.opt_cpp2_unique_ref
        yield "opt_container_with_ref", self.opt_container_with_ref
        yield "ref_type_unique", self.ref_type_unique
        yield "ref_type_shared", self.ref_type_shared
        yield "ref_type_const", self.ref_type_const
        yield "req_ref_type_shared", self.req_ref_type_shared
        yield "req_ref_type_const", self.req_ref_type_const
        yield "req_ref_type_unique", self.req_ref_type_unique
        yield "opt_ref_type_const", self.opt_ref_type_const
        yield "opt_ref_type_unique", self.opt_ref_type_unique
        yield "opt_ref_type_shared", self.opt_ref_type_shared
        yield "base_type", self.base_type
        yield "list_type", self.list_type
        yield "set_type", self.set_type
        yield "map_type", self.map_type
        yield "map_struct_type", self.map_struct_type
        yield "iobuf_type", self.iobuf_type
        yield "iobuf_ptr", self.iobuf_ptr
        yield "list_i32_template", self.list_i32_template
        yield "list_string_template", self.list_string_template
        yield "set_template", self.set_template
        yield "map_template", self.map_template
        yield "typedef_list_template", self.typedef_list_template
        yield "typedef_deque_template", self.typedef_deque_template
        yield "typedef_set_template", self.typedef_set_template
        yield "typedef_map_template", self.typedef_map_template
        yield "indirection_a", self.indirection_a
        yield "indirection_b", self.indirection_b
        yield "indirection_c", self.indirection_c
        yield "iobuf_type_val", self.iobuf_type_val
        yield "iobuf_ptr_val", self.iobuf_ptr_val
        yield "struct_struct", self.struct_struct

cdef class ComplexContainerStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.ComplexContainerStruct

    def __iter__(self):
        yield "map_of_iobufs", self.map_of_iobufs
        yield "map_of_iobuf_ptrs", self.map_of_iobuf_ptrs

cdef class FloatStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.FloatStruct

    def __iter__(self):
        yield "floatField", self.floatField
        yield "doubleField", self.doubleField

cdef class FloatUnion_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.FloatUnion

    def __iter__(self):
        yield "floatSide", self.floatSide
        yield "doubleSide", self.doubleSide

cdef class AllRequiredNoExceptMoveCtrStruct_Builder(thrift.py3.builder.StructBuilder):
    _struct_type = _module_types.AllRequiredNoExceptMoveCtrStruct

    def __iter__(self):
        yield "intField", self.intField
