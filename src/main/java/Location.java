import java.util.List;

public abstract class Location {
    private String name;
    private String hours_of_service;
    private List<Review> reviews;
    private String area;
    //area grabbed from maps

    public Location(List<Review> reviews, String hours_of_service, String area){
        this.reviews = reviews;
        this.hours_of_service = hours_of_service;
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours_of_service() {
        return hours_of_service;
    }

    public int get_avgrating(){
     double avg = 0;
     int len = reviews.size();
     for(Review r : reviews){
         avg += r.getRating();
     }
     return (int) (avg/len);
    }

    public String getArea(){
        return area;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return (getName()+"\n Address: "+getArea()+"\n Hours of Service: "+getHours_of_service()+"\n Rating: "
                +get_avgrating());
    }

}
