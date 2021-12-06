package com.aarves.bluepages.gui;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.adapter.controllers.LocationController;
import com.aarves.bluepages.adapter.presenters.LocationView;
import com.aarves.bluepages.adapter.presenters.LocationViewModel;

import java.util.List;

public class LocationActivity extends AppCompatActivity implements LocationView {
    private LocationController locationController;
    private LocationArrayAdapter locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_view);
        ListView locationListView = this.findViewById(R.id.locationListView);

        // Set Location controller
        MainApplication application = (MainApplication) this.getApplication();
        this.locationController = application.getAdapters().getLocationController();
        application.setLocationView(this);

        // Inject the locations into the views
        this.locationAdapter = new LocationArrayAdapter(this, R.layout.activity_location, locationController);
        locationListView.setAdapter(this.locationAdapter);

        this.locationController.loadLocations();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Set Location controller
        MainApplication application = (MainApplication) this.getApplication();
        application.setLocationView(this);

        this.locationController.loadLocations();
    }

    @Override
    public void displayLocations(List<LocationViewModel> locations) {
        this.locationAdapter.clear();
        this.locationAdapter.addAll(locations);
    }
}
