import java.util.HashMap;

public class ReviewManager {
    private static HashMap<Integer, Review> reviewHashMap = new HashMap<>();

    protected Review getReview(int reviewId) {
        return reviewHashMap.get(reviewId);
    }

    public void addReview(RegisteredUser reviewer, Location location, String review, int rating) {
        Review new_review = new Review(reviewer, location, review, rating);
        reviewHashMap.put(new_review.getReviewId(), new_review);
        new_review.getReviewer().addReview(new_review);
        location.addReview(new_review);
    }

    public void addReview(RegisteredUser reviewer, Location location, int rating) {
        Review new_review = new Review(reviewer, location, rating);
        reviewHashMap.put(new_review.getReviewId(), new_review);
        new_review.getReviewer().addReview(new_review);
        location.addReview(new_review);
    }

}
