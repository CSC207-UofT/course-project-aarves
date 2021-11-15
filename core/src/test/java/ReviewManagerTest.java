import com.aarves.core.entities.RegisteredUser;
import com.aarves.core.entities.Review;
import com.aarves.core.entities.StudyLocation;
import com.aarves.core.usecases.ReviewManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewManagerTest {

    ReviewManager rm = new ReviewManager();
    RegisteredUser u1 = new RegisteredUser("natsy", "testing");
    StudyLocation sl = new StudyLocation("10", "Robarts Library", "St George Street", true, true);
    Review r = new Review("natsyy",  sl, "Amazing place to study!", 5);

    @BeforeEach
    public void setUp() {
        rm.createReview(u1, sl, r.getReviewId());
    }

    @AfterEach
    public void tearDown() {
    }


    @Test
    void testCreateReview() {
        RegisteredUser u2 = new RegisteredUser("natsy2", "testing");
        StudyLocation sl2 = new StudyLocation("5", "Bahen", "St George Street", true, false);
        rm.createReview(u2, sl2, 3);
        rm.deleteAllUserReviews(u2);
        List<Integer> empty = new ArrayList<>();
        assertEquals(empty, u2.getReviews());
    }

    @Test
    void testDeleteAllUserReviews() {
        RegisteredUser u2 = new RegisteredUser("natsy2", "testing");
        StudyLocation sl2 = new StudyLocation("5", "Bahen", "St George Street", true, false);
        Review r2 = new Review("natsy2",  sl, "Noisy!", 3);
        rm.addReview(u2, sl2, r2.getReviewId());
        rm.deleteAllUserReviews(u2);
        List<Integer> empty = new ArrayList<>();
        assertEquals(empty, u2.getReviews());
    }

    @Test
    void testDeleteReview() {
        RegisteredUser u2 = new RegisteredUser("natsy2", "testing");
        StudyLocation sl2 = new StudyLocation("5", "Bahen", "St George Street", true, false);
        Review r2 = new Review("natsy2",  sl, "Noisy!", 3);
        rm.addReview(u2, sl2, r2.getReviewId());
        rm.deleteReview(u2, sl2, r2);
        List<Integer> empty = new ArrayList<>();
        assertEquals(empty, u2.getReviews());
    }
}