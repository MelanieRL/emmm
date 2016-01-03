package com.example.provenlogic1.googlemap_connect;

import com.google.android.gms.maps.model.LatLng;

public class Locales {

    private String name;
    private LatLng position;

    public Locales(String name, LatLng position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {

        return name;
    }

    public LatLng getPosition() {
        return position;
    }


}
