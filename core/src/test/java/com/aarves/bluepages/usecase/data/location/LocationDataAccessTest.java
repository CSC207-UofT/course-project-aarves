package com.aarves.bluepages.usecase.data.location;
import com.aarves.bluepages.entities.Location;

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

    }

    @Test
    void removeBookmark() {
    }

    @Test
    void updateBookmarks() {
    }

    @Test
    void getUserBookmarks() {
        assertEquals(0, locationDataAccess.getUserBookmarks("Natsyy").size());
    }

    @Test
    void addLocation() {

    }

    @Test
    void deleteLocation() {
    }

    @Test
    void getLocation() {
    }

    @Test
    void getCoordinatesMap() {
    }
}