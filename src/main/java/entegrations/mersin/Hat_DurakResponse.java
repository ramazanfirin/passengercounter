/**
 * Hat_DurakResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Hat_DurakResponse  implements java.io.Serializable {
    private entegrations.mersin.Hat_DurakResponseHat_DurakResult hat_DurakResult;

    public Hat_DurakResponse() {
    }

    public Hat_DurakResponse(
           entegrations.mersin.Hat_DurakResponseHat_DurakResult hat_DurakResult) {
           this.hat_DurakResult = hat_DurakResult;
    }


    /**
     * Gets the hat_DurakResult value for this Hat_DurakResponse.
     * 
     * @return hat_DurakResult
     */
    public entegrations.mersin.Hat_DurakResponseHat_DurakResult getHat_DurakResult() {
        return hat_DurakResult;
    }


    /**
     * Sets the hat_DurakResult value for this Hat_DurakResponse.
     * 
     * @param hat_DurakResult
     */
    public void setHat_DurakResult(entegrations.mersin.Hat_DurakResponseHat_DurakResult hat_DurakResult) {
        this.hat_DurakResult = hat_DurakResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Hat_DurakResponse)) return false;
        Hat_DurakResponse other = (Hat_DurakResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hat_DurakResult==null && other.getHat_DurakResult()==null) || 
             (this.hat_DurakResult!=null &&
              this.hat_DurakResult.equals(other.getHat_DurakResult())));
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
        if (getHat_DurakResult() != null) {
            _hashCode += getHat_DurakResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hat_DurakResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_DurakResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hat_DurakResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_DurakResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_DurakResponse>Hat_DurakResult"));
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
