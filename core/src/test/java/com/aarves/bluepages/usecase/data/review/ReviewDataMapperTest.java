package com.aarves.bluepages.usecase.data.review;

import com.aarves.bluepages.entities.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDataMapperTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testMapToDTO() {
        Review r = new Review(64,"reviewer1", 145, 3);
        r.setBody("Too noisy");
        ReviewDTO reviewDTOResult = ReviewDataMapper.mapToDTO(r);
        Assertions.assertEquals(145, reviewDTOResult.getLocationId());

    }

    @Test
    void testMapToReview() {
        ReviewDTO reviewDTO = new ReviewDTO("reviewer", 90, 5, "best sandwiches");
        Review review = new Review(800,"reviewer", 90, 5);
        review.setBody("best sandwiches");
        Review result = ReviewDataMapper.mapToReview(reviewDTO, 800);
        Assertions.assertEquals(review.getReviewId(), result.getReviewId());

    }
}