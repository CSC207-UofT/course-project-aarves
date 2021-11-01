public class AccountManager {

    private static final AccountList accounts = new AccountList();

    /**
     * Checks and returns if the account already exists.
     *
     * @param username the username of the user
     * @return true if the account already exists in accounts
     */
    public boolean isExistingAccount(String username){
        RegisteredUser existing = accounts.getUser(username);
        if (existing != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the RegisteredUser associated with the account
     *
     * @param username the RegisteredUser's username
     * @return the RegisteredUser associated with the account
     */
    public RegisteredUser getUser(String username) {
        return accounts.getUser(username);
    }

    /**
     * Adds a RegisteredUser to the AccountManager. An existing username will never be passed in.
     *
     * @param username the user's username
     * @param password the user's password
     */
    public void addUser(String username, String password){
        RegisteredUser user = new RegisteredUser(username.toLowerCase(), password);
        accounts.addUser(user);
    }

    /**
     * Deletes a user from the AccountManager and deletes all their reviews.
     *
     * @param user The user to be deleted.
     * @param rm The system's ReviewManager.
     */
    public void deleteUser(RegisteredUser user, ReviewManager rm) {
        rm.deleteAllUserReviews(user);
        accounts.deleteUser(user);
    }

    /**
     * Returns whether the login was successful.
     *
     * @param username the user's inputted username
     * @param password the user's inputted password
     * @return true if the user's username and password matches the pairing in accounts.
     */
    public boolean correctLogin(String username, String password){
        if (accounts.getUser(username) != null) {
            return accounts.getUser(username).isCorrectPassword(password);
        }
        return false;
    }

}