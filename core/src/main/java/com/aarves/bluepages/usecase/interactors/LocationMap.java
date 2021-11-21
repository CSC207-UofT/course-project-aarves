package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.Location;

import java.util.HashMap;

public class LocationMap {
    public HashMap<Integer, Location> locationHashMap = new HashMap<>();

    /**
     * Return a Location from LocationMap, based off the given Point (which contains coordinates).
     * @param point Point object containing the coordinates of Location.
     * @return  Location specified for by Point.
     */
    protected Location getLocation(Integer point) {
        return locationHashMap.get(point);
    }

    /**
     * Add a new Location to LocationMap, associated with a coordinate given by Point.
     * @param point Point object containing the coordinates of Location.
     * @param location  Location-to-be-added to LocationMap.
     * @return  Location that was added to LocationMap.
     */
    protected Location addLocation(Integer point, Location location) {
        return locationHashMap.put(point, location);
    }

    /**
     * Removes a Location from LocationMap.
     * @param point Point of the Location to-be-removed.
     * @return  Location that was removed from LocationMap.
     */
    protected Location deleteLocation(Integer point) {
        return locationHashMap.remove(point);
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
     * Returns a string representation of this LocationMap object.
     * @return String representation of LocationMap.
     */
    public String toString() {
        if (locationHashMap == null) {
            return "There are currently no locations in this Map.";
        }
        StringBuilder locations = new StringBuilder();
        for (Integer key: locationHashMap.keySet()) {
            locations.append(locationHashMap.get(key)).append("\n");
        }
        return locations.toString();
    }
}
