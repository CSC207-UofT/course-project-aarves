package com.aarves.bluepages.entities;

import java.util.ArrayList;

public class RegisteredUser extends User {
    private final ArrayList<Review> reviews = new ArrayList<>();
    private final ArrayList<Location> bookmarks = new ArrayList<>();
    private final String username;
    private final String password;

    /**
     * Constructs a new RegisteredUser, given a username and a password.
     * @param username  String containing the username.
     * @param password  String containing the password.
     */
    public RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Return the username associated with this RegisteredUser.
     * @return  String containing the username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Return whether the password matches the user's password.
     *
     * @param password the password guess
     * @return true if the password matches the user's password
     */
    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Return all the reviews made by this RegisteredUser.
     * @return  ArrayList of reviews (object Review).
     */
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    /**
     * Add a Review to the RegisteredUser.
     * @param review    Review created by the RegisteredUser.
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Removes a Review from the RegisteredUser.
     * @param review    Review to-be-removed from the RegisteredUser.
     */
    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    // TODO: method viewReviews elsewhere in the code (can't be here, or we'd have clean architecture violation)

    /**
     * Add a Location to the RegisteredUser's bookmarked locations.
     * @param loc   Location to-be-bookmarked.
     */
    public boolean addBookmark(Location loc) {
        if (this.bookmarks.contains(loc)) {
            return false;
        }
        else {
            this.bookmarks.add(loc);
            return true;
        }
    }

    /**
     * Removes a Location from the RegisteredUser's bookmarked locations.
     * @param loc   Location to-be-removed from the bookmarks.
     */
    public void deleteBookmark(Location loc) {
        this.bookmarks.remove(loc);
    }

    /**
     * Displays all bookmarks for this RegisteredUser.
     */
    public void viewBookmarks() {
        for (Location location : this.bookmarks) {
            System.out.println(location);
        }
    }

    public String getBookmarks() {
        String result = "";
        for (Location location : this.bookmarks) {
            result += location.getName() + ",";
        }
        return result;
    }
}
