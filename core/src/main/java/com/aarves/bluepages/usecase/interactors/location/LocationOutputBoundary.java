package com.aarves.bluepages.usecase.interactors.location;

import java.util.List;

public interface LocationOutputBoundary {
    void presentLocations(List<LocationOutputModel> locations, List<Boolean> bookmarked);
}
