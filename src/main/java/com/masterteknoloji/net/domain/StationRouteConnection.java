package com.masterteknoloji.net.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A StationRouteConnection.
 */
@Entity
@Table(name = "station_route_connection")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StationRouteConnection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "jhi_index")
    private Long index;

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

    public String getName() {
        return name;
    }

    public StationRouteConnection name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIndex() {
        return index;
    }

    public StationRouteConnection index(Long index) {
        this.index = index;
        return this;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Station getStation() {
        return station;
    }

    public StationRouteConnection station(Station station) {
        this.station = station;
        return this;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Route getRoute() {
        return route;
    }

    public StationRouteConnection route(Route route) {
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
        StationRouteConnection stationRouteConnection = (StationRouteConnection) o;
        if (stationRouteConnection.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stationRouteConnection.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StationRouteConnection{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", index=" + getIndex() +
            "}";
    }
}
