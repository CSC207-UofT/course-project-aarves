package com.aarves.bluepages.usecase.interactors.review;

import java.util.List;

public interface ReviewOutputBoundary {
    void presentReviews(List<ReviewOutputModel> reviews);
    void createResult(boolean success);
}
