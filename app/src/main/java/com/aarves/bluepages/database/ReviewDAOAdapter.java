package com.aarves.bluepages.database;

import com.aarves.bluepages.database.access.ReviewDatabaseDAO;
import com.aarves.bluepages.database.models.ReviewDataEntity;
import com.aarves.bluepages.database.models.ReviewDatabaseMapper;
import com.aarves.bluepages.usecase.data.review.ReviewDAO;
import com.aarves.bluepages.usecase.data.review.ReviewDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewDAOAdapter implements ReviewDAO {
    private final ReviewDatabaseDAO reviewDatabaseDAO;

    public ReviewDAOAdapter(ReviewDatabaseDAO reviewDatabaseDAO) {
        this.reviewDatabaseDAO = reviewDatabaseDAO;
    }

    @Override
    public int addReviewData(ReviewDTO review) {
        ReviewDataEntity reviewDataEntity = ReviewDatabaseMapper.mapToDataEntity(review);
        return (int) reviewDatabaseDAO.insert(reviewDataEntity);
    }

    @Override
    public void deleteReviewData(int reviewId) {
        ReviewDataEntity reviewDataEntity = this.reviewDatabaseDAO.getByID(reviewId);
        this.reviewDatabaseDAO.delete(reviewDataEntity);
    }

    @Override
    public ReviewDTO getReviewData(int reviewId) {
        ReviewDataEntity reviewDataEntity = this.reviewDatabaseDAO.getByID(reviewId);

        if(reviewDataEntity != null) {
            return ReviewDatabaseMapper.mapToDTO(reviewDataEntity);
        }
        else {
            return null;
        }
    }

    @Override
    public Map<Integer, ReviewDTO> getReviewDataByUser(String username) {
        Map<Integer, ReviewDTO> reviewMap = new HashMap<>();
        List<ReviewDataEntity> reviews = this.reviewDatabaseDAO.getByUser(username);

        for(ReviewDataEntity reviewDataEntity : reviews) {
            ReviewDTO reviewDTO = ReviewDatabaseMapper.mapToDTO(reviewDataEntity);
            reviewMap.put(reviewDataEntity.reviewId, reviewDTO);
        }

        return reviewMap;
    }

    @Override
    public Map<Integer, ReviewDTO> getReviewDataByLocation(int locationId) {
        Map<Integer, ReviewDTO> reviewMap = new HashMap<>();
        List<ReviewDataEntity> reviews = this.reviewDatabaseDAO.getByLocation(locationId);

        for(ReviewDataEntity reviewDataEntity : reviews) {
            ReviewDTO reviewDTO = ReviewDatabaseMapper.mapToDTO(reviewDataEntity);
            reviewMap.put(reviewDataEntity.reviewId, reviewDTO);
        }

        return reviewMap;
    }
}
