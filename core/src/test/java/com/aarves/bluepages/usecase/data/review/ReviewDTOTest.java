package com.aarves.bluepages.usecase.data.review;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDTOTest {

    ReviewDTO rd;

    @BeforeEach
    void setUp() {

        rd = new ReviewDTO("Natsyy", 0, 5, "good food, great vibes");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getReviewer() {
        assertEquals("Natsyy", rd.getReviewer());
    }

    @Test
    void getLocationId() {
        assertEquals(0, rd.getLocationId());
    }

    @Test
    void getRating() {
        assertEquals(5, rd.getRating());
    }

    @Test
    void getBody() {
        assertEquals("good food, great vibes", rd.getBody());
    }
}