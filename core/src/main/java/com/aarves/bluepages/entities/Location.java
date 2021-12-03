package com.aarves.bluepages.entities;

/**
 * Parent class for FoodLocation and StudyLocation
 *
 */
public abstract class Location {
    protected final String name;
    protected final String hoursOfService;
    protected final String address;
    protected final double[] coordinates;

    /**
     * Constructs a new Location object
     * @param hoursOfService hours of service of location
     * @param name name of location
     * @param address address of location
     */
    public Location(String hoursOfService, String name, String address, double[] coordinates) {
        this.hoursOfService = hoursOfService;
        this.address = address;
        this.name = name;
        this.coordinates = coordinates;
    }

    /**
     *
     * @return a String object of the Hours of Service of the Location Object
     */
    public String getHoursOfService() {
        return hoursOfService;
    }

    /**
     *
     * @return a String object of the area of the Location object(address)
     */
    public String getAddress(){
        return address;
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
     * @return a double array of the coordinates of the Location
     */
    public double[] getCoordinates(){
        return coordinates;
    }
}
