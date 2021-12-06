package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.location.LocationDataAccess;

public class LocationUseCaseInjector {
    private final BookmarkManager bookmarkManager;
    private final LocationMap locationMap;

    public LocationUseCaseInjector(LocationDAO locationDAO, LocationOutputBoundary locationOutput) {
        LocationDataAccess locationData = new LocationDataAccess(locationDAO);
        this.bookmarkManager = new BookmarkManager(locationData, locationOutput);
        this.locationMap = new LocationMap(locationData, locationOutput);
    }

    public BookmarkManager getBookmarkManager() {
        return this.bookmarkManager;
    }

    public LocationMap getLocationMap() {
        return this.locationMap;
    }
}
