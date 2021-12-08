package com.aarves.bluepages.adapter.controllers;

import com.aarves.bluepages.entities.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewControllerTest {

    private ReviewInputMockup reviewInput;
    private ReviewController reviewController;

    @BeforeEach
    void setUp() {
        reviewInput = new ReviewInputMockup("user");
        reviewController = new ReviewController(reviewInput);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testLoadUserReviews() {
        reviewController.loadUserReviews();
        assertTrue(reviewInput.isUserLoaded());
    }

    @Test
    void testLoadLocationReviews() {
        int locationId = 34;
        reviewController.loadLocationReviews(locationId);
        assertTrue(reviewInput.isLocationLoaded());
    }

    @Test
    void testCreateReview() {
        int originalSize = reviewInput.getReviews().size();
        reviewController.createReview(89, 3, "Very crowded");
        assertEquals(originalSize + 1, reviewInput.getReviews().size());

    }
}