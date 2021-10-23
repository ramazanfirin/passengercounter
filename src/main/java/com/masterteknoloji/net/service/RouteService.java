package com.masterteknoloji.net.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.repository.RouteRepository;

@Service
@Transactional
public class RouteService {

	private final RouteRepository routeRepository;
	
	String unknownName = "unknown";

	public RouteService(RouteRepository routeRepository) {
		super();
		this.routeRepository = routeRepository;
	}

	public Route findByName(String name) {
		Route route = routeRepository.findByName(unknownName);
		if(route ==null) {
			route = new Route();
			route.setName(unknownName);
			routeRepository.save(route);
		}
		return route;
	}
	
	public Route findByBusId(Long busId) {
		Route route = routeRepository.findByName(unknownName);
		if(route ==null) {
			route = new Route();
			route.setName(unknownName);
			routeRepository.save(route);
		}
		return route;
	}
	
	
}
