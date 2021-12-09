package com.aarves.bluepages.usecase.interactors.review;

/**
 * An interface for inputting review related information for a given location to use cases.
 */
public interface ReviewLocationInputBoundary {
    /**
     * Gets the rating of the location
     * @param locationId the ID of the location
     * @return the rating corresponding to the location with location ID provided.
     */
    float getLocationRating(int locationId);
}
