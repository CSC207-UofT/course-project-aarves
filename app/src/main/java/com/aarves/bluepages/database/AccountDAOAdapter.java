package com.aarves.bluepages.database;

import com.aarves.bluepages.database.access.AccountDatabaseDAO;
import com.aarves.bluepages.database.models.AccountDataEntity;
import com.aarves.bluepages.usecase.data.account.AccountDAO;

import java.util.ArrayList;

/**
 * Adapter between the account data access object implemented by Room and the account data access object used by
 * the data access in the use cases layer.
 */
public class AccountDAOAdapter implements AccountDAO {
    private final AccountDatabaseDAO accountDatabaseDAO;

    /**
     * Constructs an account adapter with the Room accounts data access dependency.
     * @param accountDatabaseDAO the Room data access object for the accounts table
     */
    public AccountDAOAdapter(AccountDatabaseDAO accountDatabaseDAO) {
        this.accountDatabaseDAO = accountDatabaseDAO;
    }

    /**
     * Adds a new account to the database using the Room data access dependency.
     * @param username the username of the new account
     * @param passwordHash the hashed password of the new account
     */
    @Override
    public void addAccount(String username, String passwordHash) {
        // Creates new Room data entity for the account with no bookmarks
        AccountDataEntity accountDataEntity = new AccountDataEntity(username, passwordHash, new ArrayList<>());
        // Inserts data entity into accounts table
        this.accountDatabaseDAO.insert(accountDataEntity);
    }

    /**
     * Deletes account from the database using the Room data access dependency.
     * @param username the username of the account to be deleted
     * @param passwordHash the hashed password of the account to be deleted
     */
    @Override
    public void deleteAccount(String username, String passwordHash) {
        // Retrieves account with given username
        AccountDataEntity accountDataEntity = accountDatabaseDAO.getByUsername(username);

        // If account exists and password hashes match, then delete from accounts table
        if(accountDataEntity != null && accountDataEntity.passwordHash.equals(passwordHash)){
            this.accountDatabaseDAO.delete(accountDataEntity);
        }
    }

    /**
     * Returns whether account with given username exists using Room data access dependency.
     * @param username the username to be checked
     * @return whether account with given username exists
     */
    @Override
    public boolean isExistingAccount(String username) {
        // Retrieves account and checks if exists
        AccountDataEntity accountDataEntity = accountDatabaseDAO.getByUsername(username);
        return accountDataEntity != null;
    }

    /**
     * Returns whether password hash matches with that of account with given username using Room data access dependency.
     * @param username the username of the account to be compared with
     * @param passwordHash the password hash to be compared
     * @return whether password hash matches
     */
    @Override
    public boolean isPasswordMatch(String username, String passwordHash) {
        String accountPasswordHash = accountDatabaseDAO.getPasswordHash(username);
        return passwordHash.equals(accountPasswordHash);
    }
}
