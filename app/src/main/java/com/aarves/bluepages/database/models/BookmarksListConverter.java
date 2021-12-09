package com.aarves.bluepages.database.models;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A Converter class used by Room to convert between a list of bookmarked location IDs to a string, which can be stored
 * in the accounts table within the database.
 */
public class BookmarksListConverter {
    /**
     * Converts list of bookmarked location IDs to a JSON-formatted string.
     * @param bookmarks the list of bookmarked location IDs to be converted
     * @return the converted JSON-formatted string representing the bookmarked location IDs
     */
    @TypeConverter
    public static String fromBookmarksList(List<Integer> bookmarks) {
        // Start GSON to convert list to JSON format
        Gson gson = new Gson();
        if(bookmarks != null) {
            // Returns JSON-formatted string
            return gson.toJson(bookmarks);
        }
        else {
            // Returns string for empty list if list is null
            return gson.toJson(new ArrayList<Integer>());
        }
    }

    /**
     * Converts JSON-formatted string to a list of bookmarked location IDs.
     * @param json a JSON-formatted string representing the bookmarked location IDs to be converted
     * @return the converted list of bookmarked location IDs
     */
    @TypeConverter
    public static List<Integer> toBookmarksList(String json) {
        // Gets the type of list of integers
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        // Converts string back to list of integers
        return (new Gson()).fromJson(json, listType);
    }
}
