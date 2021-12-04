package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

public class ReviewModelMapper {
    public static ReviewViewModel mapToViewModel(ReviewOutputModel reviewOutputModel) {
        return new ReviewViewModel(
                reviewOutputModel.getReviewer(),
                reviewOutputModel.getRating(),
                reviewOutputModel.getBody()
        );
    }
}
