package com.masterteknoloji.net.repository;

import com.masterteknoloji.net.domain.RawTable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the RawTable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RawTableRepository extends JpaRepository<RawTable, Long> {

}
