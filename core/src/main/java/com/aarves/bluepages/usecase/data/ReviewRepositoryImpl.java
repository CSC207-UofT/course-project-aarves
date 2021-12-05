package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.usecase.interactors.review.ReviewRepository;
import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewRepositoryImpl implements ReviewRepository {
    private final ReviewDAO reviewDAO;

    public ReviewRepositoryImpl(ReviewDAO reviewDAO){
        this.reviewDAO = reviewDAO;
    }

    @Override
    public Review addReview(Review review) {
        ReviewDTO reviewData = ReviewDataMapper.mapToDTO(review);
        int reviewId = this.reviewDAO.addReviewData(reviewData);

        return ReviewDataMapper.mapToReview(reviewData, reviewId);
    }

    @Override
    public void deleteReview(Review review) {
        this.reviewDAO.deleteReviewData(review.getReviewId());
    }

    @Override
    public Review getReview(int reviewId) {
        ReviewDTO reviewData = this.reviewDAO.getReviewData(reviewId);

        if(reviewData != null) {
            return ReviewDataMapper.mapToReview(reviewData, reviewId);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Review> getReviewsByUser(String username) {
        Map<Integer, ReviewDTO> reviewDataMap = this.reviewDAO.getReviewDataByUser(username);
        return this.mapToList(reviewDataMap);
    }

    @Override
    public List<Review> getReviewsByLocation(int locationId) {
        Map<Integer, ReviewDTO> reviewDataMap = this.reviewDAO.getReviewDataByLocation(locationId);
        return this.mapToList(reviewDataMap);
    }

    private List<Review> mapToList(Map<Integer, ReviewDTO> reviewMap) {
        List<Review> reviews = new ArrayList<>();
        for (int reviewId : reviewMap.keySet()) {
            Review review = ReviewDataMapper.mapToReview(reviewMap.get(reviewId), reviewId);
            reviews.add(review);
        }

        return reviews;
    }
}
