import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Review {
    private static int maxID = 0;

    private RegisteredUser reviewer;
    private Location location;
    private String review;
    private int rating;
    private int reviewId;

    private ReviewManager rm = new ReviewManager();

    public Review(RegisteredUser reviewer, Location location, String review, int rating) {
        this.reviewer = reviewer;
        this.location = location;
        this.review = review;
        this.rating = rating;

        this.reviewId = Review.maxID;
        Review.maxID += 1;
    }

    public Review(RegisteredUser reviewer, Location location, int rating) {
        this.reviewer = reviewer;
        this.location = location;
        this.rating = rating;

        this.reviewId = Review.maxID;
        Review.maxID += 1;
    }

    public int getRating() {
        return this.rating;
    }

    public String getReview() {
        return this.review;
    }

    protected int getReviewId() {
        return this.reviewId;
    }

    @Override
    public String toString() {
        return String.format("User:\t%s\n Rating:\t%s/%s\n Review:\t%s",
                this.reviewer.getUsername(), this.rating, 5, this.review);
    }

    public static void main(String[] args) {

        ArrayList<Review> reviewList = new ArrayList<>();

        StudyLocation robarts = new StudyLocation(reviewList, "", "", true, true);

        Review detailIncluded = new Review(new RegisteredUser("Billy123", "123abc"), robarts, "Fantastic place!", 4);
        System.out.println(detailIncluded);

        Review detailExcluded = new Review(new RegisteredUser("Joey456", "456sticks"), robarts, 4);
        System.out.println(detailExcluded);
    }
}
