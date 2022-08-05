package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.BusDensityHistory;
import com.masterteknoloji.net.domain.Device;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the BusDensityHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BusDensityHistoryRepository extends JpaRepository<BusDensityHistory, Long> {

	@Query("select a from BusDensityHistory a where a.bus.id=:busId and a.station.id=:stationId and a.route.id=:routeId and a.scheduledVoyage.id = :scheduledVoyageId")
	List<BusDensityHistory> findOldRecord(@Param("busId") Long busId, @Param("stationId") Long stationId,@Param("routeId") Long routeId ,@Param("scheduledVoyageId") Long scheduledVoyageId );
	
	@Query("select a from BusDensityHistory a where a.route.id=:routeId and a.scheduledVoyage.id = :scheduledVoyageId")
	List<BusDensityHistory> findByScheduledVoyageId(@Param("routeId") Long routeId, @Param("scheduledVoyageId") Long scheduledVoyageId );

	@Query("select count(a) from BusDensityHistory a where a.route.id=:routeId and a.scheduledVoyage.id = :scheduledVoyageId and a.bus.id = :busId")
	Long findByRouteIdAndScheduledVoyageId(@Param("routeId") Long routeId, @Param("scheduledVoyageId") Long scheduledVoyageId, @Param("busId") Long busId );

}
