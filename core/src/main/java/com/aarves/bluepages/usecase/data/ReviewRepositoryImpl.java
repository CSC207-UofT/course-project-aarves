package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.ReviewRepository;

import java.util.ArrayList;
import java.util.Map;

public class ReviewRepositoryImpl implements ReviewRepository {
    ReviewMapper reviewMapper;
    ReviewDAO reviewDAO;

    public ReviewRepositoryImpl(ReviewDAO reviewDAO){
        this.reviewMapper = new ReviewMapper();
        this.reviewDAO = reviewDAO;
    }

    @Override
    public int addReview(Review review) {
        ReviewDTO reviewData = this.reviewMapper.mapToDTO(review);
        return this.reviewDAO.addReviewData(reviewData);
    }

    @Override
    public void deleteReview(int reviewId) {
        this.reviewDAO.deleteReviewData(reviewId);
    }

    @Override
    public Review getReview(int reviewId) {
        ReviewDTO reviewData = this.reviewDAO.getReviewData(reviewId);
        return this.reviewMapper.mapToReview(reviewData);
    }

    @Override
    public ArrayList<Review> getReviewsByUser(User user) {
        Map<Integer, ReviewDTO> reviewDataMap = this.reviewDAO.getReviewDataByUser(user.username);

        ArrayList<Review> reviews = new ArrayList<>();
        for (ReviewDTO reviewData : reviewDataMap.values()) {
            reviews.add(this.reviewMapper.mapToReview(reviewData));
        }

        return reviews;
    }

    @Override
    public ArrayList<Review> getReviewsByLocation(int locationId) {
        Map<Integer, ReviewDTO> reviewDataMap = this.reviewDAO.getReviewDataByLocation(locationId);

        ArrayList<Review> reviews = new ArrayList<>();
        for (ReviewDTO reviewData : reviewDataMap.values()) {
            reviews.add(this.reviewMapper.mapToReview(reviewData));
        }

        return reviews;
    }
}
