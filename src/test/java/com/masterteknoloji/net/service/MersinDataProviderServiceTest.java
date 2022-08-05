package com.masterteknoloji.net.service;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.masterteknoloji.net.service.integrations.mersin.MersinCityDataProviderService;
import com.masterteknoloji.net.web.rest.vm.BusCurrentLocationInformation;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class MersinDataProviderServiceTest {

	 @Autowired
	 MersinCityDataProviderService mersinCityDataProviderService;
	
	 @Test
	 public void getStationList() throws Exception {
		List<Station>  result = mersinCityDataProviderService.getStationList();
		assertThat(result.size()).isGreaterThan(100);
		 
		Station station = result.get(0);
		assertThat(station.getStationId()).isNotNull();
		assertThat(station.getName()).isNotNull();
		assertThat(station.getLat()).isNotNull();
		assertThat(station.getLng()).isNotNull();
		assertThat(station.getId()).isNull();
	 }
	
	 @Test
	 public void getRouteList() throws Exception {
		List<Route>  result = mersinCityDataProviderService.getRoutList();
		assertThat(result.size()).isGreaterThan(70);
		 
		Route route = result.get(0);
		assertThat(route.getRouteId()).isNotNull();
		assertThat(route.getName()).isNotNull();
		assertThat(route.getRouteCode()).isNotNull();
	 }
	
	 @Test
	 public void getStationRouteConnectionList() throws Exception {
		List<StationRouteConnection>  result = mersinCityDataProviderService.getStationRouteConnectionList("11M-G"); 
		assertThat(result.size()).isGreaterThan(70);
		 
		StationRouteConnection stationRouteConnection = result.get(0);
		assertThat(stationRouteConnection.getRoute()).isNotNull();
		assertThat(stationRouteConnection.getStation()).isNotNull();
		assertThat(stationRouteConnection.getIndex()).isNotNull();
	 }
	 
	 @Test
	 public void getScheduledVoyageList() throws Exception {
		List<ScheduledVoyage>  result = mersinCityDataProviderService.getScheduledVoyageList("11M-G"); 
		assertThat(result.size()).isGreaterThan(50);
		 
		ScheduledVoyage scheduledVoyage  = result.get(0);
		assertThat(scheduledVoyage.getRoute()).isNotNull();
		assertThat(scheduledVoyage.getName()).isNotNull();
		assertThat(scheduledVoyage.getScheduledTime()).isNotNull();
	 }
	 
	 @Test
	 public void getAracBilgi() throws Exception {
		BusCurrentLocationInformation  result = mersinCityDataProviderService.getCurrentPosition("33AKN32");
		 
		assertThat(result.getDurak()).isNotNull();
		assertThat(result.getHatNo()).isNotNull();
		assertThat(result.getTarihSaat()).isNotNull();
	 }
	
}
