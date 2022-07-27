/**
 * Yanimdaki_duraklar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Yanimdaki_duraklar  implements java.io.Serializable {
    private java.lang.String proje_kodu;

    private java.lang.String ti;

    private java.lang.String enlem;

    private java.lang.String boylam;

    public Yanimdaki_duraklar() {
    }

    public Yanimdaki_duraklar(
           java.lang.String proje_kodu,
           java.lang.String ti,
           java.lang.String enlem,
           java.lang.String boylam) {
           this.proje_kodu = proje_kodu;
           this.ti = ti;
           this.enlem = enlem;
           this.boylam = boylam;
    }


    /**
     * Gets the proje_kodu value for this Yanimdaki_duraklar.
     * 
     * @return proje_kodu
     */
    public java.lang.String getProje_kodu() {
        return proje_kodu;
    }


    /**
     * Sets the proje_kodu value for this Yanimdaki_duraklar.
     * 
     * @param proje_kodu
     */
    public void setProje_kodu(java.lang.String proje_kodu) {
        this.proje_kodu = proje_kodu;
    }


    /**
     * Gets the ti value for this Yanimdaki_duraklar.
     * 
     * @return ti
     */
    public java.lang.String getTi() {
        return ti;
    }


    /**
     * Sets the ti value for this Yanimdaki_duraklar.
     * 
     * @param ti
     */
    public void setTi(java.lang.String ti) {
        this.ti = ti;
    }


    /**
     * Gets the enlem value for this Yanimdaki_duraklar.
     * 
     * @return enlem
     */
    public java.lang.String getEnlem() {
        return enlem;
    }


    /**
     * Sets the enlem value for this Yanimdaki_duraklar.
     * 
     * @param enlem
     */
    public void setEnlem(java.lang.String enlem) {
        this.enlem = enlem;
    }


    /**
     * Gets the boylam value for this Yanimdaki_duraklar.
     * 
     * @return boylam
     */
    public java.lang.String getBoylam() {
        return boylam;
    }


    /**
     * Sets the boylam value for this Yanimdaki_duraklar.
     * 
     * @param boylam
     */
    public void setBoylam(java.lang.String boylam) {
        this.boylam = boylam;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Yanimdaki_duraklar)) return false;
        Yanimdaki_duraklar other = (Yanimdaki_duraklar) obj;
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
            ((this.ti==null && other.getTi()==null) || 
             (this.ti!=null &&
              this.ti.equals(other.getTi()))) &&
            ((this.enlem==null && other.getEnlem()==null) || 
             (this.enlem!=null &&
              this.enlem.equals(other.getEnlem()))) &&
            ((this.boylam==null && other.getBoylam()==null) || 
             (this.boylam!=null &&
              this.boylam.equals(other.getBoylam())));
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
        if (getTi() != null) {
            _hashCode += getTi().hashCode();
        }
        if (getEnlem() != null) {
            _hashCode += getEnlem().hashCode();
        }
        if (getBoylam() != null) {
            _hashCode += getBoylam().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Yanimdaki_duraklar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">yanimdaki_duraklar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enlem");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "enlem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("boylam");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "boylam"));
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
