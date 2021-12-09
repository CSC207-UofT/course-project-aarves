package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.location.LocationDataAccess;

/**
 * The injector class for all location dependencies on the use case layer.
 */
public class LocationUseCaseInjector {
    private final BookmarkManager bookmarkManager;
    private final LocationMap locationMap;

    public LocationUseCaseInjector(LocationDAO locationDAO, LocationOutputBoundary locationOutput) {
        // Creates new data access class with adapter dependency
        LocationDataAccess locationData = new LocationDataAccess(locationDAO);
        // Injects data access and output boundary into use cases
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
