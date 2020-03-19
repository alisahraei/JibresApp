package com.ermile.jibresapp;

import android.content.Context;
import android.content.SharedPreferences;

public class LangPrefManager {
    private Context context;
    private SharedPreferences pref;
    private static final String PREF_NAME = "lang-pref";
    private static final String KEY_START = "startlang";
    public LangPrefManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    public boolean startLang(){
        return pref.getBoolean(KEY_START, true);
    }
    public void setStartLang(boolean start) {
        pref.edit().putBoolean(KEY_START, start).apply();
    }
}
