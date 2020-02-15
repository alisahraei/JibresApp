package com.ermile.jibresapp;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webveiw);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://jibres.ir/dashboard");
//        SliderPrefManager prefman = new SliderPrefManager(this);
//        if (prefman.startSlider()){
//            Intent intent = new Intent(this, IntroSliderActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }
//    public void playAgain(View v){
//        new SliderPrefManager(this).setStartSlider(true);
//        Intent intent = new Intent(this, IntroSliderActivity.class);
//        startActivity(intent);
//        finish();
//    }
}