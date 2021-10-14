import java.util.ArrayList;

public class RegisteredUser extends User {
    private final ArrayList<Review> reviews = new ArrayList<>();
    private final ArrayList<Location> bookmarks = new ArrayList<>();
    private final String username;
    private final String password;

    /**
     * Constructs a new RegisteredUser, given a username and a password.
     * @param username  String containing the username.
     * @param password  String containing the password.
     */
    public RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Return the password associated with this RegisteredUser.
     * @return  String containing the password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Return the username associated with this RegisteredUser.
     * @return  String containing the username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Return all the reviews made by this RegisteredUser.
     * @return  ArrayList of reviews (object Review).
     */
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    /**
     * Return all the locations bookmarked by this RegisteredUser.
     * @return  ArrayList of locations (object Location).
     */
    public ArrayList<Location> getBookmarks() {
        return this.bookmarks;
    }

    /**
     * Add a Review to the RegisteredUser.
     * @param review    Review created by the RegisteredUser.
     */
    public void addReview(Review review) {
        this.reviews.add(review);
    }

    /**
     * Removes a Review from the RegisteredUser.
     * @param review    Review to-be-removed from the RegisteredUser.
     */
    public void deleteReview(Review review) {
        this.reviews.remove(review);
    }

    /**
     * Displays all reviews made by the RegisteredUser.
     */
    public void viewReviews() {
        for (Review review: this.reviews) {
            System.out.println(review);
        }
    }

    /**
     * Add a Location to the RegisteredUser's bookmarked locations.
     * @param loc   Location to-be-bookmarked.
     */
    public void addBookmark(Location loc) {
        this.bookmarks.add(loc);
    }

    /**
     * Removes a Location from the RegisteredUser's bookmarked locations.
     * @param loc   Location to-be-removed from the bookmarks.
     */
    public void deleteBookmark(Location loc) {
        this.bookmarks.remove(loc);
    }

    /**
     * Displays all of the bookmarks for this RegisteredUser.
     */
    public void viewBookmarks() {
        for (Location location : this.bookmarks) {
            System.out.println(location);
        }
    }
}
