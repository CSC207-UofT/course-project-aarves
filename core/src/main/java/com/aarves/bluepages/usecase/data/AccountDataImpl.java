package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.entities.User;
import com.aarves.bluepages.usecase.interactors.AccountData;
import com.aarves.bluepages.usecase.interactors.LoginFailureException;
import com.aarves.bluepages.usecase.interactors.ReviewRepository;

public class AccountDataImpl implements AccountData {
    private AccountDAO accountDAO;
    private ReviewRepository reviewRepository;

    public AccountDataImpl(AccountDAO accountDAO, ReviewRepository reviewRepository) {
        this.accountDAO = accountDAO;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void addAccount(User user) {
        this.accountDAO.addAccount(user.getUsername(), user.getPasswordHash());
    }

    @Override
    public void deleteAccount(User user) {
        this.accountDAO.deleteAccount(user.getUsername(), user.getPasswordHash());
    }

    @Override
    public User getAccount(String username, String passwordHash) throws LoginFailureException {
        if(this.isPasswordMatch(username, passwordHash)) {
            User user = new User(username, passwordHash);
            user.setReviews(this.reviewRepository.getReviewsByUser(user));

            return user;
        }
        else {
            throw new LoginFailureException();
        }
    }

    @Override
    public boolean isExistingAccount(String username) {
        return this.accountDAO.isExistingAccount(username);
    }

    @Override
    public boolean isPasswordMatch(String username, String passwordHash) {
        return this.accountDAO.isPasswordMatch(username, passwordHash);
    }
}