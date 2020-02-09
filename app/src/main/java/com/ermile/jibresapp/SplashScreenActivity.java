package com.ermile.jibresapp;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private SliderPrefManager prefMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        prefMan = new SliderPrefManager(this);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        //For 3G check
        boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .isConnectedOrConnecting();
        //For WiFi Check
        boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .isConnectedOrConnecting();

        System.out.println(is3g + " net " + isWifi);

        if (!is3g && !isWifi) {
            Toast.makeText(this, "Network connection is not available", Toast.LENGTH_SHORT).show();

        } else {
//                " Your method what you want to do "
            Toast.makeText(this, "Network connection is available", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent;
                    if (!prefMan.startSlider()) {
                        intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    } else {
                        intent = new Intent(SplashScreenActivity.this, IntroSliderActivity.class);
                    }
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }

    }
}


//        if (haveNetwork()){
//             Toast.makeText(this, "Network connection is available", Toast.LENGTH_SHORT).show();
//             new Handler().postDelayed(new Runnable() {
//                 @Override
//                 public void run() {
//                    Intent intent;
//                    if (!prefMan.startSlider()){
//                        intent = new Intent(SplashScreenActivity.this , MainActivity.class);
//                    }else {
//                        intent = new Intent(SplashScreenActivity.this , IntroSliderActivity.class);
//                    }
//                    startActivity(intent);
//                    finish();
//                 }
//             },3000);
//          } else if (!haveNetwork()) {
//             Toast.makeText(this, "Network connection is not available", Toast.LENGTH_SHORT).show();
//          }
//       }
//       private boolean haveNetwork(){
//          boolean have_WIFI = false;
//          boolean have_MobileData = false;
//          ConnectivityManager check = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
//          NetworkInfo[] networkInfos = check.getAllNetworkInfo();
//          for(NetworkInfo info:networkInfos){
//             if (info.getTypeName().equalsIgnoreCase("WIFI"))if (info.isConnected())have_WIFI=true;
//             if (info.getTypeName().equalsIgnoreCase("MOBILE DATA"))if (info.isConnected())have_MobileData=true;
//          }
//          return have_WIFI||have_MobileData;
//       }


