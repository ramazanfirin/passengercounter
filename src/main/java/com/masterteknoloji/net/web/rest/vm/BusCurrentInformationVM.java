package com.masterteknoloji.net.web.rest.vm;

import java.time.Instant;

public class BusCurrentInformationVM {
	
	String plate;
	String routeName;
	String routeCode;
	Instant scheduledVoyage;
	String stationName;
	String passengerCount;
	String density;
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public Instant getScheduledVoyage() {
		return scheduledVoyage;
	}
	public void setScheduledVoyage(Instant scheduledVoyage) {
		this.scheduledVoyage = scheduledVoyage;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(String passengerCount) {
		this.passengerCount = passengerCount;
	}
	public String getDensity() {
		return density;
	}
	public void setDensity(String density) {
		this.density = density;
	}
}
