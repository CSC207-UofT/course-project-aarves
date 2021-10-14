public class StudyMap extends Map {

    /**
     * Return a StudyLocation given by point.
     * @param point Point object representing the coordinates of the StudyLocation.
     * @return      StudyLocation at the given Point.
     */
    public StudyLocation getLocation(Point point) {
        return (StudyLocation) super.getLocation(point);
    }

    /**
     * TODO: Documentation (unsure why we return something for adding a location)
     * @param point
     * @param location
     * @return
     */
    public StudyLocation addLocation(Point point, StudyLocation location) {
        return (StudyLocation) super.addLocation(point, location);
    }

    /**
     * TODO: Documentation (unsure why we return something for deleting a location)
     * @param point
     * @return
     */
    public StudyLocation deleteLocation(Point point) {
        return (StudyLocation) super.deleteLocation(point);
    }
}
