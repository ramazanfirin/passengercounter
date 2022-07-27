/**
 * Okul_servisi_araResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Okul_servisi_araResponse  implements java.io.Serializable {
    private entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult okul_servisi_araResult;

    public Okul_servisi_araResponse() {
    }

    public Okul_servisi_araResponse(
           entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult okul_servisi_araResult) {
           this.okul_servisi_araResult = okul_servisi_araResult;
    }


    /**
     * Gets the okul_servisi_araResult value for this Okul_servisi_araResponse.
     * 
     * @return okul_servisi_araResult
     */
    public entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult getOkul_servisi_araResult() {
        return okul_servisi_araResult;
    }


    /**
     * Sets the okul_servisi_araResult value for this Okul_servisi_araResponse.
     * 
     * @param okul_servisi_araResult
     */
    public void setOkul_servisi_araResult(entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult okul_servisi_araResult) {
        this.okul_servisi_araResult = okul_servisi_araResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Okul_servisi_araResponse)) return false;
        Okul_servisi_araResponse other = (Okul_servisi_araResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.okul_servisi_araResult==null && other.getOkul_servisi_araResult()==null) || 
             (this.okul_servisi_araResult!=null &&
              this.okul_servisi_araResult.equals(other.getOkul_servisi_araResult())));
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
        if (getOkul_servisi_araResult() != null) {
            _hashCode += getOkul_servisi_araResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Okul_servisi_araResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">okul_servisi_araResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("okul_servisi_araResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "okul_servisi_araResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>okul_servisi_araResponse>okul_servisi_araResult"));
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
