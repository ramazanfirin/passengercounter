/**
 * Arac_bilgiResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Arac_bilgiResponse  implements java.io.Serializable {
    private entegrations.mersin.Arac_bilgiResponseArac_bilgiResult arac_bilgiResult;

    public Arac_bilgiResponse() {
    }

    public Arac_bilgiResponse(
           entegrations.mersin.Arac_bilgiResponseArac_bilgiResult arac_bilgiResult) {
           this.arac_bilgiResult = arac_bilgiResult;
    }


    /**
     * Gets the arac_bilgiResult value for this Arac_bilgiResponse.
     * 
     * @return arac_bilgiResult
     */
    public entegrations.mersin.Arac_bilgiResponseArac_bilgiResult getArac_bilgiResult() {
        return arac_bilgiResult;
    }


    /**
     * Sets the arac_bilgiResult value for this Arac_bilgiResponse.
     * 
     * @param arac_bilgiResult
     */
    public void setArac_bilgiResult(entegrations.mersin.Arac_bilgiResponseArac_bilgiResult arac_bilgiResult) {
        this.arac_bilgiResult = arac_bilgiResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Arac_bilgiResponse)) return false;
        Arac_bilgiResponse other = (Arac_bilgiResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arac_bilgiResult==null && other.getArac_bilgiResult()==null) || 
             (this.arac_bilgiResult!=null &&
              this.arac_bilgiResult.equals(other.getArac_bilgiResult())));
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
        if (getArac_bilgiResult() != null) {
            _hashCode += getArac_bilgiResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Arac_bilgiResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">arac_bilgiResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arac_bilgiResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "arac_bilgiResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>arac_bilgiResponse>arac_bilgiResult"));
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
