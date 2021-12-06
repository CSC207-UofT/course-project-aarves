package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.usecase.data.review.ReviewDAO;
import com.aarves.bluepages.usecase.data.review.ReviewRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewRepositoryImplTest {

    ReviewRepositoryImpl reviewRepository;
    // ReviewDAOMockup reviewDAO;

    @BeforeEach
    void setUp() {
        // reviewRepository = new ReviewRepositoryImpl(reviewDAO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddReview() {
        Review r = new Review("reviewer", 34, 1);
        Review result = reviewRepository.addReview(r);
        Assertions.assertEquals(r, result);
    }

    @Test
    void deleteReview() {
    }

    @Test
    void getReview() {
    }

    @Test
    void getReviewsByUser() {
    }

    @Test
    void getReviewsByLocation() {
    }
}