package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class LocationMapTest {
    private LocationMap locationMap;

    @BeforeEach
    void setUp() {
        this.locationMap = new LocationMap();

        Location l1 = new StudyLocation("9am-10pm", "Gerstein Library", "145 St.Geroge St", true, true);
        Location l2 = new StudyLocation("9am- 1pm", "Rm101", "971 Koffler St", true, false);
        Location l3 = new FoodLocation("11am-3pm", "Freshii", "345 Yonge St", "Soups and salads", true, true, "10-20$");

        this.locationMap.addLocation(89, l3);
        this.locationMap.addLocation(234, l2);
        this.locationMap.addLocation(241, l1);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGetLocation() {
        Location loc = new StudyLocation("9am-10pm", "Earth Science Library", "87 St.George St", false, true);
        this.locationMap.addLocation(201, loc);
        Location result = this.locationMap.getLocation(201);

        Assertions.assertEquals(loc, result);
    }

    @Test
    void testNoSuchPointGetLocation() {
        Location result = this.locationMap.getLocation(91);
        Assertions.assertNull(result);
    }

    @Test
    void testAddLocation() {
        int mapSize = this.locationMap.getLocationCount();

        Location newLocation = new StudyLocation("10am-6pm", "Hart House", "438 Jamle St", true, true);
        this.locationMap.addLocation(8764, newLocation);
        Location newLocation2 = new FoodLocation("10am-6pm", "Caffeinds", "42 Queens Park Ave", "coffee and tea", true, true, "1-10$");
        this.locationMap.addLocation(324, newLocation2);
        mapSize = mapSize + 2;

        Assertions.assertEquals(mapSize, this.locationMap.getLocationCount());
    }

    @Test
    void testAddDuplicateLocation(){
        int mapSize = this.locationMap.getLocationCount();

        Location newLocation = new StudyLocation("10am-6pm", "Hart House", "438 James St", true, true);
        this.locationMap.addLocation(8764, newLocation);
        Location newLocation2 = new StudyLocation("10am-6pm", "Hart House", "438 James St", true, true);
        this.locationMap.addLocation(8764, newLocation2);
        mapSize ++;

        Assertions.assertEquals(mapSize, this.locationMap.getLocationCount());
    }

    @Test
    void testDeleteLocation() {
        this.locationMap.deleteLocation(89);
        this.locationMap.deleteLocation(234);
        this.locationMap.deleteLocation(241);

        Assertions.assertEquals(0, this.locationMap.getLocationCount());
    }

    @Test
    void testDeleteLocationNotInMap() {
        int originalSize = locationMap.getLocationCount();
        this.locationMap.deleteLocation(1);
        this.locationMap.deleteLocation(910);

        Assertions.assertEquals(originalSize, this.locationMap.getLocationCount());
    }

    @Test
    void testGetLocationByName() {
        Location result = this.locationMap.getLocationByName("Gerstein Library");
        for (Location location : this.locationMap.getLocations()) {
            String name = location.getName();

            if(name.equals("Gerstein Library")) {
                Assertions.assertEquals(result, location);
            }
        }
    }

    @Test
    void testNoLocationByName() {
        Location result = this.locationMap.getLocationByName("Varsity Stadium");
        Assertions.assertNull(result);
    }
}