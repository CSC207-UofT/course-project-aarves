package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

import java.util.List;
import java.util.Map;

/**
 * Interface which allows location use case interactors to access to location data.
 */
public interface LocationDataBoundary {
    /**
     * Adds given location entity to data source.
     * @param location the location entity to be added
     * @return the added location, along with its ID
     */
    Location addLocation(Location location);

    /**
     * Deletes given location given ID from data source.
     * @param locationId the ID of the location to be deleted
     */
    void deleteLocation(int locationId);

    /**
     * Retrieves location with given ID from data source.
     * @param locationId the ID of the location to be retrieved
     * @return the location entity with given ID, or null if location does not exist
     */
    Location getLocation(int locationId);

    /**
     * Retrieves mapping of coordinates to location IDs.
     * The key will be a list of size 2 with the first element being longitude and the second being latitude.
     * @return a mapping of coordinates to location IDs
     */
    Map<List<Long>, Integer> getCoordinatesMap();
}
