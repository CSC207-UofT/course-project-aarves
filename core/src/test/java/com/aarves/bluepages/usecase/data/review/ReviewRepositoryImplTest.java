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

    @Test
    void testDeleteReview() {
        Review r = new Review("reviewer", 34, 1);
        reviewRepository.addReview(r);
        int size = reviewDAO.reviews.size();
        reviewRepository.deleteReview(r);
        size = size - 1;
        assertEquals(size, reviewDAO.reviews.size());
    }

    @Test
    void getReview() {
        Review r = new Review(0,"reviewer", 34, 1);
        Review r2 = new Review(99, "reviewer", 34, 1);
        reviewRepository.addReview(r);
        reviewRepository.addReview(r2);
        Review result = reviewRepository.getReview(0);
        assertEquals(r.getReviewId(), result.getReviewId());

    }

    @Test
    void getReviewsByUser() {
        Review r = new Review(0,"reviewer", 34, 1);
        reviewRepository.addReview(r);
        List<Review> result = reviewRepository.getReviewsByUser("reviewer");
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(r);

        int id1 = 0;
        int id2 = 0;

        id1 = result.get(0).getReviewId();
        id2 = reviewList.get(0).getReviewId();

        assertEquals(id1, id2);
    }

    @Test
    void getReviewsByLocation() {
        Review r = new Review(0,"reviewer", 34, 1);
        reviewRepository.addReview(r);
        List<Review> resultList = reviewRepository.getReviewsByLocation(34);
        List<Review> newList = new ArrayList<>();
        newList.add(r);

        int id3 = 0;
        int id4 = 0;

        id3 = resultList.get(0).getLocationId();
        id4 = newList.get(0).getLocationId();

        assertEquals(id3, id4);


    }
}