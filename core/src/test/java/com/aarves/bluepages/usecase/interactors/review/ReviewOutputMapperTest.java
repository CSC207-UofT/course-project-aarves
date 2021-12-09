package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewOutputMapperTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testMapToOutputModels() {
        Review review = new Review("reviewer", 89, 4);
        Review review2 = new Review("reviewer", 89, 4);
        Review review3 = new Review("reviewer", 89, 4);
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review3);
        reviewList.add(review2);
        reviewList.add(review);
        List<ReviewOutputModel> result = ReviewOutputMapper.mapToOutputModels(reviewList);
        assertEquals(3, result.size());
    }

    @Test
    void testMapToOutputModel() {
        Review review = new Review("reviewer", 89, 4);
        ReviewOutputModel result = ReviewOutputMapper.mapToOutputModel(review);
        assertEquals(review.getReviewer(), result.getReviewer());
    }
}