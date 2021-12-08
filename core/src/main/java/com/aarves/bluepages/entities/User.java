package com.aarves.bluepages.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Review> reviews;
    private final List<Location> bookmarks;

    private final String username;
    private String passwordHash;

    /**
     * Constructs a new User, given a username.
     * @param username  String containing the username.
     * @param passwordHash  String containing the password.
     */
    public User(String username, String passwordHash) {
        this.reviews = new ArrayList<>();
        this.bookmarks = new ArrayList<>();

        this.username = username;
        this.passwordHash = passwordHash;
    }

    /**
     * Return the username associated with this User.
     * @return  String containing the username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Get the password hash for this user's password.
     * @return The password hash associated with the user.
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * Set the password hash for this user's password.
     * @param passwordHash String representing the hash.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Return all the reviews made by this User.
     * @return  ArrayList of Review's.
     */
    public List<Review> getReviews() {
        return this.reviews;
    }

    /**
     * Clear all the reviews made by this User.
     */
    public void clearReviews() {
        this.reviews.clear();
    }

    /**
     * Add a Review to the User.
     * @param review    Review created by the User.
     */
    public void addReview(Review review) {
        if (!this.reviews.contains(review)) {
            this.reviews.add(review);
        }
    }

    /**
     * Removes a Review from the User.
     * @param review    Review to-be-removed from the User.
     */
    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    /**
     * Returns all bookmarks for this User.
     * @return  ArrayList of Location's.
     */
    public List<Location> getBookmarks() {
        return this.bookmarks;
    }

    /**
     * Add a Location to the User's bookmarked locations.
     * @param location   Location to-be-bookmarked.
     */
    public void addBookmark(Location location) {
        if (!this.bookmarks.contains(location)) {
            this.bookmarks.add(location);
        }
    }

    /**
     * Removes a Location from the User's bookmarked locations.
     * @param location   Location to-be-removed from the bookmarks.
     */
    public void deleteBookmark(Location location) {
        this.bookmarks.remove(location);
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof User) {
            return this.username.equals(((User) other).getUsername());
        }
        else {
            return false;
        }
    }

}
