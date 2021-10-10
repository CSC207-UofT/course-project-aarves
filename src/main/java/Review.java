import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Review {
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

        // Added while-loop to check if the randomly generated ID exists. If so, keep on looping. If not, exit loop and
        // set that randomId as this Review object's reviewId.
        this.reviewId = generateId();
    }

    public Review(RegisteredUser reviewer, Location location, int rating) {
        this.reviewer = reviewer;
        this.location = location;
        this.rating = rating;

        // Same explanation as in the previous constructor.
        this.reviewId = generateId();
    }

    private int generateId() {
        int randomId = new Random().nextInt(899999) + 100000;
        while (!rm.isIdUnique(randomId)) {
            randomId = new Random().nextInt(899999) + 100000;
        }
        return randomId;
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
