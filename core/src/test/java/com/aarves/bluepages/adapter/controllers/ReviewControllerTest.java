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
    void loadUserReviews() {
        assertTrue(reviewInput.isUserLoaded());
    }

    @Test
    void loadLocationReviews() {
        assertTrue(reviewInput.isLocationLoaded());
    }

    //TODO
    @Test
    void createReview() {

    }
}