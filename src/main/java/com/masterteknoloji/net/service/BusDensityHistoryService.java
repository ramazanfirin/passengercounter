package com.masterteknoloji.net.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Bus;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.BusDensityHistoryRepository;
import com.masterteknoloji.net.repository.BusRepository;

@Service
@Transactional
public class BusDensityHistoryService {

	private final BusDensityHistoryRepository busDensityHistoryRepository;
	
	public BusDensityHistoryService(BusDensityHistoryRepository busDensityHistoryRepository) {
		super();
		this.busDensityHistoryRepository = busDensityHistoryRepository;
	}
	
	public Long getRecordCount(Long routeId,Long scheduledVoyageId,Long busId) {
		return busDensityHistoryRepository.findByRouteIdAndScheduledVoyageId(routeId, scheduledVoyageId, busId);
	}
}
