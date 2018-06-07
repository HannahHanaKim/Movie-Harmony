package com.example.hannahkim.movieharmony;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ClosestTheater extends Fragment {

    TextView txtLatitude;
    TextView txtLongitude;
    TextView uLocation;

    double latitude;
    double longitude;
    private Location myLocation = null;

    public ClosestTheater() {

    }

    public static ClosestTheater newInstance(double d1, double d2) {
        ClosestTheater fragment = new ClosestTheater();
        Bundle bundle = new Bundle();
        bundle.putDouble("input1", d1);
        bundle.putDouble("input2", d2);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_closest_theater, container, false);

        txtLatitude = (TextView)view.findViewById(R.id.latitude);
        txtLongitude = (TextView)view.findViewById(R.id.longitude);
        uLocation = (TextView)view.findViewById(R.id.userLocation);

        startLocationService();

        return view;
    }

    private void startLocationService() {
        LocationManager manager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        long minTime = 10000;
        float minDistance = 10;

        try {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, gpsListener);

            txtLatitude.setText("위치 정보 수신중...");
            txtLongitude.setText("위치 정보 수신중...");
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
    }

    private final LocationListener gpsListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            myLocation = location;
            latitude = location.getLatitude();
            longitude = location.getLongitude();

            String msg = "Latitude : " + latitude + "\nLongitude : " + longitude;
            Log.i("GPSLisenter", msg);

            txtLatitude.setText("" + latitude);
            txtLongitude.setText("" + longitude);
            GeocodingService(latitude, longitude);
            Toast.makeText(getActivity().getApplicationContext(), "위치 확인.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void GeocodingService(double d1, double d2) {
        Geocoder geocoder = new Geocoder(this.getContext(), Locale.KOREA);

        List<Address> list = null;
        StringBuffer mAddress = new StringBuffer();

        latitude = myLocation.getLatitude();
        longitude = myLocation.getLongitude();

        try {
            list = geocoder.getFromLocation(d1, d2, 1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            uLocation.setText("입출력 오류 발생 : " + e.getMessage());
            e.printStackTrace();
        }

        if ((list != null) && (list.size() >0)) {
            for (Address addr : list) {
                int index = addr.getMaxAddressLineIndex();
                for(int i = 0; i <= index; i++) {
                    mAddress.append(addr.getAddressLine(i));
                    mAddress.append(" ");
                }
                mAddress.append("\n");
            }
            uLocation.setText(mAddress);
        }
        else {
            uLocation.setText("");
        }
        uLocation.setText(list.get(0).getAddressLine(0).toString());

    }

}
