package com.masterteknoloji.net.web.rest.vm.kbb;

public class StopVM {

	String Lat;
	String  Long;
    Boolean SanalMi;
    Long KaktusDurakId;
    String KaktusDurakAd;
    
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getLong() {
		return Long;
	}
	public void setLong(String l) {
		Long = l;
	}
	public Boolean getSanalMi() {
		return SanalMi;
	}
	public void setSanalMi(Boolean sanalMi) {
		SanalMi = sanalMi;
	}
	public Long getKaktusDurakId() {
		return KaktusDurakId;
	}
	public void setKaktusDurakId(Long kaktusDurakId) {
		KaktusDurakId = kaktusDurakId;
	}
	public String getKaktusDurakAd() {
		return KaktusDurakAd;
	}
	public void setKaktusDurakAd(String kaktusDurakAd) {
		KaktusDurakAd = kaktusDurakAd;
	}
    
    
}
