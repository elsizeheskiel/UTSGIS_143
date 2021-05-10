package com.example.utsgis_143;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        LatLng rumahku = new LatLng(-0.953782, 119.836105);
        LatLng rumahibadah1 = new LatLng(-0.951815, 119.836086);
        LatLng rumahibadah2 = new LatLng(-0.953906, 119.839213);
        LatLng rumahibadah3 = new LatLng(-0.956601, 119.835582);


        //custome size marker
        int tinggi = 70;
        int lebar = 60;
        BitmapDrawable bitmapDraw = (BitmapDrawable) getResources().getDrawable(R.drawable.pin1);
        BitmapDrawable bitmapRmhIbdh = (BitmapDrawable) getResources().getDrawable(R.drawable.pin2);
        Bitmap b = bitmapDraw.getBitmap();
        Bitmap s = bitmapRmhIbdh.getBitmap();
        Bitmap markerDraw = Bitmap.createScaledBitmap(b, lebar, tinggi,  false);
        Bitmap markerRmhIbdh = Bitmap.createScaledBitmap(s, lebar, tinggi,  false);

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(rumahku).title("Marker in Rumahku")
                .snippet("Ini adalah Rumah Saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDraw)));
        mMap.addMarker(new MarkerOptions().position(rumahibadah1).title("Marker in Rumah Ibadah")
                .snippet("Ini adalah Gereja BK Korps Porame")
                .icon(BitmapDescriptorFactory.fromBitmap(markerRmhIbdh)));
        mMap.addMarker(new MarkerOptions().position(rumahibadah2).title("Marker in Rumah Ibadah")
                .snippet("Ini adalah Masjid Al-Furqan Porame")
                .icon(BitmapDescriptorFactory.fromBitmap(markerRmhIbdh)));
        mMap.addMarker(new MarkerOptions().position(rumahibadah3).title("Marker in Rumah Ibadah")
                .snippet("Ini adalah Masjid Desa Porame")
                .icon(BitmapDescriptorFactory.fromBitmap(markerRmhIbdh)));

        mMap.addPolyline(new PolylineOptions().add(
                rumahku,
                new LatLng(-0.953782, 119.836105),
                new LatLng(-0.953776, 119.836258),
                new LatLng(-0.953580, 119.836332),
                new LatLng(-0.953403, 119.836420),
                new LatLng(-0.953245, 119.836498),
                new LatLng(-0.953169, 119.836535),
                new LatLng(-0.953030, 119.836587),
                new LatLng(-0.952820, 119.836678),
                new LatLng(-0.952531, 119.836832),
                new LatLng(-0.952324, 119.836973),
                new LatLng(-0.952271, 119.837004),
                new LatLng(-0.952247, 119.836956),
                new LatLng(-0.952291, 119.836885),
                new LatLng(-0.952323, 119.836808),
                new LatLng(-0.952319, 119.836736),
                new LatLng(-0.952269, 119.836674),
                new LatLng(-0.952197, 119.836617),
                new LatLng(-0.952096, 119.836575),
                new LatLng(-0.951992, 119.836516),
                new LatLng(-0.951889, 119.836439),
                new LatLng(-0.951791, 119.836358),
                new LatLng(-0.951724, 119.836284),
                new LatLng(-0.951657, 119.836172),
                new LatLng(-0.951740, 119.836102),
                new LatLng(-0.951815, 119.836086),
                rumahibadah1
                ).width(7).color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rumahibadah1, 14.5f));
    }
}