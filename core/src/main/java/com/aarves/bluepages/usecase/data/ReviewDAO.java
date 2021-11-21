package com.aarves.bluepages.usecase.data;

import java.util.Map;

public interface ReviewDAO {
    int addReviewData(ReviewDTO review);
    void deleteReviewData(int reviewId);

    ReviewDTO getReviewData(int reviewId);
    Map<Integer, ReviewDTO> getReviewDataByUser(String username);
    Map<Integer, ReviewDTO> getReviewDataByLocation(int locationId);
}
