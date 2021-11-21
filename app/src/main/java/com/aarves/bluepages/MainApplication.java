package com.aarves.bluepages;

import android.app.Application;

import java.security.NoSuchAlgorithmException;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            AppInjector appInjector = new AppInjector(this.getApplicationContext());
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
    }
}
