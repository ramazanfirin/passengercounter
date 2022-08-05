/**
 * Service1Soap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package entegrations.mersin;

public interface Service1Soap extends java.rmi.Remote {
    public java.lang.String versiyon(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Hat_guzergahResponseHat_guzergahResult hat_guzergah(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Hat_DurakResponseHat_DurakResult hat_Durak(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.HatlarResponseHatlarResult hatlar(java.lang.String proje_kodu, java.lang.String ti, java.lang.String hat_bolge) throws java.rmi.RemoteException;
    public entegrations.mersin.Web_taksilerResponseWeb_taksilerResult web_taksiler(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Tarife_ucretleri_araResponseTarife_ucretleri_araResult tarife_ucretleri_ara(java.lang.String proje_kodu, java.lang.String ti, java.lang.String hat_no) throws java.rmi.RemoteException;
    public entegrations.mersin.Bolge_Tarife_ucretleri_araResponseBolge_Tarife_ucretleri_araResult bolge_Tarife_ucretleri_ara(java.lang.String proje_kodu, java.lang.String ti, java.lang.String bolge) throws java.rmi.RemoteException;
    public entegrations.mersin.Hat_araResponseHat_araResult hat_ara(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.DuraklarResponseDuraklarResult duraklar(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Duraktan_gecenhatlarResponseDuraktan_gecenhatlarResult duraktan_gecenhatlar(java.lang.String proje_kodu, java.lang.String durak, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.BannerResponseBannerResult banner(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Durak_araResponseDurak_araResult durak_ara(java.lang.String proje_kodu, java.lang.String durak, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Hat_Durak2ResponseHat_Durak2Result hat_Durak2(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Hattaki_araclarResponseHattaki_araclarResult hattaki_araclar(java.lang.String proje_kodu, java.lang.String hatno, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Arac_bilgiResponseArac_bilgiResult arac_bilgi(java.lang.String proje_kodu, java.lang.String plaka, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Yanimdaki_duraklarResponseYanimdaki_duraklarResult yanimdaki_duraklar(java.lang.String proje_kodu, java.lang.String ti, java.lang.String enlem, java.lang.String boylam) throws java.rmi.RemoteException;
    public entegrations.mersin.Durak_DakikaResponseDurak_DakikaResult durak_Dakika(java.lang.String proje_kodu, java.lang.String durakno, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Tarife_ara2ResponseTarife_ara2Result tarife_ara2(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Tarife_araResponseTarife_araResult tarife_ara(java.lang.String proje_kodu, java.lang.String hat, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.DuyurularResponseDuyurularResult duyurular(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Aus_duyuru_listeResponseAus_duyuru_listeResult aus_duyuru_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Aus_haber_listeResponseAus_haber_listeResult aus_haber_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Aus_proje_listeResponseAus_proje_listeResult aus_proje_liste(java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Aus_icerik_detayResponseAus_icerik_detayResult aus_icerik_detay(java.lang.String icerik_id, java.lang.String turu, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Aus_icerik_resimResponseAus_icerik_resimResult aus_icerik_resim(java.lang.String icerik_id, java.lang.String turu, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public entegrations.mersin.Okul_servisi_araResponseOkul_servisi_araResult okul_servisi_ara(java.lang.String plaka_adsoyad_tc, java.lang.String proje_kodu, java.lang.String ti) throws java.rmi.RemoteException;
    public java.lang.String servistest() throws java.rmi.RemoteException;
}
