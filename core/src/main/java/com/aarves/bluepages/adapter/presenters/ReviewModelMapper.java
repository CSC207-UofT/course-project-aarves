package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;

import java.util.ArrayList;
import java.util.List;

public class ReviewModelMapper {
    public static List<ReviewViewModel> mapToViewModels(List<ReviewOutputModel> reviewOutputModels) {
        List<ReviewViewModel> reviewViewModels = new ArrayList<>();
        for(ReviewOutputModel reviewOutputModel : reviewOutputModels) {
            reviewViewModels.add(ReviewModelMapper.mapToViewModel(reviewOutputModel));
        }

        return reviewViewModels;
    }

    public static ReviewViewModel mapToViewModel(ReviewOutputModel reviewOutputModel) {
        return new ReviewViewModel(
                reviewOutputModel.getReviewer(),
                reviewOutputModel.getRating(),
                reviewOutputModel.getBody()
        );
    }
}
