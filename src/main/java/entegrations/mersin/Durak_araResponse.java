/**
 * Durak_araResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Durak_araResponse  implements java.io.Serializable {
    private entegrations.mersin.Durak_araResponseDurak_araResult durak_araResult;

    public Durak_araResponse() {
    }

    public Durak_araResponse(
           entegrations.mersin.Durak_araResponseDurak_araResult durak_araResult) {
           this.durak_araResult = durak_araResult;
    }


    /**
     * Gets the durak_araResult value for this Durak_araResponse.
     * 
     * @return durak_araResult
     */
    public entegrations.mersin.Durak_araResponseDurak_araResult getDurak_araResult() {
        return durak_araResult;
    }


    /**
     * Sets the durak_araResult value for this Durak_araResponse.
     * 
     * @param durak_araResult
     */
    public void setDurak_araResult(entegrations.mersin.Durak_araResponseDurak_araResult durak_araResult) {
        this.durak_araResult = durak_araResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Durak_araResponse)) return false;
        Durak_araResponse other = (Durak_araResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.durak_araResult==null && other.getDurak_araResult()==null) || 
             (this.durak_araResult!=null &&
              this.durak_araResult.equals(other.getDurak_araResult())));
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
        if (getDurak_araResult() != null) {
            _hashCode += getDurak_araResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Durak_araResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">durak_araResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("durak_araResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "durak_araResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>durak_araResponse>durak_araResult"));
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
