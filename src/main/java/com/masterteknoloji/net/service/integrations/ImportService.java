package com.masterteknoloji.net.service.integrations;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.repository.StationRouteConnectionRepository;
import com.masterteknoloji.net.service.integrations.mersin.MersinCityDataProviderService;
import com.masterteknoloji.net.web.rest.vm.MersinScheduledVoyageVM;

@Service
public class ImportService {
	
	private final MersinCityDataProviderService mersinCityDataProviderService;
	private final StationRepository stationRepository;
	private final RouteRepository routeRepository;
	private final StationRouteConnectionRepository stationRouteConnectionRepository;
	private final ScheduledVoyageRepository scheduledVoyageRepository;
	
	public ImportService(MersinCityDataProviderService mersinCityDataProviderService, StationRepository stationRepository, 
			RouteRepository routeRepository, StationRouteConnectionRepository stationRouteConnectionRepository,  ScheduledVoyageRepository scheduledVoyageRepository) {
		super();
		this.mersinCityDataProviderService = mersinCityDataProviderService;
		this.stationRepository = stationRepository;
		this.routeRepository = routeRepository;
		this.stationRouteConnectionRepository = stationRouteConnectionRepository;
		this.scheduledVoyageRepository = scheduledVoyageRepository;
	}

	public void importMersinStations() throws Exception {
		List<Station> stations = mersinCityDataProviderService.getStationList();
		for (Station station : stations) {
			Station temp =stationRepository.findByStationId(station.getStationId());
			if(temp == null)
				stationRepository.save(station);
		}
	}
	
	public void importMersinRoutes() throws Exception{
		List<Route> routes = mersinCityDataProviderService.getRoutList();
		for (Route route : routes) {
			Route temp = routeRepository.findByRouteCode(route.getRouteCode());
			if(temp == null)
				routeRepository.save(route);
		}
	}
	
	public void importMersinStationRouteConnectionList() throws Exception{
		
		List<Route> routeList = routeRepository.findAll();

		for (Route route : routeList) {
			List<StationRouteConnection> items = mersinCityDataProviderService.getStationRouteConnectionList(route.getRouteCode());
			for (StationRouteConnection item : items) {
				StationRouteConnection temp = stationRouteConnectionRepository
						.findStationRouteConnection(item.getRoute().getRouteCode(), item.getStation().getStationId());
				if (temp == null) {
					Route routeTemp = routeRepository.findByRouteCode(item.getRoute().getRouteCode());
					Station stationTemp = stationRepository.findByStationId(item.getStation().getStationId());
					if(routeTemp == null || stationTemp == null) {
						System.out.println("no data foungd");
						continue;
					}
					
					item.setRoute(routeTemp);
					item.setStation(stationTemp);
					stationRouteConnectionRepository.save(item);
			
				}
				}
		}

	}
	
	
	public void importMersinSchedulesVoyges(Long dayCount) throws Exception {
		
		List<Route> routeList = routeRepository.findAll();
		for (Route route : routeList) {
			List<MersinScheduledVoyageVM> voyages = mersinCityDataProviderService.getScheduledVoyageListV2(route.getRouteCode());
			for (int i = 0; i < dayCount ; i++) {
				LocalDate temp =  LocalDate.now().plusDays(i);
				DayOfWeek dayOfWeek = temp.getDayOfWeek();
				if(dayOfWeek==DayOfWeek.valueOf("SATURDAY")) {
					insertVoyages(temp, route, voyages, "Cumartesi");
				}else if(dayOfWeek==DayOfWeek.valueOf("SUNDAY")) {
					insertVoyages(temp, route, voyages, "Pazar");
				}else {
					insertVoyages(temp, route, voyages, "Haftaiçi");
				}
			}
		}
		
		
	}

	public void insertVoyages(LocalDate localDate, Route route, List<MersinScheduledVoyageVM> voyages,String keyword){
		for (Iterator iterator = voyages.iterator(); iterator.hasNext();) {
			MersinScheduledVoyageVM mersinScheduledVoyageVM = (MersinScheduledVoyageVM) iterator.next();
			if(mersinScheduledVoyageVM.getTarifeGun().equals(keyword)) {
				String[] values = mersinScheduledVoyageVM.getSaat().split(":");
				Instant instant = localDate.atStartOfDay(ZoneId.of("Asia/Istanbul")).toInstant();
				instant = instant.plus(3,ChronoUnit.HOURS);
				instant = instant.plus(Integer.parseInt(values[0]),ChronoUnit.HOURS).plus(Integer.parseInt(values[1]),ChronoUnit.MINUTES);
				ScheduledVoyage scheduledVoyage = scheduledVoyageRepository.findScheduledVoyage(route.getId(), instant);
				if(scheduledVoyage == null) {
					scheduledVoyage = new ScheduledVoyage();
					scheduledVoyage.setName(mersinScheduledVoyageVM.getHatAdi());
					scheduledVoyage.setScheduledTime(instant);
					scheduledVoyage.setName(mersinScheduledVoyageVM.getHatAdi());
					scheduledVoyage.setRoute(route);
					scheduledVoyageRepository.save(scheduledVoyage);
				}
			}
		}
	}
	
	}
