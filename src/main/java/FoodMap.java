public class FoodMap extends Map {

    /**
     * Return a FoodLocation given by Point.
     *
     * @param point Point object containing the coordinates of Location.
     * @return reference to the FoodLocation added
     */
    public FoodLocation getLocation(Point point) {
        return (FoodLocation) super.getLocation(point);
    }

    /**
     * Add a FoodLocation to the FoodMap
     *
     * @param point Point object containing the coordinates of location.
     * @param location the location object of the location
     * @return reference to the FoodLocation added
     */
    public FoodLocation addLocation(Point point, FoodLocation location) {
        return (FoodLocation) super.addLocation(point, location);
    }

    /**
     * Delete a FoodLocation from the FoodMap
     *
     * @param point Point of the Location to-be-removed.
     * @return reference to the FoodLocation removed.
     */
    public FoodLocation deleteLocation(Point point) {
        return (FoodLocation) super.deleteLocation(point);
    }
}
