package com.masterteknoloji.net.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.StationRepository;

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
	
	public Station getUnkownStation() {
		Station station = stationRepository.findStationByName(unknownStationName);
		if(station ==null) {
			station = new Station();
			station.setName(unknownStationName);
			stationRepository.save(station);
		}
		return station;
	}
}
