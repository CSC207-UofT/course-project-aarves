package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.usecase.interactors.location.BookmarkDataBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationDataBoundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class for accessing location data through location entities, used by bookmarks and locations use case interactors.
 */
public class LocationDataAccess implements BookmarkDataBoundary, LocationDataBoundary {
    private final LocationDAO locationDAO;

    /**
     * Constructs location data access with location data source adapter dependency.
     * @param locationDAO the location data source adapter dependency
     */
    public LocationDataAccess(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    /**
     * Adds new bookmark to the bookmark list of given user using the data source adapter dependency.
     * @param username the username of the user
     * @param locationId the ID of the location to be bookmarked
     * @param bookmarks the list of the user's current bookmarks
     */
    @Override
    public void addBookmark(String username, int locationId, List<Location> bookmarks) {
        // Gets location corresponding to ID
        Location location = this.getLocation(locationId);

        // Adds bookmark if location exists
        if(location != null) {
            bookmarks.add(location);
            this.updateBookmarks(username, bookmarks);
        }
    }

    /**
     * Removes bookmark from the bookmark list of given user using the data source adapter dependency.
     * @param username the username of the user
     * @param locationId the ID of the location to be unbookmarked
     * @param bookmarks the list of the user's current bookmarks
     */
    @Override
    public void removeBookmark(String username, int locationId, List<Location> bookmarks) {
        // Gets location corresponding to ID
        Location location = this.getLocation(locationId);

        // Removes bookmark if location exists
        if(location != null) {
            bookmarks.remove(location);
            this.updateBookmarks(username, bookmarks);
        }
    }

    /**
     * Updates bookmarks list of given user in data source using the data source adapter dependency.
     * @param username the username of the user
     * @param bookmarks the list of bookmarks to be updated to
     */
    @Override
    public void updateBookmarks(String username, List<Location> bookmarks) {
        List<Integer> bookmarkIds = new ArrayList<>();

        // Gets all IDs of the bookmarked locations
        for(Location location : bookmarks) {
            bookmarkIds.add(location.getLocationId());
        }

        // Updates using data source adapter
        this.locationDAO.updateBookmarks(username, bookmarkIds);
    }

    /**
     * Retrieves all bookmarked location entities for given user using the data source adapter dependency.
     * @param username the username of the user
     * @return a list of bookmarked location entities
     */
    @Override
    public List<Location> getUserBookmarks(String username) {
        // Gets a map for bookmarked locations data
        Map<Integer, LocationDTO> bookmarksData = this.locationDAO.getBookmarksData(username);
        List<Location> bookmarks = new ArrayList<>();

        // Converts into list of bookmarked location entities
        for(int bookmarkId : bookmarksData.keySet()) {
            LocationDTO bookmarkData = bookmarksData.get(bookmarkId);
            Location bookmark = LocationDataMapper.locationFactory(bookmarkData, bookmarkId);
            bookmarks.add(bookmark);
        }

        return bookmarks;
    }

    /**
     * Adds given location entity to data source using the data source adapter dependency.
     * @param location the location entity to be added
     * @return the added location, along with its autogenerated ID
     */
    @Override
    public Location addLocation(Location location) {
        // Adds location to data source
        LocationDTO locationDTO = LocationDataMapper.mapToDTO(location);
        int locationId = this.locationDAO.addLocation(locationDTO);

        // Creates new location with given data and new ID
        return LocationDataMapper.locationFactory(locationDTO, locationId);
    }

    /**
     * Deletes given location given ID from data source using the data source adapter dependency.
     * @param locationId the ID of the location to be deleted
     */
    @Override
    public void deleteLocation(int locationId) {
        this.locationDAO.deleteLocation(locationId);
    }

    /**
     * Retrieves location with given ID from data source using the data source adapter dependency.
     * @param locationId the ID of the location to be retrieved
     * @return the location entity with given ID, or null if location does not exist
     */
    @Override
    public Location getLocation(int locationId) {
        // Gets location data from ID
        LocationDTO locationDTO = this.locationDAO.getLocationData(locationId);

        // Converts into entity if not null
        if(locationDTO != null) {
            return LocationDataMapper.locationFactory(locationDTO, locationId);
        }
        else {
            return null;
        }
    }

    /**
     * Retrieves mapping of coordinates to location IDs using the data source adapter dependency.
     * The key will be a list of size 2 with the first element being longitude and the second being latitude.
     * @return a mapping of coordinates to location IDs
     */
    @Override
    public Map<List<Long>, Integer> getCoordinatesMap() {
        return this.locationDAO.getCoordinatesMap();
    }
}
