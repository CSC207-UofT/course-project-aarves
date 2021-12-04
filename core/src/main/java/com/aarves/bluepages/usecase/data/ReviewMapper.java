package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Review;

public class ReviewMapper {
    public static ReviewDTO mapToDTO(Review review) {
        if(review.getBody() != null) {
            return new ReviewDTO(
                    review.getReviewer(),
                    review.getLocationId(),
                    review.getRating(),
                    review.getBody()
            );
        }
        else {
            return new ReviewDTO(
                    review.getReviewer(),
                    review.getLocationId(),
                    review.getRating(),
                    ""
            );
        }
    }

    public static Review mapToReview(ReviewDTO reviewDTO, int reviewId) {
        Review review = new Review(
                reviewId,
                reviewDTO.getReviewer(),
                reviewDTO.getLocationId(),
                reviewDTO.getRating()
        );
        if(!reviewDTO.getBody().isEmpty()) {
            review.setBody(reviewDTO.getBody());
        }

        return review;
    }
}
