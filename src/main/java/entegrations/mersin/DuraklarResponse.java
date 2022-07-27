/**
 * DuraklarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class DuraklarResponse  implements java.io.Serializable {
    private entegrations.mersin.DuraklarResponseDuraklarResult duraklarResult;

    public DuraklarResponse() {
    }

    public DuraklarResponse(
           entegrations.mersin.DuraklarResponseDuraklarResult duraklarResult) {
           this.duraklarResult = duraklarResult;
    }


    /**
     * Gets the duraklarResult value for this DuraklarResponse.
     * 
     * @return duraklarResult
     */
    public entegrations.mersin.DuraklarResponseDuraklarResult getDuraklarResult() {
        return duraklarResult;
    }


    /**
     * Sets the duraklarResult value for this DuraklarResponse.
     * 
     * @param duraklarResult
     */
    public void setDuraklarResult(entegrations.mersin.DuraklarResponseDuraklarResult duraklarResult) {
        this.duraklarResult = duraklarResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DuraklarResponse)) return false;
        DuraklarResponse other = (DuraklarResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.duraklarResult==null && other.getDuraklarResult()==null) || 
             (this.duraklarResult!=null &&
              this.duraklarResult.equals(other.getDuraklarResult())));
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
        if (getDuraklarResult() != null) {
            _hashCode += getDuraklarResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DuraklarResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">duraklarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duraklarResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "duraklarResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>duraklarResponse>duraklarResult"));
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
