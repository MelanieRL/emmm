package com.example.provenlogic1.googlemap_connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

             private ListView lista;
             private static Locales[] arreglo_locales = new Locales[]{
            new Locales("La Barricada", new LatLng(-38.7519663,-72.6174443),"Fono: 749933 Reparto gratis"),
            new Locales("La Picá de Uruguay", new LatLng(-38.7443151,-72.6164652),"Fono: "),
            new Locales("Al Paso", new LatLng(-38.7375426,-72.5960242),"Fono: "),
            new Locales("Cocosandwich", new LatLng(-38.7377292,-72.5947111),"Fono: 649595 - 740808 Despacho a domicilio"),
            new Locales("Chile Sandwich", new LatLng(-38.7378658, -72.5917302),"Fono: "),
            new Locales("After sandwich", new LatLng(-38.7265815, -72.6274266),"Fono:"),
            new Locales("Tao's Sandwich & Bocatas", new LatLng(-38.7373843, -72.5992395),""),
            new Locales("Kokomo delivery", new LatLng(-38.7422257,-72.5908917),""),
            new Locales("La picada de Mackenna", new LatLng(-38.7413169,-72.5892867),""),
            new Locales("Club sandwich", new LatLng(-38.7371924,-72.6258121),""),
            new Locales("Club sandwich",  new LatLng(-38.7370668,-72.6215284),""),
            new Locales("Charly dog", new LatLng(-38.7372329,-72.5920603),""),
            new Locales("El Toltén", new LatLng(-38.7387256,-72.6180388),""),
            new Locales("Media luna", new LatLng(-38.7389389,-72.5887743),""),
            new Locales("La Bóveda",  new LatLng(-38.7408376,-72.5918591),""),
            new Locales("Las Muñecas del Ñielol", new LatLng(-38.728479,-72.580046),""),
            new Locales("Zuny Tradiciones",  new LatLng(-38.7300962,-72.5823204),""),
            new Locales("Sangucheria Caupolican", new LatLng(-38.7300962,-72.5823204),""),
            new Locales("El Horno de Mama Elba", new LatLng(-38.7409697,-72.6195933),""),
            new Locales("Enkai Delivery",  new LatLng(-38.7408646,-72.619536),""),
            new Locales("Kimi SuShi",  new LatLng(-38.7432855,-72.615449),""),
            new Locales("Sushi Hasu Delivery",  new LatLng(-38.7434153,-72.6341119),""),
           // new Locales("Sandwich Al Paso", new LatLng(-38.7491022,-72.6159197),""),
          //  new Locales("Tepano´s",  new LatLng(-38.7446359,-72.6187709),""),
            new Locales("La picada de Sevilla",  new LatLng(-38.7366218,-72.6311829),""),
            new Locales("Mak Sandwich",  new LatLng(-38.7368775,-72.595614),""),
            new Locales("Mak Sandwich",  new LatLng(-38.738581,-72.5985648),""),
            new Locales("Mak Sandwich",  new LatLng(-38.7358268,-72.5939198),""),
            new Locales("Manhattan",  new LatLng(-38.7381945,-72.5980703),""),


};
    private Map<Marker, Locales> locales;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        locales = new HashMap<>();


        try {
            // Loading map
            initilizeMap();


            double latitude = 0;
            double longitude = 0;
            GPSTracker gps;
            gps = new GPSTracker(this);
            if(gps.canGetLocation()){
                latitude=gps.getLatitude();
                longitude=gps.getLongitude();
                LatLng UPV = new LatLng(latitude, longitude);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UPV, 15));

            }else{
                gps.showSettingsAlert();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**function to load map If map is not created it will create it for you **/

    GoogleMap googleMap;
    private void initilizeMap() {

        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            // Showing / hiding your current location
            googleMap.setMyLocationEnabled(true);

            // Enable / Disable zooming controls
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            // Enable / Disable my location button
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            // Enable / Disable Compass icon
            googleMap.getUiSettings().setCompassEnabled(true);

            // Enable / Disable Rotate gesture
            googleMap.getUiSettings().setRotateGesturesEnabled(true);

            // Enable / Disable zooming functionality
            googleMap.getUiSettings().setZoomGesturesEnabled(true);

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Lo siento! no se ha podido cargar el mapa", Toast.LENGTH_SHORT)
                        .show();
            }

            locales.clear();
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.burger);
            for (Locales local : arreglo_locales) {
                Marker marker = googleMap.addMarker(new MarkerOptions()
                        .position(local.getPosition())
                        .title(local.getName())
                                .snippet(local.getDescripcion())
                        .icon(icon));
                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker arg0) {
                        // call an activity(xml file)
                        Intent I = new Intent(MainActivity.this,Lista.class);
                        startActivity(I);
                    }

                });
                locales.put(marker, local);


            }
        }



    }

        @Override
        public void onBackPressed() {
          DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }

        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.ranking) {
                // Handle the camera action
            } else if (id == R.id.visitados) {

            } else if (id == R.id.favoritos) {



            } else if (id == R.id.salir) {



            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }



}
