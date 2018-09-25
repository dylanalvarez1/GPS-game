package com.example.geeksquad.gpstreasurehunt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
public class KnownLocation {
    double longitude=0;
    double latitude=0;
    Class activity;
    public KnownLocation(double lng, double lat, Class a){
        longitude=lng;
        latitude=lat;
        activity=a;
    }
    public void show(AppCompatActivity act, Context c){
        Intent intent1 = new Intent("CloseTop");
        act.sendBroadcast(intent1);
        Intent i = new Intent(c,activity);
        act.startActivity(i);
    }
    public boolean isClose(double lng, double lat, double radius){
        if(distance(longitude, latitude, lng,lat)<radius)return true;
        else return false;
    }
    private double distance(double lon1, double lat1, double lon2, double
            lat2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                *  Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                *  Math.cos(deg2rad(lat2))
                *  Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515* 1000.0;
        return (dist);
    }
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}


