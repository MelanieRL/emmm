package com.example.provenlogic1.googlemap_connect;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mely on 02-Jan-16.
 */


public class Lista extends ActionBarActivity {


    ListView listView;

    private String[] locales = {"La Barricada", "La Picá de Uruguay", "Al Paso", "Cocosandwich",
            "Chile Sandwich", "After sandwich","Tao's Sandwich & Bocatas","Kokomo delivery","La picada de Mackenna","Club sandwich",
            "Charly dog","El Toltén","Media luna","La Bóveda","Las Muñecas del Ñielol","Zuny Tradiciones","Sangucheria Caupolican",
            "El Horno de Mama Elba","Enkai Delivery","Kimi SuShi","Sushi Hasu Delivery","Sandwich Al Paso","Tepano´s","La picada de Sevilla",
            "Manhattan","Mak Sandwich"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new MyTask().execute();

    }

    class MyTask extends AsyncTask<Void,String,String> {
        ArrayAdapter<String>adapter;
        ProgressBar progressBar;
        @Override
        protected void onPreExecute() {
            adapter=(ArrayAdapter<String>)listView.getAdapter();
            progressBar=(ProgressBar)findViewById(R.id.progerss_bar);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {
            for(String num:locales){
                publishProgress(num);
                try{
                    Thread.sleep(200);
                }catch (InterruptedException e){

                    e.printStackTrace();
                }
            }
            return "Todos los Locales han sido agregados";
        }

       @Override
        protected void onProgressUpdate(String... values) {
           adapter.add(values[0]);


        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
        }
    }

}






/*
    public static float distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371; //kilometers
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist*10;
    }*/
