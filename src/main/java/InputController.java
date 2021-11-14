public class InputController implements AccountManagerDependency{

    AccountManager am;

    /**
     * 1 --> Login
     * 2 --> Register
     * 3 --> Guest
     * @param accessType
     */
    public int userAccessType(String accessType) {
        // Check if the input is valid
        switch (accessType) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            default:
                return 0;
        }
    }

    public boolean createUser(String username, String password) {
        // Create user
        if (!this.am.isExistingAccount(username)) {
            this.am.addUser(username, password);
            return true;
        } else {
            return false;
        }
    }

    public int userBookmarks(String bookmarkChoice) {
        switch (bookmarkChoice) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            default:
                return 0;
        }
    }

    @Override
    public void injectAccountManager(AccountManager am) {
        this.am = am;
    }
}
