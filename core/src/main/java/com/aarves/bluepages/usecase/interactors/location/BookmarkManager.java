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

    public BookmarkManager(BookmarkDataBoundary bookmarkData, LocationOutputBoundary locationOutput) {
        this.bookmarkData = bookmarkData;
        this.locationOutput = locationOutput;

        this.bookmarks = new ArrayList<>();
        this.username = "";
    }

    @Override
    public void addBookmark(int locationId) throws NotLoggedInException {
        this.checkLoggedIn();

        if(!this.isBookmarked(locationId)) {
            this.bookmarkData.addBookmark(this.username, locationId, this.bookmarks);
        }
    }

    @Override
    public void removeBookmark(int locationId) throws NotLoggedInException {
        this.checkLoggedIn();
        this.bookmarkData.removeBookmark(this.username, locationId, this.bookmarks);
    }

    @Override
    public boolean isBookmarked(int locationId) {
        List<Integer> bookmarkIds = new ArrayList<>();
        for(Location location : this.bookmarks) {
            bookmarkIds.add(location.getLocationId());
        }

        return bookmarkIds.contains(locationId);
    }

    @Override
    public void refreshBookmarks() {
        this.bookmarks.clear();

        List<Location> bookmarks = this.bookmarkData.getUserBookmarks(this.username);
        this.bookmarks.addAll(bookmarks);
    }

    @Override
    public void loadLocations(List<Float> ratings, List<Boolean> bookmarked) {
        List<LocationOutputModel> locationOutputModels = LocationOutputMapper.mapToOutputModels(this.bookmarks, ratings);
        this.locationOutput.presentLocations(locationOutputModels, bookmarked);
    }

    @Override
    public List<Integer> getLocationIds() {
        List<Integer> locationIds = new ArrayList<>();

        for(Location bookmark : this.bookmarks) {
            locationIds.add(bookmark.getLocationId());
        }

        return locationIds;
    }

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

    private void checkLoggedIn() throws NotLoggedInException {
        if(this.username.isEmpty()) {
            throw new NotLoggedInException();
        }
    }
}
