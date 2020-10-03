package com.example.garagebaadshah.Maps;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.garagebaadshah.InfoActivity;
import com.example.garagebaadshah.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private LocationListener locationListener;


    private static final LatLng GARAGE_1 = new LatLng(15.357751, 75.1195103);
    private static final LatLng GARAGE_2 = new LatLng(15.3714929, 75.1090076);
    private static final LatLng GARAGE_3 = new LatLng(15.3714926, 75.1090076);
    private static final LatLng GARAGE_4 = new LatLng(15.3709254, 75.1121616);
    private static final LatLng GARAGE_5 = new LatLng(15.3731597, 75.1005242);
    private static final LatLng GARAGE_6 = new LatLng(15.3429139, 75.110486);


    private Marker krishna_grg;
    private Marker SS_grg;
    private Marker gajanan_grg;
    private Marker haks_grg;
    private Marker sahara_grg;
    private Marker sridurga_grg;
    public float[] results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setInfoWindowAdapter(new CustomInfoWindow(getApplicationContext()));
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnMarkerClickListener(this);

        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("Location", location.toString());

                MarkerOptions markerOptions=new MarkerOptions();

                results = new float[10];


                List<Marker> markerList=new ArrayList<>();

                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


                LatLng current_position = new LatLng(location.getLatitude(),location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(current_position).title("My Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));



                Location.distanceBetween(location.getLatitude(), location.getLongitude(),15.357751, 75.1195103, results);
                krishna_grg=mMap.addMarker(new MarkerOptions().position(GARAGE_1).title("Krishna Garage").snippet("Distance = "+ (results[0]/1000)+ "Km"));
                krishna_grg.setTag(0);
                markerList.add(krishna_grg);

                Location.distanceBetween(location.getLatitude(), location.getLongitude(),15.3714929, 75.1090076, results);
                SS_grg=mMap.addMarker(new MarkerOptions().position(GARAGE_2).title("SS Garage").snippet("Distance = "+ (results[0]/1000)+ "Km"));
                krishna_grg.setTag(0);
                markerList.add(SS_grg);

                Location.distanceBetween(location.getLatitude(), location.getLongitude(),15.3714926, 75.1090076, results);
                gajanan_grg=mMap.addMarker(new MarkerOptions().position(GARAGE_3).title("Gajanan Garage").snippet("Distance = "+ (results[0]/1000)+ "Km"));
                gajanan_grg.setTag(0);
                markerList.add(gajanan_grg);

                Location.distanceBetween(location.getLatitude(), location.getLongitude(),15.3709254, 75.1121616, results);
                haks_grg=mMap.addMarker(new MarkerOptions().position(GARAGE_4).title("Haks Garage").snippet("Distance = "+ (results[0]/1000)+ "Km"));
                haks_grg.setTag(0);
                markerList.add(haks_grg);

                sahara_grg=mMap.addMarker(new MarkerOptions().position(GARAGE_5).title("Sahara Garage").snippet("Distance = "+ (results[0]/1000)+ "Km"));
                sahara_grg.setTag(0);
                Location.distanceBetween(location.getLatitude(), location.getLongitude(),15.3731597, 75.1005242, results);
                markerList.add(sahara_grg);


                Location.distanceBetween(location.getLatitude(), location.getLongitude(),15.3429139, 75.110486, results);
                sridurga_grg=mMap.addMarker(new MarkerOptions().position(GARAGE_6).title("SriDurga Garage").snippet("Distance = "+ (results[0]/1000)+ "Km"));
                sridurga_grg.setTag(0);
                markerList.add(sridurga_grg);




                for (Marker m: markerList)
                {
                    LatLng latLng=new LatLng(m.getPosition().latitude,m.getPosition().longitude);
                    mMap.addMarker(new MarkerOptions().position(latLng));









//                     Log.d("maker",m.getTitle());
                }

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

        if (Build.VERSION.SDK_INT < 23) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }else {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //Ask for permission
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            }else {
                // we have permission!
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }








        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);


            }
        }


    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        Intent itj=new Intent(MapsActivity.this, InfoActivity.class);
        itj.putExtra("Title",marker.getTitle());
        startActivity(itj);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}