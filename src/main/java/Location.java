import java.util.ArrayList;

/**
 * Parent class for FoodLocation and StudyLocation
 *
 */
public abstract class Location {
    final String name;
    final String hours_of_service;
    final ArrayList<Review> reviews = new ArrayList<>();
    final String area;
    float rating = -1;
    //area grabbed from maps

    /**
     * Constructs a new Location object
     * @param hoursOfService hours of service of location
     * @param name name of location
     * @param area address of location
     */
    public Location(String hoursOfService, String name, String area){
        this.hours_of_service = hoursOfService;
        this.area = area;
        this.name = name;
    }

    /**
     * Adds the given Review object into Reviews
     * @param review review to be added
     */
    public void addReview(Review review) {
        reviews.add(review);
        int total = 0;
        for (Review r : this.reviews) {
            total += r.getRating();
        }
        this.rating = (float) total / this.reviews.size();
    }

    public float getRating() {
        return this.rating;
    }

    /**
     * Deletes the given Review Object from Reviews
     * @param review review to be deleted
     */
    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    /**
     *
     * @return a String object of the Hours of Service of the Location Object
     */
    public String getHours_of_service() {
        return hours_of_service;
    }

    /**
     *
     * @return a String object of the area of the Location object(address)
     */
    public String getArea(){
        return area;
    }

    /**
     *
     * @return a String object of the name of the Location
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return String representation of Location
     */
    public String toString(){
        if (this.rating == -1) {
            return (getName() + "\n Address: " + getArea() + "\n Hours of Service: " + getHours_of_service() + "\n Rating: "
                    + "This location does not have any ratings yet.");
        }
        else {
            return (getName() + "\n Address: " + getArea() + "\n Hours of Service: " + getHours_of_service() + "\n Rating: "
                    + rating);
        }
    }

}
