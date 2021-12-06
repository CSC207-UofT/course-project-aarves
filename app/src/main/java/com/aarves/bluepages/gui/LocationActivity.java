package com.aarves.bluepages.gui;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.controllers.LocationController;
import com.aarves.bluepages.adapter.presenters.LocationView;
import com.aarves.bluepages.adapter.presenters.LocationViewModel;

import java.util.List;

public class LocationActivity extends AppCompatActivity implements LocationView {
    public static final String LOCATION_ID = "locationId";
    public static final String IS_BOOKMARK = "isBookmark";

    private LocationController locationController;
    private AccountController accountController;
    private LocationArrayAdapter locationAdapter;
    private boolean isBookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_view);
        ListView locationListView = this.findViewById(R.id.locationListView);

        // Set Location controller
        MainApplication application = (MainApplication) this.getApplication();
        this.locationController = application.getAdapters().getLocationController();
        this.accountController = application.getAdapters().getAccountController();
        application.setLocationView(this);

        // Inject the locations into the views
        this.locationAdapter = new LocationArrayAdapter(this, R.layout.activity_location, this.accountController, this.locationController);
        locationListView.setAdapter(this.locationAdapter);

        // Check if bookmarked locations or all locations
        Bundle extras = this.getIntent().getExtras();
        if(extras != null && extras.getBoolean(LocationActivity.IS_BOOKMARK)) {
            this.locationController.loadBookmarkLocations();
            this.isBookmark = true;
        }
        else {
            this.locationController.loadAllLocations();
            this.isBookmark = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Set Location controller
        MainApplication application = (MainApplication) this.getApplication();
        application.setLocationView(this);

        if(this.isBookmark) {
            this.locationController.refreshBookmarks();
            this.locationController.loadBookmarkLocations();
        }
        else {
            this.locationController.loadAllLocations();
        }
    }

    @Override
    public void displayLocations(List<LocationViewModel> locations) {
        this.locationAdapter.clear();
        this.locationAdapter.addAll(locations);
    }
}
