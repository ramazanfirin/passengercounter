package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.StationRouteConnection;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the StationRouteConnection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StationRouteConnectionRepository extends JpaRepository<StationRouteConnection, Long> {

}
