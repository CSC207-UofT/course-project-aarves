package com.aarves.bluepages.usecase.interactors.account;

/**
 * Interface for outputting account related information to UI.
 */
public interface AccountOutputBoundary {
    /**
     * Displays message based on the result of the user's login.
     * @param result the result of the login based on the information for username/password submitted by the user
     * @param username the username of the user
     */
    void loginResult(LoginResult result, String username);

    /**
     * Displays message based on the result of the user's registration.
     * @param result the result of the registration based on the user's inputted username/password
     */
    void registerResult(RegisterResult result);

    /**
     * Displays the logout message to the user.
     */
    void displayLogout();

    /**
     * Displays a user's their username.
     * @param username the username of the user
     */
    void displayInformation(String username);
}
