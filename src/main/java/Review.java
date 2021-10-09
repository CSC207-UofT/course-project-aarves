public class Review {
    private User reviewer;
    private String review;
    private int rating;

    public Review(User reviewer, String review, int rating) {
        this.reviewer = reviewer;
        this.review = review;
        this.rating = rating;
    }

    public Review(User reviewer, int rating) {
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
        return String.format("""
                User:\t%s
                Rating:\t%s/%s
                Review:\t%s""", this.reviewer.name, this.rating, 5, this.review);
    } // TODO: Make sure a 'name' attribute exists in User class (or its subclasses)

    public static void main(String[] args) {
        Review detailIncluded = new Review(new User(), "Fantastic place!", 4);
        System.out.println(detailIncluded);

        Review detailExcluded = new Review(new User(), 4);
        System.out.println(detailExcluded);
    }
}
