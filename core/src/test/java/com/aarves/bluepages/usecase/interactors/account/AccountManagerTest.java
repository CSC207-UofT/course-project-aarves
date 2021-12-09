package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.adapter.controllers.AccountInputMockup;
import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.Observer;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputBoundary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {

    AccountManager accountManager;
    AccountInputMockup accountInputMockup;
    UserObserverMockup observerMockup;
    AccountOutputBoundaryMockup accountOutputBoundary;
    AccountDataBoundaryMockup accountDataBoundary;


    @BeforeEach
    void setUp() {
        accountDataBoundary = new AccountDataBoundaryMockup();
        accountOutputBoundary = new AccountOutputBoundaryMockup();

        try {
            accountManager = new AccountManager(accountDataBoundary, accountOutputBoundary);
        }
        catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        accountInputMockup = new AccountInputMockup();
        observerMockup = new UserObserverMockup();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isLoggedIn() {
        accountManager.register("MuizOnNesquik", "AWF1000", "AWF1000");
        accountManager.login("MuizOnNesquik", "AWF1000");
        assertTrue(accountManager.isLoggedIn());
    }

    @Test
    void login() {
        accountManager.login("KELA", "BaaPAyA");
        assertSame(accountOutputBoundary.getLoginResult(), LoginResult.ACCOUNT_NOT_FOUND);

    }

    @Test
    void logout() {
        accountManager.login("KELA", "BaaPAyA");
        accountManager.logout();
        assertNull(accountManager.getUser());
    }

    @Test
    void registerAlreadyExists() {
        User user = new User("user", "pass");
        accountDataBoundary.addAccount(user);


    }

    @Test
    void registerPassMismatch() {
        User user = new User("user", "pass");
        accountDataBoundary.addAccount(user);


    }

    @Test
    void registerBadUsername() {
        User user = new User("user", "pass");
        accountDataBoundary.addAccount(user);


    }

    @Test
    void registerSuccess() {
        User user = new User("user", "pass");
        accountDataBoundary.addAccount(user);


    }

    @Test
    void loadInformation() {
    }

    @Test
    void addObserver() {
    }

    @Test
    void deleteObserver() {
    }

    @Test
    void clearObservers() {
    }

    @Test
    void notifyObservers() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void isExistingAccount() {
    }

    @Test
    void getUser() {
    }
}