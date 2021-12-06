package com.aarves.bluepages.adapter.presenters;

import java.util.List;

public interface ReviewView extends BasicView {
    void displayReviews(List<ReviewViewModel> reviews);
}
