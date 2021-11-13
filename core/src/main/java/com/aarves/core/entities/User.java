package com.aarves.core.entities;

/**
 * Parent class for GuestUser and constructs a new User object that has an attribute isLoggedOn set
 * as false to indicate that the User is not logged in.
 *
 * This class does not take any parameters.
 */

public abstract class User {

    public boolean isLoggedOn;

    /*
     * Below we have defined the constructor for the abstract class User.
     * The constructor does not take arguments and does not return anything.
     * It tells us that the User is not logged on.
     */

    public User() {
        this.isLoggedOn = false;
    }

}