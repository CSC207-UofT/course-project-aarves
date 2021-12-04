package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Review;

public class ReviewMapper {
    public static ReviewDTO mapToDTO(Review review) {
        return new ReviewDTO(
                review.getReviewer(),
                review.getLocationId(),
                review.getRating(),
                review.getBody()
        );
    }

    public static Review mapToReview(ReviewDTO reviewDTO, int reviewId) {
        return new Review(
                reviewId,
                reviewDTO.getReviewer(),
                reviewDTO.getLocationId(),
                reviewDTO.getRating(),
                reviewDTO.getBody()
        );
    }
}
