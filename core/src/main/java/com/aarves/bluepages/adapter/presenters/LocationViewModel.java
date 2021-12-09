package com.aarves.bluepages.adapter.presenters;

public class LocationViewModel {
    private final int locationId;
    private final String locationName;
    private final String locationType;
    private final int rating;

    private boolean bookmarked;

    /**
     * Creates a LocationViewModel object.
     * @param locationId the location ID of the location
     * @param locationName the location's name
     * @param locationType the type of the location (food/study)
     * @param rating the rating of the location
     * @param bookmarked whether the location is bookmarked or not
     */
    public LocationViewModel(int locationId, String locationName, String locationType, int rating, boolean bookmarked) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationType = locationType;
        this.rating = rating;

        this.bookmarked = bookmarked;
    }

    /**
     * Gets the location ID associated with the location
     * @return the location ID for the location
     */
    public int getLocationId() {
        return this.locationId;
    }

    /**
     * Gets the name of the location
     * @return the name of the location
     */
    public String getLocationName() {
        return this.locationName;
    }

    /**
     * Gets the location type (food/study) of the location
     * @return whether the location is a food or study location
     */
    public String getLocationType() {
        return this.locationType;
    }

    /**
     * Gets the current rating of the location
     * @return the rating of the location
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Returns whether the location is currently bookmarked by the user.
     * @return true if the location is currently bookmarked by the user, false otherwise.
     */
    public boolean isBookmarked() {
        return this.bookmarked;
    }

    /**
     * Toggles the bookmark status of the location to reflect whether the location is bookmarked/not bookmarked.
     */
    public void toggleBookmarked() {
        this.bookmarked = !this.bookmarked;
    }
}
