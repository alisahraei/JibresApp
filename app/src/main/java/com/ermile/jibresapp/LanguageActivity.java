package com.ermile.jibresapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageActivity extends AppCompatActivity {
Button btn_en, btn_fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        btn_en = findViewById(R.id.btn_en);
        btn_fa = findViewById(R.id.btn_fa);
    }
}
