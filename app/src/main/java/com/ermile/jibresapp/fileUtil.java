package com.ermile.jibresapp;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

class fileUtil {
    public static String ReadFileAssets(Context context, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String string = new String(buffer);
            if (string.length() == 0) {
                return null;
            } else {
                return string;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
//            e.printStackTrace();
        }
    }
}
