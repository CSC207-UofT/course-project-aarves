package com.aarves.bluepages.usecase.interactors.account;

/**
 * Interface for inputting account related data to use cases.
 */
public interface AccountInputBoundary {
    /**
     * Returns whether the account is logged in.
     * @return true if the account is logged in, false otherwise.
     */
    boolean isLoggedIn();

    /**
     * Logs the user into the program.
     * @param username the username of the user to be logged in
     * @param password the password of the user to be logged in
     */
    void login(String username, String password);

    /**
     * Logs the user out of the program
     */
    void logout();

    /**
     * Registers the user to Bluepages
     * @param username the username to be registered
     * @param password the password of the user to be registered
     * @param confirmPassword the password typed again, of the user to be registered
     */
    void register(String username, String password, String confirmPassword);

    /**
     * Loads the account information of the user.
     */
    void loadInformation();
}