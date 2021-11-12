package com.aarves.uoftyelp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraBoundsOptions;
import com.mapbox.maps.CoordinateBounds;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.Style;


public class MainMenuMapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_menu_map, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MapView mapView = getView().findViewById(R.id.mapView);
        MapboxMap mapboxMap = mapView.getMapboxMap();
        mapboxMap.loadStyleUri(Style.MAPBOX_STREETS);

        com.mapbox.geojson.Point bloorBay = com.mapbox.geojson.Point.fromLngLat(-79.38297760120373, 43.67121768976685);
        com.mapbox.geojson.Point collegeSpadina = Point.fromLngLat(-79.40543276088096, 43.653559622123446);

        CameraBoundsOptions CAMPUS = new CameraBoundsOptions.Builder().bounds(
                new CoordinateBounds(collegeSpadina, bloorBay, false)
        ).minZoom(5.0)
                .build();

        mapboxMap.setBounds(CAMPUS);
    }
}