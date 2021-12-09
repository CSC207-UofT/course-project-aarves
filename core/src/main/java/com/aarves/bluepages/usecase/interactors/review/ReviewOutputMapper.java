package com.aarves.bluepages.usecase.interactors.review;

import com.aarves.bluepages.entities.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewOutputMapper {
    /**
     * Maps the list of reviews to ReviewOutputModels
     * @param reviews the list of reviews to map
     * @return the ReviewOuputModels that have been mapped to
     */
    public static List<ReviewOutputModel> mapToOutputModels(List<Review> reviews) {
        List<ReviewOutputModel> reviewOutputModels = new ArrayList<>();
        for(Review review : reviews) {
            reviewOutputModels.add(ReviewOutputMapper.mapToOutputModel(review));
        }

        return reviewOutputModels;
    }

    /**
     * Maps a review to a ReviewOutputModel
     * @param review the review to map
     * @return the ReviewOutputModel that has been mapped to
     */
    public static ReviewOutputModel mapToOutputModel(Review review) {
        return new ReviewOutputModel(
                review.getReviewer(),
                review.getRating(),
                review.getBody()
        );
    }
}
