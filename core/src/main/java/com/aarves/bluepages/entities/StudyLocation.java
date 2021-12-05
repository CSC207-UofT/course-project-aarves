package com.aarves.bluepages.entities;

/**
 * Child class of Location
 *
 */
public class StudyLocation extends Location {
    private boolean indoors;
    private boolean quiet;

    /**
     * Constructs a new Location object
     *
     * @param name        name of location
     * @param coordinates GPS coordinates of location
     */
    public StudyLocation(String name, double[] coordinates) {
        super(name, coordinates);
    }

    /**
     *
     * @return a boolean value of whether the StudyLocation is indoors
     */
    public boolean isIndoors() {
        return indoors;
    }

    /**
     *
     * @return a boolean value of whether the StudyLocation is quiet
     */
    public boolean isQuiet() {
        return quiet;
    }

}
