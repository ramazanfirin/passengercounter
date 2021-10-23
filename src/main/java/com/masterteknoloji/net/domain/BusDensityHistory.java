package com.masterteknoloji.net.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A BusDensityHistory.
 */
@Entity
@Table(name = "bus_density_history")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BusDensityHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_date")
    private Instant recordDate;

    @Column(name = "total_passenger_count")
    private Long totalPassengerCount;

    @Column(name = "get_in_passenger_count")
    private Long getInPassengerCount;

    @Column(name = "get_out_passenger_count")
    private Long getOutPassengerCount;

    @Column(name = "density")
    private Long density;

    @ManyToOne
    private ScheduledVoyage scheduledVoyage;

    @ManyToOne
    private Bus bus;

    @ManyToOne
    private Station station;

    @ManyToOne
    private Route route;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getRecordDate() {
        return recordDate;
    }

    public BusDensityHistory recordDate(Instant recordDate) {
        this.recordDate = recordDate;
        return this;
    }

    public void setRecordDate(Instant recordDate) {
        this.recordDate = recordDate;
    }

    public Long getTotalPassengerCount() {
        return totalPassengerCount;
    }

    public BusDensityHistory totalPassengerCount(Long totalPassengerCount) {
        this.totalPassengerCount = totalPassengerCount;
        return this;
    }

    public void setTotalPassengerCount(Long totalPassengerCount) {
        this.totalPassengerCount = totalPassengerCount;
    }

    public Long getGetInPassengerCount() {
        return getInPassengerCount;
    }

    public BusDensityHistory getInPassengerCount(Long getInPassengerCount) {
        this.getInPassengerCount = getInPassengerCount;
        return this;
    }

    public void setGetInPassengerCount(Long getInPassengerCount) {
        this.getInPassengerCount = getInPassengerCount;
    }

    public Long getGetOutPassengerCount() {
        return getOutPassengerCount;
    }

    public BusDensityHistory getOutPassengerCount(Long getOutPassengerCount) {
        this.getOutPassengerCount = getOutPassengerCount;
        return this;
    }

    public void setGetOutPassengerCount(Long getOutPassengerCount) {
        this.getOutPassengerCount = getOutPassengerCount;
    }

    public Long getDensity() {
        return density;
    }

    public BusDensityHistory density(Long density) {
        this.density = density;
        return this;
    }

    public void setDensity(Long density) {
        this.density = density;
    }

    public ScheduledVoyage getScheduledVoyage() {
        return scheduledVoyage;
    }

    public BusDensityHistory scheduledVoyage(ScheduledVoyage scheduledVoyage) {
        this.scheduledVoyage = scheduledVoyage;
        return this;
    }

    public void setScheduledVoyage(ScheduledVoyage scheduledVoyage) {
        this.scheduledVoyage = scheduledVoyage;
    }

    public Bus getBus() {
        return bus;
    }

    public BusDensityHistory bus(Bus bus) {
        this.bus = bus;
        return this;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Station getStation() {
        return station;
    }

    public BusDensityHistory station(Station station) {
        this.station = station;
        return this;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Route getRoute() {
        return route;
    }

    public BusDensityHistory route(Route route) {
        this.route = route;
        return this;
    }

    public void setRoute(Route route) {
        this.route = route;
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
        BusDensityHistory busDensityHistory = (BusDensityHistory) o;
        if (busDensityHistory.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), busDensityHistory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BusDensityHistory{" +
            "id=" + getId() +
            ", recordDate='" + getRecordDate() + "'" +
            ", totalPassengerCount=" + getTotalPassengerCount() +
            ", getInPassengerCount=" + getGetInPassengerCount() +
            ", getOutPassengerCount=" + getGetOutPassengerCount() +
            ", density=" + getDensity() +
            "}";
    }
}
