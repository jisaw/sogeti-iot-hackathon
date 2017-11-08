package com.sogeti.us.model;

public class ApiRecord {

    private int id;
    private String recordedTimestamp;
    private Long latitude;
    private Long longitude;
    private String obd2Data;
    private String imageLocation;

    //----

    public ApiRecord() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecordedTimestamp() {
        return recordedTimestamp;
    }

    public void setRecordedTimestamp(String recordedTimestamp) {
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
