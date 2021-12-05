package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReviewManagerTest {

    ReviewManager reviewManager;
    ReviewRepositoryMockup reviewRepository;
    ReviewOutputBoundaryMockup reviewOutputBoundary;

    @BeforeEach
    void setUp() {
        reviewRepository = new ReviewRepositoryMockup();
        reviewOutputBoundary = new ReviewOutputBoundaryMockup();
        reviewManager = new ReviewManager(reviewRepository, reviewOutputBoundary);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadReviews() {
        reviewManager.loadReviews();
        Assertions.assertTrue(reviewOutputBoundary.presentedReviews);
    }

    @Test
    void update() {
        // use loadReviews?
        reviewManager.loadReviews();
        Review r1 = new Review("reviewer", 19, 3);
        User user = new User("username", "password");
        user.addReview(r1);
        reviewManager.update(user);
        Assertions.assertTrue(reviewOutputBoundary.presentedReviews);
    }

    @Test
    void updateNull() {
        reviewManager.update(null);
        // Assertions.assertEquals("", reviewManager.username);
    }

    @Test
    void createReview() {
        // int originalLength = reviewManager.reviews.length();
        // assertEquals(originalLength + 1, reviewManager.length());
    }

    @Test
    void testCreateReview() {
    }

    @Test
    void deleteAllUserReviews() {
    }

    @Test
    void deleteReview() {
    }

    @Test
    void getReview() {
    }
}