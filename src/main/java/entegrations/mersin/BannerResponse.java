/**
 * BannerResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class BannerResponse  implements java.io.Serializable {
    private entegrations.mersin.BannerResponseBannerResult bannerResult;

    public BannerResponse() {
    }

    public BannerResponse(
           entegrations.mersin.BannerResponseBannerResult bannerResult) {
           this.bannerResult = bannerResult;
    }


    /**
     * Gets the bannerResult value for this BannerResponse.
     * 
     * @return bannerResult
     */
    public entegrations.mersin.BannerResponseBannerResult getBannerResult() {
        return bannerResult;
    }


    /**
     * Sets the bannerResult value for this BannerResponse.
     * 
     * @param bannerResult
     */
    public void setBannerResult(entegrations.mersin.BannerResponseBannerResult bannerResult) {
        this.bannerResult = bannerResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BannerResponse)) return false;
        BannerResponse other = (BannerResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bannerResult==null && other.getBannerResult()==null) || 
             (this.bannerResult!=null &&
              this.bannerResult.equals(other.getBannerResult())));
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
        if (getBannerResult() != null) {
            _hashCode += getBannerResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BannerResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">bannerResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bannerResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "bannerResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>bannerResponse>bannerResult"));
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
