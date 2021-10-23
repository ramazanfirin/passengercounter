package com.masterteknoloji.net.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.web.rest.vm.kbb.BusLocationInformationVM;
import com.masterteknoloji.net.web.rest.vm.kbb.StopVM;

@Service
@Transactional
public class StationService {

	private final StationRepository stationRepository;
	
	String unknownStationName = "unknown";

	public StationService(StationRepository stationRepository) {
		super();
		this.stationRepository = stationRepository;
	}

	public Station findByCoordinates(String lat,String lng) {
		if(StringUtils.isEmpty(lat) && StringUtils.isEmpty(lng))
			return getUnkownStation();
		
		return stationRepository.findStationByCoordinates(lat, lng);
	}
	
	public Station findCurrentStation(BusLocationInformationVM busLocationInformationVM) {
		
		Station currentStation = null;
		
		if(!busLocationInformationVM.getInStop().getSanalMi()) {
			currentStation = getUnkownStation();
		}else {
			Long currentStopId = busLocationInformationVM.getInStop().getKaktusDurakId();
			currentStation = stationRepository.findByStationId(currentStopId);
			if(currentStation == null) {
				currentStation = new Station();
				currentStation.setName(busLocationInformationVM.getInStop().getKaktusDurakAd());
				currentStation.setStationId(currentStopId);
				currentStation.setLat(busLocationInformationVM.getInStop().getLat());
				currentStation.setLng(busLocationInformationVM.getInStop().getLong());
				stationRepository.save(currentStation);
			}
		}
		return currentStation;
	}
	
	public void insertAllStations(BusLocationInformationVM busLocationInformationVM) {
		for (StopVM item : busLocationInformationVM.getLineStops()) {
			Station currentStation = stationRepository.findByStationId(item.getKaktusDurakId());
			if(currentStation == null) {
				currentStation = new Station();
				currentStation.setName(item.getKaktusDurakAd());
				currentStation.setStationId(item.getKaktusDurakId());
				currentStation.setLat(item.getLat());
				currentStation.setLng(item.getLong());
				stationRepository.save(currentStation);
			}
		}
	}
	
	public Station getUnkownStation() {
		Station station = stationRepository.findStationByName(unknownStationName);
		if(station ==null) {
			station = new Station();
			station.setName(unknownStationName);
			stationRepository.save(station);
		}
		return station;
	}
	
	public Station getRandomStation() {
		
		List<Station> stations = stationRepository.findAll();
		
		int number = (int)(Math.random() * stations.size());
		
		return stations.get(number);
	}
}
