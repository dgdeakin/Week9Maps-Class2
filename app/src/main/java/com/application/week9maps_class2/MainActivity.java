package com.application.week9maps_class2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this, AutocompleteActivity.class));
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        LatLng sydney = new LatLng(-37.813629, 144.963058);

        LatLng sydney1 = new LatLng(-40.813629, 160.963058);

        googleMap.addMarker(new MarkerOptions()
                .title("Melbourne Marker")
                .position(sydney));

        googleMap.addMarker(new MarkerOptions()
                .title("Melbourne Marker1")
                .position(sydney1));

        Polyline polyline = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(sydney, sydney1));

        polyline.setColor(Color.BLUE);

       googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 100));


    }
}