public class Review {
    private RegisteredUser reviewer;
    private String review;
    private int rating;
    private int reviewId;

    public Review(RegisteredUser reviewer, String review, int rating) {
        this.reviewer = reviewer;
        this.review = review;
        this.rating = rating;
        // TODO: Add a getter method for the User (likely RegisteredUser) such that a list of their reviews is returned
        //       to create reviewId (based off the review-to-be's index in the list).
        this.reviewId = reviewer.getReviews().size();
    }

    public Review(RegisteredUser reviewer, int rating) {
        this.reviewer = reviewer;
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return String.format("User:\t%s\n Rating:\t%s/%s\n Review:\t%s",
                this.reviewer.name, this.rating, 5, this.review);
    }

    public static void main(String[] args) {
        Review detailIncluded = new Review(new RegisteredUser("Billy123", "123abc"), "Fantastic place!", 4);
        System.out.println(detailIncluded);

        Review detailExcluded = new Review(new RegisteredUser("Joey456", "456sticks"), 4);
        System.out.println(detailExcluded);
    }
}
