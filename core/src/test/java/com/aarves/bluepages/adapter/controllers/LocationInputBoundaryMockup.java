package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.LocationInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class LocationInputBoundaryMockup implements LocationInputBoundary {

    private List<Location> locations;
    private boolean locationsLoaded;

    public LocationInputBoundaryMockup(List<Location> locations){
        this.locations = locations;
    }
    @Override
    public void loadLocations(List<Float> ratings, List<Boolean> bookmarked) {
        this.locationsLoaded = true;
        // create new location?
    }

    @Override
    public List<Integer> getLocationIds() {
        List<Integer> locationIds = new ArrayList<>();
        for (Location l:locations){
            locationIds.add(l.getLocationId());
        }
        return locationIds;
    }

    public List<Location> getLocations(){
        return this.locations;
    }

    public boolean isLocationsLoaded() {
        return locationsLoaded;
    }
}
