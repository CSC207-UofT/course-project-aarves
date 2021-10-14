public class AccountCreator {

    /**
     * Checks if the given account already exists, if not a new account will be created
     *
     * @param manager An AccountManager
     * @param username A User's username
     * @param password A User's password
     * @return true if a new account has been created, false otherwise
     */
    public boolean createAccount(AccountManager manager, String username, String password) {
        if (manager.isExistingAccount(username)) {
            return false;
        }
        else {
            manager.addUser(username, password);
            return true;
        }
    }
}
