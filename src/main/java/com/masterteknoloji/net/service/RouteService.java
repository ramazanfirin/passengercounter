package com.masterteknoloji.net.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.web.rest.vm.kbb.BusLocationInformationVM;

@Service
@Transactional
public class RouteService {

	private final RouteRepository routeRepository;
	
	String unknownName = "unknown";

	public RouteService(RouteRepository routeRepository) {
		super();
		this.routeRepository = routeRepository;
	}
	
	public Route findUnknownRoute() {
		Route route = routeRepository.findByName(unknownName);
		if(route ==null) {
			route = new Route();
			route.setName(unknownName);
			routeRepository.save(route);
		}
		return route;
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
	
	public Route findGetFirstRoute() {
		
		List<Route> routes = routeRepository.findAll();
		if(routes.size()>0)
			return routes.get(routes.size()-1);
		else
			return null;
	}
	
	public Route findRouteByCode(String routeCode) {
		
		Route route = routeRepository.findByRouteCode(routeCode);
	    return route;
	}
	
	
	public Route findCurrentRoute(BusLocationInformationVM busLocationInformationVM) {
		
		Route currentRoute = null;
		
		if(!busLocationInformationVM.getInStop().getSanalMi()) {
			currentRoute = findUnknownRoute();
		}else {
			Long currentStopId = busLocationInformationVM.getLine().getKaktusHatId();
			currentRoute = routeRepository.findByRouteId(currentStopId);
			if(currentRoute == null) {
				currentRoute = new Route();
				currentRoute.setName(busLocationInformationVM.getLine().getKaktusHatAdi());
				currentRoute.setRouteId(busLocationInformationVM.getLine().getKaktusHatId());
				routeRepository.save(currentRoute);
			}
		}
		return currentRoute;
	}
	
}
