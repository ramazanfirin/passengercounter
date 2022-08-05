package com.masterteknoloji.net.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.masterteknoloji.net.Passengercounter2App;
import com.masterteknoloji.net.domain.Bus;
import com.masterteknoloji.net.domain.BusDensityHistory;
import com.masterteknoloji.net.domain.Device;
import com.masterteknoloji.net.domain.RawTable;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.BusDensityHistoryRepository;
import com.masterteknoloji.net.repository.BusRepository;
import com.masterteknoloji.net.repository.DeviceRepository;
import com.masterteknoloji.net.repository.RawTableRepository;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.service.integrations.mersin.MersinCityDataProviderService;
import com.masterteknoloji.net.web.rest.vm.BusCurrentLocationInformation;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class RouteDetectionServiceTest {
	
	 private final Long DEVICE_ID=90314l;

	 @Mock
	 MersinCityDataProviderService mersinCityDataProviderService;
	
	 @Autowired
	 BusRepository busRepository;
	 
	 @Autowired
	 DeviceRepository deviceRepository;

	 @Autowired
	 RawTableRepository rawTableRepository;
	 
	 @Autowired
	 RouteService routeService;
		
	 @Autowired
	 StationService stationService;
		
	 @Autowired
	 ScheduledVoyageService scheduledVoyageService;

	 @Autowired
	 BusDensityHistoryRepository busDensityHistoryRepository;
		
	 @Autowired
	 DeviceService deviceService;
		
	 @Autowired
	 BusService busService;
		
	 @Autowired
	 BusDensityHistoryService busDensityHistoryService;
	 
	 @Autowired
	 RouteRepository routeRepository;

	 @Autowired
	 StationRepository stationRepository;
	 
	 RouteDetectionService routeDetectionService;
	 
	 Bus bus;
	 Device device;
	 Route route;
	 Station station;
	 
	 @Before
	 public void prepareData() {
		 bus = new Bus();
		 bus.setPlate("33AKN32");
		 busRepository.save(bus);
		 
		 device = new Device();
		 device.setDeviceId(DEVICE_ID.toString());
		 device.setBus(bus);
		 deviceRepository.save(device);
		 
		 route = new Route();
		 route.setName("26M-G");
		 route.setRouteCode("26M-G");
		 route.setRouteId("26M");
		 routeRepository.save(route);
		 
		 station = new Station();
		 station.setName("50172");
		 station.setStationId(50172l);
		 stationRepository.save(station);
	 }
	 
	 @Before
	 public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		BusCurrentLocationInformation busCurrentLocationInformation = new BusCurrentLocationInformation();
		busCurrentLocationInformation.setDurak("50172");
		busCurrentLocationInformation.setHatNo("26M-G");
		busCurrentLocationInformation.setTarihSaat("09:00:00");
		
	    when(mersinCityDataProviderService.getCurrentPosition(anyObject())).thenReturn(busCurrentLocationInformation);

	    routeDetectionService = new RouteDetectionService(rawTableRepository, deviceRepository, mersinCityDataProviderService, routeService, stationService, scheduledVoyageService,
	    		busDensityHistoryRepository, deviceService, busService, busDensityHistoryService);

	 }
	 
	 public void insertRawTable(Long down1,Long down2,Long down3,Long down4,Long up1,Long up2,Long up3,Long up4) {
		 RawTable rawTable = new RawTable();
		 rawTable.setDeviceIdOriginal(DEVICE_ID.toString());
		 rawTable.setDownPeople1(down1);
		 rawTable.setDownPeople2(down2);
		 rawTable.setDownPeople3(down3);
		 rawTable.setDownPeople4(down4);
		 
		 rawTable.setInsertDate(Instant.now());
		 rawTable.setUpPeople1(up1);
		 rawTable.setUpPeople2(up2);
		 rawTable.setUpPeople3(up3);
		 rawTable.setUpPeople4(up4);
		 
		 rawTable.setProcessed(false);
		 rawTableRepository.save(rawTable);
		 
	 }
	 
	 
	 @Test
	 public void routeDetectionFirstRecord() throws Exception {
		insertRawTable(5l, 0l, 0l, 0l, 10l, 0l, 0l, 0l);
		routeDetectionService.detectRoute();
		
		List<RawTable> list = rawTableRepository.findAll();
		assertThat(list.size()).isEqualTo(1);
	 
		RawTable table = list.get(0);
		assertThat(table.isProcessed()).isTrue();
		assertThat(table.isIsSuccess()).isTrue();
		
		List<BusDensityHistory> list2 = busDensityHistoryRepository.findAll();
		assertThat(list2.size()).isEqualTo(1);
		
		BusDensityHistory item2 = list2.get(0);
		assertThat(item2.getBus().getBusId()).isEqualTo(bus.getBusId());
		assertThat(item2.getDensity()).isEqualTo(0);
		assertThat(item2.getGetInPassengerCount()).isEqualTo(0);
		assertThat(item2.getGetOutPassengerCount()).isEqualTo(0);
		assertThat(item2.getRecordDate()).isNotNull();
		assertThat(item2.getScheduledVoyage()).isNotNull();
		assertThat(item2.getStation().getId()).isEqualTo(station.getId());
		assertThat(item2.getTotalPassengerCount()).isEqualTo(0);
		
		assertThat(routeDetectionService.getCorrectionMap().get(DEVICE_ID.toString())).isEqualTo(5);
		
	 }
	
	 @Test
	 public void routeDetectionCheckLastRecord() throws Exception {
		insertRawTable(5l, 0l, 0l, 0l, 10l, 0l, 0l, 0l);
		insertRawTable(5l, 0l, 0l, 0l, 10l, 0l, 0l, 0l);
		
		routeDetectionService.detectRoute();
		
		List<RawTable> list = rawTableRepository.findAll();
		assertThat(list.size()).isEqualTo(2);
	 
		List<BusDensityHistory> list2 = busDensityHistoryRepository.findAll();
		assertThat(list2.size()).isEqualTo(1);
		
		BusDensityHistory item2 = list2.get(0);
		assertThat(item2.getBus().getBusId()).isEqualTo(bus.getBusId());
		assertThat(item2.getDensity()).isEqualTo(0);
		assertThat(item2.getGetInPassengerCount()).isEqualTo(0);
		assertThat(item2.getGetOutPassengerCount()).isEqualTo(0);
		assertThat(item2.getRecordDate()).isNotNull();
		assertThat(item2.getScheduledVoyage()).isNotNull();
		assertThat(item2.getStation().getId()).isEqualTo(station.getId());
		assertThat(item2.getTotalPassengerCount()).isEqualTo(0);
		
		assertThat(routeDetectionService.getCorrectionMap().get(DEVICE_ID.toString())).isEqualTo(5);
		
	 }
	
	 @Test
	 public void routeDetection() throws Exception {
		insertRawTable(5l, 0l, 0l, 0l, 10l, 0l, 0l, 0l);
		insertRawTable(6l, 0l, 0l, 0l, 15l, 0l, 0l, 0l);
		
		routeDetectionService.detectRoute();
		
		List<RawTable> list = rawTableRepository.findAll();
		assertThat(list.size()).isEqualTo(2);
	 
		List<BusDensityHistory> list2 = busDensityHistoryRepository.findAll();
		assertThat(list2.size()).isEqualTo(1);
		
		BusDensityHistory item2 = list2.get(0);
		assertThat(item2.getBus().getBusId()).isEqualTo(bus.getBusId());
		assertThat(item2.getDensity()).isGreaterThan(0);
		assertThat(item2.getGetInPassengerCount()).isEqualTo(5);
		assertThat(item2.getGetOutPassengerCount()).isEqualTo(1);
		assertThat(item2.getRecordDate()).isNotNull();
		assertThat(item2.getScheduledVoyage()).isNotNull();
		assertThat(item2.getStation().getId()).isEqualTo(station.getId());
		assertThat(item2.getTotalPassengerCount()).isEqualTo(4);
		
		assertThat(routeDetectionService.getCorrectionMap().get(DEVICE_ID.toString())).isEqualTo(5);
		
	    Bus item = busService.getBusMap().get(bus.getPlate());
		//Bus bus = busRepository.findAll().get(0); 
		assertThat(item.getCurrentRoute().getName()).isEqualTo(route.getName());
		assertThat(item.getCurrentStation().getName()).isEqualTo(station.getName());
		assertThat(item.getCurrentScheduledVoyage()).isNotNull();
		assertThat(item.getCurrentPassengerCount()).isEqualTo(4);
		assertThat(item.getCurrentDensity()).isGreaterThan(0);
		
		
	 }

	 
	 @Test
	 public void routeDetection2() throws Exception {
		insertRawTable(5l, 0l, 0l, 0l, 10l, 0l, 0l, 0l);
		insertRawTable(6l, 0l, 0l, 0l, 15l, 0l, 0l, 0l);
		insertRawTable(6l, 2l, 3l, 0l, 15l, 0l, 0l, 0l);
		insertRawTable(6l, 2l, 3l, 0l, 15l, 1l, 0l, 0l);
		insertRawTable(7l, 3l, 4l, 0l, 16l, 1l, 3l, 0l);
		
		// 9 inen,10 binen
		routeDetectionService.detectRoute();
		
		List<RawTable> list = rawTableRepository.findAll();
		assertThat(list.size()).isEqualTo(5);
	 
		List<BusDensityHistory> list2 = busDensityHistoryRepository.findAll();
		assertThat(list2.size()).isEqualTo(1);
		
		BusDensityHistory item2 = list2.get(0);
		assertThat(item2.getBus().getBusId()).isEqualTo(bus.getBusId());
		assertThat(item2.getDensity()).isGreaterThan(0);
		assertThat(item2.getGetInPassengerCount()).isEqualTo(10);
		assertThat(item2.getGetOutPassengerCount()).isEqualTo(9);
		assertThat(item2.getRecordDate()).isNotNull();
		assertThat(item2.getScheduledVoyage()).isNotNull();
		assertThat(item2.getStation().getId()).isEqualTo(station.getId());
		assertThat(item2.getTotalPassengerCount()).isEqualTo(1);
		
		assertThat(routeDetectionService.getCorrectionMap().get(DEVICE_ID.toString())).isEqualTo(5);
		
	    Bus item = busService.getBusMap().get(bus.getPlate());
		//Bus bus = busRepository.findAll().get(0); 
		assertThat(item.getCurrentRoute().getName()).isEqualTo(route.getName());
		assertThat(item.getCurrentStation().getName()).isEqualTo(station.getName());
		assertThat(item.getCurrentScheduledVoyage()).isNotNull();
		assertThat(item.getCurrentPassengerCount()).isEqualTo(1);
		assertThat(item.getCurrentDensity()).isGreaterThan(0);
		
		
	 }

}
