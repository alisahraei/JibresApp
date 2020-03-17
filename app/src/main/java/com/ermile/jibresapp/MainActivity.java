package com.ermile.jibresapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
WebView webView;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://jibres.ir/enter");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
}
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }


//        SliderPrefManager prefman = new SliderPrefManager(this);
//        if (prefman.startSlider()){
//            Intent intent = new Intent(this, IntroSliderActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    public void playAgain(View v){
//        new SliderPrefManager(this).setStartSlider(true);
//        Intent intent = new Intent(this, IntroSliderActivity.class);
//        startActivity(intent);
//        finish();
//    }
}