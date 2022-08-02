package com.masterteknoloji.net.service.integrations;

import java.util.Iterator;
import java.util.List;

import org.apache.axis.message.MessageElement;
import org.springframework.stereotype.Service;

import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;

@Service
public class BaseCityDataProviderServiceImpl implements CityDataProvider{

	@Override
	public void getBusList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Route> getRoutList() throws Exception{
		return null;
	}

	@Override
	public List<Station> getStationList() throws Exception{
		return null;
		
	}

	@Override
	public List<StationRouteConnection> getStationRouteConnectionList(String routeCode) throws Exception{
		return null;
		
	}

	@Override
	public List<ScheduledVoyage> getScheduledVoyageList(String routeCode) throws Exception{
		return null;
		
	}

	@Override
	public void getCurrentPosition() {
		// TODO Auto-generated method stub
		
	}
	
	public String findByName(MessageElement messageElement, String name) {
		for (Iterator iterator = messageElement.getChildren().iterator(); iterator.hasNext();) {
			MessageElement type = (MessageElement) iterator.next();
			if(type.getElementName().getLocalName().equals(name))
				return type.getValue();
		}
		return null;
	}

}
