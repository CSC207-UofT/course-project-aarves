import java.util.HashMap;
import java.util.ArrayList;

public class ReviewManager {

    final static HashMap<Integer, Review> reviewHashMap = new HashMap<>();

    protected Review getReview(int reviewId) {
        return reviewHashMap.get(reviewId);
    }

    /**
     * Creates a new review and adds it to the reviewHashMap
     *
     * @param reviewer the Review's RegisteredUser
     * @param location the Review's Location
     * @param review the Review's text
     * @param rating the Review's rating
     */
    public void createReview(RegisteredUser reviewer, Location location, String review, int rating) {
        Review new_review = new Review(reviewer, location, review, rating);
        addReview(location, new_review);
    }

    /**
     * Creates a new review and adds it to the reviewHashMap.
     *
     * @param reviewer the Review's RegisteredUser
     * @param location the Review's Location
     * @param rating the Review's rating
     */
    public void createReview(RegisteredUser reviewer, Location location, int rating) {
        Review new_review = new Review(reviewer, location, rating);
        addReview(location, new_review);
    }

    /**
     * Adds a review to reviewHashMap.
     *
     * @param location the Location of the review
     * @param review the Review to be added
     */
    protected void addReview(Location location, Review review) {
        reviewHashMap.put(review.getReviewId(), review);
        review.getReviewer().addReview(review);
        location.addReview(review);
    }

    /**
     * Deletes all reviews associated with a RegisteredUser.
     *
     * @param reviewer the RegisteredUser whose reviews will be deleted.
     */
    public void deleteAllUserReviews(RegisteredUser reviewer) {
        ArrayList<Review> reviews = reviewer.getReviews();
        for (Review r : reviews) {
            deleteReview(reviewer, r.getLocation(), r);
        }
    }

    /**
     * Deletes a review from all three locations where it is stored.
     *
     * @param reviewer the RegisteredUser of the review
     * @param location the Location of the review
     * @param review the Review to be deleted
     */
    public void deleteReview(RegisteredUser reviewer, Location location, Review review) {
        reviewHashMap.remove(review.getReviewId());
        reviewer.deleteReview(review);
        location.deleteReview(review);
    }

}
