package com.aarves.bluepages.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodLocationTest {

    FoodLocation fl = new FoodLocation("9-12", "Popeyes", "267 College Street",
            new double[]{43.841970401 - 79.39117270}, "Fast Food", true, true, "6-30");

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void isDineIn() {
        assertTrue(fl.isDineIn());
    }

    @Test
    void isTakeout() {
        assertTrue(fl.isTakeout());
    }

    @Test
    void getFoodType() {
        assertEquals("Fast Food" ,fl.getFoodType());
    }

    @Test
    void getPriceRange() {
        assertEquals("6-30", fl.getPriceRange());
    }

    @Test
    void testToString() {
        assertEquals("Popeyes" + "\n Address: 267 College Street" + "\n Hours of Service: 9-12" +
                "\n Food Type: Fast Food" + "\n dine-in: true" + "\n takeout: true" + "\n Price Range: 6-30",
                fl.toString());

    }
}