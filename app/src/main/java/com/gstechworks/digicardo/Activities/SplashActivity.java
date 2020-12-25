 package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.SharedPreferences.SessionConfig;

 public class SplashActivity extends AppCompatActivity {
     SessionConfig sessionConfig;
     boolean LoginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sessionConfig = new SessionConfig(this);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                LoginState = sessionConfig.getLoginState();
                if(LoginState){
                    Intent mainIntent = new Intent(SplashActivity.this, HomeActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                }else if(!LoginState){
                    Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                }
                /* Create an Intent that will start the Menu-Activity. */

            }
        }, 1500);
    }
}