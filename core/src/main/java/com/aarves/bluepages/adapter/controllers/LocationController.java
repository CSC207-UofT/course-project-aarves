package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.location.BookmarkInputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationInputBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewLocationInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class LocationController {
    private final BookmarkInputBoundary bookmarkInput;
    private final LocationInputBoundary locationInput;
    private final ReviewLocationInputBoundary reviewInput;

    public LocationController(BookmarkInputBoundary bookmarkInput, LocationInputBoundary locationInput, ReviewLocationInputBoundary reviewInput) {
        this.bookmarkInput = bookmarkInput;
        this.locationInput = locationInput;
        this.reviewInput = reviewInput;
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
        List<Integer> locationIds = this.locationInput.getLocationIds();
        List<Float> ratings = new ArrayList<>();

        for(int locationId : locationIds) {
            float rating = this.reviewInput.getLocationRating(locationId);
            ratings.add(rating);
        }

        this.locationInput.loadAllLocations(ratings);
    }
}
