public class InputGateway implements AccountManagerDependency{

    AccountManager am;

    public RegisteredUser getUser(String username) {
        return this.am.getUser(username);
    }

    public String getBookmarks(RegisteredUser user) {
        if (user.getBookmarks().equals("")) {
            return "You have zero (0) bookmarks.";
        } else {
            return "Your bookmarks are: " + user.getBookmarks();
        }
    }

    @Override
    public void injectAccountManager(AccountManager am) {
        this.am = am;
    }
}
