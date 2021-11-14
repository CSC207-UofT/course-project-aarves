package com.aarves.bluepages.entities;

/**
 * Parent class for FoodLocation and StudyLocation
 *
 */
public abstract class Location {
    protected final String name;
    protected final String hoursOfService;
    protected final String address;

    /**
     * Constructs a new Location object
     * @param hoursOfService hours of service of location
     * @param name name of location
     * @param address address of location
     */
    public Location(String hoursOfService, String name, String address){
        this.hoursOfService = hoursOfService;
        this.address = address;
        this.name = name;
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
}
