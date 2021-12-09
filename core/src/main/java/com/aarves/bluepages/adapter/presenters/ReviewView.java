package com.aarves.bluepages.adapter.presenters;

import java.util.List;

/**
 * The interface for displaying reviews.
 */
public interface ReviewView extends BasicView {
    void displayReviews(List<ReviewViewModel> reviews);
}
