package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewOutputMapper {
    public static List<ReviewOutputModel> mapToOutputModels(List<Review> reviews) {
        List<ReviewOutputModel> reviewOutputModels = new ArrayList<>();
        for(Review review : reviews) {
            reviewOutputModels.add(ReviewOutputMapper.mapToOutputModel(review));
        }

        return reviewOutputModels;
    }

    public static ReviewOutputModel mapToOutputModel(Review review) {
        return new ReviewOutputModel(
                review.getReviewer(),
                review.getRating(),
                review.getBody()
        );
    }
}
