package com.example.provenlogic1.googlemap_connect;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Mely on 12-Dec-15.
 */
public class loginNO extends Activity {

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }
    public void inicio(View view) {
        Intent mainIntent = new Intent().setClass(
                loginNO.this, inicio.class);

        startActivity(mainIntent);


      //  finish();
    }


}
