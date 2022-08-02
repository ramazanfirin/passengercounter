package com.masterteknoloji.net.service.integrations.mersin;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.axis.message.MessageElement;
import org.springframework.stereotype.Service;

import com.masterteknoloji.net.config.ApplicationProperties;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;
import com.masterteknoloji.net.service.integrations.BaseCityDataProviderServiceImpl;
import com.masterteknoloji.net.web.rest.vm.MersinScheduledVoyageVM;

import entegrations.mersin.DuraklarResponseDuraklarResult;
import entegrations.mersin.Hat_DurakResponseHat_DurakResult;
import entegrations.mersin.HatlarResponseHatlarResult;
import entegrations.mersin.Service1SoapProxy;
import entegrations.mersin.Tarife_araResponseTarife_araResult;

@Service
public class MersinCityDataProviderService extends BaseCityDataProviderServiceImpl{
	
	Service1SoapProxy service1 = new Service1SoapProxy(); 
	
	private final ApplicationProperties applicationProperties;
	
	private String projeKodu;
	private String tiKodu;
	
	public MersinCityDataProviderService(ApplicationProperties applicationProperties) {
		super();
		this.applicationProperties = applicationProperties;
		this.projeKodu = applicationProperties.getMersinProjeKodu();
		this.tiKodu = applicationProperties.getMersinTiKodu();
	}



	@Override
	public List<Station> getStationList() throws Exception {
		List<Station> result = new ArrayList<Station>();
		
		DuraklarResponseDuraklarResult response = service1.getService1Soap().duraklar(projeKodu,tiKodu);
		MessageElement[] elements = response.get_any();	
		List list = elements[1].getChildren();
		
		System.out.println(list.size());
		MessageElement asdf = (MessageElement)list.get(0);
		
		for (Iterator iterator = asdf.getChildren().iterator(); iterator.hasNext();) {
			MessageElement object = (MessageElement) iterator.next();
			String durakNo = findByName(object, "durak_no");
			String durakAdi = findByName(object, "durak_adi");
			String enlem = findByName(object, "enlem");
			String boylam = findByName(object, "boylam");
			
			Station station = new Station();
			if(durakNo!=null)
				station.setStationId(Long.parseLong(durakNo));
			station.setName(durakAdi);
			station.setLat(enlem);
			station.setLng(boylam);
		    result.add(station); 
		};
		
		return result;

	}
	
	@Override
	public List<Route> getRoutList() throws Exception {
		
		List<Route> result = new ArrayList<Route>();
		
		String bolge="MERKEZ";
		HatlarResponseHatlarResult response = service1.getService1Soap().hatlar(projeKodu,tiKodu,bolge);
		MessageElement[] elements = response.get_any();	
		List list = elements[1].getChildren();
		
		MessageElement asdf = (MessageElement)list.get(0);
		
		System.out.println(asdf.getChildren().size());
		
		for (Iterator iterator = asdf.getChildren().iterator(); iterator.hasNext();) {
			MessageElement object = (MessageElement) iterator.next();
			String hatNo = findByName(object, "hat_no");
			String hatAdi = findByName(object, "hat_adi");
			String hatYon = findByName(object, "hat_yon");
			String hatBolge = findByName(object, "hat_bolge");
			
			Route route = new Route();
			if(hatNo!=null)
				route.setRouteId(hatNo);
			route.setName(hatAdi);
			route.setRouteCode(hatNo+"-"+hatYon);
			if(hatYon.equals("D"))
				route.setInversed(true);
			else
				route.setInversed(false);
			
			result.add(route);
		};
		
		
		
		return result;
	}

	
	@Override
	public List<StationRouteConnection> getStationRouteConnectionList(String routeCode) throws Exception{
		List<StationRouteConnection> result = new ArrayList<StationRouteConnection>();
		
		Hat_DurakResponseHat_DurakResult response = service1.getService1Soap().hat_Durak(projeKodu,routeCode,tiKodu);
		MessageElement[] elements = response.get_any();	
		List list = elements[1].getChildren();
		
		MessageElement asdf = (MessageElement)list.get(0);
		
		System.out.println(asdf.getChildren().size());
		
		Route route = new Route();
		route.setRouteCode(routeCode);
		
		for (Iterator iterator = asdf.getChildren().iterator(); iterator.hasNext();) {
			MessageElement object = (MessageElement) iterator.next();
			String durakNo = findByName(object, "durak_no");
			String durakAdi = findByName(object, "durak_adi");
			String enlem = findByName(object, "enlam");
			String boylam = findByName(object, "boylam");
			String sira = findByName(object, "sira");
			
			Station station = new Station();
			if(durakNo!=null)
				station.setStationId(Long.parseLong(durakNo));
			station.setName(durakAdi);
			station.setLat(enlem);
			station.setLng(boylam);
			
			
			
			StationRouteConnection routeConnection = new StationRouteConnection();
			routeConnection.setIndex(Long.parseLong(sira));
			routeConnection.setRoute(route);
			routeConnection.setStation(station);
			
			result.add(routeConnection);
		};
		
		
		
		return result;
	}
	
