package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.review.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepositoryMockup implements ReviewRepository {

    List<Review> reviews = new ArrayList<>();

    @Override
    public Review addReview(Review review) {
        reviews.add(review);
        return review;
    }

    @Override
    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    @Override
    public Review getReview(int reviewId) {

        for (Review r:reviews){
            Integer id = r.getLocationId();
            if (id.equals(reviewId)){
                return r;
            }
        }
        return null;
    }


    @Override
    public List<Review> getReviewsByUser(User user) {
        //        for (Review r:reviews){
//            String reviewer = r.getReviewer();
//            if (reviewer.equals(user.getUsername())){
//                return r;
//            }
//        }
        return null;
    }

    @Override
    public List<Review> getReviewsByLocation(int locationId) {
        return null;
    }
}
