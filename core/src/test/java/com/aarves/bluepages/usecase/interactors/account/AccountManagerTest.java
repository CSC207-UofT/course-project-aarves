package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.adapter.controllers.AccountInputMockup;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
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
    void register() {
        accountManager.register("MuizOnNesquik", "AWF1000", "AWF1000");
        assertSame(accountOutputBoundary.getRegisterResult(), RegisterResult.SUCCESS);
    }

    @Test
    void loadInformation() {
        accountManager.register("KELA", "BaaPAyA", "BaaPAyA");
        accountManager.login("KELA", "BaaPAyA");
        accountOutputBoundary.displayInformation("KELA");
        assertTrue(accountOutputBoundary.isDisplayInformation);
    }

    @Test
    void deleteUser() {
        accountManager.register("MuizOnNesquik", "AWF1000", "AWF1000");
        accountManager.login("MuizOnNesquik", "AWF1000");
        accountManager.deleteUser();
        assertNull(accountManager.getUser());
    }

    @Test
    void isExistingAccount() {
        accountManager.register("MuizOnNesquik", "AWF1000", "AWF1000");
        boolean result = accountManager.isExistingAccount("MuizOnNesquik");
        assertTrue(result);
    }

    @Test
    void getUser() {
        accountManager.register("NainuNoob", "TMPxkabot", "TMPxkabot");
        accountManager.login("NainuNoob", "TMPxkabot");
        User u = accountDataBoundary.getUserAccount("NainuNoob", "TMPxkabot");
        assertTrue(accountManager.getUser() == u);
    }
}