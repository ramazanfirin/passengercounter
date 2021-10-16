package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.Station;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Station entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

}
