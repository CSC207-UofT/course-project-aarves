package com.aarves.bluepages.usecase.interactors.review;

/**
 * An interface for inputting review related information for a given location to use cases.
 */
public interface ReviewLocationInputBoundary {
    float getLocationRating(int locationId);
}
