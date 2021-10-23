package com.masterteknoloji.net.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterteknoloji.net.config.ApplicationProperties;
import com.masterteknoloji.net.web.rest.vm.kbb.BusLocationInformationVM;

@Service
@Transactional
public class IntegrationService {
	
	private final ApplicationProperties applicationProperties;
	
	private final ObjectMapper objectMapper;
	
	public IntegrationService(ApplicationProperties applicationProperties, ObjectMapper objectMapper) {
		super();
		this.applicationProperties = applicationProperties;
		this.objectMapper = objectMapper;
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
}
