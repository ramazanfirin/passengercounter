package com.masterteknoloji.net.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Bus;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.BusRepository;

@Service
@Transactional
public class BusService {

	private final BusRepository busRepository;
	
	private Map<String,Bus> busMap = new HashMap<String, Bus>();
	
	public BusService(BusRepository busRepository) {
		super();
		this.busRepository = busRepository;
	}
	
	public void updateCurrentBusValues(Bus bus, Station station, Route route , ScheduledVoyage scheduledVoyage, Long currentPassengerCount, Long currentDensity) {
		bus.setCurrentDensity(currentDensity);
		bus.setCurrentPassengerCount(currentPassengerCount);
		bus.setCurrentRoute(route);
		bus.setCurrentScheduledVoyage(scheduledVoyage);
		bus.setCurrentStation(station);
		busMap.put(bus.getPlate(), bus);
	}

	public Map<String, Bus> getBusMap() {
		return busMap;
	}

	public void setBusMap(Map<String, Bus> busMap) {
		this.busMap = busMap;
	}
}
