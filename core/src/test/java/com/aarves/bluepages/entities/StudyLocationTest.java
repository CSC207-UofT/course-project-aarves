package com.aarves.bluepages.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyLocationTest {

    StudyLocation sl = new StudyLocation("6-9", "Robarts Library", "130 St George St",
            new double[]{43.664486, -79.399689}, true, true);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isIndoors() {
        assertTrue(sl.isIndoors());
    }

    @Test
    void isQuiet() {
        assertTrue(sl.isQuiet());
    }

    @Test
    void testToString() {
        assertEquals("Robarts Library" + "\n Address: 130 St George St" + "\n Hours of Service: 6-9"
                + "\n Indoors: true" + "\n Quiet: true", sl.toString());
    }
}