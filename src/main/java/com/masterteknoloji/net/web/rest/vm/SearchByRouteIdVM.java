package com.masterteknoloji.net.web.rest.vm;

import java.time.Instant;

public class SearchByRouteIdVM {

	Long routeId;
	Instant date;
	Long scheduledVoyageId;
	
	public Long getScheduledVoyageId() {
		return scheduledVoyageId;
	}
	public void setScheduledVoyageId(Long scheduledVoyageId) {
		this.scheduledVoyageId = scheduledVoyageId;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	
}
