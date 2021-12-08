package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;
import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.location.LocationDAOMockup;
import com.aarves.bluepages.usecase.data.location.LocationDTO;
import com.aarves.bluepages.usecase.data.location.LocationDataMapper;
import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.location.BookmarkDataBoundary;
import com.aarves.bluepages.usecase.interactors.location.BookmarkInputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class BookmarkInputBoundaryMockup implements BookmarkInputBoundary {

    // private final LocationDAOMockup locationDAO = new LocationDAOMockup();
    private List<Location> bookmarks;
    private String username;
    private boolean locationsDisplayed;
    private boolean locationRefreshed;

    public BookmarkInputBoundaryMockup(List<Location> bookmarks, String username){
        this.bookmarks = bookmarks;
        this.username = username;

    }

    @Override
    public void addBookmark(int locationId) throws NotLoggedInException {
        double[] coordinates = {45.3, 78.4};
        Location location = new StudyLocation(locationId, "Gerstein", coordinates);
        bookmarks.add(location);

    }

    @Override
    public void removeBookmark(int locationId) throws NotLoggedInException {

        Location toRemove = null;
        for (Location l:bookmarks){
            Integer id = l.getLocationId();
            if (id.equals(locationId)){
                toRemove = l;
                // bookmarks.remove(l);
            }
        }
        bookmarks.remove(toRemove);
    }

    @Override
    public boolean isBookmarked(int locationId) {
        for (Location l:bookmarks){
            Integer id = l.getLocationId();
            if (id.equals(locationId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void refreshBookmarks() {
        this.locationRefreshed = true;

    }

    @Override
    public void loadLocations(List<Float> ratings, List<Boolean> bookmarked) {
        // null pointer error because loadLocations isnt getting passed in the right things from getLocationIds

        this.locationsDisplayed = true;
    }

    @Override
    public List<Integer> getLocationIds() {
        List<Integer> locationIds = new ArrayList<>();
        for (Location location:bookmarks){
            int id = location.getLocationId();
            locationIds.add(id);
        }
        return locationIds;
    }

    public boolean isLocationsDisplayed(){
        return this.locationsDisplayed;
    }

    public List<Location> getBookmarks(){
        return this.bookmarks;
    }

    public boolean isLocationRefreshed(){
        return this.locationRefreshed;
    }

}
