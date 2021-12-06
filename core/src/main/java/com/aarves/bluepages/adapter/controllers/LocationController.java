package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.location.BookmarkInputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationInputBoundary;

public class LocationController {
    private final BookmarkInputBoundary bookmarkInput;
    private final LocationInputBoundary locationInput;

    public LocationController(BookmarkInputBoundary bookmarkInput, LocationInputBoundary locationInput) {
        this.bookmarkInput = bookmarkInput;
        this.locationInput = locationInput;
    }

    public void toggleBookmark(int locationID) {
        try {
            if(this.bookmarkInput.isBookmarked(locationID)) {
                this.bookmarkInput.removeBookmark(locationID);
            }
            else {
                this.bookmarkInput.addBookmark(locationID);
            }
        }
        catch(NotLoggedInException exception) {
            exception.printStackTrace();
        }
    }

    public void loadLocations() {
        this.locationInput.loadLocations();
    }
}
