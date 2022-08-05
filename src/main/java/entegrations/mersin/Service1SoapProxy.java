package entegrations.mersin;

public class Service1SoapProxy implements entegrations.mersin.Service1Soap {
  private String _endpoint = null;
  private entegrations.mersin.Service1Soap service1Soap = null;
  
  public Service1SoapProxy() {
    _initService1SoapProxy();
  }
  
  public Service1SoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initService1SoapProxy();
  }
  
  private void _initService1SoapProxy() {
    try {
      service1Soap = (new entegrations.mersin.Service1Locator()).getService1Soap();
      if (service1Soap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service1Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service1Soap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service1Soap != null)
      ((javax.xml.rpc.Stub)service1Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public entegrations.mersin.Service1Soap getService1Soap() {
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap;
  }
  
  public java.lang.String versiyon(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.versiyon(proje_kodu, ti);
  }
  
  public entegrations.mersin.Hat_guzergahResponseHat_guzergahResult hat_guzergah(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.hat_guzergah(proje_kodu, hatno, ti);
  }
  
  public entegrations.mersin.Hat_DurakResponseHat_DurakResult hat_Durak(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.hat_Durak(proje_kodu, hatno, ti);
  }
  
  public entegrations.mersin.HatlarResponseHatlarResult hatlar(java.lang.String proje_kodu, java.lang.String ti, java.lang.String hat_bolge) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.hatlar(proje_kodu, ti, hat_bolge);
  }
  
  public entegrations.mersin.Web_taksilerResponseWeb_taksilerResult web_taksiler(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.web_taksiler(proje_kodu, ti);
  }
  
  public entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult tarife_ucretleri_ara(java.lang.String proje_kodu, java.lang.String ti, java.lang.String hat_no) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.tarife_ucretleri_ara(proje_kodu, ti, hat_no);
  }
  
  public entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult bolge_Tarife_ucretleri_ara(java.lang.String proje_kodu, java.lang.String ti, java.lang.String bolge) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.bolge_Tarife_ucretleri_ara(proje_kodu, ti, bolge);
  }
  
  public entegrations.mersin.Hat_araResponseHat_araResult hat_ara(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.hat_ara(proje_kodu, hat, ti);
  }
  
  public entegrations.mersin.DuraklarResponseDuraklarResult duraklar(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.duraklar(proje_kodu, ti);
  }
  
  public entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult duraktan_gecenhatlar(java.lang.String proje_kodu, java.lang.String durak, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.duraktan_gecenhatlar(proje_kodu, durak, ti);
  }
  
  public entegrations.mersin.BannerResponseBannerResult banner(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.banner(proje_kodu, ti);
  }
  
  public entegrations.mersin.Durak_araResponseDurak_araResult durak_ara(java.lang.String proje_kodu, java.lang.String durak, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.durak_ara(proje_kodu, durak, ti);
  }
  
  public entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result hat_Durak2(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.hat_Durak2(proje_kodu, hatno, ti);
  }
  
  public entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult hattaki_araclar(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.hattaki_araclar(proje_kodu, hatno, ti);
  }
  
  public entegrations.mersin.Arac_bilgiResponseArac_bilgiResult arac_bilgi(java.lang.String proje_kodu, java.lang.String plaka, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.arac_bilgi(proje_kodu, plaka, ti);
  }
  
  public entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult yanimdaki_duraklar(java.lang.String proje_kodu, java.lang.String ti, java.lang.String enlem, java.lang.String boylam) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.yanimdaki_duraklar(proje_kodu, ti, enlem, boylam);
  }
  
  public entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult durak_Dakika(java.lang.String proje_kodu, java.lang.String durakno, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.durak_Dakika(proje_kodu, durakno, ti);
  }
  
  public entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result tarife_ara2(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.tarife_ara2(proje_kodu, hat, ti);
  }
  
  public entegrations.mersin.Tarife_araResponseTarife_araResult tarife_ara(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.tarife_ara(proje_kodu, hat, ti);
  }
  
  public entegrations.mersin.DuyurularResponseDuyurularResult duyurular(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.duyurular(proje_kodu, ti);
  }
  
  public entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult aus_duyuru_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.aus_duyuru_liste(proje_kodu, ti);
  }
  
  public entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult aus_haber_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.aus_haber_liste(proje_kodu, ti);
  }
  
  public entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult aus_proje_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.aus_proje_liste(proje_kodu, ti);
  }
  
  public entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult aus_icerik_detay(java.lang.String icerik_id, java.lang.String turu, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.aus_icerik_detay(icerik_id, turu, proje_kodu, ti);
  }
  
  public entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult aus_icerik_resim(java.lang.String icerik_id, java.lang.String turu, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.aus_icerik_resim(icerik_id, turu, proje_kodu, ti);
  }
  
  public entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult okul_servisi_ara(java.lang.String plaka_adsoyad_tc, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.okul_servisi_ara(plaka_adsoyad_tc, proje_kodu, ti);
  }
  
  public java.lang.String servistest() throws java.rmi.RemoteException{
    if (service1Soap == null)
      _initService1SoapProxy();
    return service1Soap.servistest();
  }
  
  
}