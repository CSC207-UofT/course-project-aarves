import java.util.Objects;

public class Point {
    private float longitude;
    private float latitude;

    /**
     * Construct a new default Point with a latitude and longitude of 0.
     */
    public Point() {
        this.longitude = 0;
        this.latitude = 0;
    }

    /**
     * Construct a Point, representative of real-world coordinates, with a given latitude and longitude.
     * @param longitude Float representing the longitude of Point.
     * @param latitude  Float representing the latitude of Point.
     */
    public Point(float longitude, float latitude) {
        setLongitude(longitude);
        setLatitude(latitude);
    }

    /**
     * Return the longitude associated with this Point.
     * @return  Float representing the longitude.
     */
    public float getLongitude() {
        return this.longitude;
    }

    /**
     * Set the longitude for this Point.
     * @param longitude Float representing the new longitude of the Point.
     * @return  Boolean for if the given longitude is valid.
     */
    public boolean setLongitude(float longitude) {
        if(-180 <= longitude && longitude <= 180) {
            this.longitude = longitude;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Return the latitude associated with this Point.
     * @return  Float representing the latitude.
     */
    public float getLatitude() {
        return this.latitude;
    }

    /**
     * Set the latitude for this Point.
     * @param latitude  Float representing the new latitude of the Point.
     * @return  Boolean for if the given latitude is valid.
     */
    public boolean setLatitude(float latitude) {
        if(-90 <= latitude && latitude <= 90) {
            this.latitude = latitude;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Point) {
            Point p = (Point) other;
            return this.longitude == p.getLongitude() && this.latitude == p.getLatitude();
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.longitude, this.latitude);
    }
}
