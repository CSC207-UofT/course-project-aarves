import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudyLocation extends Location{
    private boolean indoors;
    private boolean quiet;
    public StudyLocation(ArrayList<Review> reviews, String hours_of_service, String area, boolean indoors,
                         boolean quiet) {
        super(reviews, hours_of_service, area);
        this.indoors = indoors;
        this.quiet = quiet;
    }

    public boolean isIndoors() {
        return indoors;
    }

    public boolean isQuiet() {
        return quiet;
    }

    @Override
    public String toString() {
        return (super.getName()+"\n Address: "+super.getArea()+"\n Hours of Service: "+super.getHours_of_service()+
                "\n Rating: " +super.get_avgrating() + "\n Indoors:"+isIndoors()+"\n Quiet: "+isQuiet());
    }
}
