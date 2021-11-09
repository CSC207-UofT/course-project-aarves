import usecases.AccountList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.RegisteredUser;

import java.io.*;

public class AccountSerializer implements Serializer {


    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static Writer writer;


    /**
     * Writes the users to file at filePath
     * @param filepath location of the file to write to
     * @param o list of users to be serialized
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
     * @param filepath file where the account list is stored
     * @return list of accounts
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public AccountList loadFile(String filepath) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        AccountList accounts = gson.fromJson(reader, AccountList.class);
        reader.close();
        return accounts;
    }

    // DELETE LATER
    public static void main(String[] args) throws IOException {
        RegisteredUser user1 = new RegisteredUser("sparky", "woof");
        RegisteredUser user2 = new RegisteredUser("johndoe", "password");
        AccountList al = new AccountList();
        al.addUser(user1);
        al.addUser(user2);
        AccountSerializer as = new AccountSerializer();
        as.saveToFile("accounts.json", al.getUser("sparky"));

    }
}
