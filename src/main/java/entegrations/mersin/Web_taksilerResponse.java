/**
 * Web_taksilerResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Web_taksilerResponse  implements java.io.Serializable {
    private entegrations.mersin.Web_taksilerResponseWeb_taksilerResult web_taksilerResult;

    public Web_taksilerResponse() {
    }

    public Web_taksilerResponse(
           entegrations.mersin.Web_taksilerResponseWeb_taksilerResult web_taksilerResult) {
           this.web_taksilerResult = web_taksilerResult;
    }


    /**
     * Gets the web_taksilerResult value for this Web_taksilerResponse.
     * 
     * @return web_taksilerResult
     */
    public entegrations.mersin.Web_taksilerResponseWeb_taksilerResult getWeb_taksilerResult() {
        return web_taksilerResult;
    }


    /**
     * Sets the web_taksilerResult value for this Web_taksilerResponse.
     * 
     * @param web_taksilerResult
     */
    public void setWeb_taksilerResult(entegrations.mersin.Web_taksilerResponseWeb_taksilerResult web_taksilerResult) {
        this.web_taksilerResult = web_taksilerResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Web_taksilerResponse)) return false;
        Web_taksilerResponse other = (Web_taksilerResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.web_taksilerResult==null && other.getWeb_taksilerResult()==null) || 
             (this.web_taksilerResult!=null &&
              this.web_taksilerResult.equals(other.getWeb_taksilerResult())));
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
        if (getWeb_taksilerResult() != null) {
            _hashCode += getWeb_taksilerResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Web_taksilerResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Web_taksilerResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("web_taksilerResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Web_taksilerResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Web_taksilerResponse>Web_taksilerResult"));
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
