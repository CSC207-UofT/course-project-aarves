public class StudyMap extends Map {
    public StudyLocation getLocation(Point point) {
        return (StudyLocation) super.getLocation(point);
    }

    public StudyLocation addLocation(Point point, StudyLocation location) {
        return (StudyLocation) super.addLocation(point, location);
    }

    public StudyLocation deleteLocation(Point point) {
        return (StudyLocation) super.deleteLocation(point);
    }
}
