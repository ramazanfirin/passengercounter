package com.masterteknoloji.net.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.masterteknoloji.net.domain.RawTable;
import com.masterteknoloji.net.repository.RawTableRepository;

@Service
@Transactional
public class RawTableService {

	private final RawTableRepository rawTableRepository;
	
	public RawTableService(RawTableRepository rawTableRepository) {
		super();
		this.rawTableRepository = rawTableRepository;
	}
	
	public void save(RawTable rawTable) {
		rawTableRepository.save(rawTable);
	}
	
//	public RawTable getLastRawTableByDeviceId(String deviceId) {
//		rawTableRepository.save(rawTable);
//	}
}
