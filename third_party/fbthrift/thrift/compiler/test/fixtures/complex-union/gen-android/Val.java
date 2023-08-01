/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
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
public class Val implements TBase, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Val");
  private static final TField STR_VAL_FIELD_DESC = new TField("strVal", TType.STRING, (short)1);
  private static final TField INT_VAL_FIELD_DESC = new TField("intVal", TType.I32, (short)2);
  private static final TField TYPEDEF_VALUE_FIELD_DESC = new TField("typedefValue", TType.MAP, (short)9);

  public final String strVal;
  public final Integer intVal;
  public final Map<Short,String> typedefValue;
  public static final int STRVAL = 1;
  public static final int INTVAL = 2;
  public static final int TYPEDEFVALUE = 9;

  public Val(
      String strVal,
      Integer intVal,
      Map<Short,String> typedefValue) {
    this.strVal = strVal;
    this.intVal = intVal;
    this.typedefValue = typedefValue;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Val(Val other) {
    if (other.isSetStrVal()) {
      this.strVal = TBaseHelper.deepCopy(other.strVal);
    } else {
      this.strVal = null;
    }
    if (other.isSetIntVal()) {
      this.intVal = TBaseHelper.deepCopy(other.intVal);
    } else {
      this.intVal = null;
    }
    if (other.isSetTypedefValue()) {
      this.typedefValue = TBaseHelper.deepCopy(other.typedefValue);
    } else {
      this.typedefValue = null;
    }
  }

  public Val deepCopy() {
    return new Val(this);
  }

  public String getStrVal() {
    return this.strVal;
  }

  // Returns true if field strVal is set (has been assigned a value) and false otherwise
  public boolean isSetStrVal() {
    return this.strVal != null;
  }

  public Integer getIntVal() {
    return this.intVal;
  }

  // Returns true if field intVal is set (has been assigned a value) and false otherwise
  public boolean isSetIntVal() {
    return this.intVal != null;
  }

  public Map<Short,String> getTypedefValue() {
    return this.typedefValue;
  }

  // Returns true if field typedefValue is set (has been assigned a value) and false otherwise
  public boolean isSetTypedefValue() {
    return this.typedefValue != null;
  }

  @Override
  public boolean equals(Object _that) {
    if (_that == null)
      return false;
    if (this == _that)
      return true;
    if (!(_that instanceof Val))
      return false;
    Val that = (Val)_that;

    if (!TBaseHelper.equalsNobinary(this.isSetStrVal(), that.isSetStrVal(), this.strVal, that.strVal)) { return false; }

    if (!TBaseHelper.equalsNobinary(this.isSetIntVal(), that.isSetIntVal(), this.intVal, that.intVal)) { return false; }

    if (!TBaseHelper.equalsNobinary(this.isSetTypedefValue(), that.isSetTypedefValue(), this.typedefValue, that.typedefValue)) { return false; }

    return true;
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(new Object[] {strVal, intVal, typedefValue});
  }

  // This is required to satisfy the TBase interface, but can't be implemented on immutable struture.
  public void read(TProtocol iprot) throws TException {
    throw new TException("unimplemented in android immutable structure");
  }

  public static Val deserialize(TProtocol iprot) throws TException {
    String tmp_strVal = null;
    Integer tmp_intVal = null;
    Map<Short,String> tmp_typedefValue = null;
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
        case STRVAL:
          if (__field.type == TType.STRING) {
            tmp_strVal = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, __field.type);
          }
          break;
        case INTVAL:
          if (__field.type == TType.I32) {
            tmp_intVal = iprot.readI32();
          } else { 
            TProtocolUtil.skip(iprot, __field.type);
          }
          break;
        case TYPEDEFVALUE:
          if (__field.type == TType.MAP) {
            {
              TMap _map21 = iprot.readMapBegin();
              tmp_typedefValue = new HashMap<Short,String>(Math.max(0, 2*_map21.size));
              for (int _i22 = 0; 
                   (_map21.size < 0) ? iprot.peekMap() : (_i22 < _map21.size); 
                   ++_i22)
              {
                Short _key23;
                String _val24;
                _key23 = iprot.readI16();
                _val24 = iprot.readString();
                tmp_typedefValue.put(_key23, _val24);
              }
              iprot.readMapEnd();
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

    Val _that;
    _that = new Val(
      tmp_strVal
      ,tmp_intVal
      ,tmp_typedefValue
    );
    _that.validate();
    return _that;
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.strVal != null) {
      oprot.writeFieldBegin(STR_VAL_FIELD_DESC);
      oprot.writeString(this.strVal);
      oprot.writeFieldEnd();
    }
    if (this.intVal != null) {
      oprot.writeFieldBegin(INT_VAL_FIELD_DESC);
      oprot.writeI32(this.intVal);
      oprot.writeFieldEnd();
    }
    if (this.typedefValue != null) {
      oprot.writeFieldBegin(TYPEDEF_VALUE_FIELD_DESC);
      {
        oprot.writeMapBegin(new TMap(TType.I16, TType.STRING, this.typedefValue.size()));
        for (Map.Entry<Short, String> _iter25 : this.typedefValue.entrySet())        {
          oprot.writeI16(_iter25.getKey());
          oprot.writeString(_iter25.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
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
