/**
 * DuyurularResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class DuyurularResponse  implements java.io.Serializable {
    private entegrations.mersin.DuyurularResponseDuyurularResult duyurularResult;

    public DuyurularResponse() {
    }

    public DuyurularResponse(
           entegrations.mersin.DuyurularResponseDuyurularResult duyurularResult) {
           this.duyurularResult = duyurularResult;
    }


    /**
     * Gets the duyurularResult value for this DuyurularResponse.
     * 
     * @return duyurularResult
     */
    public entegrations.mersin.DuyurularResponseDuyurularResult getDuyurularResult() {
        return duyurularResult;
    }


    /**
     * Sets the duyurularResult value for this DuyurularResponse.
     * 
     * @param duyurularResult
     */
    public void setDuyurularResult(entegrations.mersin.DuyurularResponseDuyurularResult duyurularResult) {
        this.duyurularResult = duyurularResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DuyurularResponse)) return false;
        DuyurularResponse other = (DuyurularResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.duyurularResult==null && other.getDuyurularResult()==null) || 
             (this.duyurularResult!=null &&
              this.duyurularResult.equals(other.getDuyurularResult())));
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
        if (getDuyurularResult() != null) {
            _hashCode += getDuyurularResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DuyurularResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">duyurularResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duyurularResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "duyurularResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>duyurularResponse>duyurularResult"));
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
