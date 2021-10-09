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
        return String.format("Rating:\t%s/%s\n" +
                             "Review:\t%s", this.rating, 5, this.review);
    }

    public static void main(String[] args) {
        Review test = new Review(new User(), "Fantastic place!", 4);
        System.out.println(test);
    }
}
