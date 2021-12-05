package com.aarves.bluepages.usecase.data;

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
