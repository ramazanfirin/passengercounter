/**
 * Service1SoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public class Service1SoapStub extends org.apache.axis.client.Stub implements entegrations.mersin.Service1Soap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[27];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Versiyon");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "VersiyonResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Hat_guzergah");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hatno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_guzergahResponse>Hat_guzergahResult"));
        oper.setReturnClass(entegrations.mersin.Hat_guzergahResponseHat_guzergahResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_guzergahResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Hat_Durak");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hatno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_DurakResponse>Hat_DurakResult"));
        oper.setReturnClass(entegrations.mersin.Hat_DurakResponseHat_DurakResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_DurakResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Hatlar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hat_bolge"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>HatlarResponse>HatlarResult"));
        oper.setReturnClass(entegrations.mersin.HatlarResponseHatlarResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "HatlarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Web_taksiler");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Web_taksilerResponse>Web_taksilerResult"));
        oper.setReturnClass(entegrations.mersin.Web_taksilerResponseWeb_taksilerResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Web_taksilerResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Tarife_ucretleri_ara");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hat_no"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_ucretleri_araResponse>Tarife_ucretleri_araResult"));
        oper.setReturnClass(entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_ucretleri_araResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Bolge_Tarife_ucretleri_ara");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "bolge"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Bolge_Tarife_ucretleri_araResponse>Bolge_Tarife_ucretleri_araResult"));
        oper.setReturnClass(entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Bolge_Tarife_ucretleri_araResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Hat_ara");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hat"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_araResponse>Hat_araResult"));
        oper.setReturnClass(entegrations.mersin.Hat_araResponseHat_araResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_araResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("duraklar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>duraklarResponse>duraklarResult"));
        oper.setReturnClass(entegrations.mersin.DuraklarResponseDuraklarResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "duraklarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("duraktan_gecenhatlar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "durak"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>duraktan_gecenhatlarResponse>duraktan_gecenhatlarResult"));
        oper.setReturnClass(entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "duraktan_gecenhatlarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("banner");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>bannerResponse>bannerResult"));
        oper.setReturnClass(entegrations.mersin.BannerResponseBannerResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "bannerResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("durak_ara");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "durak"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>durak_araResponse>durak_araResult"));
        oper.setReturnClass(entegrations.mersin.Durak_araResponseDurak_araResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "durak_araResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Hat_Durak2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hatno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_Durak2Response>Hat_Durak2Result"));
        oper.setReturnClass(entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_Durak2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("hattaki_araclar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hatno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>hattaki_araclarResponse>hattaki_araclarResult"));
        oper.setReturnClass(entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "hattaki_araclarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("arac_bilgi");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "plaka"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>arac_bilgiResponse>arac_bilgiResult"));
        oper.setReturnClass(entegrations.mersin.Arac_bilgiResponseArac_bilgiResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "arac_bilgiResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("yanimdaki_duraklar");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "enlem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "boylam"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>yanimdaki_duraklarResponse>yanimdaki_duraklarResult"));
        oper.setReturnClass(entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "yanimdaki_duraklarResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Durak_Dakika");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "durakno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Durak_DakikaResponse>Durak_DakikaResult"));
        oper.setReturnClass(entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Durak_DakikaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Tarife_ara2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hat"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_ara2Response>Tarife_ara2Result"));
        oper.setReturnClass(entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_ara2Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Tarife_ara");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "hat"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_araResponse>Tarife_araResult"));
        oper.setReturnClass(entegrations.mersin.Tarife_araResponseTarife_araResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_araResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("duyurular");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>duyurularResponse>duyurularResult"));
        oper.setReturnClass(entegrations.mersin.DuyurularResponseDuyurularResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "duyurularResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("aus_duyuru_liste");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_duyuru_listeResponse>aus_duyuru_listeResult"));
        oper.setReturnClass(entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_duyuru_listeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("aus_haber_liste");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_haber_listeResponse>aus_haber_listeResult"));
        oper.setReturnClass(entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_haber_listeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("aus_proje_liste");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_proje_listeResponse>aus_proje_listeResult"));
        oper.setReturnClass(entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_proje_listeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("aus_icerik_detay");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "icerik_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "turu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_icerik_detayResponse>aus_icerik_detayResult"));
        oper.setReturnClass(entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_icerik_detayResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("aus_icerik_resim");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "icerik_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "turu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_icerik_resimResponse>aus_icerik_resimResult"));
        oper.setReturnClass(entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_icerik_resimResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("okul_servisi_ara");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "plaka_adsoyad_tc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "proje_kodu"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tempuri.org/", "ti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://tempuri.org/", ">>okul_servisi_araResponse>okul_servisi_araResult"));
        oper.setReturnClass(entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "okul_servisi_araResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("servistest");
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://tempuri.org/", "servistestResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

    }

    public Service1SoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Service1SoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Service1SoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>arac_bilgiResponse>arac_bilgiResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Arac_bilgiResponseArac_bilgiResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_duyuru_listeResponse>aus_duyuru_listeResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_haber_listeResponse>aus_haber_listeResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_icerik_detayResponse>aus_icerik_detayResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_icerik_resimResponse>aus_icerik_resimResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>aus_proje_listeResponse>aus_proje_listeResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>bannerResponse>bannerResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.BannerResponseBannerResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Bolge_Tarife_ucretleri_araResponse>Bolge_Tarife_ucretleri_araResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>durak_araResponse>durak_araResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Durak_araResponseDurak_araResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Durak_DakikaResponse>Durak_DakikaResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>duraklarResponse>duraklarResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.DuraklarResponseDuraklarResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>duraktan_gecenhatlarResponse>duraktan_gecenhatlarResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>duyurularResponse>duyurularResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.DuyurularResponseDuyurularResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_araResponse>Hat_araResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_araResponseHat_araResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_Durak2Response>Hat_Durak2Result");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_DurakResponse>Hat_DurakResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_DurakResponseHat_DurakResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Hat_guzergahResponse>Hat_guzergahResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_guzergahResponseHat_guzergahResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>HatlarResponse>HatlarResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.HatlarResponseHatlarResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>hattaki_araclarResponse>hattaki_araclarResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>okul_servisi_araResponse>okul_servisi_araResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_ara2Response>Tarife_ara2Result");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_araResponse>Tarife_araResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_araResponseTarife_araResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Tarife_ucretleri_araResponse>Tarife_ucretleri_araResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>Web_taksilerResponse>Web_taksilerResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Web_taksilerResponseWeb_taksilerResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">>yanimdaki_duraklarResponse>yanimdaki_duraklarResult");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">arac_bilgi");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Arac_bilgi.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">arac_bilgiResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Arac_bilgiResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_duyuru_liste");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_duyuru_liste.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_duyuru_listeResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_duyuru_listeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_haber_liste");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_haber_liste.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_haber_listeResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_haber_listeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_icerik_detay");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_icerik_detay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_icerik_detayResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_icerik_detayResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_icerik_resim");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_icerik_resim.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_icerik_resimResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_icerik_resimResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_proje_liste");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_proje_liste.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">aus_proje_listeResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Aus_proje_listeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">banner");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Banner.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">bannerResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.BannerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Bolge_Tarife_ucretleri_ara");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Bolge_Tarife_ucretleri_ara.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Bolge_Tarife_ucretleri_araResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Bolge_Tarife_ucretleri_araResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">durak_ara");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Durak_ara.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">durak_araResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Durak_araResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Durak_Dakika");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Durak_Dakika.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Durak_DakikaResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Durak_DakikaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">duraklar");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Duraklar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">duraklarResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.DuraklarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">duraktan_gecenhatlar");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Duraktan_gecenhatlar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">duraktan_gecenhatlarResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Duraktan_gecenhatlarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">duyurular");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Duyurular.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">duyurularResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.DuyurularResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_ara");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_ara.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_araResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_araResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_Durak");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_Durak.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_Durak2");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_Durak2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_Durak2Response");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_Durak2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Hat_DurakResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hat_DurakResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Hatlar");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hatlar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">HatlarResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.HatlarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">hattaki_araclar");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hattaki_araclar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">hattaki_araclarResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Hattaki_araclarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">okul_servisi_ara");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Okul_servisi_ara.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">okul_servisi_araResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Okul_servisi_araResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">servistest");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Servistest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">servistestResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.ServistestResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_ara");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_ara.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_ara2");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_ara2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_ara2Response");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_ara2Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_araResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_araResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_ucretleri_ara");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_ucretleri_ara.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Tarife_ucretleri_araResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Tarife_ucretleri_araResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Web_taksiler");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Web_taksiler.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">Web_taksilerResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Web_taksilerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">yanimdaki_duraklar");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Yanimdaki_duraklar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://tempuri.org/", ">yanimdaki_duraklarResponse");
            cachedSerQNames.add(qName);
            cls = entegrations.mersin.Yanimdaki_duraklarResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public java.lang.String versiyon(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Versiyon");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Versiyon"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Hat_guzergahResponseHat_guzergahResult hat_guzergah(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Hat_guzergah");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_guzergah"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, hatno, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Hat_guzergahResponseHat_guzergahResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Hat_guzergahResponseHat_guzergahResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Hat_guzergahResponseHat_guzergahResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Hat_DurakResponseHat_DurakResult hat_Durak(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Hat_Durak");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_Durak"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, hatno, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Hat_DurakResponseHat_DurakResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Hat_DurakResponseHat_DurakResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Hat_DurakResponseHat_DurakResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.HatlarResponseHatlarResult hatlar(java.lang.String proje_kodu, java.lang.String ti, java.lang.String hat_bolge) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Hatlar");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Hatlar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti, hat_bolge});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.HatlarResponseHatlarResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.HatlarResponseHatlarResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.HatlarResponseHatlarResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Web_taksilerResponseWeb_taksilerResult web_taksiler(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Web_taksiler");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Web_taksiler"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Web_taksilerResponseWeb_taksilerResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Web_taksilerResponseWeb_taksilerResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Web_taksilerResponseWeb_taksilerResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult tarife_ucretleri_ara(java.lang.String proje_kodu, java.lang.String ti, java.lang.String hat_no) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Tarife_ucretleri_ara");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_ucretleri_ara"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti, hat_no});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult bolge_Tarife_ucretleri_ara(java.lang.String proje_kodu, java.lang.String ti, java.lang.String bolge) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Bolge_Tarife_ucretleri_ara");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Bolge_Tarife_ucretleri_ara"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti, bolge});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Hat_araResponseHat_araResult hat_ara(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Hat_ara");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_ara"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, hat, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Hat_araResponseHat_araResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Hat_araResponseHat_araResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Hat_araResponseHat_araResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.DuraklarResponseDuraklarResult duraklar(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/duraklar");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "duraklar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.DuraklarResponseDuraklarResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.DuraklarResponseDuraklarResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.DuraklarResponseDuraklarResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult duraktan_gecenhatlar(java.lang.String proje_kodu, java.lang.String durak, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/duraktan_gecenhatlar");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "duraktan_gecenhatlar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, durak, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.BannerResponseBannerResult banner(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/banner");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "banner"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.BannerResponseBannerResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.BannerResponseBannerResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.BannerResponseBannerResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Durak_araResponseDurak_araResult durak_ara(java.lang.String proje_kodu, java.lang.String durak, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/durak_ara");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "durak_ara"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, durak, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Durak_araResponseDurak_araResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Durak_araResponseDurak_araResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Durak_araResponseDurak_araResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result hat_Durak2(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Hat_Durak2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Hat_Durak2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, hatno, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult hattaki_araclar(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/hattaki_araclar");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "hattaki_araclar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, hatno, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Arac_bilgiResponseArac_bilgiResult arac_bilgi(java.lang.String proje_kodu, java.lang.String plaka, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/arac_bilgi");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "arac_bilgi"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, plaka, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Arac_bilgiResponseArac_bilgiResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Arac_bilgiResponseArac_bilgiResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Arac_bilgiResponseArac_bilgiResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult yanimdaki_duraklar(java.lang.String proje_kodu, java.lang.String ti, java.lang.String enlem, java.lang.String boylam) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/yanimdaki_duraklar");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "yanimdaki_duraklar"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti, enlem, boylam});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult durak_Dakika(java.lang.String proje_kodu, java.lang.String durakno, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Durak_Dakika");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Durak_Dakika"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, durakno, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result tarife_ara2(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Tarife_ara2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_ara2"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, hat, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Tarife_araResponseTarife_araResult tarife_ara(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/Tarife_ara");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "Tarife_ara"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, hat, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Tarife_araResponseTarife_araResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Tarife_araResponseTarife_araResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Tarife_araResponseTarife_araResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.DuyurularResponseDuyurularResult duyurular(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/duyurular");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "duyurular"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.DuyurularResponseDuyurularResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.DuyurularResponseDuyurularResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.DuyurularResponseDuyurularResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult aus_duyuru_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/aus_duyuru_liste");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_duyuru_liste"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult aus_haber_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/aus_haber_liste");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_haber_liste"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult aus_proje_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/aus_proje_liste");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_proje_liste"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult aus_icerik_detay(java.lang.String icerik_id, java.lang.String turu, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/aus_icerik_detay");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_icerik_detay"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {icerik_id, turu, proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult aus_icerik_resim(java.lang.String icerik_id, java.lang.String turu, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/aus_icerik_resim");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "aus_icerik_resim"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {icerik_id, turu, proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult okul_servisi_ara(java.lang.String plaka_adsoyad_tc, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/okul_servisi_ara");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "okul_servisi_ara"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {plaka_adsoyad_tc, proje_kodu, ti});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult) org.apache.axis.utils.JavaUtils.convert(_resp, entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String servistest() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/servistest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://tempuri.org/", "servistest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
