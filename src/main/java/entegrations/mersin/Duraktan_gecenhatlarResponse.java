/**
 * Duraktan_gecenhatlarResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Duraktan_gecenhatlarResponse  implements java.io.Serializable {
    private entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult duraktan_gecenhatlarResult;

    public Duraktan_gecenhatlarResponse() {
    }

    public Duraktan_gecenhatlarResponse(
           entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult duraktan_gecenhatlarResult) {
           this.duraktan_gecenhatlarResult = duraktan_gecenhatlarResult;
    }


    /**
     * Gets the duraktan_gecenhatlarResult value for this Duraktan_gecenhatlarResponse.
     * 
     * @return duraktan_gecenhatlarResult
     */
    public entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult getDuraktan_gecenhatlarResult() {
        return duraktan_gecenhatlarResult;
    }


    /**
     * Sets the duraktan_gecenhatlarResult value for this Duraktan_gecenhatlarResponse.
     * 
     * @param duraktan_gecenhatlarResult
     */
    public void setDuraktan_gecenhatlarResult(entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult duraktan_gecenhatlarResult) {
        this.duraktan_gecenhatlarResult = duraktan_gecenhatlarResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Duraktan_gecenhatlarResponse)) return false;
        Duraktan_gecenhatlarResponse other = (Duraktan_gecenhatlarResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.duraktan_gecenhatlarResult==null && other.getDuraktan_gecenhatlarResult()==null) || 
             (this.duraktan_gecenhatlarResult!=null &&
              this.duraktan_gecenhatlarResult.equals(other.getDuraktan_gecenhatlarResult())));
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
        if (getDuraktan_gecenhatlarResult() != null) {
            _hashCode += getDuraktan_gecenhatlarResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Duraktan_gecenhatlarResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">duraktan_gecenhatlarResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duraktan_gecenhatlarResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "duraktan_gecenhatlarResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>duraktan_gecenhatlarResponse>duraktan_gecenhatlarResult"));
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
