import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {

    AccountManager am = new AccountManager();
    ReviewManager rm = new ReviewManager();
    Location robartsPizza = new FoodLocation("11am-11pm", "Robarts",
            "pizza", true, true, "$5-7");

    @BeforeEach
    public void setUp() {
        am.addUser("greekboi", "abcdefgh");
        am.addUser("rebplane", "luwnehctik");
        am.addUser("chayos", "chay123os");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddUser() {
        am.addUser("souvlaki53", "foodtruck");
        assertEquals(true, am.accounts.containsKey("souvlaki53"));
    }

    @Test
    public void testDeleteUser() {
        am.addUser("deleteme", "sure,ok!!!");
        am.deleteUser(am.accounts.get("deleteme"), rm);
        assertEquals(false, am.accounts.containsKey("deleteme"));
    }

    @Test
    public void testIsExistingAccount() {
        Boolean existing = am.isExistingAccount("greekboi");
        assertEquals(false, existing);
    }

    @Test
    public void testCorrectLogin() {
        Boolean correct = am.correctLogin("rebplane", "luwnehctik");
        assertEquals(true, correct);
    }

    @Test
    public void testCorrectLoginIncorrect() {
        Boolean correct = am.correctLogin("greekboi", "123abc");
        assertEquals(false, correct);
    }

}