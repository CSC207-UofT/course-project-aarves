package com.aarves.bluepages.usecase.data.location;

import java.util.List;
import java.util.Map;

/**
 * Interface for location data access object adapters.
 */
public interface LocationDAO {
    /**
     * Adds a new location to the data source.
     * @param locationDTO the location data to be added
     * @return the ID of the added location
     */
    int addLocation(LocationDTO locationDTO);

    /**
     * Deletes location from data source.
     * @param locationId the ID of the location to be deleted
     */
    void deleteLocation(int locationId);

    /**
     * Updates the account with given username's bookmark list.
     * @param username the username of the account to be updated
     * @param bookmarkIds the new list of bookmarked location IDs
     */
    void updateBookmarks(String username, List<Integer> bookmarkIds);

    /**
     * Retrieves the data of the location with given ID.
     * @param locationId the ID of the location to be retrieved
     * @return the data of the location with given ID, or null if location does not exist
     */
    LocationDTO getLocationData(int locationId);

    /**
     * Retrieves all the bookmarked locations for account with given username.
     * @param username the username of the account with bookmarks to be retrieved
     * @return a mapping of location IDs to location data of bookmarked locations
     */
    Map<Integer, LocationDTO> getBookmarksData(String username);

    /**
     * Retrieves a mapping between the coordinates of each location and their IDs.
     * The key will be a list of size 2 with the first element being longitude and the second being latitude.
     * @return a mapping between the coordinates as a list of longs and their IDs
     */
    Map<List<Long>, Integer> getCoordinatesMap();
}
