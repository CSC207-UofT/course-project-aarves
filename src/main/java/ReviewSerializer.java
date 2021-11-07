import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class ReviewSerializer implements Serializer {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static Writer writer;

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param users    stores the list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filePath, Object users) throws IOException {
        writer = new FileWriter(filePath);
        gson.toJson(users, writer);
        writer.flush();
        writer.close();
    }

    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     * @throws IOException
     */
    @Override
    public ReviewList loadFile(String filePath) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ReviewList reviews = gson.fromJson(reader, ReviewList.class);
        reader.close();
        return reviews;
    }

    // DELETE LATER; just usage examples
    public static void main(String[] args) throws IOException {
        Review review1 = new Review("Review #0", new FoodLocation("9-5", "Location 1", "Area 1", "Food 1", true, true,"$"), 1);
        Review review2 = new Review("Review #1", new FoodLocation("9-5", "Location 2", "Area 2", "Food 2", true, true,"$"), 5);
        ReviewList rl = new ReviewList();
        rl.addReview(review1);
        rl.addReview(review2);
        ReviewSerializer rs = new ReviewSerializer();
        rs.saveToFile("reviews.json", rl.reviewHashMap);
    }
}
