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

    public Location getLocationByName(String name) {
        for (Point key: locationHashMap.keySet()) {
            if (name.equalsIgnoreCase(locationHashMap.get(key).getName())) {
                return locationHashMap.get(key);
            }
        }
        return null;
    }

    /**
     *
     * @return string representation of StudyMap
     */
    public String toString() {
        if (locationHashMap == null) {
            return "There are currently no locations in this FoodMap.";
        }
        StringBuilder locations = new StringBuilder();
        for (Point key: locationHashMap.keySet()) {
            locations.append(locationHashMap.get(key)).append("\n");
        }
        return locations.toString();
    }
}
