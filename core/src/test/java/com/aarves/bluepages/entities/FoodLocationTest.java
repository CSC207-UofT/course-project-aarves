package com.aarves.bluepages.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodLocationTest {

    FoodLocation fl = new FoodLocation(100, "Popeyes", new double[]{43.841970401 - 79.39117270});

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void getId() {
        assertEquals(100, fl.getLocationId());
    }

    @Test
    void getName() {
        assertEquals("Popeyes", fl.getName());
    }

    @Test
    void getCoordinates() {
        double[] expected = new double[]{43.841970401 - 79.39117270};
        double[] actual = fl.getCoordinates();
        assertEquals(expected, actual);
    }
}