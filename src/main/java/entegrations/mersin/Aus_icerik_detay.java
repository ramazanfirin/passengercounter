/**
 * Aus_icerik_detay.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Aus_icerik_detay  implements java.io.Serializable {
    private java.lang.String icerik_id;

    private java.lang.String turu;

    private java.lang.String proje_kodu;

    private java.lang.String ti;

    public Aus_icerik_detay() {
    }

    public Aus_icerik_detay(
           java.lang.String icerik_id,
           java.lang.String turu,
           java.lang.String proje_kodu,
           java.lang.String ti) {
           this.icerik_id = icerik_id;
           this.turu = turu;
           this.proje_kodu = proje_kodu;
           this.ti = ti;
    }


    /**
     * Gets the icerik_id value for this Aus_icerik_detay.
     * 
     * @return icerik_id
     */
    public java.lang.String getIcerik_id() {
        return icerik_id;
    }


    /**
     * Sets the icerik_id value for this Aus_icerik_detay.
     * 
     * @param icerik_id
     */
    public void setIcerik_id(java.lang.String icerik_id) {
        this.icerik_id = icerik_id;
    }


    /**
     * Gets the turu value for this Aus_icerik_detay.
     * 
     * @return turu
     */
    public java.lang.String getTuru() {
        return turu;
    }


    /**
     * Sets the turu value for this Aus_icerik_detay.
     * 
     * @param turu
     */
    public void setTuru(java.lang.String turu) {
        this.turu = turu;
    }


    /**
     * Gets the proje_kodu value for this Aus_icerik_detay.
     * 
     * @return proje_kodu
     */
    public java.lang.String getProje_kodu() {
        return proje_kodu;
    }


    /**
     * Sets the proje_kodu value for this Aus_icerik_detay.
     * 
     * @param proje_kodu
     */
    public void setProje_kodu(java.lang.String proje_kodu) {
        this.proje_kodu = proje_kodu;
    }


    /**
     * Gets the ti value for this Aus_icerik_detay.
     * 
     * @return ti
     */
    public java.lang.String getTi() {
        return ti;
    }


    /**
     * Sets the ti value for this Aus_icerik_detay.
     * 
     * @param ti
     */
    public void setTi(java.lang.String ti) {
        this.ti = ti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Aus_icerik_detay)) return false;
        Aus_icerik_detay other = (Aus_icerik_detay) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.icerik_id==null && other.getIcerik_id()==null) || 
             (this.icerik_id!=null &&
              this.icerik_id.equals(other.getIcerik_id()))) &&
            ((this.turu==null && other.getTuru()==null) || 
             (this.turu!=null &&
              this.turu.equals(other.getTuru()))) &&
            ((this.proje_kodu==null && other.getProje_kodu()==null) || 
             (this.proje_kodu!=null &&
              this.proje_kodu.equals(other.getProje_kodu()))) &&
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
        if (getIcerik_id() != null) {
            _hashCode += getIcerik_id().hashCode();
        }
        if (getTuru() != null) {
            _hashCode += getTuru().hashCode();
        }
        if (getProje_kodu() != null) {
            _hashCode += getProje_kodu().hashCode();
        }
        if (getTi() != null) {
            _hashCode += getTi().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Aus_icerik_detay.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">aus_icerik_detay"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("icerik_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "icerik_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("turu");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "turu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proje_kodu");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"));
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
