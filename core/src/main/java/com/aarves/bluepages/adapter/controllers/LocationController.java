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

    /**
     * Creates a new LocationController object.
     * @param bookmarkInput the BookmarkInputBoundary interface to inject
     * @param locationInput the LocationInputBoundary interface  to inject
     * @param reviewInput the ReviewLocationInputBoundary interface to inject
     */
    public LocationController(BookmarkInputBoundary bookmarkInput, LocationInputBoundary locationInput, ReviewLocationInputBoundary reviewInput) {
        this.bookmarkInput = bookmarkInput;
        this.locationInput = locationInput;
        this.reviewInput = reviewInput;
    }

    /**
     * Toggles the bookmark's state - if the location is already bookmark, un-bookmarks the location. If the location
     * is not yet bookmarked, bookmarks the location.
     * @param locationID the location's ID.
     */
    public void toggleBookmark(int locationID) {
        try {
            if(this.bookmarkInput.isBookmarked(locationID)) {
                this.bookmarkInput.removeBookmark(locationID);
            }
            else {
                this.bookmarkInput.addBookmark(locationID);
            }
            this.refreshBookmarks();
        }
        catch(NotLoggedInException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Loads all the locations to present.
     */
    public void loadAllLocations() {
        List<Integer> locationIds = this.locationInput.getLocationIds();
        this.locationInput.loadLocations(this.getRatings(locationIds), this.getBookmarked(locationIds));
    }

    /**
     * loads all the bookmarked locations by a user to present.
     */
    public void loadBookmarkLocations() {
        List<Integer> locationIds = this.bookmarkInput.getLocationIds();
        this.bookmarkInput.loadLocations(this.getRatings(locationIds), this.getBookmarked(locationIds));
    }

    /**
     * Refreshes the user list of bookmarks so that the latest bookmarked information is available.
     */
    public void refreshBookmarks() {
        this.bookmarkInput.refreshBookmarks();
    }

    /**
     * Gets the ratings of the locations associated with each locationID in the array.
     * @param locationIds the location IDs to get the ratings of
     * @return a list with the ratings of the locations
     */
    private List<Float> getRatings(List<Integer> locationIds) {
        List<Float> ratings = new ArrayList<>();

        for(int locationId : locationIds) {
            float rating = this.reviewInput.getLocationRating(locationId);
            ratings.add(rating);
        }

        return ratings;
    }

    /**
     * Gets the bookmarked status (bookmarked/not bookmarked) of the locations associated with each locationID in the
     * array.
     * @param locationIds the location IDs to get the ratings of.
     * @return a list of booleans representing whether each location is bookmarked or not.
     */
    private List<Boolean> getBookmarked(List<Integer> locationIds) {
        List<Boolean> bookmarked = new ArrayList<>();

        for(int locationId : locationIds) {
            bookmarked.add(this.bookmarkInput.isBookmarked(locationId));
        }

        return bookmarked;
    }
}
