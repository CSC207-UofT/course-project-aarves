package com.aarves.bluepages.adapter;

import com.aarves.bluepages.entities.Location;
import com.aarves.bluepages.entities.FoodLocation;
import com.aarves.bluepages.entities.StudyLocation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MapboxGateway {

    /**
     * Take the raw response from MapBox and parse it into relevant information.
     * @param json JSONObject containing the raw response.
     * @return An ArrayList of Locations containing relevant information from json.
     */
    public HashMap<Location, String> parseInformation(JSONObject json) {
        JSONArray places = new JSONArray();
        try {
            places = json.getJSONArray("features");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HashMap<Location, String> placeMap = new HashMap<>();

        for (int i = 0; i < places.length(); i++) {
            try {
                JSONObject place = places.getJSONObject(i);
                String placeName = place.getString("text_en");
                double[] coordinates = {place.getJSONObject("geometry").getJSONArray("coordinates").getDouble(0), place.getJSONObject("geometry").getJSONArray("coordinates").getDouble(1)};
                String placeAddress = place.getJSONObject("properties").getString("address");
                String placeCategory = place.getJSONObject("properties").getString("category");

                // TODO: More rigorous check to see the type of location
                // Note: Unable to find information on hours, takeout/dinein, price, indoors, or quiet.
                if (placeCategory.contains("shop")) {
                    FoodLocation fl = new FoodLocation(placeName, coordinates);
                    placeMap.put(fl, placeAddress);
                } else {
                    StudyLocation sl = new StudyLocation(placeName, coordinates);
                    placeMap.put(sl, placeAddress);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return placeMap;
    }

    /**
     * Get the address of the point of interest.
     * @param json JSONObject containing the raw response.
     * @return String containing the address of the point of interest.
     */
    public String getPointAddress(JSONObject json) {
        JSONArray features = new JSONArray();
        try {
            features = json.getJSONArray("features");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (features.length() > 0) {
            try {
                JSONObject place = features.getJSONObject(0);
                // If 'address' property exists, get address from there
                if (place.getJSONObject("properties").has("address")) {
                    return place.getJSONObject("properties").getString("address");
                } else {
                    return place.getString("address") + " " + place.getString("text");
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

}
