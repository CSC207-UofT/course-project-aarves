import java.util.ArrayList;

public class RegisteredUser extends User {
    private ArrayList<Review> reviews;
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

    // TODO: add review to location
    public void addReview(String review, int rating) {
        reviews.add(new Review(this, review, rating));
    }

    // TODO: add review to location
    // TODO: should reviews have an identifier to be able to delete the reviews?
    public void deleteReview(String review, int rating) {

    }

    // TODO: this needs to output something
    public void viewReviews() {

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


}
