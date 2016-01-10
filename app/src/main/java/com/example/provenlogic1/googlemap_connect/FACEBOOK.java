package com.example.provenlogic1.googlemap_connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class FACEBOOK extends FragmentActivity {
    private static final long SPLASH_SCREEN_DELAY = 0;
    private LoginButton loginBtn;
    private TextView username;
    private UiLifecycleHelper uiHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        uiHelper = new UiLifecycleHelper(this, statusCallback);
        uiHelper.onCreate(savedInstanceState);

       setContentView(R.layout.login);

        username = (TextView) findViewById(R.id.username);
        loginBtn = (LoginButton) findViewById(R.id.fb_login_button);
        loginBtn.setReadPermissions(Arrays.asList("email"));
        loginBtn.setUserInfoChangedCallback(new UserInfoChangedCallback() {
            @Override
            public void onUserInfoFetched(GraphUser user) {



                if (user != null) {

                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {

                            // Start the next activity
                            Intent mainIntent = new Intent().setClass(
                                    FACEBOOK.this, inicio.class);
                            startActivity(mainIntent);

                            // Close the activity so the user won't able to go back this
                            // activity pressing Back button
                            finish();
                        }
                    };

                    // Simulate a long loading process on application startup.
                    Timer timer = new Timer();
                    timer.schedule(task, SPLASH_SCREEN_DELAY);
                    username.setText("You are currently logged in as " + user.getName());
                } else {
                    username.setText("You are not logged in.");
                }
            }
        });
    }

    private Session.StatusCallback statusCallback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state,
                         Exception exception) {
            if (state.isOpened()) {

                Log.d("Facebook", "Facebook session opened.");
            } else if (state.isClosed()) {
                Log.d("Facebook", "Facebook session closed.");
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        uiHelper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSaveInstanceState(Bundle savedState) {
        super.onSaveInstanceState(savedState);
        uiHelper.onSaveInstanceState(savedState);
    }



    public void inicio(View view) {
        Intent mainIntent = new Intent().setClass(
                FACEBOOK.this, inicio.class);

        startActivity(mainIntent);

  finish();
    }
}