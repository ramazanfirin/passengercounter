package com.masterteknoloji.net.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterteknoloji.net.config.ApplicationProperties;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.repository.StationRouteConnectionRepository;
import com.masterteknoloji.net.web.rest.vm.kbb.BusLocationInformationVM;

@Service
@Transactional
public class IntegrationService {
	
	private final ApplicationProperties applicationProperties;
	
	private final ObjectMapper objectMapper;
	
	private final RouteRepository routeRepository;
	
	private final StationRepository stationRepository;
	
	private final StationRouteConnectionRepository stationRouteConnectionRepository;
	
	public IntegrationService(ApplicationProperties applicationProperties, ObjectMapper objectMapper,
			RouteRepository routeRepository, StationRepository stationRepository, StationRouteConnectionRepository stationRouteConnectionRepository) {
		super();
		this.applicationProperties = applicationProperties;
		this.objectMapper = objectMapper;
		this.routeRepository = routeRepository;
		this.stationRepository = stationRepository;
		this.stationRouteConnectionRepository = stationRouteConnectionRepository;
	}

	public BusLocationInformationVM getInformationOfBus(Long busId) throws ParseException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		BusLocationInformationVM busLocation = null;
		String result="";
		try {
			HttpGet request = new HttpGet(applicationProperties.getKbbBusLocationServiceEndpoint()+busId);
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				System.out.println(response.getProtocolVersion()); // HTTP/1.1
				System.out.println(response.getStatusLine().getStatusCode()); // 200
				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
				System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity);
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
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		busLocation = objectMapper.readValue(result, BusLocationInformationVM.class);

		return busLocation;
	}
	
	public void getRouteListFromMersin() throws JsonProcessingException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		BusLocationInformationVM busLocation = null;
		String result="";
		try {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("aranan", "TUM"));
			formparams.add(new BasicNameValuePair("tipi", "hatbilgisi"));
			UrlEncodedFormEntity entityForm = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
			
			HttpPost request = new HttpPost("https://ulasim.mersin.bel.tr/ajax/bilgi.php");
			request.setEntity(entityForm);
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				System.out.println(response.getProtocolVersion()); // HTTP/1.1
				System.out.println(response.getStatusLine().getStatusCode()); // 200
				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
				System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity);
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
		
		JsonNode jsonNodeRoot = objectMapper.readTree(result);
		if (jsonNodeRoot.isArray()) {
		    for (final JsonNode objNode : jsonNodeRoot) {
		    	Route route = new Route();
		       
		        JsonNode hatNode = objNode.get("hat_no");
		        String hat_no=hatNode.get("0").asText();
		        
		        JsonNode hatYonNode = objNode.get("hat_yon");
		        String hat_yon=hatYonNode.get("0").asText();
		        
		        JsonNode hatAdiNode = objNode.get("hat_adi");
		        String hat_adi=hatAdiNode.get("0").asText();
		        
		        JsonNode bolgeNode = objNode.get("bolge");
		        String bolge=bolgeNode.get("0").asText();
		        
		        System.out.println(hat_no+ " "+hat_yon+ " "+hat_adi+ " "+bolge);
		        
		        route.setName(hat_adi+"-"+hat_yon);
		        route.setInversed(null);
		        route.setRouteId(null);
		        route.setRouteCode(hat_no+"-"+hat_yon);
		        
		        routeRepository.save(route);
		    }
		    
		    
		}
		
		System.out.println("sdfdsdsf");
	}
	
	public void getStationListFromMersin() throws JsonProcessingException, IOException {
		
		List<Route> routeList = routeRepository.findAll();
		for (Iterator iterator = routeList.iterator(); iterator.hasNext();) {
			CloseableHttpClient httpClient = HttpClients.createDefault();

			Route route = (Route) iterator.next();

			String result = "";
			try {
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				formparams.add(new BasicNameValuePair("hatno", route.getRouteCode()));
				formparams.add(new BasicNameValuePair("tipi", "hatdurak"));
				UrlEncodedFormEntity entityForm = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

				HttpPost request = new HttpPost("https://ulasim.mersin.bel.tr/ajax/bilgi.php");
				request.setEntity(entityForm);
				CloseableHttpResponse response = httpClient.execute(request);
				try {
					System.out.println(response.getProtocolVersion()); // HTTP/1.1
					System.out.println(response.getStatusLine().getStatusCode()); // 200
					System.out.println(response.getStatusLine().getReasonPhrase()); // OK
					System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					response.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				httpClient.close();
			}

			Long index = 1l;
			JsonNode jsonNodeRoot = objectMapper.readTree(result);
			if (jsonNodeRoot.isArray()) {
				for (final JsonNode objNode : jsonNodeRoot) {

					JsonNode enlemNode = objNode.get("enlem");
					String enlem = enlemNode.get("0").asText();

					JsonNode boylamNode = objNode.get("boylam");
					String boylam = boylamNode.get("0").asText();

					JsonNode durakNode = objNode.get("durak_no");
					Long durak_no = durakNode.get("0").asLong();

					JsonNode durakAdiNode = objNode.get("durak_adi");
					String durakAdi = durakAdiNode.get("0").asText();

					Station station = stationRepository.findByStationId(durak_no);
					if (station == null) {
						station = new Station();
						station.setLat(enlem);
						station.setLng(boylam);
						station.setName(durakAdi);
						station.setStationId(durak_no);
					    stationRepository.save(station);
					}

					
					StationRouteConnection stationRouteConnection = new StationRouteConnection();
					stationRouteConnection.setRoute(route);
					stationRouteConnection.setStation(station);
					stationRouteConnection.setIndex(index);

					stationRouteConnectionRepository.save(stationRouteConnection);
					index=index+1;
				}

			}
		}

		System.out.println("sdfdsdsf");
	}
}
