package com.masterteknoloji.net.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A RawTable.
 */
@Entity
@Table(name = "raw_table")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RawTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id_original")
    private String deviceIdOriginal;

    @Column(name = "up_people_1")
    private Long upPeople1;

    @Column(name = "down_people_1")
    private Long downPeople1;

    @Column(name = "up_people_2")
    private Long upPeople2;

    @Column(name = "down_people_2")
    private Long downPeople2;

    @Column(name = "up_people_3")
    private Long upPeople3;

    @Column(name = "down_people_3")
    private Long downPeople3;

    @Column(name = "up_people_4")
    private Long upPeople4;

    @Column(name = "down_people_4")
    private Long downPeople4;

    @Column(name = "cur_people")
    private Long curPeople;

    @Column(name = "incr_people")
    private Long incrPeople;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;

    @Column(name = "insert_date")
    private Instant insertDate;

    @Column(name = "processed")
    private Boolean processed;

    @Column(name = "is_success")
    private Boolean isSuccess;

    @Column(name = "error_message")
    private String errorMessage;

    @ManyToOne
    private Device device;

    @ManyToOne
    private ScheduledVoyage voyage;

    @ManyToOne
    private Station station;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceIdOriginal() {
        return deviceIdOriginal;
    }

    public RawTable deviceIdOriginal(String deviceIdOriginal) {
        this.deviceIdOriginal = deviceIdOriginal;
        return this;
    }

    public void setDeviceIdOriginal(String deviceIdOriginal) {
        this.deviceIdOriginal = deviceIdOriginal;
    }

    public Long getUpPeople1() {
        return upPeople1;
    }

    public RawTable upPeople1(Long upPeople1) {
        this.upPeople1 = upPeople1;
        return this;
    }

    public void setUpPeople1(Long upPeople1) {
        this.upPeople1 = upPeople1;
    }

    public Long getDownPeople1() {
        return downPeople1;
    }

    public RawTable downPeople1(Long downPeople1) {
        this.downPeople1 = downPeople1;
        return this;
    }

    public void setDownPeople1(Long downPeople1) {
        this.downPeople1 = downPeople1;
    }

    public Long getUpPeople2() {
        return upPeople2;
    }

    public RawTable upPeople2(Long upPeople2) {
        this.upPeople2 = upPeople2;
        return this;
    }

    public void setUpPeople2(Long upPeople2) {
        this.upPeople2 = upPeople2;
    }

    public Long getDownPeople2() {
        return downPeople2;
    }

    public RawTable downPeople2(Long downPeople2) {
        this.downPeople2 = downPeople2;
        return this;
    }

    public void setDownPeople2(Long downPeople2) {
        this.downPeople2 = downPeople2;
    }

    public Long getUpPeople3() {
        return upPeople3;
    }

    public RawTable upPeople3(Long upPeople3) {
        this.upPeople3 = upPeople3;
        return this;
    }

    public void setUpPeople3(Long upPeople3) {
        this.upPeople3 = upPeople3;
    }

    public Long getDownPeople3() {
        return downPeople3;
    }

    public RawTable downPeople3(Long downPeople3) {
        this.downPeople3 = downPeople3;
        return this;
    }

    public void setDownPeople3(Long downPeople3) {
        this.downPeople3 = downPeople3;
    }

    public Long getUpPeople4() {
        return upPeople4;
    }

    public RawTable upPeople4(Long upPeople4) {
        this.upPeople4 = upPeople4;
        return this;
    }

    public void setUpPeople4(Long upPeople4) {
        this.upPeople4 = upPeople4;
    }

    public Long getDownPeople4() {
        return downPeople4;
    }

    public RawTable downPeople4(Long downPeople4) {
        this.downPeople4 = downPeople4;
        return this;
    }

    public void setDownPeople4(Long downPeople4) {
        this.downPeople4 = downPeople4;
    }

    public Long getCurPeople() {
        return curPeople;
    }

    public RawTable curPeople(Long curPeople) {
        this.curPeople = curPeople;
        return this;
    }

    public void setCurPeople(Long curPeople) {
        this.curPeople = curPeople;
    }

    public Long getIncrPeople() {
        return incrPeople;
    }

    public RawTable incrPeople(Long incrPeople) {
        this.incrPeople = incrPeople;
        return this;
    }

    public void setIncrPeople(Long incrPeople) {
        this.incrPeople = incrPeople;
    }

    public String getLat() {
        return lat;
    }

    public RawTable lat(String lat) {
        this.lat = lat;
        return this;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public RawTable lng(String lng) {
        this.lng = lng;
        return this;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Instant getInsertDate() {
        return insertDate;
    }

    public RawTable insertDate(Instant insertDate) {
        this.insertDate = insertDate;
        return this;
    }

    public void setInsertDate(Instant insertDate) {
        this.insertDate = insertDate;
    }

    public Boolean isProcessed() {
        return processed;
    }

    public RawTable processed(Boolean processed) {
        this.processed = processed;
        return this;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean isIsSuccess() {
        return isSuccess;
    }

    public RawTable isSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public RawTable errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Device getDevice() {
        return device;
    }

    public RawTable device(Device device) {
        this.device = device;
        return this;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public ScheduledVoyage getVoyage() {
        return voyage;
    }

    public RawTable voyage(ScheduledVoyage scheduledVoyage) {
        this.voyage = scheduledVoyage;
        return this;
    }

    public void setVoyage(ScheduledVoyage scheduledVoyage) {
        this.voyage = scheduledVoyage;
    }

    public Station getStation() {
        return station;
    }

    public RawTable station(Station station) {
        this.station = station;
        return this;
    }

    public void setStation(Station station) {
        this.station = station;
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
        RawTable rawTable = (RawTable) o;
        if (rawTable.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rawTable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RawTable{" +
            "id=" + getId() +
            ", deviceIdOriginal='" + getDeviceIdOriginal() + "'" +
            ", upPeople1=" + getUpPeople1() +
            ", downPeople1=" + getDownPeople1() +
            ", upPeople2=" + getUpPeople2() +
            ", downPeople2=" + getDownPeople2() +
            ", upPeople3=" + getUpPeople3() +
            ", downPeople3=" + getDownPeople3() +
            ", upPeople4=" + getUpPeople4() +
            ", downPeople4=" + getDownPeople4() +
            ", curPeople=" + getCurPeople() +
            ", incrPeople=" + getIncrPeople() +
            ", lat='" + getLat() + "'" +
            ", lng='" + getLng() + "'" +
            ", insertDate='" + getInsertDate() + "'" +
            ", processed='" + isProcessed() + "'" +
            ", isSuccess='" + isIsSuccess() + "'" +
            ", errorMessage='" + getErrorMessage() + "'" +
            "}";
    }
}
