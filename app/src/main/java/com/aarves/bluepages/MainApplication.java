package com.aarves.bluepages;

import android.app.Application;
import com.aarves.bluepages.database.DatabaseInjector;

import java.security.NoSuchAlgorithmException;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            DatabaseInjector databaseInjector = new DatabaseInjector(getApplicationContext());
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
    }
}
