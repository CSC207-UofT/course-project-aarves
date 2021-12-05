package com.aarves.bluepages.entities;

public abstract class Location {
    protected final String name;
    protected final double[] coordinates;

    /**
     * Constructs a new Location object
     * @param name name of location
     * @param coordinates GPS coordinates of location
     */
    public Location(String name, double[] coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    /**
     *
     * @return a String object of the name of the Location
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return an array of doubles representing the coordinates of the Location object
     */
    public double[] getCoordinates(){
        return this.coordinates;
    }
}
