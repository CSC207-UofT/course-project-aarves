package com.aarves.bluepages.database.models;

import com.aarves.bluepages.usecase.data.review.ReviewDTO;

/**
 * A helper class for mapping between review data transfer objects and Room's data entities.
 */
public class ReviewDatabaseMapper {
    /**
     * Converts given review data transfer object to a Room data entity.
     * @param reviewDTO the review data transfer object to be converted
     * @return the converted Room review data entity
     */
    public static ReviewDataEntity mapToDataEntity(ReviewDTO reviewDTO) {
        return new ReviewDataEntity(
                reviewDTO.getReviewer(),
                reviewDTO.getLocationId(),
                reviewDTO.getRating(),
                reviewDTO.getBody()
        );
    }

    /**
     * Converts the given Room review data entity to a data transfer object.
     * @param reviewDataEntity the Room review data entity to be converted
     * @return the converted review data transfer object
     */
    public static ReviewDTO mapToDTO(ReviewDataEntity reviewDataEntity) {
        return new ReviewDTO(
                reviewDataEntity.reviewer,
                reviewDataEntity.locationId,
                reviewDataEntity.rating,
                reviewDataEntity.body
        );
    }
}
