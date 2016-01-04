package com.example.provenlogic1.googlemap_connect;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Mely on 02-Jan-16.
 */


public class Lista extends Activity {
    ListView lv;
    TextView seleccionado;
    String[] locales = {"La Barricada", "La Picá de Uruguay", "Al Paso", "Cocosandwich",
            "Chile Sandwich", "After sandwich", "Tao's Sandwich & Bocatas", "Kokomo delivery", "La picada de Mackenna", "Club sandwich",
            "Charly dog", "El Toltén", "Media luna", "La Bóveda", "Las Muñecas del Ñielol", "Zuny Tradiciones", "Sangucheria Caupolican",
            "El Horno de Mama Elba", "Enkai Delivery", "Kimi SuShi", "Sushi Hasu Delivery", "Sandwich Al Paso", "Tepano´s"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        lv=(ListView)findViewById(R.id.list);
        seleccionado = (TextView) findViewById(R.id.seleccionado);
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new ArrayList<String>()));
        new MyTask().execute();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                seleccionado.setText("Has seleccionado: " + locales[position]);


            }
        });
    }
    class MyTask extends AsyncTask<Void,String,String>{
        ArrayAdapter<String>adapter;
        ProgressBar progressBar;
        int count;
        @Override
        protected void onPreExecute() {
            adapter=(ArrayAdapter<String>)lv.getAdapter();
            progressBar=(ProgressBar)findViewById(R.id.progerss_bar);
            progressBar.setMax(15);
            progressBar.setProgress(0);
            progressBar.setVisibility(View.VISIBLE);
            count=0;

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
            return "todos los numero han sido agregados";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            progressBar.setProgress(count);

        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
        }
    }

}