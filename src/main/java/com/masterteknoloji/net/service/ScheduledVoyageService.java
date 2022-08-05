package com.masterteknoloji.net.service;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Bus;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;

@Service
@Transactional
public class ScheduledVoyageService {

	private final RouteRepository routeRepository;
	
	private final ScheduledVoyageRepository scheduledVoyageRepository;
	
	public ScheduledVoyageService(RouteRepository routeRepository, ScheduledVoyageRepository scheduledVoyageRepository) {
		super();
		this.routeRepository = routeRepository;
		this.scheduledVoyageRepository = scheduledVoyageRepository;
	}
	
	public ScheduledVoyage findOrInsertScheduledVoyage(Route route, Instant scheduledTime, Bus bus) {
		ScheduledVoyage scheduledVoyage =  scheduledVoyageRepository.findScheduledVoyage(route.getId(), scheduledTime);
		if(scheduledVoyage == null) {
			scheduledVoyage = new ScheduledVoyage();
			scheduledVoyage.setBus(bus);
			scheduledVoyage.setRoute(route);
			scheduledVoyage.setName(route.getName());
			scheduledVoyage.setScheduledTime(scheduledTime);
			scheduledVoyageRepository.save(scheduledVoyage);
		}
		
		return scheduledVoyage;
	}
}
