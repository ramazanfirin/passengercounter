/**
 * Aus_icerik_detayResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Aus_icerik_detayResponse  implements java.io.Serializable {
    private entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult aus_icerik_detayResult;

    public Aus_icerik_detayResponse() {
    }

    public Aus_icerik_detayResponse(
           entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult aus_icerik_detayResult) {
           this.aus_icerik_detayResult = aus_icerik_detayResult;
    }


    /**
     * Gets the aus_icerik_detayResult value for this Aus_icerik_detayResponse.
     * 
     * @return aus_icerik_detayResult
     */
    public entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult getAus_icerik_detayResult() {
        return aus_icerik_detayResult;
    }


    /**
     * Sets the aus_icerik_detayResult value for this Aus_icerik_detayResponse.
     * 
     * @param aus_icerik_detayResult
     */
    public void setAus_icerik_detayResult(entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult aus_icerik_detayResult) {
        this.aus_icerik_detayResult = aus_icerik_detayResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Aus_icerik_detayResponse)) return false;
        Aus_icerik_detayResponse other = (Aus_icerik_detayResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aus_icerik_detayResult==null && other.getAus_icerik_detayResult()==null) || 
             (this.aus_icerik_detayResult!=null &&
              this.aus_icerik_detayResult.equals(other.getAus_icerik_detayResult())));
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
        if (getAus_icerik_detayResult() != null) {
            _hashCode += getAus_icerik_detayResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Aus_icerik_detayResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">aus_icerik_detayResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aus_icerik_detayResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_icerik_detayResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_icerik_detayResponse>aus_icerik_detayResult"));
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
