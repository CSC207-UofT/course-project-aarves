package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.usecase.interactors.location.LocationOutputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationOutputModel;

import java.util.List;

public class LocationOutputBoundaryMockup implements LocationOutputBoundary {

    private boolean locationsPresented;

    @Override
    public void presentLocations(List<LocationOutputModel> locations, List<Boolean> bookmarked) {
        this.locationsPresented = true;
    }

    public boolean isLocationsPresented(){
        return locationsPresented;
    }
}
