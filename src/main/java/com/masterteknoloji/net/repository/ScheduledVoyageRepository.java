package com.masterteknoloji.net.repository;

import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masterteknoloji.net.domain.ScheduledVoyage;


/**
 * Spring Data JPA repository for the ScheduledVoyage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ScheduledVoyageRepository extends JpaRepository<ScheduledVoyage, Long> {
	
	@Query("select a from ScheduledVoyage a where a.route.id =:routeId and a.scheduledTime = :scheduledTime")
	ScheduledVoyage findScheduledVoyage(@Param("routeId") Long routeId,@Param("scheduledTime") Instant scheduledTime);

}
