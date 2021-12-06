package com.aarves.bluepages.usecase.data.review;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.usecase.data.review.ReviewDAO;
import com.aarves.bluepages.usecase.data.review.ReviewRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewRepositoryImplTest {

    ReviewRepositoryImpl reviewRepository;
    ReviewDAOMock reviewDAO;

    @BeforeEach
    void setUp() {
        reviewDAO = new ReviewDAOMock();
        reviewRepository = new ReviewRepositoryImpl(reviewDAO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddReview() {
        int original = reviewDAO.reviews.size();
        Review r = new Review("reviewer", 34, 1);
        reviewRepository.addReview(r);
        Assertions.assertEquals(original + 1, reviewDAO.reviews.size());
    }

    // TODO: concurrent modification error
    @Test
    void testDeleteReview() {
        Review r = new Review("reviewer", 34, 1);
        reviewRepository.addReview(r);
        int size = reviewDAO.reviews.size();
        reviewRepository.deleteReview(r);
        size = size - 1;
        assertEquals(size, reviewDAO.reviews.size());

    }

    // TODO: not passing
    @Test
    void getReview() {
        Review r = new Review(0,"reviewer", 34, 1);
        Review r2 = new Review(99, "reviewer", 34, 1);
        reviewRepository.addReview(r);
        reviewRepository.addReview(r2);
        Review result = reviewRepository.getReview(0);
        assertEquals(r, result);

    }

    // TODO: not passing
    @Test
    void getReviewsByUser() {
        Review r = new Review(0,"reviewer", 34, 1);
        Review r2 = new Review(99, "reviewer", 101, 5);
        reviewRepository.addReview(r);
        reviewRepository.addReview(r2);
        List<Review> result = reviewRepository.getReviewsByUser("reviewer");
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(r);
        reviewList.add(r2);
        assertEquals(reviewList, result);
    }

    @Test
    void getReviewsByLocation() {
    }
}