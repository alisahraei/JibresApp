package com.ermile.jibresapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class SplashScreenActivity extends AppCompatActivity {
    private SliderPrefManager prefMan;
//    private LangPrefManager langpref;
    LottieAnimationView animationView;
    int sleep = 500;
    ImageView logo;
    TextView app_name, slug, meta;
    View background;
    @Override
    protected void onResume() {

       super.onResume();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        prefMan = new SliderPrefManager(this);
//        langpref = new LangPrefManager(this);
        setDefaultLanguage();
        try {
            setValSplash();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        haveNetwork();
//        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//
//        boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
//                .isConnectedOrConnecting();
//        //For WiFi Check
//        boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
//                .isConnectedOrConnecting();
//
//        System.out.println(is3g + " net " + isWifi);
//
//        if (!is3g && !isWifi) {
//            Toast.makeText(this, "Network connection is not available", Toast.LENGTH_SHORT).show();
//            BottomSheetFragment bottomSheetDialog = BottomSheetFragment.newInstance();
//            bottomSheetDialog.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");
//
//        } else {
////                " Your method what you want to do "
//            Toast.makeText(this, "Network connection is available", Toast.LENGTH_SHORT).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent;
//                    if (!prefMan.startSlider()) {
//                        intent = new Intent(SplashScreenActivity.this, MainActivity.class);
//                    } else {
//                        intent = new Intent(SplashScreenActivity.this, IntroSliderActivity.class);
//                    }
//                    startActivity(intent);
//                    finish();
//                }
//            }, 3000);
//        }


    }
    public void haveNetwork(){
        //For 3G check
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .isConnectedOrConnecting();
        //For WiFi Check
        boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .isConnectedOrConnecting();
        System.out.println(is3g + " net " + isWifi);
        if (!is3g && !isWifi){
            Refresh();
        } else {
            checkSplash();
        }
    }
    void checkSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
//              if (langpref.startLang()){
//                  intent = new Intent(SplashScreenActivity.this, LanguageActivity.class);
//              } else
                if (!prefMan.startSlider()) {
                    intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(SplashScreenActivity.this, IntroSliderActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
    void setDefaultLanguage() {
        if (getAppLanguage() == null) {
            String deviceLanguage = Locale.getDefault().getLanguage();
            if (deviceLanguage.equals("fa")) {
                AppManager.get(getApplicationContext()).setAppLanguage(deviceLanguage);
            } else {
                AppManager.get(getApplicationContext()).setAppLanguage("en");
            }
        }
    }
    String getAppLanguage() {
        return AppManager.getAppLanguage(getApplication());
    }

    void setValSplash() throws JSONException {

        String from = "#ffffff", to = "#ffffff";
        int style = 1;
        JSONObject object = new JSONObject(JsonManager.getJsonSplash(getApplication()));
        if (!object.isNull("theme")) {
            switch (object.getString("theme")) {
                case "Jibres":
                    style = 1;
                    break;
                default:
                    style = 2;
                    break;
            }
        }
        if (style == 2) {
                animationView.setVisibility(View.INVISIBLE);
            } else {
                animationView.setVisibility(View.VISIBLE);
            }
            if (!object.isNull("sleep")) {
                sleep = object.getInt("sleep");
            }
            if (!object.isNull("logo")) {
                try {
                    Glide.with(this)
                            .applyDefaultRequestOptions(new RequestOptions()
                                    .placeholder(R.drawable.logo)
                                    .error(R.drawable.logo))
                            .load(object.getString("logo"))
                            .into(logo);
                } catch (Exception e) {

                }
            }
            if (!object.isNull("title")) {
                app_name.setText(object.getString("title"));
            }
            if (!object.isNull("desc")) {
                slug.setText(object.getString("desc"));
            }
            if (!object.isNull("meta")) {
                meta.setText(object.getString("meta"));
            }
            if (!object.isNull("bg")) {
                JSONObject bg = object.getJSONObject("bg");
                if (!bg.isNull("from"))
                    from = bg.getString("from");
                if (!bg.isNull("to"))
                    to = bg.getString("to");
            }
            if (!object.isNull("color")) {
                JSONObject color = object.getJSONObject("color");
                if (!color.isNull("primary")) {
                    app_name.setTextColor(Color.parseColor(color.getString("primary")));
                    slug.setTextColor(Color.parseColor(color.getString("primary")));
                }
                if (!color.isNull("secondary")) {
                    meta.setTextColor(Color.parseColor(color.getString("secondary")));
                }
            }
        ColorUtil.setGradient(background, from, to);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

    public void Refresh() {
        BottomSheetFragment bottomSheetDialog = BottomSheetFragment.newInstance();
        bottomSheetDialog.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.setCancelable(false);
        bottomSheetFragment.setListener(() -> {
            bottomSheetFragment.dismiss();
            finish();
            startActivity(getIntent());
        });
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

    }

}



