package com.example.provenlogic1.googlemap_connect;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Mely on 02-Jan-16.
 */


public class Lista extends Activity {

    ListView lv;
    TextView seleccionado;
    String[] locales = {"La Barricada", "La Picá de Uruguay", "Al Paso", "Cocosandwich",
            "Chile Sandwich", "After sandwich","Tao's Sandwich & Bocatas","Kokomo delivery","La picada de Mackenna","Club sandwich",
            "Charly dog","El Toltén","Media luna","La Bóveda","Las Muñecas del Ñielol","Zuny Tradiciones","Sangucheria Caupolican",
            "El Horno de Mama Elba","Enkai Delivery","Kimi SuShi","Sushi Hasu Delivery","Sandwich Al Paso","Tepano´s"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        lv=(ListView)findViewById(R.id.list);
        seleccionado=(TextView)findViewById(R.id.seleccionado);
        lv.setAdapter(new ArrayAdapter(this,R.layout.entrada,locales));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                seleccionado.setText("Has seleccionado: "+locales[position]);


            }
        });
    }





}