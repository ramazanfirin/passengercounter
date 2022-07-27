/**
 * Hattaki_araclarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Hattaki_araclarResponse  implements java.io.Serializable {
    private entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult hattaki_araclarResult;

    public Hattaki_araclarResponse() {
    }

    public Hattaki_araclarResponse(
           entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult hattaki_araclarResult) {
           this.hattaki_araclarResult = hattaki_araclarResult;
    }


    /**
     * Gets the hattaki_araclarResult value for this Hattaki_araclarResponse.
     * 
     * @return hattaki_araclarResult
     */
    public entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult getHattaki_araclarResult() {
        return hattaki_araclarResult;
    }


    /**
     * Sets the hattaki_araclarResult value for this Hattaki_araclarResponse.
     * 
     * @param hattaki_araclarResult
     */
    public void setHattaki_araclarResult(entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult hattaki_araclarResult) {
        this.hattaki_araclarResult = hattaki_araclarResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Hattaki_araclarResponse)) return false;
        Hattaki_araclarResponse other = (Hattaki_araclarResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hattaki_araclarResult==null && other.getHattaki_araclarResult()==null) || 
             (this.hattaki_araclarResult!=null &&
              this.hattaki_araclarResult.equals(other.getHattaki_araclarResult())));
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
        if (getHattaki_araclarResult() != null) {
            _hashCode += getHattaki_araclarResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hattaki_araclarResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">hattaki_araclarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hattaki_araclarResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "hattaki_araclarResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>hattaki_araclarResponse>hattaki_araclarResult"));
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
