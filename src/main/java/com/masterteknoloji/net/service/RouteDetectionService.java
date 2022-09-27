package com.masterteknoloji.net.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger log = LoggerFactory.getLogger(RouteDetectionService.class);

	private final RawTableRepository rawTableRepository;

	private final DeviceRepository deviceRepository;

	private final MersinCityDataProviderService mersinCityDataProviderService;

	private final RouteService routeService;

	private final StationService stationService;

	private final ScheduledVoyageService scheduledVoyageService;

	private final BusDensityHistoryRepository busDensityHistoryRepository;

	private final DeviceService deviceService;

	private final BusService busService;

	private final BusDensityHistoryService busDensityHistoryService;

	private Map<String, Long> correctionMap = new HashMap<String, Long>();

	public RouteDetectionService(RawTableRepository rawTableRepository, DeviceRepository deviceRepository,
			MersinCityDataProviderService mersinCityDataProviderService, RouteService routeService,
			StationService stationService, ScheduledVoyageService scheduledVoyageService,
			BusDensityHistoryRepository busDensityHistoryRepository, DeviceService deviceService, BusService busService,
			BusDensityHistoryService busDensityHistoryService) {
		super();
		this.rawTableRepository = rawTableRepository;
		this.deviceRepository = deviceRepository;
		this.mersinCityDataProviderService = mersinCityDataProviderService;
		this.routeService = routeService;
		this.stationService = stationService;
		this.scheduledVoyageService = scheduledVoyageService;
		this.busDensityHistoryRepository = busDensityHistoryRepository;
		this.deviceService = deviceService;
		this.busService = busService;
		this.busDensityHistoryService = busDensityHistoryService;
	}

	private Map<String, RawTable> lastRawTableMap = new HashMap<String, RawTable>();

	@Scheduled(fixedDelay = 15000)
	public void detectRoute() {
        
		log.info("RouteDetectionJob Basladi");;
		
		List<RawTable> unprocessedList = rawTableRepository.findUnprocessedRecords(new PageRequest(0, 500));
		int i = 0;
		log.info("RouteDetectionJob analiz edilecek kayit sayisi:"+unprocessedList.size());;
		for (RawTable rawTable : unprocessedList) {
			try {

				//rawTable = rawTableRepository.findOne(rawTable.getId());
				String deviceId = rawTable.getDeviceIdOriginal();
				rawTable.setInsertDate(rawTable.getInsertDate().minus(5,ChronoUnit.HOURS));

				RawTable lastRawTableofDevice = lastRawTableMap.get(deviceId);

				if (Util.checkIsItUnnecesary(rawTable, lastRawTableofDevice)) {
					saveError(rawTable, "dublicate:id1:"+rawTable.getId()+ ",id2="+lastRawTableofDevice.getId());
					log.info("RouteDetectionJob bir önceki kayit ile ayni.id:"+rawTable.getId());
					continue;
				}

				if(!Util.isValid(rawTable)) {
					saveError(rawTable, "timeout:id:"+rawTable.getId()+",time1:"+rawTable.getInsertDate()+",time2:"+Instant.now());
					log.info("RouteDetectionJob timeout.id:"+rawTable.getId());
					continue;
				}
				
				
				Bus bus = findBus(deviceId);

				BusCurrentLocationInformation busCurrentLocationInformation = mersinCityDataProviderService
						.getCurrentPosition(bus.getPlate());
				rawTable.setCurrentRouteCode(busCurrentLocationInformation.getHatNo());
				rawTable.setCurrentStationId(busCurrentLocationInformation.getDurak());
				rawTable.setCurrentVoyage(busCurrentLocationInformation.getTarihSaat());
				
				if (busCurrentLocationInformation.getHatNo().equals("0")) {
					saveError(rawTable, "RouteDetectionJob aktif_sefer_bulanamadi");
					continue;
				}

				Route route = routeService.findRouteByCode(busCurrentLocationInformation.getHatNo());
				if (route==null) {
					saveError(rawTable, "RouteDetectionJob route bulanamadi:"+busCurrentLocationInformation.getHatNo());
					continue;
				}
				
				Station station = stationService.findByStationId(Long.parseLong(busCurrentLocationInformation.getDurak()));
				if (station==null) {
					saveError(rawTable, "RouteDetectionJob durak bulanamadi:"+busCurrentLocationInformation.getDurak());
					continue;
				}
				rawTable.setStation(station);
				
				Instant scheduledTime = calculateScheduledTime(busCurrentLocationInformation);
				ScheduledVoyage scheduledVoyage = scheduledVoyageService.findOrInsertScheduledVoyage(route,scheduledTime, bus);
				rawTable.setVoyage(scheduledVoyage);
				
				saveStatistics(rawTable, bus, station, route, scheduledVoyage);

			} catch (Exception e) {
				saveError(rawTable, e.getMessage());
				e.printStackTrace();
			}
		}
		log.info("RouteDetectionJob Bitti");;
		

	}

	public void saveStatistics(RawTable rawTable, Bus bus, Station station, Route route,
			ScheduledVoyage scheduledVoyage) throws Exception {
		BusDensityHistory busDensityHistory;
		List<BusDensityHistory> oldvalues = busDensityHistoryRepository.findOldRecord(bus.getId(), station.getId(),
				route.getId(), scheduledVoyage.getId());

		if (oldvalues.size() > 0) {
			busDensityHistory = oldvalues.get(0);
		} else {
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

		Long correction = calculateCorrection(route.getId(), scheduledVoyage.getId(), bus.getId(), rawTable);
		Long totalPassengerOfBus = Util.calculateCurrentPassengerCount(lastRawTableofDevice, rawTable, correction);
	
		busDensityHistory.setTotalPassengerCount(totalPassengerOfBus);
		busDensityHistory.setRecordDate(rawTable.getInsertDate().minus(3, ChronoUnit.HOURS));
		busDensityHistory.setLastRawRecord(rawTable);
		Long density = 100 * totalPassengerOfBus / 60;
		busDensityHistory.setDensity(density);
		busDensityHistoryRepository.save(busDensityHistory);

		saveSuccessfuly(rawTable);
		busService.updateCurrentBusValues(bus, station, route, scheduledVoyage, totalPassengerOfBus, density);
		lastRawTableMap.put(deviceId, rawTable);

	}

	public Boolean isValid(BusCurrentLocationInformation busCurrentLocationInformation) {
		if(busCurrentLocationInformation.getHatNo().equals("") || busCurrentLocationInformation.getDurak().equals("") ||
				busCurrentLocationInformation.getTarihSaat().equals("")) {
			return false;
		}else {
			return true;
		}
			
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
		date.setSeconds(0);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		return Instant.parse(dateFormat.format(date) + ".00Z").minus(3, ChronoUnit.HOURS);
		// return date.toInstant();
	}

	public Long calculateCorrection(Long routeId, Long scheduledVoyageId, Long busId, RawTable rawTable) {
		Long correction = 0l;
		Long count = busDensityHistoryService.getRecordCount(routeId, scheduledVoyageId, busId);

		if (count == 0 || correctionMap.get(rawTable.getDeviceIdOriginal()) == null) {
			Long totalGetIn = Util.calculateGetInOfRawTable(rawTable);
			Long totalGetOut = Util.calculateGetOutOfRawTable(rawTable);
			correction = totalGetIn - totalGetOut;
			correctionMap.put(rawTable.getDeviceIdOriginal(), correction);
			rawTable.setCorrection(correction);
		} else {
			correction = correctionMap.get(rawTable.getDeviceIdOriginal());
		}

		return correction;
	}

	public void saveSuccessfuly(RawTable rawTable) {
		rawTable.setIsSuccess(true);
		rawTable.setProcessed(true);
		rawTableRepository.save(rawTable);
	}
	
	public void saveError(RawTable rawTable, String error) {
		rawTable.setIsSuccess(false);
		rawTable.setProcessed(true);
		rawTable.setErrorMessage(error);
		rawTableRepository.save(rawTable);
	}

	public Map<String, Long> getCorrectionMap() {
		return correctionMap;
	}

	public void setCorrectionMap(Map<String, Long> correctionMap) {
		this.correctionMap = correctionMap;
	}
}
