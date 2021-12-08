package com.aarves.bluepages.usecase.interactors.location;

import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationOutputMapperTest {

    LocationOutputMapper locationOutputMapper;
    @BeforeEach
    void setUp() {
        locationOutputMapper = new LocationOutputMapper();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mapToOutputModels() {
        List<Float> ratingsList = new ArrayList<>();
        ratingsList.add(3.3f);
        ratingsList.add(4.9f);
        List<Location> locationList = new ArrayList<>();
        double[] coordinate= {34.4, 23.4};
        double[] coordinate2= {38.4, 22.4};
        Location studyLocation = new StudyLocation("Robarts", coordinate);
        Location foodLocation = new FoodLocation(45, "Starbucks", coordinate2);
        locationList.add(studyLocation);
        locationList.add(foodLocation);
        List<LocationOutputModel> locationOutputModels = locationOutputMapper.mapToOutputModels(locationList, ratingsList);
        assertEquals(2, locationOutputModels.size());
    }

    @Test
    void mapToOutputModelsStudyLocation() {
        double[] coordinate= {34.4, 23.4};
        Location location = new StudyLocation("Robarts", coordinate);
        LocationOutputModel result = locationOutputMapper.mapToOutputModel(location, 4);
        assertEquals("Robarts", result.getLocationName());

    }

    @Test
    void mapToOutputModelsFoodLocation() {
        double[] coordinate= {34.4, 23.4};
        Location location = new FoodLocation(45, "Starbucks", coordinate);
        LocationOutputModel result = locationOutputMapper.mapToOutputModel(location, 3);
        assertEquals("Starbucks", result.getLocationName());
    }


}