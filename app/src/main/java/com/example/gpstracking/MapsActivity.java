package com.example.gpstracking;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    List<Location> savedLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.id_map);
        mapFragment.getMapAsync(this);
        MyApplication myApplication = (MyApplication) getApplicationContext();
        savedLocations = myApplication.getMyLocations();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        LatLng sydney = new LatLng(55.6761, 12.5683);
        //googleMap.addMarker(new MarkerOptions().position(location).title("COpenhagen"));
        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));

        for (Location location: savedLocations
        ){
            LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
            MarkerOptions markerOptions= new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Lat:"+location.getLatitude()+"Lon:"+location.getLongitude());
            mMap.addMarker(markerOptions);
        }
    }
}