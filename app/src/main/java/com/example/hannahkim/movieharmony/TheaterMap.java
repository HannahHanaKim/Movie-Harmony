package com.example.hannahkim.movieharmony;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
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

    double d1, d2;

    public TheaterMap() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            d1 = getArguments().getDouble("input1");
            d2 = getArguments().getDouble("input2");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_theater_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng U_Location = new LatLng(d1, d2);
        MarkerOptions marker_user = new MarkerOptions();
        marker_user.position(U_Location);
        marker_user.title("내 위치");

        Marker userLocation = googleMap.addMarker(marker_user); //여기 코드 다름!
        userLocation.showInfoWindow();

        /* 여기 코드 다 다름! */
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(U_Location));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
    }
}
