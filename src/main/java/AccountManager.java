import java.util.HashMap;
import java.util.Locale;

public class AccountManager {

    HashMap<String, RegisteredUser> accounts = new HashMap<>();

    /**
     * Checks and returns if the account already exists.
     *
     * @param username the username of the user
     * @return true if the account already exists in accounts
     */
    public boolean isExistingAccount(String username){
        return accounts.containsKey(username.toLowerCase());
    }

    /**
     * Returns the RegisteredUser associated with the account
     *
     * @param username the RegisteredUser's username
     * @return the RegisteredUser associated with the account
     */
    public RegisteredUser getUser(String username) {
        return accounts.get(username);
    }

    /**
     * Adds a RegisteredUser to the AccountManager. An existing username will never be passed in.
     *
     * @param username the user's username
     * @param password the user's password
     */
    public void addUser(String username, String password){
        accounts.put(username.toLowerCase(), new RegisteredUser(username, password));
    }

    /**
     * Deletes a user from the AccountManager and deletes all their reviews.
     *
     * @param user The user to be deleted.
     * @param rm The system's ReviewManager.
     */
    public void deleteUser(RegisteredUser user, ReviewManager rm) {
        rm.deleteAllUserReviews(user);
        accounts.remove(user.getUsername());
    }

    /**
     * Returns whether the login was successful.
     *
     * @param username the user's inputted username
     * @param password the user's inputted password
     * @return true if the user's username and password matches the pairing in accounts.
     */
    public boolean correctLogin(String username, String password){
        if (accounts.get(username) != null) {
            String storedPassword = accounts.get(username).getPassword();
            return storedPassword.equals(password);
        }
        return false;
    }

}