package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.location.LocationOutputBoundary;
import com.aarves.bluepages.usecase.interactors.location.LocationOutputModel;
import com.aarves.bluepages.usecase.interactors.location.LocationType;
import com.aarves.bluepages.usecase.interactors.review.ReviewOutputModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationPresenterTest {

    LocationPresenter locationPresenter;
    LocationViewMockup locationView;

    @BeforeEach
    void setUp() {
        locationView = new LocationViewMockup();
        locationPresenter = new LocationPresenter();
        locationPresenter.setLocationView(locationView);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void presentLocations() {
        LocationOutputModel l1 = new LocationOutputModel(786, "Halal Guys",
                LocationType.FOOD, 5);
        List<LocationOutputModel> locationOutputModelList = new ArrayList<>();
        locationOutputModelList.add(l1);
        List<Boolean> bookmarkedLocations = new ArrayList<>();
        bookmarkedLocations.add(true);
        locationPresenter.presentLocations(locationOutputModelList, bookmarkedLocations);
        Assertions.assertTrue(locationView.isLocationDisplayed());

    }

}