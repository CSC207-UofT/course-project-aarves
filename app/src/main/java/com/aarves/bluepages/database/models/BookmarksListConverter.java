package com.aarves.bluepages.database.models;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookmarksListConverter {
    @TypeConverter
    public static String fromBookmarksList(List<Integer> bookmarks) {
        Gson gson = new Gson();
        if(bookmarks != null) {
            return gson.toJson(gson);
        }
        else {
            return gson.toJson(new ArrayList<Integer>());
        }
    }

    @TypeConverter
    public static List<Integer> toBookmarksList(String json) {
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        return (new Gson()).fromJson(json, listType);
    }
}
