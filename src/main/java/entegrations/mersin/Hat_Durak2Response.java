/**
 * Hat_Durak2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Hat_Durak2Response  implements java.io.Serializable {
    private entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result hat_Durak2Result;

    public Hat_Durak2Response() {
    }

    public Hat_Durak2Response(
           entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result hat_Durak2Result) {
           this.hat_Durak2Result = hat_Durak2Result;
    }


    /**
     * Gets the hat_Durak2Result value for this Hat_Durak2Response.
     * 
     * @return hat_Durak2Result
     */
    public entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result getHat_Durak2Result() {
        return hat_Durak2Result;
    }


    /**
     * Sets the hat_Durak2Result value for this Hat_Durak2Response.
     * 
     * @param hat_Durak2Result
     */
    public void setHat_Durak2Result(entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result hat_Durak2Result) {
        this.hat_Durak2Result = hat_Durak2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Hat_Durak2Response)) return false;
        Hat_Durak2Response other = (Hat_Durak2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hat_Durak2Result==null && other.getHat_Durak2Result()==null) || 
             (this.hat_Durak2Result!=null &&
              this.hat_Durak2Result.equals(other.getHat_Durak2Result())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getHat_Durak2Result() != null) {
            _hashCode += getHat_Durak2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hat_Durak2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_Durak2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hat_Durak2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_Durak2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_Durak2Response>Hat_Durak2Result"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
