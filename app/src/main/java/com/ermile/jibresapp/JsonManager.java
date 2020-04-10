package com.ermile.jibresapp;

import android.content.Context;

class JsonManager {
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
}
