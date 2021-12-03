package com.aarves.bluepages.gui;

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
import com.mapbox.geojson.BoundingBox;
import com.mapbox.geojson.Geometry;
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
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private @NotNull MapboxMap mapboxMap;

    // Set LatLng for bloorBay and collegeSpadina
    private final LatLng bloorBay = new LatLng(43.67121768976685, -79.38297760120373);
    private final LatLng collegeSpadina = new LatLng(43.653559622123446, -79.40543276088096);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Configure Mapbox token
        Mapbox.getInstance(this, getResources().getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_map);

        // Bind the map to just the vicinity around campus
        mapView = findViewById(R.id.mapView);
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
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                new Thread() {
                    public void run() {
                        LookupController lc = new LookupController();
                        MapboxGateway mg = new MapboxGateway();
                        JSONObject json = lc.lookupLocation(editText.getText().toString(), getResources().getString(R.string.mapbox_access_token));
                        ArrayList<Location> locationArray = mg.parseInformation(json);

                        // Show snackbar on UI thread
                        runOnUiThread(() -> {
                            if (locationArray.size() > 0) {
                                Location location = locationArray.get(0);
                                Snackbar.make(findViewById(R.id.mapView), "First result: " + location.getAddress(), Snackbar.LENGTH_LONG).show();
                            }

                            // Add the points to the map
                            mapboxMap.clear();
                            for (Location location : locationArray) {
                                mapboxMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(location.getCoordinates()[1], location.getCoordinates()[0]))
                                        .title(location.getName()));
                            }

                            // Zoom camera to first result
                            if (locationArray.size() > 0) {
                                mapboxMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locationArray.get(0).getCoordinates()[1], locationArray.get(0).getCoordinates()[0]), 16));
                            }

                        });
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

    @Override
    public void onMapReady(@NonNull @NotNull com.mapbox.mapboxsdk.maps.MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        // Set the map style from URI
        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/ashenafee/ckw8c49wi2of616pdbiend57d"));

        // Create a LatLng bound for BloorBay LatLng object

//        LatLngBounds bound = new LatLngBounds.Builder()
//                .include(bloorBay)
//                .include(collegeSpadina)
//                        .build();
//
//        // Bound the map to all the area covered by the LatLngBounds object
//
//        mapboxMap.setLatLngBoundsForCameraTarget(bound);

        // Set the minimum and maximum zoom of the map to the same value

//        mapboxMap.setMinZoomPreference(15);
//        mapboxMap.setMaxZoomPreference(15);

        // Zoom camera in to bloorBay and collegeSpadina
         mapboxMap.setCameraPosition(new CameraPosition.Builder()
                .target(bloorBay)
                        .target(collegeSpadina)
                .zoom(15)
                .build());

        // Set latlngbounds
        LatLngBounds latLngBounds = new LatLngBounds.Builder()
                .include(bloorBay)
                .include(collegeSpadina)
                .build();

        // Set camera bounds
        mapboxMap.setLatLngBoundsForCameraTarget(latLngBounds);
        mapboxMap.setMinZoomPreference(15);
        mapboxMap.setMaxZoomPreference(18);
    }
}
