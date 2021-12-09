package com.aarves.bluepages.usecase.interactors.location;

import java.util.List;

/**
 * Interface for inputting location related information to use cases.
 */
public interface LocationInputBoundary {
    void loadLocations(List<Float> ratings, List<Boolean> bookmarked);
    List<Integer> getLocationIds();
}
