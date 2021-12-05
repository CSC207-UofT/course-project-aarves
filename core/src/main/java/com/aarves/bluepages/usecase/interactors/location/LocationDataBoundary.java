package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;

public interface LocationDataBoundary {
    Location getLocation(int locationId);
}
