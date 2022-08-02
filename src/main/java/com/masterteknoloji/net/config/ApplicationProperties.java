package com.masterteknoloji.net.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Passengercounter 2.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
	
	String kbbBusLocationServiceEndpoint;
	
	Boolean activateScheduled;
	
	Boolean simulation;
	
	String mersinTiKodu;
	
	String mersinProjeKodu;
	

	public String getMersinTiKodu() {
		return mersinTiKodu;
	}

	public void setMersinTiKodu(String mersinTiKodu) {
		this.mersinTiKodu = mersinTiKodu;
	}

	public String getMersinProjeKodu() {
		return mersinProjeKodu;
	}

	public void setMersinProjeKodu(String mersinProjeKodu) {
		this.mersinProjeKodu = mersinProjeKodu;
	}

	public Boolean getSimulation() {
		return simulation;
	}

	public void setSimulation(Boolean simulation) {
		this.simulation = simulation;
	}

	public Boolean getActivateScheduled() {
		return activateScheduled;
	}

	public void setActivateScheduled(Boolean activateScheduled) {
		this.activateScheduled = activateScheduled;
	}

	public String getKbbBusLocationServiceEndpoint() {
		return kbbBusLocationServiceEndpoint;
	}

	public void setKbbBusLocationServiceEndpoint(String kbbBusLocationServiceEndpoint) {
		this.kbbBusLocationServiceEndpoint = kbbBusLocationServiceEndpoint;
	}

	
}
