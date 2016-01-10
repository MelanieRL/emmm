package com.example.provenlogic1.googlemap_connect;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;

/**
 * Created by Mely on 11-Dec-15.
 */
public class inicio extends Activity{

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

    }
    public void iniciar(View view) {
        Intent mainIntent = new Intent().setClass(
               inicio.this, MainActivity.class);

        startActivity(mainIntent);


       // finish();
    }
    public void lista(View view) {
        Intent mainIntent = new Intent().setClass(
                inicio.this, Lista.class);

        startActivity(mainIntent);

// finish();
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("SaboreAPP")
                .setMessage("Estas seguro de que quieres salir?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("NO", null)
                .show();

    }

}
