package com.ermile.jibresapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SliderPrefManager prefman = new SliderPrefManager(this);
//        if (prefman.startSlider()){
//            Intent intent = new Intent(this, IntroSliderActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }
    public void playAgain(View v){
        new SliderPrefManager(this).setStartSlider(true);
        Intent intent = new Intent(this, IntroSliderActivity.class);
        startActivity(intent);
        finish();
    }
}