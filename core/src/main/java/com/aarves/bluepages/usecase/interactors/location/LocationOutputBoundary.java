package com.aarves.bluepages.usecase.interactors.location;

import java.util.List;

/**
 * An interface for outputting location related information to UI.
 */
public interface LocationOutputBoundary {
    /**
     * Presents location information to user
     * @param locations the list of LocationOutputModels of locations
     * @param bookmarked whether each location is bookmarked/not bookmarked
     */
    void presentLocations(List<LocationOutputModel> locations, List<Boolean> bookmarked);
}
