package com.aarves.bluepages.entities;

/**
 * Child class of Location
 *
 */
public class StudyLocation extends Location {
    private final boolean indoors;
    private final boolean quiet;

    /**
     * Constructs a new StudyLocation Object
     * @param hours_of_service hours of service
     * @param name name of location
     * @param address address
     * @param indoors if location is indoors
     * @param quiet if location is quiet
     */
    public StudyLocation(String hours_of_service, String name, String address, double[] coordinates, boolean indoors, boolean quiet) {
        super(hours_of_service, name, address, coordinates);
        this.indoors = indoors;
        this.quiet = quiet;
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

    /**
     *
     * @return String representation of StudyLocation
     */
    @Override
    public String toString() {
        return (super.getName() + "\n Address: " + super.getAddress() + "\n Hours of Service: "
                + super.getHoursOfService() + "\n Indoors: " + isIndoors() + "\n Quiet: " + isQuiet());
    }
}
