package com.aarves.bluepages;

import android.app.Application;
import com.aarves.bluepages.database.AppDatabase;
import com.aarves.bluepages.database.DatabaseInjector;

import java.security.NoSuchAlgorithmException;

public class MainApplication extends Application {
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            DatabaseInjector databaseInjector = new DatabaseInjector(getApplicationContext());
            this.database = databaseInjector.getDatabase();
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
