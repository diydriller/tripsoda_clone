package com.example.application;

import com.google.gson.annotations.SerializedName;

public class Page2Info {

    @SerializedName("locationId")
    private int locationId;
    @SerializedName("tourName")
    private String tourName;
    @SerializedName("tourMonth")
    private int tourMonth;
    @SerializedName("tourDay")
    private int tourDay;
    @SerializedName("tourHour")
    private int tourHour;
    @SerializedName("image")
    private String image;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public int getTourMonth() {
        return tourMonth;
    }

    public void setTourMonth(int tourMonth) {
        this.tourMonth = tourMonth;
    }

    public int getTourDay() {
        return tourDay;
    }

    public void setTourDay(int tourDay) {
        this.tourDay = tourDay;
    }

    public int getTourHour() {
        return tourHour;
    }

    public void setTourHour(int tourHour) {
        this.tourHour = tourHour;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
