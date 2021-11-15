package com.aarves.core.databases;

import com.aarves.core.usecases.ReviewList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class ReviewSerializer implements Serializer {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static Writer writer;

    /**
     * Writes the reviews to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param reviews    stores the list of reviews to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filePath, Object reviews) throws IOException {
        writer = new FileWriter(filePath);
        gson.toJson(reviews, writer);
        writer.flush();
        writer.close();
    }

    /**
     * Store the reviews to file at filePath.
     *
     * @param filePath file where the reviews list is stored
     * @return list of reviews
     * @throws IOException
     */
    @Override
    public ReviewList loadFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ReviewList reviews = gson.fromJson(reader, ReviewList.class);
        reader.close();
        return reviews;
    }
}