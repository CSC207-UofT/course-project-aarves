package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.exceptions.NotLoggedInException;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ReviewManagerTest {

    ReviewManager reviewManager;
    ReviewRepositoryMockup reviewRepository;
    ReviewOutputBoundaryMockup reviewOutputBoundary;

    @BeforeEach
    void setUp() {
        reviewRepository = new ReviewRepositoryMockup();
        reviewOutputBoundary = new ReviewOutputBoundaryMockup();
        reviewManager = new ReviewManager(reviewRepository, reviewOutputBoundary);
        // set reviewManager's username
        User user = new User("user", "pass");
        reviewManager.update(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateReview() throws NotLoggedInException {
        reviewManager.createReview(123, 5, "best study spot on campus");
        Assertions.assertEquals(1, reviewRepository.reviews.size());
    }

    @Test
    void testCreateReviewNoBody() throws NotLoggedInException {
        reviewManager.createReview(123, 5);
        Assertions.assertEquals(1, reviewRepository.reviews.size());
    }


    @Test
    void testLoadUserReviews(){
        reviewManager.loadUserReviews();
        Assertions.assertTrue(reviewOutputBoundary.presentedReviews);
    }

    @Test
    void testLoadReviews() {
        reviewManager.loadUserReviews();
        Assertions.assertTrue(reviewOutputBoundary.presentedReviews);
    }

    @Test
    void testUpdate() {

        User user = new User("user", "pass");
        reviewManager.update(user);
        Assertions.assertTrue(reviewOutputBoundary.presentedReviews);
    }


    @Test
    void deleteAllUserReviews() throws NotLoggedInException, PermissionsFailureException {

        reviewManager.deleteAllUserReviews();
        Assertions.assertTrue(reviewRepository.reviews.isEmpty());

    }

    @Test
    void testDeleteReview() throws NotLoggedInException, PermissionsFailureException {

        reviewManager.createReview(34, 2, "bad cookies");
        reviewManager.createReview(56, 4, "great food!");
        reviewManager.createReview(90, 5, "loved the space");

        List<Integer> ids = new ArrayList<>();

        for (Review r: reviewRepository.reviews) {
            if (r.getLocationId() == 34) {
                ids.add(r.getReviewId());
            }
        }
        Review my_Review = reviewManager.getReview(ids.get(0));
        reviewManager.deleteReview(my_Review);

        Assertions.assertEquals(2, reviewRepository.reviews.size());

    }

    @Test
    void testGetReview() {

        Review r = new Review(12, "reviewer", 345, 4);
        this.reviewRepository.addReview(r);
        Review result = reviewManager.getReview(12);
        Assertions.assertEquals(r, result);

    }
}