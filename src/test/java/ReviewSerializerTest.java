import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReviewSerializerTest {

    ReviewSerializer rs = new ReviewSerializer();
    ReviewList rl = new ReviewList();
    StudyLocation sl = new StudyLocation("10", "Robarts Library", "St George Street", true, true);
    Review r = new Review("natsyy",  sl, "Amazing place to study!", 5);

    @BeforeEach
    public void setUp() {

        rl.addReview(r);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void loadFile() throws IOException {
        rs.saveToFile("src/test/java/testing.json", rl);
        ReviewList rl2 = rs.loadFile("src/test/java/testing.json");
        assertSame(rl2, rl);
    }
}