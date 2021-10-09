import org.junit.*;

import static org.junit.Assert.*;

public class ExampleTest {
    AccountCreator ac;

    @Before
    public void setUp() throws Exception {
        ac = new AccountCreator();
    }

    @Test(timeout = 50)
    public void TestExample() {
        assertTrue(ac instanceof AccountCreator);
    }
}