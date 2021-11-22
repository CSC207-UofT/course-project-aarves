package com.aarves.bluepages.gui;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aarves.bluepages.R;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.adapter.MapboxGateway;
import com.aarves.bluepages.adapter.controllers.LookupController;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.maps.CameraBoundsOptions;
import com.mapbox.maps.CoordinateBounds;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;

import org.json.JSONObject;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Bind the map to just the vicinity around campus
        MapView mapView = this.findViewById(R.id.mapView);
        MapboxMap mapboxMap = mapView.getMapboxMap();
        mapboxMap.loadStyleUri("mapbox://styles/ashenafee/ckw8c49wi2of616pdbiend57d");

        Point bloorBay = com.mapbox.geojson.Point.fromLngLat(-79.38297760120373, 43.67121768976685);
        Point collegeSpadina = Point.fromLngLat(-79.40543276088096, 43.653559622123446);

        CameraBoundsOptions CAMPUS = new CameraBoundsOptions.Builder().bounds(
                        new CoordinateBounds(collegeSpadina, bloorBay, false)
                ).minZoom(5.0)
                .build();

        mapboxMap.setBounds(CAMPUS);

        searchConfiguration();
    }

    /**
     * Configure the search bar to take the user's input when the enter button is selected.
     */
    private void searchConfiguration() {
        EditText editText = this.findViewById(R.id.search);
        editText.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                new Thread() {
                    public void run() {
                        LookupController lc = new LookupController();
                        MapboxGateway mg = new MapboxGateway();
                        JSONObject json = lc.lookupLocation(editText.getText().toString(), getResources().getString(R.string.mapbox_access_token));
                        ArrayList<Location> locationArray = mg.parseInformation(json);

                        for (Location loc: locationArray) {
                            System.out.println(loc);
                        }
                    }
                }.start();
                handled = true;
            }
            return handled;
        });
    }
}
