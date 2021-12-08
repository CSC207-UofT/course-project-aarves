package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;
import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LocationControllerTest {

    LocationController locationController;
    LocationInputBoundaryMockup locationInput;
    BookmarkInputBoundaryMockup bookmarkInput;
    ReviewInputMockup reviewInput;

    @BeforeEach
    void setUp() {

        // setup List<Location> for locationInput
        double[] coordinates = {45.3, 78.4};
        Location location = new StudyLocation(12, "Gerstein", coordinates);
        double[] coordinates2 = {45.3, 78.4};
        Location location2 = new StudyLocation(89, "EJ Pratt", coordinates2);
        List<Location> locationList = new ArrayList<>();
        locationList.add(location);
        locationList.add(location2);

        // setup List<Location> for bookmarkInput
        double[] coordinates3 = {45.3, 78.4};
        Location location3 = new StudyLocation(12, "Gerstein", coordinates3);
        double[] coordinates4 = {45.3, 78.4};
        Location location4 = new StudyLocation(89, "EJ Pratt", coordinates4);
        List<Location> bookmarkLocationList = new ArrayList<>();
        bookmarkLocationList.add(location3);
        bookmarkLocationList.add(location4);

        // construct new LocationController
        locationInput = new LocationInputBoundaryMockup(locationList);
        bookmarkInput = new BookmarkInputBoundaryMockup(bookmarkLocationList, "username");
        reviewInput = new ReviewInputMockup("user");
        locationController = new LocationController(bookmarkInput, locationInput, reviewInput);
    }

    @AfterEach
    void tearDown() {
    }

    //TODO: fix null concurrentModificationException
    @Test
    void testToggleBookmark() throws NotLoggedInException {
        this.bookmarkInput.addBookmark(78);
        int originalLength = this.bookmarkInput.getBookmarks().size();
        this.locationController.toggleBookmark(78);
        assertEquals(originalLength - 1, bookmarkInput.getBookmarks().size());
    }

    @Test
    void testLoadAllLocations() {

        this.locationController.loadAllLocations();
        assertTrue(this.locationInput.isLocationsLoaded());
    }

    @Test
    void testLoadBookmarkLocations() throws NotLoggedInException {
        this.bookmarkInput.addBookmark(14);
        this.bookmarkInput.addBookmark(90);
        this.bookmarkInput.addBookmark(23);
        this.locationController.loadBookmarkLocations();
        assertTrue(this.bookmarkInput.isLocationsDisplayed());
    }

    @Test
    void testRefreshBookmarks() {
        this.locationController.refreshBookmarks();
        assertTrue(this.bookmarkInput.isLocationRefreshed());
    }
}