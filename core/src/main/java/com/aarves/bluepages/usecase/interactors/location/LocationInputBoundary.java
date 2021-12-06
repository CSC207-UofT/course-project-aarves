package com.aarves.bluepages.usecase.interactors.location;

import java.util.List;

public interface LocationInputBoundary {
    void loadLocations(List<Float> ratings);
    List<Integer> getLocationIds();
}
