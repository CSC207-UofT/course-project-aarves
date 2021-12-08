package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationMapTest {

    LocationMap locationMap;
    LocationOutputBoundaryMockup locationOutputBoundary;
    LocationDataBoundaryMockup locationDataBoundary;

    @BeforeEach
    void setUp() {

        // setting up a list of locations for LocationDataBoundary
        List<Location> locationList = new ArrayList<>();
        double[] coordinates = {4.5, 3.4};
        Location location = new StudyLocation(5, "Freshii", coordinates);
        double[] coordinates2 = {3.5, 3.4};
        Location location2 = new StudyLocation(2, "Tims", coordinates2);
        locationList.add(location);
        locationList.add(location2);

        locationOutputBoundary = new LocationOutputBoundaryMockup();
        locationDataBoundary = new LocationDataBoundaryMockup(locationList);
        locationMap = new LocationMap(locationDataBoundary, locationOutputBoundary);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadLocations() {

    }

    @Test
    void getLocationIds() {
        List<Float> ratings = new ArrayList<>();
        ratings.add(4.6f);
        ratings.add(3.2f);
        ratings.add(5.0f);

        List<Boolean> bookmarkedList = new ArrayList<>();
        bookmarkedList.add(true);
        bookmarkedList.add(false);
        bookmarkedList.add(true);

        locationMap.loadLocations(ratings, bookmarkedList);
        Assertions.assertTrue(this.locationOutputBoundary.isLocationsPresented());
    }

    @Test
    void getLocation() {
    }

    @Test
    void getLocationId() {
    }

    @Test
    void addLocation() {
        double[] coordinates = {4.5, 3.4};
        Location location = new StudyLocation(5, "Freshii", coordinates);
        Long[] coordinate = {490000L, 4652421L};
        locationMap.addLocation(coordinate, location);

    }

    @Test
    void deleteLocationByCoordinates() {
    }
}