package com.aarves.bluepages.usecase.exceptions;

/**
 * An exception thrown when the user is not logged in, but attempting to perform action which requires an account.
 */
public class NotLoggedInException extends Exception {
    public NotLoggedInException() {
        super("User is not logged on!");
    }
}
