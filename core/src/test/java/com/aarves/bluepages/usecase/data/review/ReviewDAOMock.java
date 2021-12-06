package com.aarves.bluepages.usecase.data.review;

import com.aarves.bluepages.entities.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewDAOMock implements ReviewDAO{

    List<Review> reviews = new ArrayList<>();

    @Override
    public int addReviewData(ReviewDTO review) {
        Review r = new Review(review.getReviewer(), review.getLocationId(), review.getRating());
        reviews.add(r);
        return r.getReviewId();
    }

    @Override
    public void deleteReviewData(int reviewId) {
        reviews.removeIf(r -> r.getReviewId() == reviewId);
    }

    @Override
    public ReviewDTO getReviewData(int reviewId) {
        for (Review r:reviews){
            if (r.getReviewId() == reviewId) {
                return new ReviewDTO(r.getReviewer(), r.getLocationId(), r.getRating(), r.getBody());
            }
        }
        return null;
    }

    @Override
    public Map<Integer, ReviewDTO> getReviewDataByUser(String username) {
        Map<Integer, ReviewDTO> reviewMap = new HashMap<>();
        for (Review r:reviews){
            ReviewDTO reviewDTO = ReviewDataMapper.mapToDTO(r);
            reviewMap.put(r.getReviewId(), reviewDTO);
        }
        return reviewMap;
    }

    @Override
    public Map<Integer, ReviewDTO> getReviewDataByLocation(int locationId) {
        Map<Integer, ReviewDTO> reviewMap = new HashMap<>();
        for (Review r:reviews){
            ReviewDTO reviewDTO = ReviewDataMapper.mapToDTO(r);
            reviewMap.put(r.getReviewId(), reviewDTO);
        }
        return reviewMap;
    }
}
