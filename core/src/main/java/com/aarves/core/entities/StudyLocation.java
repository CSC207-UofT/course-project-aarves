package com.aarves.core.entities;

/**
 * Child class of Location
 *
 */
public class StudyLocation extends Location {
    final private boolean indoors;
    final private boolean quiet;

    /**
     * Constructs a new StudyLocation Object
     * @param hours_of_service hours of service
     * @param name name of location
     * @param area address
     * @param indoors if location is indoors
     * @param quiet if location is quiet
     */
    public StudyLocation(String hours_of_service, String name, String area, boolean indoors,
                         boolean quiet) {
        super(hours_of_service, name, area);
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
        return (super.getName()+"\n Address: "+super.getArea()+"\n Hours of Service: "+super.getHours_of_service()+
                "\n Rating: " + super.getRating() + "\n Indoors:"+isIndoors()+"\n Quiet: "+isQuiet());
    }
}
