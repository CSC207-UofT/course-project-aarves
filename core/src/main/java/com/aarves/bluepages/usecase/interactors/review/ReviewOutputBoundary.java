package com.aarves.bluepages.usecase.interactors.review;

import java.util.List;

/**
 * An interface for outputting review related information to UI.
 */
public interface ReviewOutputBoundary {
    /**
     * Presents the given reviews to the user.
     * @param reviews the ReviewOutputModels of the reviews to present.
     */
    void presentReviews(List<ReviewOutputModel> reviews);

    /**
     * Displays the result of the review creation.
     * @param success whether the review creation process was successful or not.
     */
    void createResult(boolean success);
}
