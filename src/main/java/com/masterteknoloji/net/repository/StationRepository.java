package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.RawTable;
import com.masterteknoloji.net.domain.Station;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the Station entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
	@Query("select a from Station a where a.lat=:lat and a.lng=:lng")
	Station findStationByCoordinates(@Param("lat") String lat,@Param("lng") String lng);

	@Query("select a from Station a where a.name=:name")
	Station findStationByName(@Param("name") String name);
	
	@Query("select a from Station a where a.stationId=:stationId")
	Station findByStationId(@Param("stationId") Long stationId);
}

