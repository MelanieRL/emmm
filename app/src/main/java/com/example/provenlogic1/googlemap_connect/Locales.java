package com.example.provenlogic1.googlemap_connect;

import com.google.android.gms.maps.model.LatLng;

public class Locales {

    private String name;
    private LatLng position;
    private String descripcion;


    public Locales(String name, LatLng position,String descripcion) {
        this.name = name;
        this.position = position;
        this.descripcion=descripcion;
    }

    public String getName() {

        return name;
    }

    public LatLng getPosition() {
        return position;
    }
    public String getDescripcion(){
            return descripcion;
    }


}
