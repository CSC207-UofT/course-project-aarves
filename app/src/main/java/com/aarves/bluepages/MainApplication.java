package com.aarves.bluepages;

import android.app.Application;
import com.aarves.bluepages.database.DatabaseInjector;

import java.security.NoSuchAlgorithmException;

public class MainApplication extends Application {
    private DatabaseInjector databaseInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            this.databaseInjector = new DatabaseInjector(getApplicationContext());
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
    }

    public DatabaseInjector getDatabaseInjector() {
        return this.databaseInjector;
    }
}