	@Override
	public List<ScheduledVoyage> getScheduledVoyageList(String routeCode) throws Exception{
		
		List<ScheduledVoyage> result = new ArrayList<ScheduledVoyage>();
		
		Tarife_araResponseTarife_araResult response = service1.getService1Soap().tarife_ara(projeKodu,routeCode,tiKodu);
		MessageElement[] elements = response.get_any();	
		List list = elements[1].getChildren();
		
		MessageElement asdf = (MessageElement)list.get(0);
		
		System.out.println(asdf.getChildren().size());
		
		Route route = new Route();
		route.setRouteCode(routeCode);
		
		for (Iterator iterator = asdf.getChildren().iterator(); iterator.hasNext();) {
			MessageElement object = (MessageElement) iterator.next();
			String tarifeGun = findByName(object, "tarife_gun");
			String hatAdi = findByName(object, "hat_adi");
			String saat = findByName(object, "saat");
			
			ScheduledVoyage scheduledVoyage = new ScheduledVoyage();
			scheduledVoyage.setName(hatAdi);
			scheduledVoyage.setRoute(route);
			
			String[] values = saat.split(":");
			Instant t1 = Instant.now();
			t1.plus(Integer.parseInt(values[0]),ChronoUnit.HOURS).plus(Integer.parseInt(values[1]),ChronoUnit.MINUTES);
			
			scheduledVoyage.setScheduledTime(t1);
			
			result.add(scheduledVoyage);
		};
		
		
		
		return result;
		
	}

	public List<MersinScheduledVoyageVM> getScheduledVoyageListV2(String routeCode) throws Exception{
		
		List<MersinScheduledVoyageVM> result = new ArrayList<MersinScheduledVoyageVM>();
		
		Tarife_araResponseTarife_araResult response = service1.getService1Soap().tarife_ara(projeKodu,routeCode,tiKodu);
		MessageElement[] elements = response.get_any();	
		List list = elements[1].getChildren();
		
		MessageElement asdf = (MessageElement)list.get(0);
		
		System.out.println(asdf.getChildren().size());
		
		Route route = new Route();
		route.setRouteCode(routeCode);
		
		for (Iterator iterator = asdf.getChildren().iterator(); iterator.hasNext();) {
			MessageElement object = (MessageElement) iterator.next();
			String tarifeGun = findByName(object, "tarife_gun");
			String hatAdi = findByName(object, "hat_adi");
			String saat = findByName(object, "saat");
			
			MersinScheduledVoyageVM scheduledVoyage = new MersinScheduledVoyageVM();
			scheduledVoyage.setHatAdi(hatAdi);
			scheduledVoyage.setSaat(saat);
			scheduledVoyage.setTarifeGun(tarifeGun);
			
			result.add(scheduledVoyage);
		};
		
		
		
		return result;
		
	}

}
