package com.masterteknoloji.net.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Bus;
import com.masterteknoloji.net.domain.BusDensityHistory;
import com.masterteknoloji.net.domain.Device;
import com.masterteknoloji.net.domain.RawTable;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.BusDensityHistoryRepository;
import com.masterteknoloji.net.repository.DeviceRepository;
import com.masterteknoloji.net.repository.RawTableRepository;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;
import com.masterteknoloji.net.repository.StationRepository;

@Service
@Transactional
public class DensityCalculaterService {

    private final Logger log = LoggerFactory.getLogger(DensityCalculaterService.class);

    private final RawTableRepository rawTableRepository;
    
    private final BusDensityHistoryRepository busDensityHistoryRepository;
    
    private final DeviceRepository deviceRepository;
    
    private final StationService stationService;
    
    private final RouteService routeService;
    
    private final ScheduledVoyageRepository scheduledVoyageRepository;
    
    private Map<String,Long> currentDevicePassegerCount = new HashMap<String, Long>();
    
    public DensityCalculaterService(RawTableRepository rawTableRepository, 
    		BusDensityHistoryRepository busDensityHistoryRepository,DeviceRepository deviceRepository, 
    		StationService stationService,RouteService routeService,ScheduledVoyageRepository scheduledVoyageRepository) {
		super();
		this.rawTableRepository = rawTableRepository;
		this.busDensityHistoryRepository = busDensityHistoryRepository;
		this.deviceRepository = deviceRepository;
		this.stationService = stationService;
		this.routeService = routeService;
		this.scheduledVoyageRepository = scheduledVoyageRepository;
    }

	@Scheduled(fixedDelay = 60000)
    public void calculateDensity() {
    	log.info("calculateDensity basladi");
    
    	List<RawTable> unprocessedList = rawTableRepository.findUnprocessedRecords(new PageRequest(0, 1000));
    	for (RawTable rawTable : unprocessedList) {
    		try {
				String deviceId = rawTable.getDeviceIdOriginal();
				Long currentPassengerCOunt = calculatePassengeCountOfDevice(rawTable);
				currentDevicePassegerCount.put(deviceId, currentPassengerCOunt);
				
				Bus bus = findBus(deviceId);
				Station station = findStation(rawTable.getLat(), rawTable.getLng());
				Route route = findRoute(bus.getId());
				ScheduledVoyage scheduledVoyage = findScheduledVoyage(bus.getId());
				
				BusDensityHistory busDensityHistory;
				List<BusDensityHistory> oldvalues = busDensityHistoryRepository.findOldRecord(bus.getId(), station.getId(), route.getId());
				if(oldvalues.size()>0)
					busDensityHistory = oldvalues.get(0);
				else
					busDensityHistory = new BusDensityHistory();
				
				busDensityHistory.setBus(bus);
				busDensityHistory.setDensity(currentPassengerCOunt);
				busDensityHistory.setRecordDate(null);
				busDensityHistory.setRoute(route);
				busDensityHistory.setScheduledVoyage(scheduledVoyage);
				busDensityHistory.setStation(station);
				
				Long totalPassengerOfBus = calculatePassengeCountOfBus(bus.getId());
				busDensityHistory.setTotalPassengerCount(totalPassengerOfBus);
				
				busDensityHistoryRepository.save(busDensityHistory);
				rawTable.setIsSuccess(true);
    		} catch (Exception e) {
    			e.printStackTrace();
				rawTable.setIsSuccess(false);
			}
			rawTable.setProcessed(true);
			rawTableRepository.save(rawTable);
    	}
    	
       	log.info("calculateDensity bitt");
        
    }
    
    public Long calculatePassengeCountOfDevice(RawTable rawTable) {
    	Long totalGetIn = rawTable.getUpPeople1()+rawTable.getUpPeople2()+rawTable.getUpPeople3()+rawTable.getUpPeople4();
     	Long totalGetOut = rawTable.getDownPeople1()+rawTable.getDownPeople2()+rawTable.getDownPeople3()+rawTable.getDownPeople4();
       
     	return totalGetIn - totalGetOut;
    }
    
    public Long calculatePassengeCountOfBus(Long busId) {
    	
    	Long result = 0l;
        List<Device> deviceList = deviceRepository.findDevicesByBusId(busId);
     	for (Device device : deviceList) {
			Long temp = currentDevicePassegerCount.get(device.getDeviceId());
			if(temp != null)
				result = result + temp;
		}
        		
        return result;
    }
    
    public Bus findBus(String deviceId) {
    	Device device = deviceRepository.findDeviceByDeviceId(deviceId);
    	return device.getBus();
    }
    
    public Station findStation(String lat,String lng) {
    	Station station = stationService.findByCoordinates(lat, lng);
    	return station;
    }

    public Route findRoute(Long busId) {
    	Route route = routeService.findByBusId(busId);
    	return route;
    }

    public ScheduledVoyage findScheduledVoyage(Long busId) {
    	List<ScheduledVoyage> routeList = scheduledVoyageRepository.findAll();
    	if(routeList.size() > 0)
    		return routeList.get(0);
    	else
    		return null;
    }
}
