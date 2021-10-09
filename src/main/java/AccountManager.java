import java.util.HashMap;
public class AccountManager {

    HashMap<String, RegisteredUser> accounts = new HashMap<>();
    public boolean isExistingAccount(String username){
        return accounts.containsKey(username);
    }

    public void addUser(String username, String password){
        accounts.put(username, new RegisteredUser(username, password));
    }

    public void deleteUser(String username) {
        accounts.remove(username);
    }

    public boolean correctLogin(String username, String password){
        String storedpassword = accounts.get(username).getPassword();
        return storedpassword.equals(password);
    }

}