package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO: fix null pointer exception for most test cases

class LocationControllerTest {

    LocationController locationController;
    LocationInputBoundaryMockup locationInput;
    BookmarkInputBoundaryMockup bookmarkInput;
    ReviewInputMockup reviewInput;

    @BeforeEach
    void setUp() {
        locationInput = new LocationInputBoundaryMockup();
        bookmarkInput = new BookmarkInputBoundaryMockup();
        reviewInput = new ReviewInputMockup("user");
        locationController = new LocationController(bookmarkInput, locationInput, reviewInput);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void toggleBookmark() throws NotLoggedInException {
        this.bookmarkInput.addBookmark(78);
        int originalLength = this.bookmarkInput.getBookmarks().size();
        this.locationController.toggleBookmark(78);
        assertEquals(originalLength - 1, bookmarkInput.getBookmarks().size());
    }

    @Test
    void loadAllLocations() {
        this.locationController.loadAllLocations();
        assertTrue(this.locationInput.isLocationsLoaded());
    }

    @Test
    void loadBookmarkLocations() {
        this.locationController.loadBookmarkLocations();
        assertTrue(this.bookmarkInput.isLocationsDisplayed());
    }

    @Test
    void refreshBookmarks() {
        this.locationController.refreshBookmarks();
        assertTrue(this.bookmarkInput.isLocationRefreshed());
    }
}