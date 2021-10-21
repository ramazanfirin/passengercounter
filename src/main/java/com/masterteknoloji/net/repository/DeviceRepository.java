package com.masterteknoloji.net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masterteknoloji.net.domain.Device;


/**
 * Spring Data JPA repository for the Device entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

	@Query("select a from Device a where a.bus.id=:busId")
	List<Device> findDevicesByBusId(@Param("busId") Long busId);
	
	@Query("select a from Device a where a.deviceId=:deviceId")
	Device findDeviceByDeviceId(@Param("deviceId") String deviceId);
}
