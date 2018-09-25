package com.example.geeksquad.gpstreasurehunt;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements
        LocationListener {
    private final int REQUEST_PERMISSION_ACCESS_FINE_LOCATION=1;
    List<KnownLocation> myKnownLocations = new ArrayList<KnownLocation>();

    public static boolean keyOfUnderstanding = false;
    public static boolean keyOfCulture = false;
    public static boolean keyOfIntellect = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        KnownLocation centuryTower = new KnownLocation(-122.086, 37.4223, MainActivity.class);
        myKnownLocations.add(centuryTower);

        KnownLocation toronto = new KnownLocation(-79.4609, 43.6568, Main2Activity.class);
        myKnownLocations.add(toronto);

        KnownLocation saoPaulo = new KnownLocation(-46.8755, -23.6822, Main3Activity.class);
        myKnownLocations.add(saoPaulo);

        KnownLocation paris = new KnownLocation(2.27702, 48.8588, Main4Activity.class);
        myKnownLocations.add(paris);


        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if ( ContextCompat.checkSelfPermission( this,
                android.Manifest.permission.ACCESS_FINE_LOCATION ) !=
                PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions( this, new String[] {
                            android.Manifest.permission.ACCESS_FINE_LOCATION  },
                    REQUEST_PERMISSION_ACCESS_FINE_LOCATION );
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, this);
    }
    @Override
    public void onLocationChanged(Location location) {
        for(int i=0;i<myKnownLocations.size();i++){
            KnownLocation loc = myKnownLocations.get(i);
            if(loc.isClose(location.getLongitude(),location.getLatitude(),
                    100)){
                loc.show(this,getBaseContext());
            }

        }
        if(keyOfIntellect && keyOfUnderstanding && keyOfCulture) {
            Intent i = new Intent(getBaseContext(), Main5Activity.class);
            startActivity(i);

        }



    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle
            extras) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onProviderDisabled(String provider) {
    }
}
