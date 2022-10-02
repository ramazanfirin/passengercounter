package com.masterteknoloji.net.repository;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masterteknoloji.net.domain.BusDensityHistory;


/**
 * Spring Data JPA repository for the BusDensityHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BusDensityHistoryRepository extends JpaRepository<BusDensityHistory, Long> {

	@Query("select a from BusDensityHistory a where a.bus.id=:busId and a.station.id=:stationId and a.route.id=:routeId and a.scheduledVoyage.id = :scheduledVoyageId")
	List<BusDensityHistory> findOldRecord(@Param("busId") Long busId, @Param("stationId") Long stationId,@Param("routeId") Long routeId ,@Param("scheduledVoyageId") Long scheduledVoyageId );
	
	@Query("select a from BusDensityHistory a where a.route.id=:routeId and a.scheduledVoyage.id = :scheduledVoyageId")
	List<BusDensityHistory> findByScheduledVoyageId(@Param("routeId") Long routeId, @Param("scheduledVoyageId") Long scheduledVoyageId );

	@Query("select count(a) from BusDensityHistory a where a.route.id=:routeId and a.scheduledVoyage.id = :scheduledVoyageId and a.bus.id = :busId")
	Long findByRouteIdAndScheduledVoyageId(@Param("routeId") Long routeId, @Param("scheduledVoyageId") Long scheduledVoyageId, @Param("busId") Long busId );

	@Query(value = "select \r\n"
			+ "busdensity0_.scheduled_voyage_id as voyageId, \r\n"
			+ "scheduledv1_.scheduled_time as voyageTime, \r\n"
			+ "station2_.name as stationName, \r\n"
			+ "busdensity0_.station_id as stationId, \r\n"
			+ "busdensity0_.total_passenger_count as passengerCount \r\n"
			+ "from bus_density_history busdensity0_ \r\n"
			+ "cross join scheduled_voyage scheduledv1_ \r\n"
			+ "cross join station station2_ \r\n"
			+ "where busdensity0_.scheduled_voyage_id=scheduledv1_.id and busdensity0_.station_id=station2_.id and \r\n"
			+ "busdensity0_.route_id=:routeId and \r\n"
			+ "scheduledv1_.scheduled_time>:startDate and \r\n"
			+ "scheduledv1_.scheduled_time<:endDate \r\n"
			+ "group by busdensity0_.scheduled_voyage_id , scheduledv1_.scheduled_time , station2_.name , busdensity0_.station_id order by busdensity0_.scheduled_voyage_id, busdensity0_.record_date\r\n"
			+ "",nativeQuery = true)
	List<Map<String, Object>> findDailyChartData(@Param("routeId") Long routeId, @Param("startDate") Instant startDate,@Param("endDate") Instant endDate );

	@Query(value = "select \r\n"
			+ "busdensity0_.scheduled_voyage_id as voyageId, \r\n"
			+ "scheduledv1_.scheduled_time as voyageTime, \r\n"
			+ "station2_.name as stationName, \r\n"
			+ "busdensity0_.station_id as stationId, \r\n"
			+ "busdensity0_.total_passenger_count as passengerCount \r\n"
			+ "from bus_density_history busdensity0_ \r\n"
			+ "cross join scheduled_voyage scheduledv1_ \r\n"
			+ "cross join station station2_ \r\n"
			+ "where busdensity0_.scheduled_voyage_id=scheduledv1_.id and busdensity0_.station_id=station2_.id and \r\n"
			+ "busdensity0_.route_id=:routeId and \r\n" 
			+ "busdensity0_.scheduled_voyage_id=:scheduledVoyageId \r\n"
			//+ "scheduledv1_.scheduled_time>:startDate and \r\n"
			//+ "scheduledv1_.scheduled_time<:endDate \r\n"
			+ "group by busdensity0_.scheduled_voyage_id , scheduledv1_.scheduled_time , station2_.name , busdensity0_.station_id order by busdensity0_.scheduled_voyage_id, busdensity0_.record_date\r\n"
			+ "",nativeQuery = true)
	List<Map<String, Object>> findDailyChartData(@Param("routeId") Long routeId, @Param("scheduledVoyageId") Long scheduledVoyageId);

}
