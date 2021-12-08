package com.aarves.bluepages;

import android.app.Application;

import com.aarves.bluepages.adapter.AdapterInjector;
import com.aarves.bluepages.adapter.presenters.*;

import java.security.NoSuchAlgorithmException;

/**
 * The class representing the application, analogous to the main class.
 */
public class MainApplication extends Application {
    private AppInjector appInjector;

    /**
     * Sets up the application and injects all dependencies.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            // Injects all application dependencies on the framework layer
            this.appInjector = new AppInjector(this.getApplicationContext());
        }
        catch (NoSuchAlgorithmException exception) {
            // Handles exception which should never occur as algorithm used exists
            exception.printStackTrace();
        }
    }

    /**
     * Returns the injector for the interface adapter layer.
     * @return the injector for the interface adapter layer
     */
    public AdapterInjector getAdapters() {
        return this.appInjector.getAdapterInjector();
    }

    /**
     * Injects the account view dependency into the interface adapter layer.
     * @param accountView the account view to be set
     */
    public void setAccountView(AccountView accountView) {
        this.getAdapters().setAccountView(accountView);
    }

    /**
     * Injects the account menu view dependency into the interface adapter layer.
     * @param accountMenuView the account menu view to be set
     */
    public void setAccountMenuView(AccountMenuView accountMenuView) {
        this.getAdapters().setAccountMenuView(accountMenuView);
    }

    /**
     * Injects the location view dependency into the interface adapter layer.
     * @param locationView the location view to be set
     */
    public void setLocationView(LocationView locationView) {
        this.getAdapters().setLocationView(locationView);
    }

    /**
     * Injects the review view dependency into the interface adapter layer.
     * @param reviewView the review view to be set
     */
    public void setReviewView(ReviewView reviewView) {
        this.getAdapters().setReviewView(reviewView);
    }

    /**
     * Injects the basic review view dependency into the interface adapter layer.
     * @param baseView the basic review view to be set
     */
    public void setReviewBaseView(BasicView baseView) {
        this.getAdapters().setReviewBaseView(baseView);
    }
}
