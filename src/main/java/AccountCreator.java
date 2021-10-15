public class AccountCreator {

    /**
     * Checks if the given account already exists, if not a new account will be created
     *
     * @param manager An AccountManager
     * @param username A User's username
     * @param password A User's password
     */
    public void createAccount(AccountManager manager, String username, String password) {
        manager.addUser(username, password);
    }
}
