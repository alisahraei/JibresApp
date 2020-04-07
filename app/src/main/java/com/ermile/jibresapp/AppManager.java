package com.ermile.jibresapp;

import android.content.Context;

public class AppManager {
    public static final String appLanguage = "appLanguage";

    private AppManager(Context context) {
        super();
    }

    public static String getAppLanguage(Context context) {
        return AppManager
                .get(context)
                .getUserInfo()
                .get(AppManager.appLanguage);
    }
    public static AppManager get(Context context) {
        return new AppManager(context);
    }

}
