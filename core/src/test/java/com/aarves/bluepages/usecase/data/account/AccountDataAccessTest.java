package com.aarves.bluepages.usecase.data.account;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.review.ReviewRepositoryMockup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDataAccessTest {

    AccountDAOMockup ao;
    AccountDataAccess ada;

    @BeforeEach
    void setUp() {
        ada = new AccountDataAccess(ao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAccount() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        ada.addAccount(new_user);

        assertTrue(ao.isExistingAccount("Natsyy"));
    }

    @Test
    void deleteAccount() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        ada.addAccount(new_user);
        ada.deleteAccount(new_user);

        assertFalse(ao.isExistingAccount("Natsyy"));
    }

    @Test
    void getUserAccount() {
        // ada.getUserAccount("Natsyy", "$$%%^&8");
    }

    @Test
    void isExistingAccount() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        ada.addAccount(new_user);

        assertTrue(ada.isExistingAccount("Natsyy"));
    }

    @Test
    void isPasswordMatch() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        ada.addAccount(new_user);

        assertTrue(ada.isPasswordMatch("Natsyy", "M$a%tB1rya*i"));
    }
}