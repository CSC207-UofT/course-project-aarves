package com.aarves.bluepages.database;

import com.aarves.bluepages.database.access.ReviewDatabaseDAO;
import com.aarves.bluepages.database.models.ReviewDataEntity;
import com.aarves.bluepages.database.models.ReviewDatabaseMapper;
import com.aarves.bluepages.usecase.data.ReviewDAO;
import com.aarves.bluepages.usecase.data.ReviewDTO;

import java.util.HashMap;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {
    private final ReviewDatabaseDAO reviewDatabaseDAO;
    private final ReviewDatabaseMapper reviewDatabaseMapper;

    public ReviewDAOImpl(ReviewDatabaseDAO reviewDatabaseDAO) {
        this.reviewDatabaseDAO = reviewDatabaseDAO;
        this.reviewDatabaseMapper = new ReviewDatabaseMapper();
    }

    @Override
    public int addReviewData(ReviewDTO review) {
        ReviewDataEntity reviewDataEntity = this.reviewDatabaseMapper.mapToDataEntity(review);
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
        return this.reviewDatabaseMapper.mapToDTO(reviewDataEntity);
    }

    @Override
    public HashMap<Integer, ReviewDTO> getReviewDataByUser(String username) {
        HashMap<Integer, ReviewDTO> reviewMap = new HashMap<>();
        List<ReviewDataEntity> reviews = this.reviewDatabaseDAO.getByUser(username);

        for(ReviewDataEntity reviewDataEntity : reviews) {
            ReviewDTO reviewDTO = this.reviewDatabaseMapper.mapToDTO(reviewDataEntity);
            reviewMap.put(reviewDataEntity.reviewId, reviewDTO);
        }

        return reviewMap;
    }

    @Override
    public HashMap<Integer, ReviewDTO> getReviewDataByLocation(int locationId) {
        HashMap<Integer, ReviewDTO> reviewMap = new HashMap<>();
        List<ReviewDataEntity> reviews = this.reviewDatabaseDAO.getByLocation(locationId);

        for(ReviewDataEntity reviewDataEntity : reviews) {
            ReviewDTO reviewDTO = this.reviewDatabaseMapper.mapToDTO(reviewDataEntity);
            reviewMap.put(reviewDataEntity.reviewId, reviewDTO);
        }

        return reviewMap;
    }
}
