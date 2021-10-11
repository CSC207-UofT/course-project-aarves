import java.util.ArrayList;
import java.util.List;

public abstract class Location {
    private String name;
    private String hours_of_service;
    private ArrayList<Review> reviews;
    private String area;
    //area grabbed from maps

    public Location(ArrayList<Review> reviews, String hours_of_service, String area){
        this.reviews = reviews;
        this.hours_of_service = hours_of_service;
        this.area = area;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void deleteReview(Review review) {
        this.reviews.remove(review);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours_of_service() {
        return hours_of_service;
    }

    public int get_avgrating(){
     double avg = 0;
     int len = this.reviews.size();
     for(Review r : this.reviews){
         avg += r.getRating();
     }
     if (this.reviews.size() == 0) {
         return -1;
     }
     else {
         return (int) (avg/len);
     }
    }

    public String getArea(){
        return area;
    }

    public String getName(){
        return name;
    }

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
