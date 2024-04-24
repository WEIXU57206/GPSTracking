package com.example.gpstracking;

import android.app.Application;
import android.location.Location;

import java.util.ArrayList;
import java.util.List;
public class MyApplication extends BeaconReferenceApplication{

    private List<Location>myLocations;

    private static MyApplication singleton;

    public void setMyLocations(List<Location> myLocations){
        this.myLocations = myLocations;
    }

    public MyApplication getInstance(){
        return singleton;
    }

    public void onCreate(){
        super.onCreate();
        singleton = this;
        myLocations = new ArrayList<>();
    }

    public List<Location> getMyLocations() {
            return myLocations;
    }
}
