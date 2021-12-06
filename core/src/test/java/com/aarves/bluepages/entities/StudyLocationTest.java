package com.aarves.bluepages.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyLocationTest {

    StudyLocation sl = new StudyLocation(1,"Robarts Library", new double[]{43.664486, -79.399689});

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        assertEquals(1, sl.getLocationId());
    }

    @Test
    void getName() {
        assertEquals("Robarts Library", sl.getName());
    }

    @Test
    void getCoordinates() {
        double[] expected = new double[]{43.664486, -79.399689};
        double[] actual = sl.getCoordinates();
        assertArrayEquals(expected, actual);
    }
}