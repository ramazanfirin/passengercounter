/**
 * Aus_icerik_resimResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Aus_icerik_resimResponse  implements java.io.Serializable {
    private entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult aus_icerik_resimResult;

    public Aus_icerik_resimResponse() {
    }

    public Aus_icerik_resimResponse(
           entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult aus_icerik_resimResult) {
           this.aus_icerik_resimResult = aus_icerik_resimResult;
    }


    /**
     * Gets the aus_icerik_resimResult value for this Aus_icerik_resimResponse.
     * 
     * @return aus_icerik_resimResult
     */
    public entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult getAus_icerik_resimResult() {
        return aus_icerik_resimResult;
    }


    /**
     * Sets the aus_icerik_resimResult value for this Aus_icerik_resimResponse.
     * 
     * @param aus_icerik_resimResult
     */
    public void setAus_icerik_resimResult(entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult aus_icerik_resimResult) {
        this.aus_icerik_resimResult = aus_icerik_resimResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Aus_icerik_resimResponse)) return false;
        Aus_icerik_resimResponse other = (Aus_icerik_resimResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aus_icerik_resimResult==null && other.getAus_icerik_resimResult()==null) || 
             (this.aus_icerik_resimResult!=null &&
              this.aus_icerik_resimResult.equals(other.getAus_icerik_resimResult())));
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
        if (getAus_icerik_resimResult() != null) {
            _hashCode += getAus_icerik_resimResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Aus_icerik_resimResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">aus_icerik_resimResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aus_icerik_resimResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_icerik_resimResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_icerik_resimResponse>aus_icerik_resimResult"));
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
