import java.util.List;

public abstract class Location {
    private String hours_of_service;
    private List<Review> reviews;
    private String area;
    //area grabbed from maps

    public Location(List<Review> reviews, String hours_of_service){
        this.reviews = reviews;
        this.hours_of_service = hours_of_service;
    }

    public String getHours_of_service() {
        return hours_of_service;
    }

    public int get_avgrating(){
     return 0;
    }

}
