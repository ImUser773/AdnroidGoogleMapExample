package com.iam_dav.googlemap.googleMap;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by champ on 2/7/2560.
 */

public interface MapActivityView {

    void initGoogleMap();

    void addMarker(DataSnapshot dataSnapshot);
}
