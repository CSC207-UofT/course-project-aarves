package com.aarves.core.databases;

import com.aarves.core.usecases.AccountList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class AccountSerializer implements Serializer {


    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static Writer writer;


    /**
     * Writes the users to file at filePath
     *
     * @param filepath location of the file to write to
     * @param o        list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filepath, Object o) throws IOException {
        writer = new FileWriter(filepath);
        gson.toJson(o, writer);
        //makes sure that any buffered data is written to disk
        writer.flush();
        // flushes the data and indicates there isnt anymore data
        writer.close();

    }

    /**
     * Store the accounts to filePath
     *
     * @param filepath file where the account list is stored
     * @return list of accounts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public AccountList loadFile(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        AccountList accounts = gson.fromJson(reader, AccountList.class);
        reader.close();
        return accounts;
    }

}