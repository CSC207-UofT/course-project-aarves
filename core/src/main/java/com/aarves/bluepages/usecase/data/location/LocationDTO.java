package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.usecase.interactors.location.LocationType;

/**
 * Data transfer object for locations data.
 */
public class LocationDTO {
    private final String name;
    private final double[] coordinates;
    private final LocationType type;

    /**
     * Constructs new location data transfer object with given name, coordinates, and type.
     * @param name the name of the location
     * @param coordinates the coordinates of the location
     * @param type the type of location
     */
    public LocationDTO(String name, double[] coordinates, LocationType type) {
        this.name = name;
        this.coordinates = coordinates;
        this.type = type;
    }

    /**
     * Returns the name of the location
     * @return the name of the location
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the coordinates of the location, with first element being longitude and second being latitude
     * @return the coordinates of the location
     */
    public double[] getCoordinates() {
        return this.coordinates;
    }

    /**
     * Returns the type of location
     * @return the type of location
     */
    public LocationType getType() {
        return this.type;
    }
}
