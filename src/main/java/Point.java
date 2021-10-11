import java.util.Objects;

public class Point {
    private float longitude;
    private float latitude;

    public Point() {
        this.longitude = 0;
        this.latitude = 0;
    }

    public Point(int longitude, int latitude) {
        setLongitude(longitude);
        setLatitude(latitude);
    }

    public float getLongitude() {
        return this.longitude;
    }

    public boolean setLongitude(float longitude) {
        if(-180 <= longitude && longitude <= 180) {
            this.longitude = longitude;
            return true;
        }
        else {
            return false;
        }
    }

    public float getLatitude() {
        return this.latitude;
    }

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
