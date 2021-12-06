package com.aarves.bluepages.gui;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.aarves.bluepages.MainApplication;
import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.controllers.BookmarkController;
import com.aarves.bluepages.adapter.presenters.LocationViewModel;
import com.aarves.bluepages.usecase.data.location.LocationType;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {
    private BookmarkController bookmarkController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the location views
        setContentView(R.layout.activity_location_view);
        ListView locationListView = findViewById(R.id.locationListView);

        // set bookmark controller
        MainApplication application = (MainApplication) this.getApplication();
        this.bookmarkController = application.getAdapters().getBookmarkController();

        // hardcoded values for now
        ArrayList<LocationViewModel> locations = new ArrayList<>();
        locations.add(new LocationViewModel("Robarts Library", LocationType.STUDY));
        locations.add(new LocationViewModel("Second Cup", LocationType.FOOD));

        // inject the locations into the views
        LocationArrayAdapter locationAdapter = new LocationArrayAdapter(this, R.layout.activity_location, locations, bookmarkController);
        locationListView.setAdapter(locationAdapter);
    }

}
