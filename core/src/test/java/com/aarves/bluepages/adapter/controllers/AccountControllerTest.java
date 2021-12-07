package com.aarves.bluepages.adapter.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class AccountControllerTest {
    private AccountInputMockup accountInput;
    private AccountController accountController;

    @BeforeEach
    public void setUp() {
        this.accountInput = new AccountInputMockup();
        this.accountController = new AccountController(this.accountInput);
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testLoginUsername() {
        String username = "username";
        String password = "password";

        this.accountController.login(username, password);
        Assertions.assertEquals(username, this.accountInput.getUsername());
    }

    @Test
    public void testLoginPassword() {
        String username = "username";
        String password = "password";

        this.accountController.login(username, password);
        Assertions.assertEquals(password, this.accountInput.getPassword());
    }

    @Test
    public void testLoggedIn() {
        String username = "username";
        String password = "password";

        this.accountController.login(username, password);
        Assertions.assertTrue(this.accountInput.isLoggedIn());
    }

    @Test
    public void testNotLoggedIn() {
        Assertions.assertFalse(this.accountInput.isLoggedIn());
    }

    @Test
    public void testIsLoggedIn() {
        this.accountController.login("username", "pass");
        this.accountController.isLoggedIn();
        Assertions.assertTrue(this.accountInput.isLoggedIn());
    }

    @Test
    public void testLogout() {
        this.accountController.logout();
        Assertions.assertFalse(this.accountInput.isLoggedIn());
    }

    @Test
    public void testRegister() {
        this.accountController.register("username", "pass", "pass");
        Assertions.assertEquals(this.accountInput.getUsername(), "username");
    }

    @Test
    public void testRegisterActivity() {
        this.accountController.register("username", "pass", "pass");
        Assertions.assertFalse(this.accountInput.isLoggedIn());
    }

    @Test
    public void testLoadAccInfo() {
        this.accountController.loadAccountInformation();
        Assertions.assertTrue(this.accountInput.isLoaded());
    }


}
