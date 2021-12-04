package com.aarves.bluepages.usecase.interactors;

import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LocationMapTest {

    LocationMap locationMap = new LocationMap();

    @BeforeEach
    void setUp() {
        Location l1 = new StudyLocation("9am-10pm", "Gerstein Library", "145 St.Geroge St", true, true);
        Location l2 = new StudyLocation("9am- 1pm", "Rm101", "971 Koffler St", true, false);
        Location l3 = new FoodLocation("11am-3pm", "Freshii", "345 Yonge St", "Soups and salads", true, true, "10-20$");
        locationMap.addLocation(89, l3);
        locationMap.addLocation(234, l2);
        locationMap.addLocation(241, l1);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetLocation() {
        Location loc = new StudyLocation("9am-10pm", "Earth Science Library", "87 St.George St", false, true);
        locationMap.addLocation(201, loc);
        Location result = locationMap.getLocation(201);
        assertEquals(loc, result);

    }

    @Test
    void testNoSuchPointGetLocation() {
        Location result = locationMap.getLocation(91);
        assertNull(result);
    }


    @Test
    void testAddLocation() {
        int mapSize = locationMap.locationHashMap.size();
        Location newLocation = new StudyLocation("10am-6pm", "Hart House", "438 Jamle St", true, true);
        locationMap.addLocation(8764, newLocation);
        Location newLocation2 = new FoodLocation("10am-6pm", "Caffeinds", "42 Queens Park Ave", "coffee and tea", true, true, "1-10$");
        locationMap.addLocation(324, newLocation2);
        mapSize = mapSize + 2;
        assertEquals(mapSize, locationMap.locationHashMap.size());
    }

    // TODO: do we want the following case?:
    // if a key already in the map tries to be added again
    // put() will override the value so the location just gets updated
    @Test
    void testAddDuplicateLocation(){
        int mapSize = locationMap.locationHashMap.size();
        Location newLocation = new StudyLocation("10am-6pm", "Hart House", "438 James St", true, true);
        locationMap.addLocation(8764, newLocation);
        mapSize ++;
        Location newLocation2 = new StudyLocation("10am-6pm", "Hart House", "438 James St", true, true);
        locationMap.addLocation(8764, newLocation2);
        assertEquals(mapSize, locationMap.locationHashMap.size());

    }

    @Test
    void testDeleteLocation() {
        locationMap.deleteLocation(89);
        locationMap.deleteLocation(234);
        locationMap.deleteLocation(241);
        Map<Integer, Location> empty = new HashMap<>();
        assertEquals(empty.size(), locationMap.locationHashMap.size());
    }


    @Test
    void testDeleteLocationNotInMap() {
        int originalSize = locationMap.locationHashMap.size();
        locationMap.deleteLocation(1);
        locationMap.deleteLocation(910);
        assertEquals(originalSize, locationMap.locationHashMap.size());
    }

    @Test
    void testGetLocationByName() {
        Location result = locationMap.getLocationByName("Gerstein Library");
        for (Location l:locationMap.locationHashMap.values()){
            String name = l.getName();
            if (name.equals("Gerstein Library")){
                assertEquals(result, l);
            }
        }
    }

    @Test
    void testNoSuchLocationByName() {
        Location result = locationMap.getLocationByName("Varsity Stadium");
        assertNull(result);

    }
}