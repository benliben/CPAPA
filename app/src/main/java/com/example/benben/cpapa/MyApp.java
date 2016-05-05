package com.example.benben.cpapa;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by benben on 2016/5/3.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}
