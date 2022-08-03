package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the StationRouteConnection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StationRouteConnectionRepository extends JpaRepository<StationRouteConnection, Long> {

	@Query("select a.station from StationRouteConnection a where a.route.id =:routeId")
	List<Station> findStationListByRouteId(@Param("routeId") Long routeId);
	
	@Query("select a from StationRouteConnection a where a.route.routeCode =:routeCode and a.station.id = :stationId")
	StationRouteConnection findStationRouteConnection(@Param("routeCode") String routeCode,@Param("stationId") Long stationId);

	@Query("select a from StationRouteConnection a where a.route.id =:routeId")
	List<StationRouteConnection> findByRouteId(@Param("routeId") Long routeId);
	
}
