/**
 * Yanimdaki_duraklarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Yanimdaki_duraklarResponse  implements java.io.Serializable {
    private entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult yanimdaki_duraklarResult;

    public Yanimdaki_duraklarResponse() {
    }

    public Yanimdaki_duraklarResponse(
           entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult yanimdaki_duraklarResult) {
           this.yanimdaki_duraklarResult = yanimdaki_duraklarResult;
    }


    /**
     * Gets the yanimdaki_duraklarResult value for this Yanimdaki_duraklarResponse.
     * 
     * @return yanimdaki_duraklarResult
     */
    public entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult getYanimdaki_duraklarResult() {
        return yanimdaki_duraklarResult;
    }


    /**
     * Sets the yanimdaki_duraklarResult value for this Yanimdaki_duraklarResponse.
     * 
     * @param yanimdaki_duraklarResult
     */
    public void setYanimdaki_duraklarResult(entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult yanimdaki_duraklarResult) {
        this.yanimdaki_duraklarResult = yanimdaki_duraklarResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Yanimdaki_duraklarResponse)) return false;
        Yanimdaki_duraklarResponse other = (Yanimdaki_duraklarResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.yanimdaki_duraklarResult==null && other.getYanimdaki_duraklarResult()==null) || 
             (this.yanimdaki_duraklarResult!=null &&
              this.yanimdaki_duraklarResult.equals(other.getYanimdaki_duraklarResult())));
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
        if (getYanimdaki_duraklarResult() != null) {
            _hashCode += getYanimdaki_duraklarResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Yanimdaki_duraklarResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">yanimdaki_duraklarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yanimdaki_duraklarResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "yanimdaki_duraklarResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>yanimdaki_duraklarResponse>yanimdaki_duraklarResult"));
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
