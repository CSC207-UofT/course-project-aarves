package com.aarves.core.usecases;

import com.aarves.core.entities.RegisteredUser;

public class InputGateway {

    AccountManager am = new AccountManager();

    /**
     * Return a RegisteredUser associated with the given username.
     * @param username A String representing the username of a RegisteredUser.
     * @return A RegisteredUser with the inputted String as their username.
     */
    public RegisteredUser getUser(String username) {
        return am.getUser(username);
    }

    /**
     * Return a String representation of all the bookmarks belonging to user.
     * @param user A RegisteredUser to pull bookmarks from.
     * @return A String showing the bookmarks that user has.
     */
    public String getBookmarks(RegisteredUser user) {
        if (user.getBookmarks().equals("")) {
            return "You have zero (0) bookmarks.";
        } else {
            return "Your bookmarks are: " + user.getBookmarks();
        }
    }
}
