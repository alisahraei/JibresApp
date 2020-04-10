package com.ermile.jibresapp;

import android.content.Context;

class JsonReadFile {
    private static String file_intro = "/intro_default.json";
    private static String file_splash = "/splash_default.json";
    private static String folder_json = "json";

    public static String intro(Context context) {
        return fileUtil.ReadFileAssets(context, folder_json + file_intro);
    }

    public static String splash(Context context) {
        return fileUtil.ReadFileAssets(context, folder_json + file_splash);
    }
}
