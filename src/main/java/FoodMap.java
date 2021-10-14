public class FoodMap extends Map {
    public FoodLocation getLocation(Point point) {
        return (FoodLocation) super.getLocation(point);
    }

    public FoodLocation addLocation(Point point, FoodLocation location) {
        return (FoodLocation) super.addLocation(point, location);
    }

    public FoodLocation deleteLocation(Point point) {
        return (FoodLocation) super.deleteLocation(point);
    }
}
