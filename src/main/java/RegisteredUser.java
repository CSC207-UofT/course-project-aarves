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

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void deleteReview(Review review) {
        this.reviews.remove(review);
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

    public void viewBookmarks() {
        for (Location location : this.bookmarks) {
            System.out.println(location);
        }
    }

    public static void main(String[] args) {
        RegisteredUser u1 = new RegisteredUser("javalover", "nevercpp");
        RegisteredUser u2 = new RegisteredUser("hogwartsscholar", "hairypotty");

        ArrayList<Review> reviewList = new ArrayList<>();
        StudyLocation robarts = new StudyLocation("", "", true, true);
        StudyLocation gerstein = new StudyLocation( "", "", true, true);
        StudyLocation koffler = new StudyLocation( "", "", true, true);

        u1.viewReviews();

    }

}
