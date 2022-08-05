package com.masterteknoloji.net.service;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.Bus;
import com.masterteknoloji.net.domain.Device;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.repository.DeviceRepository;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;

@Service
@Transactional
public class DeviceService {

	private final DeviceRepository deviceRepository;
	
	public DeviceService(DeviceRepository deviceRepository) {
		super();
		this.deviceRepository = deviceRepository;
	}
	
	public Device findByDeviceId(String deviceId) {
		Device device = deviceRepository.findDeviceByDeviceId(deviceId);
		return device;
	}
}
