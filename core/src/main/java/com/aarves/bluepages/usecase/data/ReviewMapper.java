package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Review;

public class ReviewMapper { // TODO: Refactor to make static?
    public ReviewDTO mapToDTO(Review review) {
        return new ReviewDTO(
                review.getReviewer(),
                review.getLocationId(),
                review.getRating(),
                review.getBody()
        );
    }

    public Review mapToReview(ReviewDTO reviewDTO) {
        return new Review(
                reviewDTO.getReviewer(),
                reviewDTO.getLocationId(),
                reviewDTO.getRating(),
                reviewDTO.getBody()
        );
    }
}
