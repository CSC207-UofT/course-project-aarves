public class AccountCreator {

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
