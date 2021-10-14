public class Review {
    private static int maxID = 0;

    private RegisteredUser reviewer;
    private Location location;
    private String review;
    private int rating;
    private int reviewId;

    /**
     * Constructs a new Review object which belongs to a given RegisteredUser regarding a specific Location, and
     * containing a String with information about the RegisteredUser's experience, and an Integer rating out of 5 based
     * on the RegisteredUser's opinion.
     *
     * @param reviewer  The RegisteredUser creating the Review.
     * @param location  The Location this Review is addressed towards.
     * @param review    String information about the RegisteredUser's opinions.
     * @param rating    Integer rating (out of 5) for location as per the RegisteredUser's opinion.
     */
    public Review(RegisteredUser reviewer, Location location, String review, int rating) {
        this.reviewer = reviewer;
        this.location = location;
        this.review = review;
        this.rating = rating;

        this.reviewId = Review.maxID;
        Review.maxID += 1;
    }

    /**
     * Constructs a new Review object which belongs to a given RegisteredUser regarding a specific Location, and an
     * Integer rating out of 5 based on the RegisteredUser's opinion.
     *
     * @param reviewer  The RegisteredUser creating the Review.
     * @param location  The Location this Review is addressed towards.
     * @param rating    Integer rating (out of 5) for location as per the RegisteredUser's opinion.
     */
    public Review(RegisteredUser reviewer, Location location, int rating) {
        this.reviewer = reviewer;
        this.location = location;
        this.rating = rating;

        this.reviewId = Review.maxID;
        Review.maxID += 1;
    }

    /**
     * Return the rating associated with this Review.
     * @return  Integer representing the rating (out of 5).
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * Return the written opinion associated with this Review (if applicable).
     * @return  String representing the opinion.
     */
    public String getReview() {
        return this.review;
    }

    /**
     * Return the RegisteredUser who left this Review.
     * @return  RegisteredUser who created this Review.
     */
    public RegisteredUser getReviewer() {
        return this.reviewer;
    }

    /**
     * Return the ID associated with this Review.
     * @return  Integer representing the ID of the Review.
     */
    protected int getReviewId() {
        return this.reviewId;
    }

    /**
     * Return the Location for which this Review is meant for.
     * @return  Location who the Review is directed towards.
     */
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("User:\t%s\n Rating:\t%s/%s\n Review:\t%s",
                this.reviewer.getUsername(), this.rating, 5, this.review);
    }
}
