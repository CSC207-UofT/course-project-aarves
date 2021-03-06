package com.aarves.bluepages.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    // User object with a passwordHash mocking how actual hashing works.
    User u1 =  new User("natsyy", "*??##4578");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUsername() {
        assertEquals("natsyy", u1.getUsername());
    }

    @Test
    void getPasswordHash() {
        assertEquals("*??##4578", u1.getPasswordHash());
    }

    @Test
    void setPasswordHash() {
        u1.setPasswordHash("###---^^[A-Z]");
        assertEquals("###---^^[A-Z]", u1.getPasswordHash());
    }

    @Test
    void getReviews() {
        List<Review> emp = new ArrayList<>();
        assertEquals(emp, u1.getReviews());
    }

    @Test
    void setReviews() {
        Review r1 = new Review(1, "natsyy", 0, 5);
        r1.setBody("Amazing place to study!");
        u1.getReviews().add(r1);

        assertEquals(r1, u1.getReviews().get(0));
    }

    @Test
    void addReview() {
        Review r1 = new Review(1, "natsyy", 0, 5);
        r1.setBody("Amazing place to study!");
        u1.addReview(r1);

        assertEquals(r1, u1.getReviews().get(0));
    }

    @Test
    void deleteReview() {
        Review r1 = new Review(1, "natsyy", 0, 5);
        r1.setBody("Amazing place to study!");
        u1.addReview(r1);
        u1.deleteReview(r1);

        assertTrue(u1.getReviews().isEmpty());
    }

    @Test
    void getBookmarks() {
        List<Location> emp = new ArrayList<>();
        assertEquals(emp, u1.getBookmarks());
    }

    @Test
    void addBookmark() {
        FoodLocation fl = new FoodLocation(100, "Popeyes", new double[]{43.841970401 - 79.39117270});
        u1.addBookmark(fl);
        assertTrue(u1.getBookmarks().contains(fl));
    }

    @Test
    void deleteBookmark() {
        FoodLocation fl = new FoodLocation(100, "Popeyes", new double[]{43.841970401 - 79.39117270});
        u1.addBookmark(fl);
        u1.deleteBookmark(fl);

        assertTrue(u1.getBookmarks().isEmpty());
    }
}