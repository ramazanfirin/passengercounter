package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.Station;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the Route entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
	@Query("select a from Route a where a.name=:name")
	Route findByName(@Param("name") String name);
	
	@Query("select a from Route a where a.routeId=:routeId")
	Route findByRouteId(@Param("routeId") Long routeId);
	
	@Query("select a from Route a where a.routeCode=:routeCode")
	Route findByRouteCode(@Param("routeCode") String routeCode);
}
