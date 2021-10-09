public class Review {
    private RegisteredUser reviewer;
    private String review;
    private int rating;
    private int reviewId;

    public Review(RegisteredUser reviewer, String review, int rating) {
        this.reviewer = reviewer;
        this.review = review;
        this.rating = rating;
        if (reviewer.getReviews() != null) {
            this.reviewId = reviewer.getReviews().size();
        } else {
            this.reviewId = 1;
        }

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
