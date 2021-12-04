package com.aarves.bluepages.entities;

/**
 * Child class of Location
 *
 */
public class FoodLocation extends Location {
    private final String foodType;
    private final boolean takeout;
    private final boolean dineIn;
    private final String priceRange;

    /**
     * Constructs a new FoodLocation Object
     *
     * @param hours_of_service hours of service
     * @param name name of location
     * @param address address of location
     * @param food type of food
     * @param takeout if location has takeout
     * @param dineIn if location has dine-in
     * @param priceRange the price range of the location ($, $$, $$$)
     */
    public FoodLocation(String hours_of_service, String name, String address, double[] coordinates, String food,
                        boolean takeout, boolean dineIn, String priceRange) {
        super(hours_of_service, name, address, coordinates);
        this.foodType = food;
        this.takeout = takeout;
        this.dineIn = dineIn;
        this.priceRange = priceRange;
    }

    /**
     *
     * @return  a boolean value regarding if the location has dine-in as an option
     */
    public boolean isDineIn() {
        return dineIn;
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
    public String getFoodType() {
        return foodType;
    }

    /**
     *
     * @return a String value of the Price range of the location object
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     *
     * @return String representation of FoodLocation
     */
    @Override
    public String toString() {
        return (super.getName() + "\n Address: " + super.getAddress() + "\n Hours of Service: "
                + super.getHoursOfService() + "\n Food Type: " + getFoodType() + "\n dine-in: " + isDineIn()
                + "\n takeout: " + isTakeout() + "\n Price Range: " + getPriceRange());
    }
}
