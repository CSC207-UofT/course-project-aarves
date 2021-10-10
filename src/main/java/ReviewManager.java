import java.util.HashMap;

public class ReviewManager {
    private static HashMap<Integer, Review> reviewHashMap = new HashMap<>();

    protected Review getReview(int reviewId) {
        return reviewHashMap.get(reviewId);
    }

    public void createReview(RegisteredUser reviewer, Location location, String review, int rating) {
        Review new_review = new Review(reviewer, location, review, rating);
        addReview(location, new_review);
    }

    public void createReview(RegisteredUser reviewer, Location location, int rating) {
        Review new_review = new Review(reviewer, location, rating);
        addReview(location, new_review);
    }

    public void addReview(Location location, Review review) {
        reviewHashMap.put(review.getReviewId(), review);
        review.getReviewer().addReview(review);
        location.addReview(review);
    }

}
