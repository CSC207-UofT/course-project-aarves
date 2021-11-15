package com.aarves.core.gateways;

import com.aarves.core.entities.RegisteredUser;
import com.aarves.core.usecases.AccountManager;

public class InputGateway {

    AccountManager am = new AccountManager();

    public RegisteredUser getUser(String username) {
        return am.getUser(username);
    }

    public String getBookmarks(RegisteredUser user) {
        if (user.getBookmarks().equals("")) {
            return "You have zero (0) bookmarks.";
        } else {
            return "Your bookmarks are: " + user.getBookmarks();
        }
    }
}
