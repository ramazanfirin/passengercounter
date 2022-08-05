package com.masterteknoloji.net.service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
import com.masterteknoloji.net.service.integrations.mersin.MersinCityDataProviderService;
import com.masterteknoloji.net.service.util.Util;
import com.masterteknoloji.net.web.rest.vm.BusCurrentLocationInformation;

@Service
public class RouteDetectionService {

	private final RawTableRepository rawTableRepository;
	
	private final DeviceRepository deviceRepository;
	
	private final MersinCityDataProviderService mersinCityDataProviderService;

	private final RouteService routeService;
	
	private final StationService stationService;
	
	private final ScheduledVoyageService scheduledVoyageService;

	private final BusDensityHistoryRepository busDensityHistoryRepository;
	
	private final DeviceService deviceService;
	
	private Map<String,Long> currentDevicePassegerCount = new HashMap<String, Long>();
	
	public RouteDetectionService(RawTableRepository rawTableRepository, DeviceRepository deviceRepository, 
			MersinCityDataProviderService mersinCityDataProviderService, RouteService routeService, 
			StationService stationService,ScheduledVoyageService scheduledVoyageService,
			BusDensityHistoryRepository busDensityHistoryRepository,DeviceService deviceService) {
		super();
		this.rawTableRepository = rawTableRepository;
		this.deviceRepository = deviceRepository;
		this.mersinCityDataProviderService = mersinCityDataProviderService;
		this.routeService = routeService;
		this.stationService = stationService;
		this.scheduledVoyageService = scheduledVoyageService;
		this.busDensityHistoryRepository = busDensityHistoryRepository;
		this.deviceService = deviceService;
	}

	 private Map<String,RawTable> lastRawTableMap = new HashMap<String, RawTable>();

	 @Scheduled(fixedDelay = 60000)
	public void detectRoute() {
		
		List<RawTable> unprocessedList = rawTableRepository.findUnprocessedRecords(new PageRequest(0, 500));
    	int i =0;
    	for (RawTable rawTable : unprocessedList) {
    		try {
    			
    			rawTable = rawTableRepository.findOne(rawTable.getId());
    			String deviceId = rawTable.getDeviceIdOriginal();
    			
    			RawTable lastRawTableofDevice = lastRawTableMap.get(deviceId);
				
    			if(Util.checkIsItUnnecesary(rawTable, lastRawTableofDevice)) {
    				saveSuccessfuly(rawTable);
    				continue;
    			}
    			
    			Bus bus = findBus(deviceId);
    			
    			BusCurrentLocationInformation busCurrentLocationInformation = mersinCityDataProviderService.getCurrentPosition(bus.getPlate()); 
    			if(busCurrentLocationInformation.getHatNo().equals("0")) {
    				rawTable.setErrorMessage("aktif_sefer_bulanamadi");
    				saveSuccessfuly(rawTable);
    				continue;
    			}
    			
    			Route route = routeService.findRouteByCode(busCurrentLocationInformation.getHatNo());
    			Station station = stationService.findByStationId(Long.parseLong(busCurrentLocationInformation.getDurak()));
    			Instant scheduledTime = calculateScheduledTime(busCurrentLocationInformation);
    			ScheduledVoyage scheduledVoyage= scheduledVoyageService.findOrInsertScheduledVoyage(route, scheduledTime, bus); 
    			
    		} catch (Exception e) {
				saveError(rawTable, e.getMessage());
			}
    	}
    	
	}
	
	public void saveStatistics(RawTable rawTable, Bus bus,Station station, Route route, ScheduledVoyage scheduledVoyage ) throws Exception{
		BusDensityHistory busDensityHistory;
		List<BusDensityHistory> oldvalues = busDensityHistoryRepository.findOldRecord(bus.getId(), station.getId(), route.getId());
		
		if(oldvalues.size()>0) {
			busDensityHistory = oldvalues.get(0);
		}else {
			busDensityHistory = new BusDensityHistory();
			busDensityHistory.setBus(bus);
			
			busDensityHistory.setRoute(route);
			busDensityHistory.setScheduledVoyage(scheduledVoyage);
			busDensityHistory.setStation(station);
			busDensityHistory.setFirstRawRecord(rawTable);
		}
		String deviceId = rawTable.getDeviceIdOriginal();
		RawTable lastRawTableofDevice = lastRawTableMap.get(deviceId);
		
		Long getInDiff = Util.calculateDiffGetIn(lastRawTableofDevice, rawTable);
		busDensityHistory.setGetInPassengerCount(busDensityHistory.getGetInPassengerCount() + getInDiff);
		
		Long getOutDiff = Util.calculateDiffGetOut(lastRawTableofDevice, rawTable);
		busDensityHistory.setGetOutPassengerCount(busDensityHistory.getGetOutPassengerCount() + getOutDiff);
		
		Long totalPassengerOfBus = Util.calculateCurrentPassengerCount(lastRawTableofDevice,rawTable);
		currentDevicePassegerCount.put(deviceId, totalPassengerOfBus);
		busDensityHistory.setTotalPassengerCount(totalPassengerOfBus);
		
		busDensityHistory.setRecordDate(rawTable.getInsertDate());
		busDensityHistory.setLastRawRecord(rawTable);
		busDensityHistory.setDensity(100*totalPassengerOfBus/60);
		
		busDensityHistoryRepository.save(busDensityHistory);
		saveSuccessfuly(lastRawTableofDevice);
		lastRawTableMap.put(deviceId, rawTable);
		
	}
	
	public Bus findBus(String deviceId) {
    	Device device = deviceService.findByDeviceId(deviceId);
    	return device.getBus();
    }
	
	public Instant calculateScheduledTime(BusCurrentLocationInformation busCurrentLocationInformation) {
		Date date = new Date();
		String[] values = busCurrentLocationInformation.getTarihSaat().split(":");
    	date.setHours(Integer.parseInt(values[0]));
    	date.setMinutes(Integer.parseInt(values[1]));
		
    	return date.toInstant();
	}
	
	public void saveSuccessfuly(RawTable rawTable) {
		rawTable.setIsSuccess(true);
		rawTable.setProcessed(true);
		rawTableRepository.save(rawTable);
	}
	
	public void saveError(RawTable rawTable,String error) {
		rawTable.setIsSuccess(false);
		rawTable.setProcessed(true);
		rawTable.setErrorMessage(error);
		rawTableRepository.save(rawTable);
	}
}
