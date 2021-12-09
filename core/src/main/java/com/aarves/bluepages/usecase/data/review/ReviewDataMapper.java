package com.aarves.bluepages.usecase.data.review;

import com.aarves.bluepages.entities.Review;

/**
 * A helper class for mapping between review entities and data transfer objects.
 */
public class ReviewDataMapper {
    /**
     * Converts review entity into review data transfer object.
     * @param review the review entity to be converted
     * @return the converted review data transfer object
     */
    public static ReviewDTO mapToDTO(Review review) {
        // If the body is null, set as empty string
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

    /**
     * Converts review data transfer object to review entity.
     * @param reviewDTO the review transfer object to be converted
     * @param reviewId the ID of the review to be created
     * @return the converted review entity
     */
    public static Review mapToReview(ReviewDTO reviewDTO, int reviewId) {
        Review review = new Review(
                reviewId,
                reviewDTO.getReviewer(),
                reviewDTO.getLocationId(),
                reviewDTO.getRating()
        );
        // Sets body of review if non-empty
        if(!reviewDTO.getBody().isEmpty()) {
            review.setBody(reviewDTO.getBody());
        }

        return review;
    }
}
