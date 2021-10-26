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

import com.masterteknoloji.net.config.ApplicationProperties;
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
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;
import com.masterteknoloji.net.web.rest.vm.kbb.BusLocationInformationVM;

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
    
    private final ApplicationProperties applicationProperties;
    
    private final IntegrationService integrationService;
    
    private Map<String,Long> currentDevicePassegerCount = new HashMap<String, Long>();
    
    private Map<String,RawTable> lastRawTableMap = new HashMap<String, RawTable>();
    
    private Station tempStation;
    
    public DensityCalculaterService(RawTableRepository rawTableRepository, 
    		BusDensityHistoryRepository busDensityHistoryRepository,DeviceRepository deviceRepository, 
    		StationService stationService,RouteService routeService,
    		ScheduledVoyageRepository scheduledVoyageRepository,ApplicationProperties applicationProperties,
    		IntegrationService integrationService) {
		super();
		this.rawTableRepository = rawTableRepository;
		this.busDensityHistoryRepository = busDensityHistoryRepository;
		this.deviceRepository = deviceRepository;
		this.stationService = stationService;
		this.routeService = routeService;
		this.scheduledVoyageRepository = scheduledVoyageRepository;
		this.applicationProperties = applicationProperties;
		this.integrationService = integrationService;
    }

	@Scheduled(fixedDelay = 60000)
	public void calculateDensityJob() {
		log.info("calculateDensityJob basladi");
		if(applicationProperties.getActivateScheduled()) {
			calculateDensity();
		}else {
			log.info("activated Scheduled is not active");
		}
			
		log.info("calculateDensityJob basladi");
	}
	
	
	
    public void calculateDensity() {
    	log.info("calculateDensity basladi");
    	
    	List<RawTable> unprocessedList = rawTableRepository.findUnprocessedRecords(new PageRequest(0, 10));
    	int i =0;
    	for (RawTable rawTable : unprocessedList) {
    		try {
    		
				String deviceId = rawTable.getDeviceIdOriginal();
				
				Bus bus = findBus(deviceId);
				
				Station station = null;
				Route route = null;
				if(!applicationProperties.getSimulation()) {
					BusLocationInformationVM busLocationInformationVM = integrationService.getInformationOfBus(bus.getBusId());
					 
					//stationService.insertAllStations(busLocationInformationVM);
					
					station = stationService.findCurrentStation(busLocationInformationVM);
					route = routeService.findCurrentRoute(busLocationInformationVM);
    		    }else {
    		    	station = tempStation;
//    		    	if( i!=0 && i % 50 ==0)
//    		    		station = stationService.getRandomStation();
    		    	route = routeService.findGetFirstRoute();
    		    }
				
				ScheduledVoyage scheduledVoyage = findScheduledVoyage(bus.getId());
				
				BusDensityHistory busDensityHistory;
				List<BusDensityHistory> oldvalues = busDensityHistoryRepository.findOldRecord(bus.getId(), station.getId(), route.getId());
				
				if(oldvalues.size()>0) {
					busDensityHistory = oldvalues.get(0);
				}else {
					busDensityHistory = new BusDensityHistory();
					busDensityHistory.setBus(bus);
					//busDensityHistory.setDensity(currentPassengerCOunt);
					
					busDensityHistory.setRoute(route);
					busDensityHistory.setScheduledVoyage(scheduledVoyage);
					busDensityHistory.setStation(station);
				}
				
				RawTable lastRawTableofDevice = lastRawTableMap.get(deviceId);
				
				Long getInDiff = calculateDiffGetIn(lastRawTableofDevice, rawTable);
				busDensityHistory.setGetInPassengerCount(busDensityHistory.getGetInPassengerCount() + getInDiff);
				
				Long getOutDiff = calculateDiffGetOut(lastRawTableofDevice, rawTable);
				busDensityHistory.setGetOutPassengerCount(busDensityHistory.getGetOutPassengerCount() + getOutDiff);
				
				Long calculateCurrentPassengerCount = calculateCurrentPassengerCount(rawTable);
				currentDevicePassegerCount.put(deviceId, calculateCurrentPassengerCount);
				
				Long totalPassengerOfBus = calculatePassengeCountOfBus(bus.getId());
				busDensityHistory.setTotalPassengerCount(totalPassengerOfBus);
				
				busDensityHistory.setRecordDate(rawTable.getInsertDate());
				busDensityHistoryRepository.save(busDensityHistory);
				rawTable.setIsSuccess(true);
				lastRawTableMap.put(deviceId, rawTable);
			} catch (Exception e) {
    			e.printStackTrace();
				rawTable.setIsSuccess(false);
			}
			rawTable.setProcessed(true);
			rawTableRepository.save(rawTable);
			i++;
    	}
    	
       	log.info("calculateDensity bitt");
        
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
    
    public ScheduledVoyage findScheduledVoyage(Long busId) {
    	List<ScheduledVoyage> routeList = scheduledVoyageRepository.findAll();
    	if(routeList.size() > 0)
    		return routeList.get(0);
    	else
    		return null;
    }
    
    public Station getTempStation() {
		return tempStation;
	}

	public void setTempStation(Station tempStation) {
		this.tempStation = tempStation;
	}

	public Long calculateDiffGetIn(RawTable lastRawTable,RawTable currentRawTable) {
		Long result = 0l;
		
		if( lastRawTable == null) {
			result = calculateGetInOfRawTable(currentRawTable);
		}else {
			Long totalGetInOfCurrent = calculateGetInOfRawTable(currentRawTable);
			Long totalGetInOfLast = 	calculateGetInOfRawTable(lastRawTable);
			result = totalGetInOfCurrent -totalGetInOfLast;
		}
		
		return result;
	}

	public Long calculateDiffGetOut(RawTable lastRawTable,RawTable currentRawTable) {
		Long result = 0l;
		
		if( lastRawTable == null) {
			result = calculateGetOutOfRawTable(currentRawTable);
		}else {
			Long totalGetOutOfCurrent = calculateGetOutOfRawTable(currentRawTable);
			Long totalGetOutOfLast = 	calculateGetOutOfRawTable(lastRawTable);
			result = totalGetOutOfCurrent -totalGetOutOfLast;
		}
		
		return result;
	}
	
	public Long calculateGetInOfRawTable(RawTable rawTable) {
		Long totalGetIn = 0l;
		totalGetIn = rawTable.getUpPeople1()+rawTable.getUpPeople2()+rawTable.getUpPeople3()+rawTable.getUpPeople4();
		return totalGetIn;
	}
	
	public Long calculateGetOutOfRawTable(RawTable rawTable) {
		Long totalGetIn = 0l;
		totalGetIn = rawTable.getDownPeople1()+rawTable.getDownPeople2()+rawTable.getDownPeople3()+rawTable.getDownPeople4();
		return totalGetIn;
	}
	
	public Long calculateCurrentPassengerCount(RawTable rawTable) {
		Long totalGetIn = calculateGetInOfRawTable(rawTable);
		Long totalGetOut = calculateGetOutOfRawTable(rawTable);
		return totalGetIn - totalGetOut;
	}
}
