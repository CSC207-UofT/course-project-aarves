package com.aarves.bluepages.entities;

public abstract class Location {
    private static final int DEFAULT_ID = 0;

    private final int locationId;
    protected final String name;
    protected final double[] coordinates;

    /**
     * Constructs a new Location object
     *
     * @param locationId    ID of Location
     * @param name          name of Location
     * @param coordinates   GPS coordinates of Location
     */
    public Location(int locationId, String name, double[] coordinates) {
        this.name = name;
        this.coordinates = coordinates;

        this.locationId = locationId;
    }

    /**
     * Constructs a new Location object. Using DEFAULT_ID indicates that Location is not in database.
     *
     * @param name          name of Location
     * @param coordinates   GPS coordinates of Location
     */
    public Location(String name, double[] coordinates) {
        this.name = name;
        this.coordinates = coordinates;

        this.locationId = Location.DEFAULT_ID;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Location) {
            return this.locationId == ((Location) other).getLocationId();
        }
        else {
            return false;
        }
    }

    /**
     * Return the ID associated with this Location.
     * @return  Integer representing the ID of the Location.
     */
    public int getLocationId() {
        return this.locationId;
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
