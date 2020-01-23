package com.ermile.jibresapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
private SliderPrefManager prefMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        prefMan = new SliderPrefManager(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (!prefMan.startSlider()){
                    intent = new Intent(SplashScreenActivity.this , MainActivity.class);
                }else {
                    intent = new Intent(SplashScreenActivity.this , IntroSliderActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
