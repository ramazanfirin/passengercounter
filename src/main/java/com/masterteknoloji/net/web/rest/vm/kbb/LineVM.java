package com.masterteknoloji.net.web.rest.vm.kbb;

public class LineVM {
	
	Long KaktusHatId; 
    String KaktusHatAdi;
    String ReducedHatString;
    Long HatTip;
    
	public Long getKaktusHatId() {
		return KaktusHatId;
	}
	public void setKaktusHatId(Long kaktusHatId) {
		KaktusHatId = kaktusHatId;
	}
	public String getKaktusHatAdi() {
		return KaktusHatAdi;
	}
	public void setKaktusHatAdi(String kaktusHatAdi) {
		KaktusHatAdi = kaktusHatAdi;
	}
	public String getReducedHatString() {
		return ReducedHatString;
	}
	public void setReducedHatString(String reducedHatString) {
		ReducedHatString = reducedHatString;
	}
	public Long getHatTip() {
		return HatTip;
	}
	public void setHatTip(Long hatTip) {
		HatTip = hatTip;
	}
}
