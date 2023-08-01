/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package test.fixtures.adapter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import com.facebook.thrift.*;
import com.facebook.thrift.annotations.*;
import com.facebook.thrift.async.*;
import com.facebook.thrift.meta_data.*;
import com.facebook.thrift.server.*;
import com.facebook.thrift.transport.*;
import com.facebook.thrift.protocol.*;

@SuppressWarnings({ "unused", "serial" })
public class Bar implements TBase, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Bar");
  private static final TField STRUCT_FIELD_FIELD_DESC = new TField("structField", TType.STRUCT, (short)1);
  private static final TField OPTIONAL_STRUCT_FIELD_FIELD_DESC = new TField("optionalStructField", TType.STRUCT, (short)2);
  private static final TField STRUCT_LIST_FIELD_FIELD_DESC = new TField("structListField", TType.LIST, (short)3);
  private static final TField OPTIONAL_STRUCT_LIST_FIELD_FIELD_DESC = new TField("optionalStructListField", TType.LIST, (short)4);

  public final Foo structField;
  public final Foo optionalStructField;
  public final List<Foo> structListField;
  public final List<Foo> optionalStructListField;
  public static final int STRUCTFIELD = 1;
  public static final int OPTIONALSTRUCTFIELD = 2;
  public static final int STRUCTLISTFIELD = 3;
  public static final int OPTIONALSTRUCTLISTFIELD = 4;

  public Bar(
      Foo structField,
      Foo optionalStructField,
      List<Foo> structListField,
      List<Foo> optionalStructListField) {
    this.structField = structField;
    this.optionalStructField = optionalStructField;
    this.structListField = structListField;
    this.optionalStructListField = optionalStructListField;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Bar(Bar other) {
    if (other.isSetStructField()) {
      this.structField = TBaseHelper.deepCopy(other.structField);
    } else {
      this.structField = null;
    }
    if (other.isSetOptionalStructField()) {
      this.optionalStructField = TBaseHelper.deepCopy(other.optionalStructField);
    } else {
      this.optionalStructField = null;
    }
    if (other.isSetStructListField()) {
      this.structListField = TBaseHelper.deepCopy(other.structListField);
    } else {
      this.structListField = null;
    }
    if (other.isSetOptionalStructListField()) {
      this.optionalStructListField = TBaseHelper.deepCopy(other.optionalStructListField);
    } else {
      this.optionalStructListField = null;
    }
  }

  public Bar deepCopy() {
    return new Bar(this);
  }

  public Foo getStructField() {
    return this.structField;
  }

  // Returns true if field structField is set (has been assigned a value) and false otherwise
  public boolean isSetStructField() {
    return this.structField != null;
  }

  public Foo getOptionalStructField() {
    return this.optionalStructField;
  }

  // Returns true if field optionalStructField is set (has been assigned a value) and false otherwise
  public boolean isSetOptionalStructField() {
    return this.optionalStructField != null;
  }

  public List<Foo> getStructListField() {
    return this.structListField;
  }

  // Returns true if field structListField is set (has been assigned a value) and false otherwise
  public boolean isSetStructListField() {
    return this.structListField != null;
  }

  public List<Foo> getOptionalStructListField() {
    return this.optionalStructListField;
  }

  // Returns true if field optionalStructListField is set (has been assigned a value) and false otherwise
  public boolean isSetOptionalStructListField() {
    return this.optionalStructListField != null;
  }

  @Override
  public boolean equals(Object _that) {
    if (_that == null)
      return false;
    if (this == _that)
      return true;
    if (!(_that instanceof Bar))
      return false;
    Bar that = (Bar)_that;

    if (!TBaseHelper.equalsNobinary(this.isSetStructField(), that.isSetStructField(), this.structField, that.structField)) { return false; }

    if (!TBaseHelper.equalsNobinary(this.isSetOptionalStructField(), that.isSetOptionalStructField(), this.optionalStructField, that.optionalStructField)) { return false; }

    if (!TBaseHelper.equalsNobinary(this.isSetStructListField(), that.isSetStructListField(), this.structListField, that.structListField)) { return false; }

    if (!TBaseHelper.equalsNobinary(this.isSetOptionalStructListField(), that.isSetOptionalStructListField(), this.optionalStructListField, that.optionalStructListField)) { return false; }

    return true;
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(new Object[] {structField, optionalStructField, structListField, optionalStructListField});
  }

  // This is required to satisfy the TBase interface, but can't be implemented on immutable struture.
  public void read(TProtocol iprot) throws TException {
    throw new TException("unimplemented in android immutable structure");
  }

  public static Bar deserialize(TProtocol iprot) throws TException {
    Foo tmp_structField = null;
    Foo tmp_optionalStructField = null;
    List<Foo> tmp_structListField = null;
    List<Foo> tmp_optionalStructListField = null;
    TField __field;
    iprot.readStructBegin();
    while (true)
    {
      __field = iprot.readFieldBegin();
      if (__field.type == TType.STOP) { 
        break;
      }
      switch (__field.id)
      {
        case STRUCTFIELD:
          if (__field.type == TType.STRUCT) {
            tmp_structField = Foo.deserialize(iprot);
          } else { 
            TProtocolUtil.skip(iprot, __field.type);
          }
          break;
        case OPTIONALSTRUCTFIELD:
          if (__field.type == TType.STRUCT) {
            tmp_optionalStructField = Foo.deserialize(iprot);
          } else { 
            TProtocolUtil.skip(iprot, __field.type);
          }
          break;
        case STRUCTLISTFIELD:
          if (__field.type == TType.LIST) {
            {
              TList _list26 = iprot.readListBegin();
              tmp_structListField = new ArrayList<Foo>(Math.max(0, _list26.size));
              for (int _i27 = 0; 
                   (_list26.size < 0) ? iprot.peekList() : (_i27 < _list26.size); 
                   ++_i27)
              {
                Foo _elem28;
                _elem28 = Foo.deserialize(iprot);
                tmp_structListField.add(_elem28);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, __field.type);
          }
          break;
        case OPTIONALSTRUCTLISTFIELD:
          if (__field.type == TType.LIST) {
            {
              TList _list29 = iprot.readListBegin();
              tmp_optionalStructListField = new ArrayList<Foo>(Math.max(0, _list29.size));
              for (int _i30 = 0; 
                   (_list29.size < 0) ? iprot.peekList() : (_i30 < _list29.size); 
                   ++_i30)
              {
                Foo _elem31;
                _elem31 = Foo.deserialize(iprot);
                tmp_optionalStructListField.add(_elem31);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, __field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, __field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    Bar _that;
    _that = new Bar(
      tmp_structField
      ,tmp_optionalStructField
      ,tmp_structListField
      ,tmp_optionalStructListField
    );
    _that.validate();
    return _that;
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.structField != null) {
      oprot.writeFieldBegin(STRUCT_FIELD_FIELD_DESC);
      this.structField.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.optionalStructField != null) {
      if (isSetOptionalStructField()) {
        oprot.writeFieldBegin(OPTIONAL_STRUCT_FIELD_FIELD_DESC);
        this.optionalStructField.write(oprot);
        oprot.writeFieldEnd();
      }
    }
    if (this.structListField != null) {
      oprot.writeFieldBegin(STRUCT_LIST_FIELD_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.structListField.size()));
        for (Foo _iter32 : this.structListField)        {
          _iter32.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.optionalStructListField != null) {
      if (isSetOptionalStructListField()) {
        oprot.writeFieldBegin(OPTIONAL_STRUCT_LIST_FIELD_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.optionalStructListField.size()));
          for (Foo _iter33 : this.optionalStructListField)          {
            _iter33.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    return toString(1, true);
  }

  @Override
  public String toString(int indent, boolean prettyPrint) {
    return TBaseHelper.toStringHelper(this, indent, prettyPrint);
  }

  public void validate() throws TException {
    // check for required fields
  }

}

