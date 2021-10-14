import java.util.HashMap;

public abstract class Map {
    private HashMap<Point, Location> locationHashMap = new HashMap<>();

    protected Location getLocation(Point point) {
        return locationHashMap.get(point);
    }

    protected Location addLocation(Point point, Location location) {
        return locationHashMap.put(point, location);
    }

    protected Location deleteLocation(Point point) {
        return locationHashMap.remove(point);
    }
}
