package com.aarves.bluepages.usecase.data.account;

/**
 * Interface for account data access object adapters.
 */
public interface AccountDAO {
    /**
     * Adds a new account from data source.
     * @param username the username of the new account
     * @param passwordHash the hashed password of the new account
     */
    void addAccount(String username, String passwordHash);

    /**
     * Deletes account from data source.
     * @param username the username of the account to be deleted
     * @param passwordHash the hashed password of the account to be deleted
     */
    void deleteAccount(String username, String passwordHash);

    /**
     * Returns whether account with given username exists.
     * @param username the username to be checked
     * @return whether account with given username exists
     */
    boolean isExistingAccount(String username);

    /**
     * Returns whether password hash matches with that of account with given username.
     * @param username the username of the account to be compared with
     * @param passwordHash the password hash to be compared
     * @return whether password hash matches
     */
    boolean isPasswordMatch(String username, String passwordHash);
}
