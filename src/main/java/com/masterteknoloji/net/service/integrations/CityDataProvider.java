package com.masterteknoloji.net.service.integrations;

public interface CityDataProvider {

	public void getBusList();
	
	public void getRoutList();
	
	public void getStationList();
	
	public void getStationRouteConnectionList();
	
	public void getScheduledVoyageList();
	
	public void getCurrentPosition();
	
}
