package com.masterteknoloji.net.web.rest.vm.kbb;

import java.util.ArrayList;
import java.util.List;

public class BusLocationInformationVM {

	Boolean SignalIsLive;
	String DeviceNo;
	String GmtDateTime;
	String  Latitude;
	String  Longitude;
	Long  ValidatorHatID;
	Long  KoseNo;
	String  PlakaNo;
	Boolean IsLastStop;
	LineVM Line;
	
	StopVM PreviousStop;
	StopVM NextStop;
	StopVM InStop;
	
	List<StopVM> LineStops = new ArrayList<StopVM>();

	public Boolean getSignalIsLive() {
		return SignalIsLive;
	}

	public void setSignalIsLive(Boolean signalIsLive) {
		SignalIsLive = signalIsLive;
	}

	public String getDeviceNo() {
		return DeviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		DeviceNo = deviceNo;
	}

	public String getGmtDateTime() {
		return GmtDateTime;
	}

	public void setGmtDateTime(String gmtDateTime) {
		GmtDateTime = gmtDateTime;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public Long getValidatorHatID() {
		return ValidatorHatID;
	}

	public void setValidatorHatID(Long validatorHatID) {
		ValidatorHatID = validatorHatID;
	}

	public Long getKoseNo() {
		return KoseNo;
	}

	public void setKoseNo(Long koseNo) {
		KoseNo = koseNo;
	}

	public String getPlakaNo() {
		return PlakaNo;
	}

	public void setPlakaNo(String plakaNo) {
		PlakaNo = plakaNo;
	}

	public Boolean getIsLastStop() {
		return IsLastStop;
	}

	public void setIsLastStop(Boolean isLastStop) {
		IsLastStop = isLastStop;
	}

	public StopVM getPreviousStop() {
		return PreviousStop;
	}

	public void setPreviousStop(StopVM previousStop) {
		PreviousStop = previousStop;
	}

	public StopVM getNextStop() {
		return NextStop;
	}

	public void setNextStop(StopVM nextStop) {
		NextStop = nextStop;
	}

	public StopVM getInStop() {
		return InStop;
	}

	public void setInStop(StopVM inStop) {
		InStop = inStop;
	}

	public List<StopVM> getLineStops() {
		return LineStops;
	}

	public void setLineStops(List<StopVM> lineStops) {
		LineStops = lineStops;
	}

	public LineVM getLine() {
		return Line;
	}

	public void setLine(LineVM line) {
		Line = line;
	}
}
