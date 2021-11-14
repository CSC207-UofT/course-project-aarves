package com.aarves.bluepages.database;

import com.aarves.bluepages.usecase.data.ReviewDAO;
import com.aarves.bluepages.usecase.data.ReviewDTO;
import com.aarves.bluepages.database.access.ReviewDatabaseDAO;
import com.aarves.bluepages.database.models.ReviewDataEntity;
import com.aarves.bluepages.database.models.ReviewDatabaseMapper;

import java.util.Map;

public class ReviewDAOImpl implements ReviewDAO {
    private ReviewDatabaseDAO reviewDatabaseDAO;
    private ReviewDatabaseMapper reviewDatabaseMapper;

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

    }

    @Override
    public ReviewDTO getReviewData(int reviewId) {
        ReviewDataEntity reviewDataEntity = this.reviewDatabaseDAO.getByID(reviewId);
        return this.reviewDatabaseMapper.mapToDTO(reviewDataEntity);
    }

    @Override
    public Map<Integer, ReviewDTO> getReviewDataByUser(String username) {
        return null;
    }

    @Override
    public Map<Integer, ReviewDTO> getReviewDataByLocation(int locationId) {
        return null;
    }
}
