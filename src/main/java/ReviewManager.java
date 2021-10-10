import java.util.HashMap;

public class ReviewManager {
    private static HashMap<Integer, Review> reviewHashMap = new HashMap<>();

    protected boolean isIdUnique(int reviewId) {
        return !reviewHashMap.containsValue(reviewId);
    }

    protected Review getReview(int reviewId) {
        return reviewHashMap.get(reviewId);
    }

    protected void addReview(Review review) {
        reviewHashMap.put(review.getReviewId(), review);
    }
}
