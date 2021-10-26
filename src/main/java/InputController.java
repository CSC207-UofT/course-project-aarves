public class InputController {

    AccountManager am = new AccountManager();

    /**
     * 1 --> Login
     * 2 --> Register
     * 3 --> Guest
     * @param accessType
     */
    public int userAccessType(String accessType) {
        // Check if the input is valid
        return switch (accessType) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            default -> 0;
        };
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
        return switch (bookmarkChoice) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            default -> 0;
        };
    }
}
