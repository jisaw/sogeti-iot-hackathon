package com.sogeti.us.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
public class ApiRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private ZonedDateTime recordedTimestamp;
    private Long latitude;
    private Long longitude;
    private String obd2Data;
    private String imageLocation;

    //----


    public ApiRecord(ZonedDateTime recordedTimestamp, Long latitude, Long longitude, String obd2Data, String imageLocation) {
        this.recordedTimestamp = recordedTimestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.obd2Data = obd2Data;
        this.imageLocation = imageLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getRecordedTimestamp() {
        return recordedTimestamp;
    }

    public void setRecordedTimestamp(ZonedDateTime recordedTimestamp) {
        this.recordedTimestamp = recordedTimestamp;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getObd2Data() {
        return obd2Data;
    }

    public void setObd2Data(String obd2Data) {
        this.obd2Data = obd2Data;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
