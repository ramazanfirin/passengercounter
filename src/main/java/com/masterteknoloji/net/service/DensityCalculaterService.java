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
    
    public DensityCalculaterService(RawTableRepository rawTableRepository, 
    		BusDensityHistoryRepository busDensityHistoryRepository,DeviceRepository deviceRepository, 
    		StationService stationService,RouteService routeService,
    		ScheduledVoyageRepository scheduledVoyageRepository,ApplicationProperties applicationProperties,
    		IntegrationService integrationService, ObjectMapper objectMapper,StationRepository stationRepository) {
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
	
	public void calculateCoordinatesOfRawTable(RawTable rawTable) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		BusLocationInformationVM busLocation = null;
		String result="";
		
		String deviceId=rawTable.getDeviceIdOriginal();
		Instant endDate=rawTable.getInsertDate().plusSeconds(5);
		Instant startDate=rawTable.getInsertDate().plusSeconds(-5);
		
		String start = simpleDateFormat.format(Date.from(startDate));
		String end = simpleDateFormat.format(Date.from(endDate));
		//String parameters = URLEncoder.encode("devIdno="+deviceId.toString()+"&begintime="+start+"&endtime="+end,"UTF-8");
		String parameters = "devIdno="+deviceId.toString()+"&begintime="+start+"&endtime="+end;
		
		String url = "http://passengercounter.masterteknoloji.net/StandardApiAction_queryTrackDetail.action?"+parameters.replace(" ", "+");
		try {
			HttpGet request = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				System.out.println(response.getProtocolVersion()); // HTTP/1.1
				System.out.println(response.getStatusLine().getStatusCode()); // 200
				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
				System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity);
					JsonNode actualObj = objectMapper.readTree(result);
					
					ArrayNode arrayNode = (ArrayNode)actualObj.get("tracks");
					JsonNode item = arrayNode.get(0);
					JsonNode lat = item.get("lat");
					JsonNode lng = item.get("lng");
					
					rawTable.setLat((String)lat.asText());
					rawTable.setLng((String)lng.asText());
					rawTableRepository.save(rawTable);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			httpClient.close();
		}
		System.out.println("kbb servisi çağrıldı");
		System.out.println("result:"+result);
		
	}
	
    public void calculateDensity() {
    	log.info("calculateDensity basladi");
    	
    	
    	List<RawTable> unprocessedList = rawTableRepository.findUnprocessedRecords(new PageRequest(0, 10));
    	int i =0;
    	for (RawTable rawTable : unprocessedList) {
    		try {
    			calculateCoordinatesOfRawTable(rawTable);
    		
    			rawTable = rawTableRepository.findOne(rawTable.getId());
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
    		    	 
    		    	station = findNearestStation(rawTable.getLat(),rawTable.getLng());
    		    	
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
					busDensityHistory.setFirstRawRecord(rawTable);
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
				
				//busDensityHistory.setRecordDate(rawTable.getInsertDate());
				busDensityHistory.setLastRawRecord(rawTable);
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
    
    public Station findNearestStation(String lat,String lng) {
    	Station result = null;
    	List<Station> stationList = stationRepository.findAll();
    	if(stationList.size()==0)
    		result = insertNewStation(lat, lng);
    	
    	for (Iterator iterator = stationList.iterator(); iterator.hasNext();) {
			Station station = (Station) iterator.next();
			double discante = distance(new Double(station.getLat()), new Double(station.getLng()), new Double(lat), new Double(lng), "K");
			if(discante<10)
				result = station;
    	}
    	
    	if(result == null)
    		result = insertNewStation(lat, lng);
    	
    	
    	return result;
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
				dist = dist * 1.609344 / 1000;
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
