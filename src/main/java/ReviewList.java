import java.util.HashMap;
import java.util.Map;

public class ReviewList {
    final static Map<Integer, Review> reviewHashMap = new HashMap<>();

    /**
     * Adds a review to the reviews list.
     * @param review the review to add
     */
    public void addReview(Review review) {
        reviewHashMap.put(review.getReviewId(), review);
    }

    /**
     * Deletes a review from the review hash map.
     * @param review the review to be deleted.
     */
    public void deleteReview(Review review) {
        reviewHashMap.remove(review.getReviewId());
    }

    /**
     * Return the review associated with the reviewID.
     *
     * @param reviewID the review ID of the review
     * @return the Review with the given review ID
     */
    public Review getReview(Integer reviewID) {
        return reviewHashMap.get(reviewID);
    }
}
