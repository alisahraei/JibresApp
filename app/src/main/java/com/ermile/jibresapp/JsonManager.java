package com.ermile.jibresapp;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

class JsonManager extends ContextWrapper {
    SharedPreferences sharedPreferences;
    public static final String json_splash = "json_splash";
    public static final String json_intro = "json_intro";

    public JsonManager(Context context) {
        super(context);
    }

    public static String getJsonSplash(Context context) {
        return JsonManager
                .context(context)
                .getJson()
                .get(JsonManager.json_splash);
    }
    public static JsonManager context(Context context) {
        return new JsonManager(context);
    }
    public Map<String, String> getJson() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(json_intro, sharedPreferences.getString(json_intro, JsonReadFile.intro(this)));
        hashMap.put(json_splash, sharedPreferences.getString(json_splash, JsonReadFile.splash(this)));
        return hashMap;
    }
}
