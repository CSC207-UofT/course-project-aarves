/*
 * This file contains JUnit test cases for BagMainTest.java and the
 * methods from the other Bag classes.
 *
 * You should NOT modify this file! When you push Basics.java to
 * GitHub, it should run these tests. You can see the results in the
 * "Actions" tab of your repository.
 */

import org.junit.*;

import static org.junit.Assert.*;

public class ExampleTest {
    AccountCreator ac;

    @Before
    public void setUp() throws Exception {
        ac = new AccountCreator();
    }

    @Test(timeout = 50)
    public void TestEnhanceBagsTrue() {
        assertTrue(ac instanceof AccountCreator);
    }
}