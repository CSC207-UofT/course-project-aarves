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
     * @param point coordinates of the StudyLocation
     * @param location the location
     * @return reference to the StudyLocation
     */
    public StudyLocation addLocation(Point point, StudyLocation location) {
        return (StudyLocation) super.addLocation(point, location);
    }

    /**
     * @param point coordinates of the StudyLocation
     * @return reference to the StudyLocation
     */
    public StudyLocation deleteLocation(Point point) {
        return (StudyLocation) super.deleteLocation(point);
    }
}
