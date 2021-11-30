package com.aarves.bluepages.adapter.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountControllerTest {
    AccountInputMockup accountInput;
    AccountController accountController;

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
        assertEquals(username, this.accountInput.getUsername());
    }

    @Test
    public void testLoginPassword() {
        String username = "username";
        String password = "password";

        this.accountController.login(username, password);
        assertEquals(password, this.accountInput.getPassword());
    }

    @Test
    public void testLoggedIn() {
        String username = "username";
        String password = "password";

        this.accountController.login(username, password);
        assertTrue(this.accountInput.isLoggedIn());
    }

    @Test
    public void testNotLoggedIn() {
        assertFalse(this.accountInput.isLoggedIn());
    }
}
