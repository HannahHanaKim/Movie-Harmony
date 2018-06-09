package com.example.hannahkim.movieharmony;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class TheaterMap extends Fragment implements OnMapReadyCallback {

    private double d1;
    private double d2;


    public TheaterMap() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_theater_map, container, false);

        // Inflate the layout for this fragment

        return view;
    }

    public void displayReceivedData(double data1, double data2) {

        this.d1 = data1;
        this.d2 = data2;

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(final GoogleMap map) {
        map.clear();
        LatLng U_LOCATION = new LatLng(this.d1,this.d2);
        MarkerOptions marker_user = new MarkerOptions();
        marker_user.position(U_LOCATION);
        marker_user.title("내 위치");
        //markerOptions.snippet("부연설명");
        Marker user_location = map.addMarker(marker_user);
        user_location.showInfoWindow();

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(U_LOCATION,14));

    }



}