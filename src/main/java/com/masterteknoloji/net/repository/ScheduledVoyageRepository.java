package com.masterteknoloji.net.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.domain.StationRouteConnection;


/**
 * Spring Data JPA repository for the ScheduledVoyage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ScheduledVoyageRepository extends JpaRepository<ScheduledVoyage, Long> {
	
	@Query("select a from ScheduledVoyage a where a.route.id =:routeId and a.scheduledTime = :scheduledTime")
	ScheduledVoyage findScheduledVoyage(@Param("routeId") Long routeId,@Param("scheduledTime") Instant scheduledTime);

	@Query("select a from ScheduledVoyage a where a.route.id =:routeId and a.scheduledTime > :startDate and a.scheduledTime< :endDate")
	List<ScheduledVoyage> findByRouteId(@Param("routeId") Long routeId,@Param("startDate") Instant startDate,@Param("endDate") Instant endDate);
}
