package com.aarves.bluepages.usecase.interactors.location;

public class LocationOutputModel {
    private final int locationId;
    private final String locationName;
    private final LocationType locationType;
    private final float rating;

    /**
     * Creates a LocationOutputModel
     * @param locationId the ID of the location
     * @param locationName the name of the location
     * @param locationType the type of the location (food/study)
     * @param rating the rating of the location
     */
    public LocationOutputModel(int locationId, String locationName, LocationType locationType, float rating) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationType = locationType;
        this.rating = rating;
    }

    /**
     * Returns the ID of the location
     * @return the location's ID
     */
    public int getLocationId() {
        return this.locationId;
    }

    /**
     * Returns the name of the location
     * @return the location's name
     */
    public String getLocationName() {
        return this.locationName;
    }

    /**
     * Returns the type of the location (food/study)
     * @return the type (food/study) of the location
     */
    public LocationType getLocationType() {
        return this.locationType;
    }

    /**
     * Returns the rating of the location
     * @return the rating of the location.
     */
    public float getRating() {
        return this.rating;
    }
}
