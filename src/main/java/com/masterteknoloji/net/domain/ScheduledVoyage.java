package com.masterteknoloji.net.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A ScheduledVoyage.
 */
@Entity
@Table(name = "scheduled_voyage")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ScheduledVoyage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "scheduled_time")
    private Instant scheduledTime;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Bus bus;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ScheduledVoyage name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getScheduledTime() {
        return scheduledTime;
    }

    public ScheduledVoyage scheduledTime(Instant scheduledTime) {
        this.scheduledTime = scheduledTime;
        return this;
    }

    public void setScheduledTime(Instant scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Route getRoute() {
        return route;
    }

    public ScheduledVoyage route(Route route) {
        this.route = route;
        return this;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Bus getBus() {
        return bus;
    }

    public ScheduledVoyage bus(Bus bus) {
        this.bus = bus;
        return this;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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
        ScheduledVoyage scheduledVoyage = (ScheduledVoyage) o;
        if (scheduledVoyage.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), scheduledVoyage.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ScheduledVoyage{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", scheduledTime='" + getScheduledTime() + "'" +
            "}";
    }
}
