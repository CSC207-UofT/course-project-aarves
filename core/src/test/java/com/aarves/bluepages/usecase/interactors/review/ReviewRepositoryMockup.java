package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.Review;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.review.ReviewRepository;

import java.lang.reflect.Array;
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

        return user.getReviews();

    }

    @Override
    public List<Review> getReviewsByLocation(int locationId) {

        List<Review> location_Reviews = new ArrayList<>();

        for (Review r: reviews) {

            int id = r.getLocationId();

            if (id == locationId) {
                location_Reviews.add(r);
            }
        }
        return location_Reviews;

    }
}
