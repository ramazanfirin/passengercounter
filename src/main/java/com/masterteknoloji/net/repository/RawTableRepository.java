package com.masterteknoloji.net.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masterteknoloji.net.domain.RawTable;


/**
 * Spring Data JPA repository for the RawTable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RawTableRepository extends JpaRepository<RawTable, Long> {

	@Query("select a from RawTable a where a.processed=false order by id")
	List<RawTable> findUnprocessedRecords(Pageable pageable);
}
