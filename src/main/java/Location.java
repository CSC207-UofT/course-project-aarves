import java.util.List;

public abstract class Location {
    private String hours_of_service;
    private List<Review> reviews;
    private String area;

    public Location(List<Review> reviews, String hours_of_service){

    }

    public String getHours_of_service() {
        return hours_of_service;
    }

    public int get_avgrating(){
     return 0;
    }

}
