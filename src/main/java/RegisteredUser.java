import java.util.ArrayList;

public class RegisteredUser extends User {
    private ArrayList<Review> reviews = new ArrayList<>();
    private ArrayList<Location> bookmarks;
    private String username;
    private String password;

    public RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public ArrayList<Location> getBookmarks() {
        return this.bookmarks;
    }

    // TODO: add review to location
    public void addReview(Location location, String review, int rating) {
        reviews.add(new Review(this, location, review, rating));
    }

    // TODO: add review to location
    public void deleteReview(String review, int rating) {

    }

    public void viewReviews() {
        for (Review review: this.reviews) {
            System.out.println(review);
        }
    }

    public void addBookmark(Location loc) {
        this.bookmarks.add(loc);
    }

    public void deleteBookmark(Location loc) {
        this.bookmarks.remove(loc);
    }

     // TODO: Not sure if should keep output here, can move somewhere later.
     // TODO:Need Location subclasses done first though, to get their attributes.

    public void viewBookmarks() {

    }

    public static void main(String[] args) {
        RegisteredUser u1 = new RegisteredUser("javalover", "nevercpp");
        RegisteredUser u2 = new RegisteredUser("hogwartsscholar", "hairypotty");

        ArrayList<Review> reviewList = new ArrayList<>();
        StudyLocation robarts = new StudyLocation(reviewList, "", "", true, true);
        StudyLocation gerstein = new StudyLocation(reviewList, "", "", true, true);
        StudyLocation koffler = new StudyLocation(reviewList, "", "", true, true);

        u1.addReview(robarts, "Very quiet and productive, would love to go back!", 5);
        u1.addReview(gerstein, "Bottom of the barrel. Never go here...", 1);
        u1.addReview(koffler, "Good.", 3);

        u2.addReview(robarts, "Please open the full 5th floor", 1);
        u2.addReview(gerstein, "Not my cup of tea.", 2);
        u2.addReview(koffler, "Good study spot.", 4);

        u1.viewReviews();

    }

}
