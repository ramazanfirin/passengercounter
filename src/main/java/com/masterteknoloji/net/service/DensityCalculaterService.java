package com.masterteknoloji.net.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
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
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.repository.StationRouteConnectionRepository;
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
    
    String pattern = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    
    private final ObjectMapper objectMapper;
    
    private final StationRepository stationRepository;
    
    private final StationRouteConnectionRepository stationRouteConnectionRepository;
    
    private Long correction;
    
    public DensityCalculaterService(RawTableRepository rawTableRepository, 
    		BusDensityHistoryRepository busDensityHistoryRepository,DeviceRepository deviceRepository, 
    		StationService stationService,RouteService routeService,
    		ScheduledVoyageRepository scheduledVoyageRepository,ApplicationProperties applicationProperties,
    		IntegrationService integrationService, ObjectMapper objectMapper,StationRepository stationRepository,
    		 StationRouteConnectionRepository stationRouteConnectionRepository) {
		super();
		this.rawTableRepository = rawTableRepository;
		this.busDensityHistoryRepository = busDensityHistoryRepository;
		this.deviceRepository = deviceRepository;
		this.stationService = stationService;
		this.routeService = routeService;
		this.scheduledVoyageRepository = scheduledVoyageRepository;
		this.applicationProperties = applicationProperties;
		this.integrationService = integrationService;
		this.objectMapper = objectMapper;
		this.stationRepository = stationRepository;
		this.stationRouteConnectionRepository = stationRouteConnectionRepository;
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
    	
    	correction = 0l;
    	List<RawTable> unprocessedList = rawTableRepository.findUnprocessedRecords(new PageRequest(0, 500));
    	int i =0;
    	for (RawTable rawTable : unprocessedList) {
    		try {
    			
    			rawTable = rawTableRepository.findOne(rawTable.getId());
    			String deviceId = rawTable.getDeviceIdOriginal();
    			RawTable lastRawTableofDevice = lastRawTableMap.get(deviceId);
				
    			if(checkIsItUnnecesary(rawTable, lastRawTableofDevice)) {
    				rawTable.setIsSuccess(true);
    				saveRawTable(rawTable);
    			}
    			
    			Bus bus = findBus(deviceId);
				
				Station station = null;
				Route route = null;
				if(!applicationProperties.getSimulation()) {
					BusLocationInformationVM busLocationInformationVM = integrationService.getInformationOfBus(bus.getBusId());
					 
					//stationService.insertAllStations(busLocationInformationVM);
					
					station = stationService.findCurrentStation(busLocationInformationVM);
					route = routeService.findCurrentRoute(busLocationInformationVM);
    		    }else {
    		    	
    		    	
//    		    	if( i!=0 && i % 50 ==0)
//    		    		station = stationService.getRandomStation();
    		    	//route = routeService.findGetFirstRoute();
    		    	route =routeService.findRouteByCode("28M-G");
    		    	station = findNearestStation(rawTable.getLat(),rawTable.getLng(),route.getId());
    		    }
				
				ScheduledVoyage scheduledVoyage = findScheduledVoyage(bus.getId());
				
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
				
				
				Long getInDiff = calculateDiffGetIn(lastRawTableofDevice, rawTable);
				busDensityHistory.setGetInPassengerCount(busDensityHistory.getGetInPassengerCount() + getInDiff);
				
				Long getOutDiff = calculateDiffGetOut(lastRawTableofDevice, rawTable);
				busDensityHistory.setGetOutPassengerCount(busDensityHistory.getGetOutPassengerCount() + getOutDiff);
				
				Long calculateCurrentPassengerCount = calculateCurrentPassengerCount(lastRawTableofDevice,rawTable);
				currentDevicePassegerCount.put(deviceId, calculateCurrentPassengerCount);
				
				Long totalPassengerOfBus = calculatePassengeCountOfBus(bus.getId());
				busDensityHistory.setTotalPassengerCount(totalPassengerOfBus);
				
				busDensityHistory.setRecordDate(rawTable.getInsertDate());
				busDensityHistory.setLastRawRecord(rawTable);
				busDensityHistory.setDensity(100*totalPassengerOfBus/60);
				
				busDensityHistoryRepository.save(busDensityHistory);
				rawTable.setIsSuccess(true);
				lastRawTableMap.put(deviceId, rawTable);
				i++;
			} catch (Exception e) {
    			e.printStackTrace();
				rawTable.setIsSuccess(false);
			}
    		saveRawTable(rawTable);
			i++;
    	}
    	
       	log.info("calculateDensity bitt");
        
    }
    
    public void saveRawTable(RawTable rawTable) {
    	rawTable.setProcessed(true);
		rawTableRepository.save(rawTable);
    }
    
    public Boolean checkIsItUnnecesary(RawTable rawTable,RawTable lastRawTableofDevice ) {
    	if(lastRawTableofDevice == null)
    		return false;
    	
    	if(rawTable.getDeviceIdOriginal().equals(lastRawTableofDevice.getDeviceIdOriginal())
    		&& rawTable.getDownPeople1().longValue() == lastRawTableofDevice.getDownPeople1().longValue()	
    		&& rawTable.getUpPeople1().longValue() == lastRawTableofDevice.getUpPeople1().longValue()	
    		
    		&& rawTable.getDownPeople2().longValue() == lastRawTableofDevice.getDownPeople2().longValue()	
    		&& rawTable.getUpPeople2().longValue() == lastRawTableofDevice.getUpPeople2().longValue()	
    		
    		&& rawTable.getDownPeople3().longValue() == lastRawTableofDevice.getDownPeople3().longValue()	
    		&& rawTable.getUpPeople3().longValue() == lastRawTableofDevice.getUpPeople3().longValue()	
    			
    		&& rawTable.getDownPeople4().longValue() == lastRawTableofDevice.getDownPeople4().longValue()	
    		&& rawTable.getUpPeople4().longValue() == lastRawTableofDevice.getUpPeople4().longValue()	
    	) return true;
    		else
    	return false;
    }
    
    public Station findNearestStation(String lat,String lng,Long routeId) {
    	Station result = null;
    	List<Station> stationList = stationRouteConnectionRepository.findStationListByRouteId(routeId);
    	//if(stationList.size()==0)
    	//	result = insertNewStation(lat, lng);
    	
    	
    	if(!lat.contains(".")){
    		lat = lat.substring(0, 2) + "." + lat.substring(2, lat.length());
    	}
    	
    	if(!lng.contains(".")){
    		lng = lng.substring(0, 2) + "." + lng.substring(2, lng.length());
    	}
    	
    	Station nearestStation = null;
    	double nearestDistance = 10000000;
    	for (Iterator iterator = stationList.iterator(); iterator.hasNext();) {
			Station station = (Station) iterator.next();
			double discante = distance(new Double(station.getLat()), new Double(station.getLng()), new Double(lng), new Double(lat), "K");
			if(discante<52) {
				System.out.println("discante:"+discante+ ",lat="+lat+",lng="+lng+"st_lat="+station.getLat()+",st_lan="+station.getLng());
				nearestStation = station;
				nearestDistance =  discante;
				break;
			}	
			if(discante<nearestDistance) {
				nearestDistance = discante;
				nearestStation = station;
			}
		}
    	
    	if(nearestStation.getId()==4690)
    		System.out.println("dsfsdfsdf");
    	System.out.println("nearest distance = " + nearestDistance);
    	return nearestStation;
    	
    	
    	//if(result == null)
    		//result = insertNewStation(lat, lng);
    	
    	
    	//return result;
    }
    
    public Station insertNewStation(String lat,String lng) {
    	Random rand = new Random();
    	Station station = new Station();
    	station.setLat(lat);
    	station.setLng(lng);
    	station.setName("DURAK_"+rand.nextInt(1000));
    	stationRepository.save(station);
    	return station;
    }
    
    private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344 * 1000;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
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
			result = 0l;
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
			result = 0l;
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
	
	public Long calculateCurrentPassengerCount(RawTable lastRawTable,RawTable rawTable) {
		if( lastRawTable == null) { 
			Long totalGetIn = calculateGetInOfRawTable(rawTable);
			Long totalGetOut = calculateGetOutOfRawTable(rawTable);
			correction = totalGetIn - totalGetOut;
			System.out.println("correction : "+ correction);
			return 0l;
		}	
		Long totalGetIn = calculateGetInOfRawTable(rawTable);
		Long totalGetOut = calculateGetOutOfRawTable(rawTable);
		
		//totalGetIn  =totalGetIn + 130;
		return totalGetIn - totalGetOut-correction;
	}
}
