package com.example.application;

import com.google.gson.annotations.SerializedName;

public class Page1Info {

    @SerializedName("locationId")
    private int locationId;
    @SerializedName("locationName")
    private String locationName;
    @SerializedName("image")
    private String image;
    @SerializedName("userId")
    private int userId;
    @SerializedName("month")
    private int month;
    @SerializedName("day")
    private int day;
    @SerializedName("hour")
    private int hour;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
