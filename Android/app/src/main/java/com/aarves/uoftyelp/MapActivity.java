package com.aarves.uoftyelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraBoundsOptions;
import com.mapbox.maps.CoordinateBounds;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.Style;
import com.mapbox.maps.extension.style.StyleContract;
import com.mapbox.maps.extension.style.sources.generated.GeoJsonSource;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MapView mapView = findViewById(R.id.mapView);
        MapboxMap mapboxMap = mapView.getMapboxMap();
        mapboxMap.loadStyleUri(Style.MAPBOX_STREETS);

        Point bloorBay = Point.fromLngLat(-79.38297760120373, 43.67121768976685);
        Point collegeSpadina = Point.fromLngLat(-79.40543276088096, 43.653559622123446);

        CameraBoundsOptions CAMPUS = new CameraBoundsOptions.Builder().bounds(
                new CoordinateBounds(collegeSpadina, bloorBay, false)
        ).minZoom(5.0)
                .build();

        mapboxMap.setBounds(CAMPUS);

    }

}