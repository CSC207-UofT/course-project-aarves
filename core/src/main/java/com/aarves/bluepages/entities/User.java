package com.aarves.bluepages.entities;

import java.util.ArrayList;

public class User {
    private final ArrayList<Review> reviews;
    private final ArrayList<Location> bookmarks;

    private final String username;

    /**
     * Constructs a new User, given a username.
     * @param username  String containing the username.
     */
    public User(String username) {
        this.reviews = new ArrayList<>();
        this.bookmarks = new ArrayList<>();

        this.username = username;
    }

    /**
     * Return the username associated with this User.
     * @return  String containing the username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Return all the reviews made by this User.
     * @return  ArrayList of Review's.
     */
    public ArrayList<Review> getReviews() {
        return this.reviews;
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
    public ArrayList<Location> getBookmarks() {
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
}
