package com.aarves.bluepages.usecase.data.location;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aarves.bluepages.usecase.interactors.location.LocationType;

import static org.junit.jupiter.api.Assertions.*;

class LocationDTOTest {

    LocationDTO ld;
    double[] coordinates;

    @BeforeEach
    void setUp() {
        coordinates = new double[]{43.841970401, - 79.39117270};
        ld = new LocationDTO("Popeyes", coordinates, LocationType.FOOD);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        assertEquals("Popeyes", ld.getName());
    }

    @Test
    void getCoordinates() {
        assertSame(coordinates, ld.getCoordinates());
    }

    @Test
    void getType() {
        assertEquals(LocationType.FOOD, ld.getType());
    }
}