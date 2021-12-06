package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.usecase.interactors.location.LocationType;

public class LocationDTO {
    private final String name;
    private final double[] coordinates;
    private final LocationType type;

    public LocationDTO(String name, double[] coordinates, LocationType type) {
        this.name = name;
        this.coordinates = coordinates;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    public LocationType getType() {
        return this.type;
    }
}
