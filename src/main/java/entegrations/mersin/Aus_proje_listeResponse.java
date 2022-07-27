/**
 * Aus_proje_listeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Aus_proje_listeResponse  implements java.io.Serializable {
    private entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult aus_proje_listeResult;

    public Aus_proje_listeResponse() {
    }

    public Aus_proje_listeResponse(
           entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult aus_proje_listeResult) {
           this.aus_proje_listeResult = aus_proje_listeResult;
    }


    /**
     * Gets the aus_proje_listeResult value for this Aus_proje_listeResponse.
     * 
     * @return aus_proje_listeResult
     */
    public entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult getAus_proje_listeResult() {
        return aus_proje_listeResult;
    }


    /**
     * Sets the aus_proje_listeResult value for this Aus_proje_listeResponse.
     * 
     * @param aus_proje_listeResult
     */
    public void setAus_proje_listeResult(entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult aus_proje_listeResult) {
        this.aus_proje_listeResult = aus_proje_listeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Aus_proje_listeResponse)) return false;
        Aus_proje_listeResponse other = (Aus_proje_listeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aus_proje_listeResult==null && other.getAus_proje_listeResult()==null) || 
             (this.aus_proje_listeResult!=null &&
              this.aus_proje_listeResult.equals(other.getAus_proje_listeResult())));
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
        if (getAus_proje_listeResult() != null) {
            _hashCode += getAus_proje_listeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Aus_proje_listeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">aus_proje_listeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aus_proje_listeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_proje_listeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_proje_listeResponse>aus_proje_listeResult"));
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
