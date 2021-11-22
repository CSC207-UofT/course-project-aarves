package com.aarves.bluepages.database.models;

import com.aarves.bluepages.usecase.data.ReviewDTO;

public class ReviewDatabaseMapper {
    public static ReviewDataEntity mapToDataEntity(ReviewDTO reviewDTO) {
        return new ReviewDataEntity(
                reviewDTO.getReviewer(),
                reviewDTO.getLocationId(),
                reviewDTO.getRating(),
                reviewDTO.getBody()
        );
    }

    public static ReviewDTO mapToDTO(ReviewDataEntity reviewDataEntity) {
        return new ReviewDTO(
                reviewDataEntity.reviewer,
                reviewDataEntity.locationId,
                reviewDataEntity.rating,
                reviewDataEntity.body
        );
    }
}
