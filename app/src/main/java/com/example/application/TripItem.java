package com.example.application;

import android.graphics.Bitmap;

public class TripItem {
    String location;
    int month;
    int day;
    int hour;
    Bitmap pic;
    long sum;
    int locationId;

    public TripItem(String location, int month, int day, int hour, Bitmap pic,int locationId) {
        this.location = location;
        this.month = month;
        this.day = day;
        this.hour=hour;
        this.pic = pic;
        this.sum=hour+day*24+month*720;
        this.locationId=locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public Bitmap getPic() {
        return pic;
    }

    public long getSum(){
        return sum;
    }

}
