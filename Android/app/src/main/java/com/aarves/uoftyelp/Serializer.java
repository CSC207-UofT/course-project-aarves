package com.aarves.uoftyelp;

import java.io.IOException;

public interface Serializer {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o) throws IOException;

    /**
     * @param filepath location of ser file
     */
    Object loadFile(String filepath) throws IOException, ClassNotFoundException;
}