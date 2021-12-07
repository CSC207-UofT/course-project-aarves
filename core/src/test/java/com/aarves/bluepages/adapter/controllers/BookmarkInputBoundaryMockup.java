package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.location.LocationDTO;
import com.aarves.bluepages.usecase.data.location.LocationDataMapper;
import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.interactors.location.BookmarkDataBoundary;
import com.aarves.bluepages.usecase.interactors.location.BookmarkInputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationInputBoundary;

import java.util.ArrayList;
import java.util.List;

public class BookmarkInputBoundaryMockup implements BookmarkInputBoundary {

    private LocationDAO locationDAO;
    private List<Location> bookmarks;
    private String username;
    private boolean locationsDisplayed;
    private boolean locationRefreshed;

    @Override
    public void addBookmark(int locationId) throws NotLoggedInException {
        LocationDTO locationDTO = this.locationDAO.getLocationData(locationId);
        Location newLocation = LocationDataMapper.locationFactory(locationDTO, locationId);
        bookmarks.add(newLocation);

    }

    @Override
    public void removeBookmark(int locationId) throws NotLoggedInException {
        for (Location l:bookmarks){
            Integer id = l.getLocationId();
            if (id.equals(locationId)){
                bookmarks.remove(l);
            }
        }
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
