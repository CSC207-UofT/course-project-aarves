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
        rm.addReview(sl, u1, r);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void testGetReview() {
        Review my_Review = rm.getReview(r.getReviewId());
        assertSame(my_Review, r);
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
    void testAddReview() {
        assertNotNull(rm.getReview(0));
    }

    @Test
    void testDeleteAllUserReviews() {
        RegisteredUser u2 = new RegisteredUser("natsy2", "testing");
        StudyLocation sl2 = new StudyLocation("5", "Bahen", "St George Street", true, false);
        Review r2 = new Review("natsy2",  sl, "Noisy!", 3);
        rm.addReview(sl2, u2, r2);
        rm.deleteAllUserReviews(u2);
        List<Integer> empty = new ArrayList<>();
        assertEquals(empty, u2.getReviews());
    }

    @Test
    void testDeleteReview() {
        RegisteredUser u2 = new RegisteredUser("natsy2", "testing");
        StudyLocation sl2 = new StudyLocation("5", "Bahen", "St George Street", true, false);
        Review r2 = new Review("natsy2",  sl, "Noisy!", 3);
        rm.addReview(sl2, u2, r2);
        rm.deleteReview(u2, sl2, r2);
        List<Integer> empty = new ArrayList<>();
        assertEquals(empty, u2.getReviews());
    }
}