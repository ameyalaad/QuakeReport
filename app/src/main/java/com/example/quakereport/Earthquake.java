package com.example.quakereport;

public class Earthquake {

    private double mMagnitude;

    private String mLocation;

    private long mTime;

    private String mUrl;

    public Earthquake(double  magnitude, String location, long time, String url){
        this.mLocation=location;
        this.mMagnitude=magnitude;
        this.mTime=time;
        this.mUrl=url;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getTime(){
        return mTime;
    }

    public String getUrl(){
        return mUrl;
    }
}
