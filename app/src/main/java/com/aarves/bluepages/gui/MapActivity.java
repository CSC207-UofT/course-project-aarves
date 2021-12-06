package com.aarves.bluepages.gui;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.MapboxGateway;
import com.aarves.bluepages.adapter.controllers.LookupController;
import com.aarves.bluepages.entities.Location;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonElement;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.geojson.BoundingBox;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Geometry;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.maps.CameraBoundsOptions;
import com.mapbox.maps.CoordinateBounds;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private @NotNull MapboxMap mapboxMap;

    // Set LatLng for bloorBay and collegeSpadina
    private final LatLng northEast = new LatLng(43.67121768976685, -79.38297760120373);
    private final LatLng southWest = new LatLng(43.653559622123446, -79.40543276088096);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Configure Mapbox token
        Mapbox.getInstance(this, getResources().getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_map);

        // Bind the map to just the vicinity around campus
        MapView mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        searchConfiguration();
    }

    /**
     * Configure the search bar to take the user's input when the enter button is selected.
     */
    private void searchConfiguration() {
        EditText editText = this.findViewById(R.id.search);
        editText.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            // Listen for the enter key
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                new Thread() {
                    public void run() {
                        // Take the user's input and search for it
                        LookupController lc = new LookupController();
                        MapboxGateway mg = new MapboxGateway();
                        JSONObject json = lc.lookupLocation(editText.getText().toString(), getResources().getString(R.string.mapbox_access_token));
                        ArrayList<Location> locationArray = mg.parseInformation(json);

                        runOnUiThread(() -> {
                            // Add the points to the map
                            mapboxMap.clear();
                            for (Location location : locationArray) {
                                mapboxMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(location.getCoordinates()[1], location.getCoordinates()[0]))
                                        .title(location.getName())
                                        .snippet(location.getAddress()));
                            }

                            // Zoom camera to first result
                            if (locationArray.size() > 0) {
                                mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locationArray.get(0).getCoordinates()[1], locationArray.get(0).getCoordinates()[0]), 16));
                            }

                        });
                    }
                }.start();
                handled = true;
            }
            return handled;
        });
    }

    @Override
    public void onMapReady(@NonNull @NotNull com.mapbox.mapboxsdk.maps.MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        // Set the map style from URI
        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/ashenafee/ckw8c49wi2of616pdbiend57d"));

        // Get rendered features based off the user's tap
        mapboxMap.addOnMapClickListener(point -> {
            mapboxMap.clear();
            PointF screenPoint = mapboxMap.getProjection().toScreenLocation(point);
            List<Feature> features = mapboxMap.queryRenderedFeatures(screenPoint);
            if (!features.isEmpty()) {

                // Get the first feature where geometry is a Point
                for (Feature feature : features) {
                    if (feature.geometry().type().equals("Point")) {
                        // Get latitude and longitude of the feature
                        Point coordinates = (Point) feature.geometry();
                        double latitude = coordinates.latitude();
                        double longitude = coordinates.longitude();

                        // Get the address of the feature
                        new Thread() {
                            public void run() {
                                LookupController lc = new LookupController();
                                JSONObject json = lc.lookupLocation( longitude + "," + latitude, getResources().getString(R.string.mapbox_access_token));
                                String address = new MapboxGateway().getPointAddress(json);

                                // Return the address to the UI thread
                                runOnUiThread(() -> {
                                    String name = feature.getStringProperty("name");

                                    // Display pinpoint graphic with location name and address
                                    mapboxMap.addMarker(new MarkerOptions()
                                            .position(new LatLng(latitude, longitude))
                                            .title(name)
                                            .snippet(address));
                                });
                            }
                        }.start();
                    }
                }
            }
            return true;
        });

        // Zoom camera in to the downtown core
        mapboxMap.setCameraPosition(new CameraPosition.Builder()
                .zoom(13)
                .build());

        // Build the bounds of the map
        LatLngBounds latLngBounds = new LatLngBounds.Builder()
                .include(northEast)
                .include(southWest)
                .build();

        // Set camera bounds
        mapboxMap.setLatLngBoundsForCameraTarget(latLngBounds);
        mapboxMap.setMinZoomPreference(13);
        mapboxMap.setMaxZoomPreference(17);
    }
}
