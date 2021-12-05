package com.aarves.bluepages.entities;

/**
 * Child class of Location
 *
 */
public class FoodLocation extends Location {
    private String foodType;
    private boolean takeout;
    private boolean dineIn;
    private String priceRange;

    /**
     * Constructs a new Location object
     *
     * @param name        name of location
     * @param coordinates GPS coordinates of location
     */
    public FoodLocation(String name, double[] coordinates) {
        super(name, coordinates);
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

}
