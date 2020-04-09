package com.ermile.jibresapp;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class AppManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String appLanguage = "appLanguage";
    public static final String pin_code = "pin_code";
    public static final String apikey = "apikey";
    public static final String userCode = "userCode";
    public static final String zonId = "zonId";
    public static final String mobile = "mobile";
    public static final String store = "store";

    private AppManager(Context context) {
        super();
    }

    public static String getAppLanguage(Context context) {
        return AppManager
                .get(context)
                .getUserInfo()
                .get(AppManager.appLanguage);
    }

    public Map<String, String> getUserInfo() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(appLanguage, sharedPreferences.getString(appLanguage, null));
        hashMap.put(store, sharedPreferences.getString(store, "y885"));
        hashMap.put(apikey, sharedPreferences.getString(apikey, null));
        hashMap.put(userCode, sharedPreferences.getString(userCode, null));
        hashMap.put(zonId, sharedPreferences.getString(zonId, null));
        hashMap.put(mobile, sharedPreferences.getString(mobile, null));

        hashMap.put(pin_code, sharedPreferences.getString(pin_code, null));
        return hashMap;
    }

    public static AppManager get(Context context) {
        return new AppManager(context);
    }
    public void setAppLanguage(String languageLocal) {
            editor.putString(appLanguage, languageLocal);
            editor.apply();
        }
}
