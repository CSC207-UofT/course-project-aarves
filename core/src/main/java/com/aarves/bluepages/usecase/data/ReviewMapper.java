package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.Review;

public class ReviewMapper {
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
                reviewDTO.getReview()
        );
    }
}
