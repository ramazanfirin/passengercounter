/**
 * Tarife_ara2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Tarife_ara2Response  implements java.io.Serializable {
    private entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result tarife_ara2Result;

    public Tarife_ara2Response() {
    }

    public Tarife_ara2Response(
           entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result tarife_ara2Result) {
           this.tarife_ara2Result = tarife_ara2Result;
    }


    /**
     * Gets the tarife_ara2Result value for this Tarife_ara2Response.
     * 
     * @return tarife_ara2Result
     */
    public entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result getTarife_ara2Result() {
        return tarife_ara2Result;
    }


    /**
     * Sets the tarife_ara2Result value for this Tarife_ara2Response.
     * 
     * @param tarife_ara2Result
     */
    public void setTarife_ara2Result(entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result tarife_ara2Result) {
        this.tarife_ara2Result = tarife_ara2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Tarife_ara2Response)) return false;
        Tarife_ara2Response other = (Tarife_ara2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tarife_ara2Result==null && other.getTarife_ara2Result()==null) || 
             (this.tarife_ara2Result!=null &&
              this.tarife_ara2Result.equals(other.getTarife_ara2Result())));
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
        if (getTarife_ara2Result() != null) {
            _hashCode += getTarife_ara2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Tarife_ara2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_ara2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarife_ara2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_ara2Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_ara2Response>Tarife_ara2Result"));
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
