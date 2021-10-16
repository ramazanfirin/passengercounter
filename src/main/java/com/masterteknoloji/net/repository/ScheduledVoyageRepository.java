package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.ScheduledVoyage;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ScheduledVoyage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ScheduledVoyageRepository extends JpaRepository<ScheduledVoyage, Long> {

}
