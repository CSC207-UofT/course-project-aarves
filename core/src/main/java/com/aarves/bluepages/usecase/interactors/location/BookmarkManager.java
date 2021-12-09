package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.Observer;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.User;

import java.util.ArrayList;
import java.util.List;

public class BookmarkManager implements BookmarkInputBoundary, Observer<User> {
    private final BookmarkDataBoundary bookmarkData;
    private final LocationOutputBoundary locationOutput;

    private List<Location> bookmarks;
    private String username;

    /**
     * Creates a BookmarkManager object.
     * @param bookmarkData the BookmarkDataBoundary to be injected.
     * @param locationOutput the LocationOutputBoundary to be injected.
     */
    public BookmarkManager(BookmarkDataBoundary bookmarkData, LocationOutputBoundary locationOutput) {
        this.bookmarkData = bookmarkData;
        this.locationOutput = locationOutput;

        this.bookmarks = new ArrayList<>();
        this.username = "";
    }

    /**
     * Adds the bookmark with the location ID to the user's bookmarks.
     * @param locationId the ID of the location to be bookmarked
     * @throws NotLoggedInException
     */
    @Override
    public void addBookmark(int locationId) throws NotLoggedInException {
        this.checkLoggedIn();

        if(!this.isBookmarked(locationId)) {
            this.bookmarkData.addBookmark(this.username, locationId, this.bookmarks);
        }
    }

    /**
     * Removes the bookmark with the location ID from the user's bookmarks.
     * @param locationId the ID of the location to be removed.
     * @throws NotLoggedInException
     */
    @Override
    public void removeBookmark(int locationId) throws NotLoggedInException {
        this.checkLoggedIn();
        this.bookmarkData.removeBookmark(this.username, locationId, this.bookmarks);
    }

    /**
     * Returns whether the location with the location ID is bookmarked or not
     * @param locationId the ID of the location
     * @return true if the location is bookmarked, false otherwise
     */
    @Override
    public boolean isBookmarked(int locationId) {
        List<Integer> bookmarkIds = new ArrayList<>();
        for(Location location : this.bookmarks) {
            bookmarkIds.add(location.getLocationId());
        }

        return bookmarkIds.contains(locationId);
    }

    /**
     * Gets the current state of the user's bookmarks.
     */
    @Override
    public void refreshBookmarks() {
        this.bookmarks.clear();

        List<Location> bookmarks = this.bookmarkData.getUserBookmarks(this.username);
        this.bookmarks.addAll(bookmarks);
    }

    /**
     * Load all the ratings and bookmark status to the locations, and map the locations to LocationOutputModels.
     * @param ratings a list of ratings of the locations
     * @param bookmarked a list of the bookmark status of the location
     */
    @Override
    public void loadLocations(List<Float> ratings, List<Boolean> bookmarked) {
        List<LocationOutputModel> locationOutputModels = LocationOutputMapper.mapToOutputModels(this.bookmarks, ratings);
        this.locationOutput.presentLocations(locationOutputModels, bookmarked);
    }

    /**
     * Gets the location IDs of all the locations.
     * @return the location IDs of all the locations in Bluepages.
     */
    @Override
    public List<Integer> getLocationIds() {
        List<Integer> locationIds = new ArrayList<>();

        for(Location bookmark : this.bookmarks) {
            locationIds.add(bookmark.getLocationId());
        }

        return locationIds;
    }

    /**
     * Updates the user with the changed bookmark status.
     * @param arg the argument related to the changed state of the observable
     */
    @Override
    public void update(User arg) {
        if(arg != null) {
            this.bookmarks = arg.getBookmarks();
            this.username = arg.getUsername();

            this.refreshBookmarks();
        }
        else {
            this.bookmarks = new ArrayList<>();
            this.username = "";
        }
    }

    /**
     * Chekcs whether the user is currently logged in - if not, throw a NotLoggedInException
     * @throws NotLoggedInException
     */
    private void checkLoggedIn() throws NotLoggedInException {
        if(this.username.isEmpty()) {
            throw new NotLoggedInException();
        }
    }
}
