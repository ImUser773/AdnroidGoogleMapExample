package com.iam_dav.googlemap.googleMap;

import android.support.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iam_dav.googlemap.base.BasePresenter;

/**
 * Created by champ on 2/7/2560.
 */

public class MapPresenter extends BasePresenter {
    private final MapsActivity mMap;
    private FirebaseDatabase database;
    private DatabaseReference location;


    public MapPresenter(@NonNull final MapsActivity view) {
        mMap = view;
    }

    public void initGooglemap () {
        mMap.initGoogleMap();
    }

    public void loadLocation() {
        database = FirebaseDatabase.getInstance();
        location = database.getReference("location");

        location.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mMap.addMarker(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
