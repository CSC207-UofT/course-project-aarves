package com.aarves.bluepages.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    Review r = new Review(1, "Natsyy", 0, 5);
    Review r2 = new Review("NatsyySon", 1, 0);

    @BeforeEach
    public void setUp() {
        r.setBody("Scrumptious food and amazing ambiance!");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void getReviewer() {
        assertEquals("Natsyy", r.getReviewer());
    }

    @Test
    void getLocationId() {
        assertEquals(0, r.getLocationId());
    }

    @Test
    void getRating() {
        assertEquals(5, r.getRating());
    }

    @Test
    void setRating() {
        r2.setRating(5);
        assertEquals(5, r2.getRating());
    }

    @Test
    void getBody() {
        assertEquals("Scrumptious food and amazing ambiance!",  r.getBody());
    }

    @Test
    void setBody() {
        r2.setBody("Had a misunderstanding and gave them a rating of 0 but the manager was extremely helpful and " +
                "sorted out everything so I changed my rating to 5");
        assertEquals("Had a misunderstanding and gave them a rating of 0 but the manager was extremely helpful and " +
                "sorted out everything so I changed my rating to 5", r2.getBody());
    }

    @Test
    void getReviewId() {
        assertEquals(1, r.getReviewId());
    }

    @Test
    void getDefaultReviewId() {
        assertEquals(0, r2.getReviewId());
    }
}