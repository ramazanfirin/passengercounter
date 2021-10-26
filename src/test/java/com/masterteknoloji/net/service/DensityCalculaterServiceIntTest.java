package com.masterteknoloji.net.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.BusDensityHistoryRepository;
import com.masterteknoloji.net.repository.BusRepository;
import com.masterteknoloji.net.repository.DeviceRepository;
import com.masterteknoloji.net.repository.RawTableRepository;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;
import com.masterteknoloji.net.repository.StationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class DensityCalculaterServiceIntTest {

	@Autowired
	RawTableRepository rawTableRepository;

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	BusRepository busRepository;

	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	ScheduledVoyageRepository scheduledVoyageRepository;

	@Autowired
	BusDensityHistoryRepository busDensityHistoryRepository;
	
	@Autowired
	StationRepository stationRepository ;
	
	@Autowired
	DensityCalculaterService densityCalculaterService ;
	
	Bus bus;
	
	Device device;
	
	Station station1 ;
	
	Station station2;
	
	Route route;
	
	ScheduledVoyage scheduledVoyage;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        bus = new Bus();
    	bus.setPlate("383838");
    	busRepository.save(bus);
    	
    	device = new Device();
    	device.setDeviceId("123");
    	device.setBus(bus);
    	deviceRepository.save(device);
    	
    	station1 = new Station();
    	station1.setLat("1");
    	station1.setLng("2");
    	stationRepository.save(station1);
    	
       	
    	station2 = new Station();
    	station2.setLat("3");
    	station2.setLng("4");
    	stationRepository.save(station2);
    	
    	route = new Route();
    	route.setName("routename");
    	routeRepository.save(route);
    	
    	scheduledVoyage = new ScheduledVoyage();
    	scheduledVoyage.setName("scheduledVoyage");
    	scheduledVoyageRepository.save(scheduledVoyage);
    }

    @Test
    public void oneRecord() throws Exception {

    	RawTable rawTable = new RawTable();
    	rawTable.setDeviceIdOriginal("123");
    	rawTable.setDownPeople1(1l);
    	rawTable.setDownPeople2(1l);
    	rawTable.setDownPeople3(1l);
    	rawTable.setDownPeople4(1l);
    	rawTable.setLat("1");
    	rawTable.setLng("2");
    	rawTable.setUpPeople1(2l);
    	rawTable.setUpPeople2(2l);
    	rawTable.setUpPeople3(2l);
    	rawTable.setUpPeople4(2l);
    	rawTable.setProcessed(false);
    	rawTableRepository.save(rawTable);
    	
    	densityCalculaterService.setTempStation(station1);
    	densityCalculaterService.calculateDensity();
    	
    	List<BusDensityHistory> result = busDensityHistoryRepository.findAll();
    	assertThat(result.size()).isEqualTo(1);
    	
    	BusDensityHistory item = result.get(0);
    	assertThat(item.getBus().getPlate()).isEqualTo(bus.getPlate());
    	assertThat(item.getRoute().getName()).isEqualTo(route.getName());
    	assertThat(item.getScheduledVoyage().getName()).isEqualTo(scheduledVoyage.getName());
    	assertThat(item.getStation().getName()).isEqualTo(station1.getName());
    	assertThat(item.getTotalPassengerCount()).isEqualTo(4);
    	assertThat(item.getGetInPassengerCount()).isEqualTo(8);
    	assertThat(item.getGetOutPassengerCount()).isEqualTo(4);
    	assertThat(item.getStation().getId()).isEqualTo(station1.getId());
    	
    	rawTable = rawTableRepository.findOne(rawTable.getId());
    	assertThat(rawTable.isProcessed()).isEqualTo(true);
    }

    @Test
    public void twoRecord() throws Exception {

    	RawTable rawTable = new RawTable();
    	rawTable.setDeviceIdOriginal("123");
    	rawTable.setDownPeople1(1l);
    	rawTable.setDownPeople2(1l);
    	rawTable.setDownPeople3(1l);
    	rawTable.setDownPeople4(1l);
    	rawTable.setLat("1");
    	rawTable.setLng("2");
    	rawTable.setUpPeople1(2l);
    	rawTable.setUpPeople2(2l);
    	rawTable.setUpPeople3(2l);
    	rawTable.setUpPeople4(2l);
    	rawTable.setProcessed(false);
    	rawTableRepository.save(rawTable);
    	
    	RawTable rawTable2 = new RawTable();
    	rawTable2.setDeviceIdOriginal("123");
    	rawTable2.setDownPeople1(2l);
    	rawTable2.setDownPeople2(2l);
    	rawTable2.setDownPeople3(2l);
    	rawTable2.setDownPeople4(2l);
    	rawTable2.setLat("1");
    	rawTable2.setLng("2");
    	rawTable2.setUpPeople1(4l);
    	rawTable2.setUpPeople2(4l);
    	rawTable2.setUpPeople3(4l);
    	rawTable2.setUpPeople4(4l);
    	rawTable2.setProcessed(false);
    	rawTableRepository.save(rawTable2);
    	
    	densityCalculaterService.setTempStation(station1);
    	densityCalculaterService.calculateDensity();
    	
    	List<BusDensityHistory> result = busDensityHistoryRepository.findAll();
    	assertThat(result.size()).isEqualTo(1);
    	
    	BusDensityHistory item = result.get(0);
    	assertThat(item.getBus().getPlate()).isEqualTo(bus.getPlate());
    	assertThat(item.getRoute().getName()).isEqualTo(route.getName());
    	assertThat(item.getScheduledVoyage().getName()).isEqualTo(scheduledVoyage.getName());
    	assertThat(item.getStation().getName()).isEqualTo(station1.getName());
    	assertThat(item.getTotalPassengerCount()).isEqualTo(8);
    	assertThat(item.getGetInPassengerCount()).isEqualTo(16);
    	assertThat(item.getGetOutPassengerCount()).isEqualTo(8);
    	
    	
    	rawTable = rawTableRepository.findOne(rawTable.getId());
    	assertThat(rawTable.isProcessed()).isEqualTo(true);
    }
    
    @Test
    public void twoStation() throws Exception {

    	RawTable rawTable = new RawTable();
    	rawTable.setDeviceIdOriginal("123");
    	rawTable.setDownPeople1(1l);
    	rawTable.setDownPeople2(1l);
    	rawTable.setDownPeople3(1l);
    	rawTable.setDownPeople4(1l);
    	rawTable.setLat("1");
    	rawTable.setLng("2");
    	rawTable.setUpPeople1(2l);
    	rawTable.setUpPeople2(2l);
    	rawTable.setUpPeople3(2l);
    	rawTable.setUpPeople4(2l);
    	rawTable.setProcessed(false);
    	rawTableRepository.save(rawTable);
    	
    	densityCalculaterService.setTempStation(station1);
    	densityCalculaterService.calculateDensity();
    	
    	RawTable rawTable2 = new RawTable();
    	rawTable2.setDeviceIdOriginal("123");
    	rawTable2.setDownPeople1(2l);
    	rawTable2.setDownPeople2(2l);
    	rawTable2.setDownPeople3(2l);
    	rawTable2.setDownPeople4(2l);
    	rawTable2.setLat("3");
    	rawTable2.setLng("4");
    	rawTable2.setUpPeople1(4l);
    	rawTable2.setUpPeople2(4l);
    	rawTable2.setUpPeople3(4l);
    	rawTable2.setUpPeople4(4l);
    	rawTable2.setProcessed(false);
    	rawTableRepository.save(rawTable2);
    	
    	densityCalculaterService.setTempStation(station2);
    	densityCalculaterService.calculateDensity();
    	
    	List<BusDensityHistory> result = busDensityHistoryRepository.findAll();
    	assertThat(result.size()).isEqualTo(2);
    	
    	BusDensityHistory item = result.get(0);
    	assertThat(item.getBus().getPlate()).isEqualTo(bus.getPlate());
    	assertThat(item.getRoute().getName()).isEqualTo(route.getName());
    	assertThat(item.getScheduledVoyage().getName()).isEqualTo(scheduledVoyage.getName());
    	assertThat(item.getStation().getName()).isEqualTo(station1.getName());
    	assertThat(item.getTotalPassengerCount()).isEqualTo(4);
    	assertThat(item.getStation().getId()).isEqualTo(station1.getId());
    	assertThat(item.getGetInPassengerCount()).isEqualTo(8);
    	assertThat(item.getGetOutPassengerCount()).isEqualTo(4);
    	
    	BusDensityHistory item2 = result.get(1);
    	assertThat(item2.getBus().getPlate()).isEqualTo(bus.getPlate());
    	assertThat(item2.getRoute().getName()).isEqualTo(route.getName());
    	assertThat(item2.getScheduledVoyage().getName()).isEqualTo(scheduledVoyage.getName());
    	assertThat(item2.getStation().getName()).isEqualTo(station1.getName());
    	assertThat(item2.getTotalPassengerCount()).isEqualTo(8);
    	assertThat(item2.getStation().getId()).isEqualTo(station2.getId());
    	assertThat(item2.getGetInPassengerCount()).isEqualTo(8);
    	assertThat(item2.getGetOutPassengerCount()).isEqualTo(4);
    	
    	rawTable = rawTableRepository.findOne(rawTable.getId());
    	assertThat(rawTable.isProcessed()).isEqualTo(true);
    }

}
