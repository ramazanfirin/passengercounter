package com.masterteknoloji.net.service.integrations;

import java.util.List;

import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;

public interface CityDataProvider {

	public void getBusList();
	
	public List<Route> getRoutList() throws Exception; 
	
	public List<Station> getStationList() throws Exception;
	
	public List<StationRouteConnection> getStationRouteConnectionList(String routeCode) throws Exception;
	
	public List<ScheduledVoyage> getScheduledVoyageList(String routeCode) throws Exception;
	
	public void getCurrentPosition();
	
}
