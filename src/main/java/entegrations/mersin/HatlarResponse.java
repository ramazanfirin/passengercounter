/**
 * HatlarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class HatlarResponse  implements java.io.Serializable {
    private entegrations.mersin.HatlarResponseHatlarResult hatlarResult;

    public HatlarResponse() {
    }

    public HatlarResponse(
           entegrations.mersin.HatlarResponseHatlarResult hatlarResult) {
           this.hatlarResult = hatlarResult;
    }


    /**
     * Gets the hatlarResult value for this HatlarResponse.
     * 
     * @return hatlarResult
     */
    public entegrations.mersin.HatlarResponseHatlarResult getHatlarResult() {
        return hatlarResult;
    }


    /**
     * Sets the hatlarResult value for this HatlarResponse.
     * 
     * @param hatlarResult
     */
    public void setHatlarResult(entegrations.mersin.HatlarResponseHatlarResult hatlarResult) {
        this.hatlarResult = hatlarResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HatlarResponse)) return false;
        HatlarResponse other = (HatlarResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hatlarResult==null && other.getHatlarResult()==null) || 
             (this.hatlarResult!=null &&
              this.hatlarResult.equals(other.getHatlarResult())));
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
        if (getHatlarResult() != null) {
            _hashCode += getHatlarResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HatlarResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">HatlarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hatlarResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "HatlarResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>HatlarResponse>HatlarResult"));
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
