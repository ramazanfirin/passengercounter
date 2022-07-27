/**
 * Durak_DakikaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Durak_DakikaResponse  implements java.io.Serializable {
    private entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult durak_DakikaResult;

    public Durak_DakikaResponse() {
    }

    public Durak_DakikaResponse(
           entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult durak_DakikaResult) {
           this.durak_DakikaResult = durak_DakikaResult;
    }


    /**
     * Gets the durak_DakikaResult value for this Durak_DakikaResponse.
     * 
     * @return durak_DakikaResult
     */
    public entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult getDurak_DakikaResult() {
        return durak_DakikaResult;
    }


    /**
     * Sets the durak_DakikaResult value for this Durak_DakikaResponse.
     * 
     * @param durak_DakikaResult
     */
    public void setDurak_DakikaResult(entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult durak_DakikaResult) {
        this.durak_DakikaResult = durak_DakikaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Durak_DakikaResponse)) return false;
        Durak_DakikaResponse other = (Durak_DakikaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.durak_DakikaResult==null && other.getDurak_DakikaResult()==null) || 
             (this.durak_DakikaResult!=null &&
              this.durak_DakikaResult.equals(other.getDurak_DakikaResult())));
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
        if (getDurak_DakikaResult() != null) {
            _hashCode += getDurak_DakikaResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Durak_DakikaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Durak_DakikaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("durak_DakikaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Durak_DakikaResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Durak_DakikaResponse>Durak_DakikaResult"));
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
