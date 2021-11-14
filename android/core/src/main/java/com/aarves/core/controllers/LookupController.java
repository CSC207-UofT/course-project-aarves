package com.aarves.core.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class LookupController {

    private static String MAPBOX_PREFIX = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    private static String MAPBOX_SUFFIX = ".json?country=ca&bbox=-79.40543276088096%2C43.653559622123446%2C-79.38297760120373%2C43.67121768976685&proximity=-79.39593184050538%2C43.66099799082462&language=en&access_token=";

    public JSONObject lookupLocation(String location, String token) {
        Document doc = null;
        try {
            String mapboxUrl = MAPBOX_PREFIX + location + MAPBOX_SUFFIX + token;
            doc = Jsoup.connect(mapboxUrl).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return JSON response
        String rawData = doc.text();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(rawData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
