/**
 * Tarife_ucretleri_araResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Tarife_ucretleri_araResponse  implements java.io.Serializable {
    private entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult tarife_ucretleri_araResult;

    public Tarife_ucretleri_araResponse() {
    }

    public Tarife_ucretleri_araResponse(
           entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult tarife_ucretleri_araResult) {
           this.tarife_ucretleri_araResult = tarife_ucretleri_araResult;
    }


    /**
     * Gets the tarife_ucretleri_araResult value for this Tarife_ucretleri_araResponse.
     * 
     * @return tarife_ucretleri_araResult
     */
    public entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult getTarife_ucretleri_araResult() {
        return tarife_ucretleri_araResult;
    }


    /**
     * Sets the tarife_ucretleri_araResult value for this Tarife_ucretleri_araResponse.
     * 
     * @param tarife_ucretleri_araResult
     */
    public void setTarife_ucretleri_araResult(entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult tarife_ucretleri_araResult) {
        this.tarife_ucretleri_araResult = tarife_ucretleri_araResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Tarife_ucretleri_araResponse)) return false;
        Tarife_ucretleri_araResponse other = (Tarife_ucretleri_araResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tarife_ucretleri_araResult==null && other.getTarife_ucretleri_araResult()==null) || 
             (this.tarife_ucretleri_araResult!=null &&
              this.tarife_ucretleri_araResult.equals(other.getTarife_ucretleri_araResult())));
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
        if (getTarife_ucretleri_araResult() != null) {
            _hashCode += getTarife_ucretleri_araResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Tarife_ucretleri_araResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_ucretleri_araResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarife_ucretleri_araResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_ucretleri_araResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_ucretleri_araResponse>Tarife_ucretleri_araResult"));
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
