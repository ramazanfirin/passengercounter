package com.masterteknoloji.net.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.masterteknoloji.net.Passengercounter2App;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.repository.StationRouteConnectionRepository;
import com.masterteknoloji.net.service.integrations.ImportService;
import com.masterteknoloji.net.service.integrations.mersin.MersinCityDataProviderService;
import com.masterteknoloji.net.web.rest.vm.MersinScheduledVoyageVM;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class ImportServiceTest {

	 @Autowired
	 ImportService importService;
	 
	 @Autowired
	 StationRepository stationRepository;
	 
	 @Autowired
	 RouteRepository routeRepository;
	 
	 @Autowired
	 StationRouteConnectionRepository stationRouteConnectionRepository ;
	 
	 @Autowired
	 ScheduledVoyageRepository scheduledVoyageRepository ;
	
	 @Autowired
	 MersinCityDataProviderService mersinCityDataProviderService;
	 
	 @Test
	 public void importMersinStations() throws Exception {
		importService.importMersinStations();
		List<Station> stations = stationRepository.findAll();
		
		assertThat(stations.size()).isGreaterThan(1000);
		 
		Station station = stations.get(0);
		assertThat(station.getStationId()).isNotNull();
		assertThat(station.getName()).isNotNull();
		assertThat(station.getLat()).isNotNull();
		assertThat(station.getLng()).isNotNull();
		assertThat(station.getId()).isNotNull();
	 }
	 
	 @Test
	 public void importMersinStationsDoubleInsert() throws Exception {
		importService.importMersinStations();
		List<Station> stations = stationRepository.findAll();
		int countBefore = stations.size();
		
		importService.importMersinStations();
		stations = stationRepository.findAll();
		int countafter = stations.size();
		
		assertThat(countafter).isEqualTo(countBefore);

	 }
	 
	 @Test
	 public void importMersinRoutes() throws Exception {
		importService.importMersinRoutes();
		List<Route> routes = routeRepository.findAll();
		
		assertThat(routes.size()).isGreaterThan(70);
		 
		Route item = routes.get(0);
		assertThat(item.getRouteId()).isNotNull();
		assertThat(item.getName()).isNotNull();
		assertThat(item.getRouteCode()).isNotNull();
		assertThat(item.getId()).isNotNull();
	 }
	
	 @Test
	 public void importMersinRoutesDoubleInsert() throws Exception {
		importService.importMersinRoutes();
		List<Route> routes = routeRepository.findAll();
		int countBefore = routes.size();
		
		importService.importMersinRoutes();
		routes = routeRepository.findAll();
		int countafter = routes.size();
		
		assertThat(countafter).isEqualTo(countBefore);

	 }
	 
	 @Test
	 public void importMersinStationRoutesConnection() throws Exception {
		importService.importMersinRoutes();
		importService.importMersinStations();;
		importService.importMersinStationRouteConnectionList();
		
		List<StationRouteConnection> items = stationRouteConnectionRepository.findAll();
		
		assertThat(items.size()).isGreaterThan(70);
		 
		StationRouteConnection item = items.get(0);
		assertThat(item.getIndex()).isNotNull();
		assertThat(item.getRoute()).isNotNull();
		assertThat(item.getStation()).isNotNull();
	 }
	 
	 @Test
	 public void importMersinStationRoutesConnectionDoubleInsert() throws Exception {
		importService.importMersinRoutes();
		importService.importMersinStations();;
		importService.importMersinStationRouteConnectionList();
		
		List<StationRouteConnection> items = stationRouteConnectionRepository.findAll();
		int beforeCount = items.size();
		
		importService.importMersinStationRouteConnectionList();
		items = stationRouteConnectionRepository.findAll();
		int afterCount = items.size();
		
		assertThat(afterCount).isEqualTo(beforeCount);
	 }
	 
	 
	 
	 @Test
	 public void importMersinScheduledVoyages() throws Exception {
		
		
		Route route = new Route();
		route.setName(null);
		route.setRouteCode("11M-G");
		route.setRouteId("11M");
		routeRepository.save(route);
	
		//importService.importMersinRoutes();
		importService.importMersinSchedulesVoyges(1l);
		
		List<ScheduledVoyage> items = scheduledVoyageRepository.findAll();
		List<MersinScheduledVoyageVM> list = mersinCityDataProviderService.getScheduledVoyageListV2("11M-G");
		LocalDate temp =  LocalDate.now();
		DayOfWeek dayOfWeek = temp.getDayOfWeek();
		String keyword = "";
		if(dayOfWeek==DayOfWeek.valueOf("SATURDAY")) {
			keyword = "Cumartesi";
		}else if(dayOfWeek==DayOfWeek.valueOf("SUNDAY")) {
			keyword = "Pazar";
		}else {
			keyword = "Haftaiçi";
		}
		
		
		Long result = getCount(list, keyword);
		assertThat(items.size()).isEqualTo(result.intValue());
		 
		importService.importMersinSchedulesVoyges(1l);
		List<ScheduledVoyage> items2 = scheduledVoyageRepository.findAll();
		assertThat(items.size()).isEqualTo(items2.size());
		
		ScheduledVoyage item = items.get(0);
		assertThat(item.getName()).isNotNull();
		assertThat(item.getRoute()).isNotNull();
		assertThat(item.getScheduledTime()).isNotNull();
	 
	 }
	 
	 private Long getCount(List<MersinScheduledVoyageVM> list,String keyword) {
		 Long result = 0l;
		 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			MersinScheduledVoyageVM mersinScheduledVoyageVM = (MersinScheduledVoyageVM) iterator.next();
			if(mersinScheduledVoyageVM.getTarifeGun().equals(keyword)) {
				result++;
			}
		}
		 
		 return result;
	 }
}
