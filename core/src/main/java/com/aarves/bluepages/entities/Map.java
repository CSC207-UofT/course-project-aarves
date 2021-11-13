package com.aarves.bluepages.entities;

import java.util.HashMap;

public abstract class Map {
    public HashMap<Point, Location> locationHashMap = new HashMap<>();

    /**
     * Return a Location from Map, based off the given Point (which contains coordinates).
     * @param point Point object containing the coordinates of Location.
     * @return  Location specified for by Point.
     */
    protected Location getLocation(Point point) {
        return locationHashMap.get(point);
    }

    /**
     * Add a new Location to Map, associated with a coordinate given by Point.
     * @param point Point object containing the coordinates of Location.
     * @param location  Location-to-be-added to Map.
     * @return  Location that was added to Map.
     */
    protected Location addLocation(Point point, Location location) {
        return locationHashMap.put(point, location);
    }

    /**
     * Removes a Location from Map.
     * @param point Point of the Location to-be-removed.
     * @return  Location that was removed from Map.
     */
    protected Location deleteLocation(Point point) {
        return locationHashMap.remove(point);
    }

    /**
     * Return a Location from Map, based off the given name. Returns null if the location is not found.
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
     * Returns a string representation of this Map object.
     * @return String representation of Map.
     */
    public String toString() {
        if (locationHashMap == null) {
            return "There are currently no locations in this Map.";
        }
        StringBuilder locations = new StringBuilder();
        for (Point key: locationHashMap.keySet()) {
            locations.append(locationHashMap.get(key)).append("\n");
        }
        return locations.toString();
    }
}
