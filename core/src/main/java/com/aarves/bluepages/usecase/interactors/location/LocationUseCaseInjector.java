package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.location.LocationDataAccess;

public class LocationUseCaseInjector {
    private final LocationMap locationMap;

    public LocationUseCaseInjector(LocationDAO locationDAO) {
        LocationDataBoundary locationData = new LocationDataAccess(locationDAO);
        this.locationMap = new LocationMap(locationData);
    }

    public LocationMap getLocationMap() {
        return this.locationMap;
    }
}
