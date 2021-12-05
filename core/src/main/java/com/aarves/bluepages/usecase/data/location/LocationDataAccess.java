package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.BookmarkDataBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationDataBoundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationDataAccess implements BookmarkDataBoundary, LocationDataBoundary {
    private final LocationDAO locationDAO;

    public LocationDataAccess(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    @Override
    public void addBookmark(String username, int locationId, List<Location> bookmarks) {
        Location location = this.getLocation(locationId);

        if(location != null) {
            bookmarks.add(location);
            this.updateBookmarks(username, bookmarks);
        }
    }

    @Override
    public void removeBookmark(String username, int locationId, List<Location> bookmarks) {
        Location location = this.getLocation(locationId);

        if(location != null) {
            bookmarks.remove(location);
            this.updateBookmarks(username, bookmarks);
        }
    }

    @Override
    public void updateBookmarks(String username, List<Location> bookmarks) {
        List<Integer> bookmarkIds = new ArrayList<>();

        for(Location location : bookmarks) {
            bookmarkIds.add(location.getLocationId());
        }

        this.locationDAO.updateBookmarks(username, bookmarkIds);
    }

    @Override
    public List<Location> getUserBookmarks(String username) {
        Map<Integer, LocationDTO> bookmarksData = this.locationDAO.getBookmarksData(username);
        List<Location> bookmarks = new ArrayList<>();

        for(int bookmarkId : bookmarksData.keySet()) {
            LocationDTO bookmarkData = bookmarksData.get(bookmarkId);
            Location bookmark = LocationDataMapper.locationFactory(bookmarkData, bookmarkId);
            bookmarks.add(bookmark);
        }

        return bookmarks;
    }

    @Override
    public Location addLocation(Location location) {
        LocationDTO locationDTO = LocationDataMapper.mapToDTO(location);
        int locationId = this.locationDAO.addLocation(locationDTO);

        return LocationDataMapper.locationFactory(locationDTO, locationId);
    }

    @Override
    public void deleteLocation(int locationId) {
        this.locationDAO.deleteLocation(locationId);
    }

    @Override
    public Location getLocation(int locationId) {
        LocationDTO locationDTO = this.locationDAO.getLocationData(locationId);

        if(locationDTO != null) {
            return LocationDataMapper.locationFactory(locationDTO, locationId);
        }
        else {
            return null;
        }
    }

    @Override
    public Map<List<Long>, Integer> getCoordinatesMap() {
        return this.locationDAO.getCoordinatesMap();
    }
}
