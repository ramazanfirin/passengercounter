package com.masterteknoloji.net.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Bus;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.BusRepository;
import com.masterteknoloji.net.service.integrations.mersin.MersinCityDataProviderService;
import com.masterteknoloji.net.web.rest.vm.BusCurrentLocationInformation;

@Service
@Transactional
public class BusService {

	private final BusRepository busRepository;
	
	private Map<String,Bus> busMap = new HashMap<String, Bus>();
	
	private final MersinCityDataProviderService mersinCityDataProviderService;
	
	public BusService(BusRepository busRepository, MersinCityDataProviderService mersinCityDataProviderService) {
		super();
		this.busRepository = busRepository;
		this.mersinCityDataProviderService = mersinCityDataProviderService;
	}
	
	public void updateCurrentBusValues(Bus bus, Station station, Route route , ScheduledVoyage scheduledVoyage, Long currentPassengerCount, Long currentDensity) {
		bus.setCurrentDensity(currentDensity);
		bus.setCurrentPassengerCount(currentPassengerCount);
		bus.setCurrentRoute(route);
		bus.setCurrentScheduledVoyage(scheduledVoyage);
		bus.setCurrentStation(station);
		busMap.put(bus.getPlate(), bus);
	}

	
	@Scheduled(fixedDelay = 60000)
	public void detectLastStatusOfBus() throws Exception {
		List<Bus> list = busRepository.findAll();
		for (Bus bus : list) {
			BusCurrentLocationInformation busCurrentLocationInformation = mersinCityDataProviderService.getCurrentPosition(bus.getPlate()); 
			if(busCurrentLocationInformation.getHatNo().equals("0")) {
				bus.setCurrentDensity(0l);
				bus.setCurrentPassengerCount(0l);
				bus.setCurrentRoute(null);
				bus.setCurrentScheduledVoyage(null);
				bus.setCurrentStation(null);
				busMap.put(bus.getPlate(), bus);
			}
		}
	}
	
	public Map<String, Bus> getBusMap() {
		return busMap;
	}

	public void setBusMap(Map<String, Bus> busMap) {
		this.busMap = busMap;
	}
}
