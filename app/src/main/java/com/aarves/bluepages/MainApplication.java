package com.aarves.bluepages;

import android.app.Application;

import com.aarves.bluepages.adapter.AdapterInjector;
import com.aarves.bluepages.adapter.presenters.AccountMenuView;
import com.aarves.bluepages.adapter.presenters.AccountView;
import com.aarves.bluepages.adapter.presenters.BasicView;
import com.aarves.bluepages.adapter.presenters.ReviewView;

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

    public void setAccountMenuView(AccountMenuView accountMenuView) {
        this.getAdapters().setAccountMenuView(accountMenuView);
    }

    public void setReviewView(ReviewView reviewView) {
        this.getAdapters().setReviewView(reviewView);
    }

    public void setReviewBaseView(BasicView baseView) {
        this.getAdapters().setReviewBaseView(baseView);
    }
}
