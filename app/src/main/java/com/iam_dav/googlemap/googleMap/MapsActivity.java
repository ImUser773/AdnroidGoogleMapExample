package com.iam_dav.googlemap.googleMap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.iam_dav.googlemap.R;
import com.iam_dav.googlemap.base.BaseActivity;

import java.util.Map;


public class MapsActivity extends BaseActivity<MapPresenter>
        implements MapActivityView, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private static final String TAG = MapsActivity.class.getSimpleName();
    private GoogleMap mMap;
    private MarkerOptions options;


    @NonNull
    @Override
        protected MapPresenter createPresenter(@NonNull Context context) {
        return new MapPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        options = new MarkerOptions();

        mPresenter.initGooglemap();
        mPresenter.loadLocation();
    }

    @Override
    public void initGoogleMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void addMarker(DataSnapshot dataSnapshot) {
        Map<String,Object> content = (Map<String, Object>) dataSnapshot.getValue();
        Log.i(TAG, content.toString());
        for (int i = 0; i < content.size(); i++) {
            String mLat = content.get("lat").toString();
            String mLong = content.get("long").toString();
            String title = content.get("name").toString();
            options.position(new LatLng(Double.parseDouble(mLat),Double.parseDouble(mLong)));
            options.title(title);
            mMap.addMarker(options);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng shopspot = new LatLng(13.7790747, 100.5459478);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(shopspot));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(shopspot, 17));

        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.i("click", marker.getTitle());
        switch (marker.getTitle()) {
            case "7-11":
                Log.i("click", "7-11");
                break;
            case "ร้านอาหารตามสั่ง":
                Log.i("click", "7-11");
                break;
            case "ร้านลูกชิ้นปิ้ง":
                Log.i("click", "7-11");
                break;
            case "":
                Log.i("click", "7-11");
                break;
        }

        return false;
    }



}
