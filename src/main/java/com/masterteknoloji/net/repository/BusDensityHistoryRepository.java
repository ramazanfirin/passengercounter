package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.BusDensityHistory;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the BusDensityHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BusDensityHistoryRepository extends JpaRepository<BusDensityHistory, Long> {

}
