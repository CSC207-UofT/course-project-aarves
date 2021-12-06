package com.aarves.bluepages.usecase.data.location;

import com.aarves.bluepages.adapter.controllers.LookupController;
import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationDataMapperTest {

    LocationDataMapper locationDataMapper;

    @BeforeEach
    void setUp() {
        locationDataMapper = new LocationDataMapper();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testMapToDTOFood() {
        double[] coordinate = {32.4, 45.6};
        Location foodLocation = new FoodLocation("Starbucks", coordinate);
        LocationDTO result = locationDataMapper.mapToDTO(foodLocation);
        assertEquals(coordinate, result.getCoordinates());

    }

    @Test
    void testMapToDTOStudy() {
        double[] coordinate = {32.4, 45.6};
        Location studyLocation = new StudyLocation("Robarts", coordinate);
        LocationDTO result = locationDataMapper.mapToDTO(studyLocation);
        assertEquals(coordinate, result.getCoordinates());
    }

    @Test
    void testStudyLocationFactory() {
        // set location id
        double[] coordinate = {32.4, 45.6};
        LocationDTO locationDTO = new LocationDTO("Robarts", coordinate, LocationType.STUDY);
        Location result = locationDataMapper.locationFactory(locationDTO, 89);
        Location expected = new StudyLocation(89, "Robarts", coordinate);
        assertEquals(expected.getLocationId(), result.getLocationId());
    }

    @Test
    void testFoodLocationFactory() {
        // set location id
        double[] coordinate = {32.4, 45.6};
        LocationDTO locationDTO = new LocationDTO("Tim Hortons", coordinate, LocationType.FOOD);
        Location result = locationDataMapper.locationFactory(locationDTO, 89);
        Location expected = new FoodLocation(89, "Tim Hortons", coordinate);
        assertEquals(expected.getLocationId(), result.getLocationId());
    }
}