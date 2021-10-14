import java.util.ArrayList;
import java.util.List;

/**
 * Child class of Location
 *
 */
public class FoodLocation extends Location{
    private String foodtype;
    private boolean takeout;
    private boolean dinein;
    private String pricerange;


    /**
     * Constructs a new FoodLocation Object
     * @param hours_of_service
     * @param area
     * @param food
     * @param takeout
     * @param dinein
     * @param pricerange
     */
    public FoodLocation(String hours_of_service, String area, String food,
                        boolean takeout, boolean dinein, String pricerange) {
        super(hours_of_service, area);
        this.foodtype = food;
        this.takeout = takeout;
        this.dinein = dinein;
        this.pricerange = pricerange;
    }

    /**
     *
     * @return  a boolean value regarding if the location has dine-in as an option
     */
    public boolean isDinein() {
        return dinein;
    }

    /**
     *
     * @return  a boolean value regarding if the location has takeout as an option
     */
    public boolean isTakeout() {
        return takeout;
    }

    /**
     *
     * @return a String value of the type of food served at the location
     */
    public String getFoodtype() {
        return foodtype;
    }

    /**
     *
     * @return a String value of the Price range of the location object
     */
    public String getPricerange() {
        return pricerange;
    }

    /**
     *
     * @return String representation of FoodLocation
     */
    @Override
    public String toString() {
        return (super.getName()+"\n Address: "+super.getArea()+"\n Hours of Service: "+super.getHours_of_service()
                +"\n Rating: " +super.get_avgrating()+"\n"+getFoodtype()+"\n dine-in: "+isDinein()+"\n takeout: "+isTakeout()
                +"\n"+getPricerange());
    }
}
