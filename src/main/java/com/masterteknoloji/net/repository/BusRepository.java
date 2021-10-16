package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.Bus;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Bus entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}
