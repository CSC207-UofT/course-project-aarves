package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationMap {
    private final Map<Integer, Location> locationHashMap = new HashMap<>();

    /**
     * Return a Location from LocationMap, based off the given coordinates.
     * @param point coordinates containing the coordinates of Location.
     * @return  Location specified for by coordinates.
     */
    public Location getLocation(Integer point) {
        return locationHashMap.get(point);
    }

    public List<Location> getLocations() {
        return new ArrayList<>(this.locationHashMap.values());
    }

    /**
     * Return a Location from LocationMap, based off the given name. Returns null if the location is not found.
     * @param name String name of the Location to be searched for.
     * @return  Location specified for by name.
     */
    public Location getLocationByName(String name) {
        for (Location location: locationHashMap.values()) {
            if (name.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }

    /**
     * Add a new Location to LocationMap, associated with a coordinate given by coordinates.
     * @param point coordinates containing the coordinates of Location.
     * @param location  Location-to-be-added to LocationMap.
     * @return  Location that was added to LocationMap.
     */
    public Location addLocation(Integer point, Location location) {
        return locationHashMap.put(point, location);
    }

    /**
     * Removes a Location from LocationMap.
     * @param point coordinates of the Location to-be-removed.
     * @return  Location that was removed from LocationMap.
     */
    public Location deleteLocation(Integer point) {
        return locationHashMap.remove(point);
    }

    public int getLocationCount() {
        return this.locationHashMap.size();
    }

    /**
     * Returns a string representation of this LocationMap object.
     * @return String representation of LocationMap.
     */
    public String toString() {
        if (locationHashMap.isEmpty()) {
            return "There are currently no locations in this Map.";
        }
        StringBuilder locations = new StringBuilder();
        for (Integer key: locationHashMap.keySet()) {
            locations.append(locationHashMap.get(key)).append("\n");
        }
        return locations.toString();
    }
}
