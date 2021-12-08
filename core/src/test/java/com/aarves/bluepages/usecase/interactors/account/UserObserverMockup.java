package com.aarves.bluepages.usecase.interactors.account;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.Observer;

public class UserObserverMockup implements Observer<User> {

    boolean updated;

    public void update(User arg) {
        this.updated = true;
    }
}
