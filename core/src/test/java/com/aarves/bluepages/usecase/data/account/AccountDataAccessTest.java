package com.aarves.bluepages.usecase.data.account;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountDataAccessTest {

    AccountDAOMockup accountDAOMockup;
    AccountDataAccess accountDataAccess;

    @BeforeEach
    void setUp() {
        accountDAOMockup = new AccountDAOMockup();
        accountDataAccess = new AccountDataAccess(accountDAOMockup);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAccount() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        accountDataAccess.addAccount(new_user);

        assertTrue(accountDAOMockup.isExistingAccount("Natsyy"));
    }

    @Test
    void deleteAccount() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        accountDataAccess.addAccount(new_user);
        accountDataAccess.deleteAccount(new_user);

        assertFalse(accountDAOMockup.isExistingAccount("Natsyy"));
    }

    @Test
    void getUserAccountNull() {
        try {
            accountDataAccess.getUserAccount("Natsyy", "M$a%tB1rya*i");
            assertNull(accountDataAccess.getUserAccount("Natsyy", "M$a%tB1rya*i"));
        }
        catch(PermissionsFailureException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void getUserAccount() {
        try {
            User new_user = new User("Natsyy", "M$a%tB1rya*i");
            accountDataAccess.addAccount(new_user);

            assertSame(new_user.getUsername(), accountDataAccess.getUserAccount("Natsyy",
                    "M$a%tB1rya*i").getUsername());

        }
        catch(PermissionsFailureException exception) {
            exception.printStackTrace();
        }
    }


    @Test
    void isExistingAccount() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        accountDataAccess.addAccount(new_user);

        assertTrue(accountDataAccess.isExistingAccount("Natsyy"));
    }

    @Test
    void isPasswordMatch() {
        User new_user = new User("Natsyy", "M$a%tB1rya*i");
        accountDataAccess.addAccount(new_user);

        assertTrue(accountDataAccess.isPasswordMatch("Natsyy", "M$a%tB1rya*i"));
    }
}