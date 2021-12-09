package com.aarves.bluepages.usecase.data.location;
import com.aarves.bluepages.entities.Location;

import com.aarves.bluepages.entities.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationDataAccessTest {

    LocationDAOMockup locationDAOMockup;
    LocationDataAccess locationDataAccess;

    @BeforeEach
    void setUp() {
        locationDAOMockup = new LocationDAOMockup();
        locationDataAccess = new LocationDataAccess(locationDAOMockup);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addBookmark() {
        List<Location> bookmarks = new ArrayList<>();
        double[] coordinate = {13.4, 346.3};
        Location l1 = new StudyLocation("Gerstein", coordinate);
        bookmarks.add(l1);
        locationDataAccess.addBookmark("username", 13, bookmarks);
        assertEquals(0, locationDAOMockup.getBookmarksData("username").size());
    }

    @Test
    void getUserBookmarks() {
        assertEquals(0, locationDataAccess.getUserBookmarks("Natsyy").size());
    }

    @Test
    void addLocation() {
        double[] coordinate = {13.4, 346.3};
        Location l1 = new StudyLocation("Gerstein", coordinate);
        Location result = locationDataAccess.addLocation(l1);
        assertEquals(l1.getLocationId(), result.getLocationId());
    }


}