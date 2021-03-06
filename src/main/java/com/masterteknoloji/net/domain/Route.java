package com.masterteknoloji.net.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Route.
 */
@Entity
@Table(name = "route")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "inversed")
    private Boolean inversed;

    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "route_code")
    private String routeCode;

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

    public Route name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isInversed() {
        return inversed;
    }

    public Route inversed(Boolean inversed) {
        this.inversed = inversed;
        return this;
    }

    public void setInversed(Boolean inversed) {
        this.inversed = inversed;
    }

    public Long getRouteId() {
        return routeId;
    }

    public Route routeId(Long routeId) {
        this.routeId = routeId;
        return this;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public Route routeCode(String routeCode) {
        this.routeCode = routeCode;
        return this;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
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
        Route route = (Route) o;
        if (route.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), route.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Route{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", inversed='" + isInversed() + "'" +
            ", routeId=" + getRouteId() +
            ", routeCode='" + getRouteCode() + "'" +
            "}";
    }
}
