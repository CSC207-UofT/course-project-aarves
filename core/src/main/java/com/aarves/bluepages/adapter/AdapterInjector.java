package com.aarves.bluepages.adapter;

import com.aarves.bluepages.adapter.controllers.AccountController;
import com.aarves.bluepages.adapter.controllers.LocationController;
import com.aarves.bluepages.adapter.controllers.ReviewController;
import com.aarves.bluepages.adapter.presenters.*;

import com.aarves.bluepages.usecase.data.account.AccountDAO;
import com.aarves.bluepages.usecase.data.location.LocationDAO;
import com.aarves.bluepages.usecase.data.review.ReviewDAO;

import com.aarves.bluepages.usecase.interactors.account.AccountManager;
import com.aarves.bluepages.usecase.interactors.account.AccountUseCaseInjector;
import com.aarves.bluepages.usecase.interactors.location.BookmarkManager;
import com.aarves.bluepages.usecase.interactors.location.LocationMap;
import com.aarves.bluepages.usecase.interactors.location.LocationUseCaseInjector;
import com.aarves.bluepages.usecase.interactors.review.ReviewManager;
import com.aarves.bluepages.usecase.interactors.review.ReviewUseCaseInjector;

import java.security.NoSuchAlgorithmException;

/**
 * The injector class for all dependencies on the interface adapters layer.
 */
public class AdapterInjector {
    private final AccountController accountController;
    private final AccountPresenter accountPresenter;
    private final LocationController locationController;
    private final LocationPresenter locationPresenter;
    private final ReviewController reviewController;
    private final ReviewPresenter reviewPresenter;

    public AdapterInjector(AccountDAO accountDAO, LocationDAO locationDAO, ReviewDAO reviewDAO) throws NoSuchAlgorithmException {
        // Creates output boundaries / presenters
        this.accountPresenter = new AccountPresenter();
        this.locationPresenter = new LocationPresenter();
        this.reviewPresenter = new ReviewPresenter();

        // Injects into the domain injectors
        AccountUseCaseInjector accountInjector = new AccountUseCaseInjector(accountDAO, this.accountPresenter);
        LocationUseCaseInjector locationInjector = new LocationUseCaseInjector(locationDAO, this.locationPresenter);
        ReviewUseCaseInjector reviewInjector = new ReviewUseCaseInjector(reviewDAO, this.reviewPresenter);

        // Retrieves input boundaries from the domain injectors
        AccountManager accountManager = accountInjector.getAccountManager();
        BookmarkManager bookmarkManager = locationInjector.getBookmarkManager();
        LocationMap locationMap = locationInjector.getLocationMap();
        ReviewManager reviewManager = reviewInjector.getReviewManager();

        // Injects observers for observer design pattern
        accountManager.addObserver(bookmarkManager);
        accountManager.addObserver(reviewManager);

        // Injects input boundaries into the controllers
        this.accountController = new AccountController(accountManager);
        this.locationController = new LocationController(bookmarkManager, locationMap, reviewManager);
        this.reviewController = new ReviewController(reviewManager);
    }

    public AccountController getAccountController() {
        return this.accountController;
    }

    public void setAccountView(AccountView accountView) {
        this.accountPresenter.setAccountView(accountView);
    }

    public void setAccountMenuView(AccountMenuView accountMenuView) {
        this.accountPresenter.setAccountMenuView(accountMenuView);
    }

    public LocationController getLocationController() {
        return this.locationController;
    }

    public void setLocationView(LocationView locationView) {
        this.locationPresenter.setLocationView(locationView);
    }

    public ReviewController getReviewController() {
        return this.reviewController;
    }

    public void setReviewView(ReviewView reviewView) {
        this.reviewPresenter.setReviewView(reviewView);
    }

    public void setReviewBaseView(BasicView baseView) {
        this.reviewPresenter.setBaseView(baseView);
    }
}
