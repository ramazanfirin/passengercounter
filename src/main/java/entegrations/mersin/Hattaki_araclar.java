/**
 * Hattaki_araclar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Hattaki_araclar  implements java.io.Serializable {
    private java.lang.String proje_kodu;

    private java.lang.String hatno;

    private java.lang.String ti;

    public Hattaki_araclar() {
    }

    public Hattaki_araclar(
           java.lang.String proje_kodu,
           java.lang.String hatno,
           java.lang.String ti) {
           this.proje_kodu = proje_kodu;
           this.hatno = hatno;
           this.ti = ti;
    }


    /**
     * Gets the proje_kodu value for this Hattaki_araclar.
     * 
     * @return proje_kodu
     */
    public java.lang.String getProje_kodu() {
        return proje_kodu;
    }


    /**
     * Sets the proje_kodu value for this Hattaki_araclar.
     * 
     * @param proje_kodu
     */
    public void setProje_kodu(java.lang.String proje_kodu) {
        this.proje_kodu = proje_kodu;
    }


    /**
     * Gets the hatno value for this Hattaki_araclar.
     * 
     * @return hatno
     */
    public java.lang.String getHatno() {
        return hatno;
    }


    /**
     * Sets the hatno value for this Hattaki_araclar.
     * 
     * @param hatno
     */
    public void setHatno(java.lang.String hatno) {
        this.hatno = hatno;
    }


    /**
     * Gets the ti value for this Hattaki_araclar.
     * 
     * @return ti
     */
    public java.lang.String getTi() {
        return ti;
    }


    /**
     * Sets the ti value for this Hattaki_araclar.
     * 
     * @param ti
     */
    public void setTi(java.lang.String ti) {
        this.ti = ti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Hattaki_araclar)) return false;
        Hattaki_araclar other = (Hattaki_araclar) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.proje_kodu==null && other.getProje_kodu()==null) || 
             (this.proje_kodu!=null &&
              this.proje_kodu.equals(other.getProje_kodu()))) &&
            ((this.hatno==null && other.getHatno()==null) || 
             (this.hatno!=null &&
              this.hatno.equals(other.getHatno()))) &&
            ((this.ti==null && other.getTi()==null) || 
             (this.ti!=null &&
              this.ti.equals(other.getTi())));
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
        if (getProje_kodu() != null) {
            _hashCode += getProje_kodu().hashCode();
        }
        if (getHatno() != null) {
            _hashCode += getHatno().hashCode();
        }
        if (getTi() != null) {
            _hashCode += getTi().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hattaki_araclar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">hattaki_araclar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proje_kodu");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hatno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "hatno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
