import java.util.ArrayList;
import java.util.List;
/**
 * Parent class for FoodLocation and StudyLocation
 *
 */
public abstract class Location {
    private String name;
    private String hours_of_service;
    private ArrayList<Review> reviews = new ArrayList<>();
    private String area;
    //area grabbed from maps

    /**
     * Constructs a new Location object
     * @param hours_of_service
     * @param area
     */
    public Location(String hours_of_service, String name, String area){
        this.hours_of_service = hours_of_service;
        this.area = area;
        this.name = name;
    }

    /**
     * Adds the given Review object into Reviews
     * @param review
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Deletes the given Review Object from Reviews
     * @param review
     */
    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    /**
     * Sets the Name of the Location Object
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return a String object of the Hours of Service of the Location Object
     */
    public String getHours_of_service() {
        return hours_of_service;
    }

    /**
     * Given the ArrayList of reviews, return the average of all the ratings associated with
     * the Location Object
     * @return int object of the
     * average of the ratings given from each Review from the ArrayList reviews
     */
    public int get_avgrating(){
     double avg = 0;

    if (this.reviews == null) {
        return -1;
    }

     int len = this.reviews.size();
     for(Review r : this.reviews){
         avg += r.getRating();
     }
     return (int) (avg/len);
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
        int avg_rating = this.get_avgrating();
        if (avg_rating == -1) {
            return (getName() + "\n Address: " + getArea() + "\n Hours of Service: " + getHours_of_service() + "\n Rating: "
                    + "This location does not have any ratings yet.");
        }
        else {
            return (getName() + "\n Address: " + getArea() + "\n Hours of Service: " + getHours_of_service() + "\n Rating: "
                    + avg_rating);
        }
    }

}
