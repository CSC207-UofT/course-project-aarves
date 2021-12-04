package com.aarves.bluepages.usecase.data;

import com.aarves.bluepages.usecase.interactors.account.AccountDataBoundary;
import com.aarves.bluepages.usecase.interactors.review.ReviewRepository;
import com.aarves.bluepages.usecase.exceptions.PermissionsFailureException;
import com.aarves.bluepages.entities.User;

public class AccountDataAccess implements AccountDataBoundary {
    private final AccountDAO accountDAO;
    private final ReviewRepository reviewRepository;

    public AccountDataAccess(AccountDAO accountDAO, ReviewRepository reviewRepository) {
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
    public User getUserAccount(String username, String passwordHash) throws PermissionsFailureException {
        if(!this.isExistingAccount(username)) {
            return null;
        }

        if(this.isPasswordMatch(username, passwordHash)) {
            User user = new User(username, passwordHash);
            user.setReviews(this.reviewRepository.getReviewsByUser(user));

            return user;
        }
        else {
            throw new PermissionsFailureException();
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
