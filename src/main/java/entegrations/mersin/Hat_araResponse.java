/**
 * Hat_araResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Hat_araResponse  implements java.io.Serializable {
    private entegrations.mersin.Hat_araResponseHat_araResult hat_araResult;

    public Hat_araResponse() {
    }

    public Hat_araResponse(
           entegrations.mersin.Hat_araResponseHat_araResult hat_araResult) {
           this.hat_araResult = hat_araResult;
    }


    /**
     * Gets the hat_araResult value for this Hat_araResponse.
     * 
     * @return hat_araResult
     */
    public entegrations.mersin.Hat_araResponseHat_araResult getHat_araResult() {
        return hat_araResult;
    }


    /**
     * Sets the hat_araResult value for this Hat_araResponse.
     * 
     * @param hat_araResult
     */
    public void setHat_araResult(entegrations.mersin.Hat_araResponseHat_araResult hat_araResult) {
        this.hat_araResult = hat_araResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Hat_araResponse)) return false;
        Hat_araResponse other = (Hat_araResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hat_araResult==null && other.getHat_araResult()==null) || 
             (this.hat_araResult!=null &&
              this.hat_araResult.equals(other.getHat_araResult())));
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
        if (getHat_araResult() != null) {
            _hashCode += getHat_araResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hat_araResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_araResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hat_araResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_araResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_araResponse>Hat_araResult"));
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
