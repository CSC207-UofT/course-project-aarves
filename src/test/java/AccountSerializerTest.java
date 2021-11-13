import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AccountSerializerTest {

    AccountSerializer as = new AccountSerializer();
    AccountList ac = new AccountList();
    RegisteredUser u1 = new RegisteredUser("natsy", "testing");

    @BeforeEach
    public void setUp() {

        ac.addUser(u1);
    }

    @AfterEach
    public void tearDown() {
    }


    @Test
    void testLoadFile() throws IOException {
        as.saveToFile("src/test/java/testing.json", ac);
        AccountList ac2 = as.loadFile("src/test/java/testing.json");
        assertSame(ac, ac2);

    }
}