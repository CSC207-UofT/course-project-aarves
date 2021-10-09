import java.util.List;

public class FoodLocation extends Location{
    private String foodtype;
    private boolean takeout;
    private boolean dinein;
    private int pricerange;

    public FoodLocation(List<Review> reviews, String hours_of_service, String area,
                        String food, boolean takeout, boolean dinein, int pricerange) {
        super(reviews, hours_of_service, area);
        this.foodtype = food;
        this.takeout = takeout;
        this.dinein = dinein;
        this.pricerange = pricerange;
    }

    public boolean isDinein() {
        return dinein;
    }

    public boolean isTakeout() {
        return takeout;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public int getPricerange() {
        return pricerange;
    }

    @Override
    public String toString() {
        return (super.getName()+"\n Address: "+super.getArea()+"\n Hours of Service: "+super.getHours_of_service()
                +"\n Rating: " +super.get_avgrating()+"\n"+getFoodtype()+"\n dine-in: "+isDinein()+"\n takeout: "+isTakeout()
                +"\n"+getPricerange());
    }
}
