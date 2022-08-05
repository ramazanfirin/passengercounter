package com.masterteknoloji.net.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Bus.
 */
@Entity
@Table(name = "bus")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "bus_id")
    private Long busId;

    @Transient
    private Route currentRoute;
    
    @Transient
    private Station currentStation;
    
    @Transient
    private ScheduledVoyage currentScheduledVoyage;
    
    @Transient
    private Long currentPassengerCount;
    
    @Transient
    private long currentDensity;
    
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public Bus plate(String plate) {
        this.plate = plate;
        return this;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getBusId() {
        return busId;
    }

    public Bus busId(Long busId) {
        this.busId = busId;
        return this;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bus bus = (Bus) o;
        if (bus.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bus.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Bus{" +
            "id=" + getId() +
            ", plate='" + getPlate() + "'" +
            ", busId=" + getBusId() +
            "}";
    }

	public Route getCurrentRoute() {
		return currentRoute;
	}

	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute = currentRoute;
	}

	public Station getCurrentStation() {
		return currentStation;
	}

	public void setCurrentStation(Station currentStation) {
		this.currentStation = currentStation;
	}

	public ScheduledVoyage getCurrentScheduledVoyage() {
		return currentScheduledVoyage;
	}

	public void setCurrentScheduledVoyage(ScheduledVoyage currentScheduledVoyage) {
		this.currentScheduledVoyage = currentScheduledVoyage;
	}

	public Long getCurrentPassengerCount() {
		return currentPassengerCount;
	}

	public void setCurrentPassengerCount(Long currentPassengerCount) {
		this.currentPassengerCount = currentPassengerCount;
	}

	public long getCurrentDensity() {
		return currentDensity;
	}

	public void setCurrentDensity(long currentDensity) {
		this.currentDensity = currentDensity;
	}
}
