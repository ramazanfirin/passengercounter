package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.Route;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Route entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}
