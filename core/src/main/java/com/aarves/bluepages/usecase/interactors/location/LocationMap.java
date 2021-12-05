package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LocationMap {
    private final LocationDataBoundary locationData;
    private final Map<List<Long>, Integer> coordinatesMap;

    public LocationMap(LocationDataBoundary locationData) {
        this.locationData = locationData;
        this.coordinatesMap = this.locationData.getCoordinatesMap();
    }

    /**
     * Return Location from LocationMap, based off the given coordinates.
     * @param coordinates   coordinates containing the coordinates of Location.
     * @return              Location specified for by coordinates.
     */
    public Location getLocation(Long[] coordinates) {
        int locationId = this.getLocationId(coordinates);
        return this.locationData.getLocation(locationId);
    }

    /**
     * Return location ID from LocationMap, based off the given coordinates.
     * @param coordinates   coordinates containing the coordinates of Location.
     * @return              Location ID specified for by coordinates.
     */
    public int getLocationId(Long[] coordinates) {
        this.checkCoordinates(coordinates);

        List<Long> coordinatesList = Arrays.asList(coordinates);
        return this.coordinatesMap.get(coordinatesList);
    }

    public List<Integer> getLocationIds() {
        return new ArrayList<>(this.coordinatesMap.values());
    }

    /**
     * Add a new Location to LocationMap, associated with a coordinate given by coordinates.
     * @param coordinates   coordinates containing the coordinates of Location.
     * @param location      Location-to-be-added to LocationMap.
     * @return              Location ID that was added to LocationMap.
     */
    public int addLocation(Long[] coordinates, Location location) {
        this.checkCoordinates(coordinates);

        int newLocationId = this.locationData.addLocation(location).getLocationId();
        Integer locationId = this.coordinatesMap.put(Arrays.asList(coordinates).subList(0, 2), newLocationId);
        if(locationId != null) {
            return locationId;
        }
        else {
            return -1;
        }
    }

    /**
     * Removes a Location from LocationMap.
     * @param coordinates   coordinates of the Location to-be-removed.
     * @return              Location ID that was removed from LocationMap.
     */
    public int deleteLocationByCoordinates(Long[] coordinates) {
        this.checkCoordinates(coordinates);

        Integer locationId = this.coordinatesMap.remove(Arrays.asList(coordinates).subList(0, 2));
        if(locationId != null) {
            this.locationData.deleteLocation(locationId);
            return locationId;
        }
        else {
            return -1;
        }
    }

    private void checkCoordinates(Long[] coordinates) {
        if(coordinates.length < 2) {
            throw new IllegalArgumentException("Length of argument 'coordinates' cannot be shorter than 2");
        }
    }
}
