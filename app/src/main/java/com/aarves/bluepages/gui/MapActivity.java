package com.aarves.bluepages.gui;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.aarves.bluepages.R;
import com.aarves.bluepages.adapter.MapboxGateway;
import com.aarves.bluepages.adapter.controllers.LookupController;
import com.aarves.bluepages.entities.Location;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private @NotNull MapboxMap mapboxMap;

    private final LatLng northEast = new LatLng(43.67121768976685, -79.38297760120373);
    private final LatLng southWest = new LatLng(43.653559622123446, -79.40543276088096);

    /**
     * Configure the map once the activity is created.
     * @param savedInstanceState
     */
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
     * Set the map style and add listeners for user taps.
     * @param mapboxMap
     */
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
                        configurePopup(mapboxMap, feature);
                    }
                }
            }
            return true;
        });

        // Configure the camera position
        configureCameraPosition(mapboxMap);
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
                getSearchResults(editText);
                handled = true;
            }
            return handled;
        });
    }

    /**
     * Get the search results from the MapBox API.
     * @param editText The EditText that contains the search query.
     */
    private void getSearchResults(EditText editText) {
        new Thread() {
            public void run() {
                // Take the user's input and search for it
                LookupController lc = new LookupController();
                MapboxGateway mg = new MapboxGateway();
                JSONObject json = lc.lookupLocation(editText.getText().toString(), getResources().getString(R.string.mapbox_access_token));
                HashMap<Location, String> locationMap = mg.parseInformation(json);

                // Get all locations from locationMap
                ArrayList<Location> locations = new ArrayList<>(locationMap.keySet());

                displaySearchResults(locationMap, locations);
            }
        }.start();
    }

    /**
     * Display the search results on the map.
     * @param locationMap The HashMap containing the locations and their corresponding information.
     * @param locations The list of locations to be displayed.
     */
    private void displaySearchResults(HashMap<Location, String> locationMap, ArrayList<Location> locations) {
        runOnUiThread(() -> {
            // Add the points to the map
            mapboxMap.clear();
            for (Location location : locations) {
                createResultPoints(location, locationMap);
            }

            // Zoom camera to first result
            if (locations.size() > 0) {
                mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locations.get(0).getCoordinates()[1], locations.get(0).getCoordinates()[0]), 16));
            }

        });
    }

    /**
     * Create points for each search result.
     * @param location The location to be displayed.
     */
    private void createResultPoints(Location location, HashMap<Location, String> locationMap) {
        // Create a new marker for each location
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(location.getCoordinates()[1], location.getCoordinates()[0]));

        mapboxMap.addMarker(new MarkerOptions()
                .position(new LatLng(location.getCoordinates()[1], location.getCoordinates()[0]))
                .title(location.getName())
                .snippet(locationMap.get(location)));

        // Set on marker click listener
        mapboxMap.setOnMarkerClickListener(marker1 -> {
            // Get the marker's information
            String locationName = marker1.getTitle();
            String locationAddress = marker1.getSnippet();

            // Create a new popup window
            showPopup(locationName, locationAddress);
            return true;
        });
    }

    /**
     * Configure the map zoom and location.
     * @param mapboxMap The MapBox map.
     */
    private void configureCameraPosition(@NotNull MapboxMap mapboxMap) {
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

    /**
     * Configure the pinpoint feature when POIs are clicked.
     * @param mapboxMap The MapBox map.
     * @param feature The feature that was clicked.
     */
    private void configurePopup(@NotNull MapboxMap mapboxMap, Feature feature) {
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
                            .position(new LatLng(latitude, longitude)));

                    // Show the popup window displaying information
                    showPopup(name, address);
                });
            }
        }.start();
    }

    /**
     * Show the popup window displaying information on the location
     * @param name The name of the location.
     * @param address The address of the location.
     */
    private void showPopup(String name, String address) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_location, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // Change the text of the popup window
        TextView locationInfo = popupView.findViewById(R.id.popupLocInfo);
        String info = name + "\n" + address;
        locationInfo.setText(info);
        System.out.println(info);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(findViewById(R.id.mapView), Gravity.CENTER, 0, 0);
    }
}
