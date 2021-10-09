import java.util.ArrayList;

public class RegisteredUser extends User {
    private ArrayList<Review> reviews;
    private String username;
    private String password;

    public RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    /**
     * TODO: add review (needs to communicate with location storing reviews too)
     */

    /**
     * TODO: delete review (needs to communicate with location storing reviews too)
     */

    /**
     * TODO: view reviews
     */

    /**
     * TODO: add bookmark
     */


    /**
     * TODO: delete bookmarks
     */

    /**
     * TODO: view bookmarks
     */


}
