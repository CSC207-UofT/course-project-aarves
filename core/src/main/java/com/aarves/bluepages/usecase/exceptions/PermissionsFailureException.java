package com.aarves.bluepages.usecase.exceptions;

/**
 * An exception thrown when user attempts to have access to the private information of another account.
 */
public class PermissionsFailureException extends Exception {
    public PermissionsFailureException() {
        super("User has insufficient permissions!");
    }
}
