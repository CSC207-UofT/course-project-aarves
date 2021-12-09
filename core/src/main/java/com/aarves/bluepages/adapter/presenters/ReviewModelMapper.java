package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

import java.util.ArrayList;
import java.util.List;

public class ReviewModelMapper {
    /**
     * Maps the reviews from ReviewOutputModels to ReviewViewModels, for presenting.
     * @param reviewOutputModels the list of ReviewOutputModels to map
     * @return the ReviewViewModels that have been mapped from the ReviewOutputModels
     */
    public static List<ReviewViewModel> mapToViewModels(List<ReviewOutputModel> reviewOutputModels) {
        List<ReviewViewModel> reviewViewModels = new ArrayList<>();
        for(ReviewOutputModel reviewOutputModel : reviewOutputModels) {
            reviewViewModels.add(ReviewModelMapper.mapToViewModel(reviewOutputModel));
        }

        return reviewViewModels;
    }

    /**
     * Map a review from a ReviewOutputModel to a ReviewViewModel
     * @param reviewOutputModel the ReviewOutputModel to map
     * @return the ReviewViewModel of the review, mapped from it's ReviewOutputModel
     */
    public static ReviewViewModel mapToViewModel(ReviewOutputModel reviewOutputModel) {
        return new ReviewViewModel(
                reviewOutputModel.getReviewer(),
                reviewOutputModel.getRating(),
                reviewOutputModel.getBody()
        );
    }
}
