package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.ReviewRepository;

import java.util.ArrayList;
import java.util.Map;

public class ReviewRepositoryImpl implements ReviewRepository {
    private ReviewMapper reviewMapper;
    private ReviewDAO reviewDAO;

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
    public void deleteReview(Review review) {
        this.reviewDAO.deleteReviewData(review.getReviewId());
    }

    @Override
    public Review getReview(int reviewId) {
        ReviewDTO reviewData = this.reviewDAO.getReviewData(reviewId);
        return this.reviewMapper.mapToReview(reviewData);
    }

    @Override
    public ArrayList<Review> getReviewsByUser(User user) {
        Map<Integer, ReviewDTO> reviewDataMap = this.reviewDAO.getReviewDataByUser(user.username);
        return this.mapToList(reviewDataMap);
    }

    @Override
    public ArrayList<Review> getReviewsByLocation(int locationId) {
        Map<Integer, ReviewDTO> reviewDataMap = this.reviewDAO.getReviewDataByLocation(locationId);
        return this.mapToList(reviewDataMap);
    }

    private ArrayList<Review> mapToList(Map<Integer, ReviewDTO> reviewMap) {
        ArrayList<Review> reviews = new ArrayList<>();
        for (int reviewId : reviewMap.keySet()) {
            Review review = this.reviewMapper.mapToReview(reviewMap.get(reviewId));
            review.setReviewId(reviewId);

            reviews.add(review);
        }

        return reviews;
    }
}
