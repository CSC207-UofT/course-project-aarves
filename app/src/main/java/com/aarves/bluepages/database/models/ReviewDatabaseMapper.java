package com.aarves.bluepages.database.models;

import com.aarves.bluepages.usecase.data.ReviewDTO;

public class ReviewDatabaseMapper { // TODO: Refactor to make static?
    public ReviewDataEntity mapToDataEntity(ReviewDTO reviewDTO) {
        return new ReviewDataEntity(
                reviewDTO.getReviewer(),
                reviewDTO.getLocationId(),
                reviewDTO.getRating(),
                reviewDTO.getBody()
        );
    }

    public ReviewDTO mapToDTO(ReviewDataEntity reviewDataEntity) {
        return new ReviewDTO(
                reviewDataEntity.reviewer,
                reviewDataEntity.locationId,
                reviewDataEntity.rating,
                reviewDataEntity.body
        );
    }
}
