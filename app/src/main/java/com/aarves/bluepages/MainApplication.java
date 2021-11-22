package com.aarves.bluepages;

import android.app.Application;

import com.aarves.bluepages.adapter.AdapterInjector;
import com.aarves.bluepages.adapter.presenters.AccountView;

import java.security.NoSuchAlgorithmException;

public class MainApplication extends Application {
    private AppInjector appInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            this.appInjector = new AppInjector(this.getApplicationContext());
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
    }

    public AdapterInjector getAdapters() {
        return this.appInjector.getAdapterInjector();
    }

    public void setAccountView(AccountView accountView) {
        this.getAdapters().setAccountView(accountView);
    }
}