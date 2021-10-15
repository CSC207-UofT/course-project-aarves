import jdk.jfr.Registered;

import java.util.Scanner;

/**
 * Not a functional class. Just created to test out the written scenario with the skeleton program.
 */

public class Scenario {

    private static AccountManager am = new AccountManager();
    private static ReviewManager rm = new ReviewManager();
    private AccountCreator ac = new AccountCreator();
    private Scanner scn = new Scanner(System.in);
    private static FoodMap fm = new FoodMap();
    private static StudyMap sm = new StudyMap();
    private static User user;

    public Scenario() {
        am.addUser("billy123", "iambilly");
        am.addUser("javalover", "neverevercpp");
        am.addUser("rickastley", "getrolled");

        fm.addLocation(new Point((float) 43.6645, (float) 79.3997) , new FoodLocation("9am-5pm",
                "So Sushi", "Robarts Library Cafeteria", "Sushi",
                true, true, "$$"));
        fm.addLocation(new Point((float) 43.6625, (float) 79.3985), new FoodLocation("9am-5pm",
                "Second Cup", "Sidney Smith", "Cafe", true, false, "$"));
        sm.addLocation(new Point((float) 43.6645, (float) 79.3997), new StudyLocation("8:30am-11pm",
                "1st Floor Study Rooms", "Robarts Library", true, true));
    }

    public String mainMenu() {
        // Ask the user whether they want to signup or login (or continue as guest)
        // Ensure that the user inputs a valid choice (1, 2, or 3)
        String choice = "-1";
        while (!("1".equals(choice) || "2".equals(choice) || "3".equals(choice))) {
            System.out.println("AARVES --- Signup/Login\n[1] Signup\n[2] Login\n[3] Continue as guest");
            choice = scn.nextLine();
        }
        return choice;
    }

    public void userSignup() {

        System.out.println("AARVES --- Signup");
        System.out.print("Username:\t");
        String username = scn.nextLine().trim();
        boolean flag = true;
        while (flag) {
            // Check if the account exists
            if (!am.isExistingAccount(username)) {
                flag = false;
            }
            else if (username.length() < 3) {
                System.out.println("Your username must be at least 3 characters long");
                System.out.print("Username:\t");
                username = scn.nextLine().trim();
            }
            else {
                System.out.println("That username is taken, please enter a new one.");
                System.out.print("Username:\t");
                username = scn.nextLine().trim();
            }
        }
        // Ask for the user's preferred password - passwords must be at least 8 characters long
        flag = true;
        String password = "";
        do {
            System.out.print("Password:\t");
            password = scn.nextLine();
            if (password.length() >= 8) {
                flag = false;
            }
            else {
                System.out.println("Your password must be at least 8 characters long");
            }
        } while (flag);

        // Create the account
        ac.createAccount(am, username, password);
        System.out.println("Your account has been successfully created! Please login.");

    }

    public RegisteredUser userLogin() {

        System.out.println("AARVES --- Login");
        System.out.print("Username:\t");
        String username = scn.nextLine();
        System.out.print("Password:\t");
        String password = scn.nextLine();

        boolean flag = true;
        while (flag) {
            if (am.correctLogin(username, password)) {
                flag = false;
            } else {
                System.out.println("Username/password is incorrect. Please try again.\n");
                System.out.print("Username:\t");
                username = scn.nextLine();
                System.out.print("Password:\t");
                password = scn.nextLine();
            }
        }
        System.out.printf("Welcome to AARVES, %s!%n", username);
        return  am.getUser(username);
    }

    public String locationAction() {
        String choice = "-1";
        while (!("1".equals(choice) || "2".equals(choice))) {
            System.out.println("AARVES --- Location Viewer \n[1] Filter Location by Type \n[2] Search Location" );
            choice = scn.nextLine();
        }
        return choice;
    }

    public Location search() {
        String search = "";
        while(true) {
            System.out.print("AARVES --- Search Location:" );
            search = scn.nextLine();
            Location food_location = fm.getLocationByName(search);
            Location study_location = sm.getLocationByName(search);
            if(food_location != null) {
                System.out.println(food_location);
                return food_location;
            } else if(study_location != null) {
                System.out.println(study_location);
                return study_location;
            }
            else {
                System.out.println("No search results found, please search again.");
            }
        }
    }

    public void filter() {
        String choice = "-1";
        // Choose how they want to filter the information
        while (!("1".equals(choice) || "2".equals(choice) || "3".equals(choice))) {
            System.out.println("AARVES --- Filter \n[1] Filter by Food \n[2] Filter by Study" );
            choice = scn.nextLine();
        }
        if ("1".equals(choice)) {
            System.out.println(fm.toString());
        }
        else {
            System.out.println(sm.toString());
        }
    }

    public void bookmarkLocation(Location location, RegisteredUser user) {
        System.out.println("Would you like to bookmark this location (Y/N)?\t");
        String bookmark = scn.nextLine();
        if (bookmark.equalsIgnoreCase("Y")) {
            user.addBookmark(location);
            System.out.println();
            System.out.println("Location successfully bookmarked!");
        }
    }

    public void leaveReview(Location location, RegisteredUser user) {
        System.out.println("Would you like to leave a review (Y/N)?\t");
        String review = scn.nextLine();
        if (review.equalsIgnoreCase("Y")) {
            System.out.println("Review content:\t");
            String review_content = scn.nextLine();
            System.out.println("Rating (/5). Please input an integer value between 0 and 5:\t");
            int rating = -1;
            while (rating < 0 || rating > 5) {
                rating = scn.nextInt();
            }
            rm.createReview(user, location, review_content, rating);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Scenario sc = new Scenario();
        Location location = null;
        boolean flag = true;

        // Below loop is to test account creation/main menu function.
        while (flag) {
            String choice = sc.mainMenu();
            System.out.println();

            // Branch options based off their choice
            if ("1".equals(choice)) {
                sc.userSignup();
                System.out.println();
                sc.user = sc.userLogin();
            } else if ("2".equals(choice)) {
                sc.user = sc.userLogin();
            } else if ("3".equals(choice)) {
                sc.user = new GuestUser();
                System.out.println("Welcome to AARVES!");
            }

            boolean search_flag = true;
            while(search_flag) {
                // Ask whether they'd like to search or filter the locations
                System.out.println();
                String action = sc.locationAction();
                // Branch options based off their choice

                // Ask if they want to filter their results before searching, or just search
                if ("1".equals(action)) {
                    sc.filter();
                    location = sc.search();
                } else if ("2".equals(action)) {
                    location = sc.search();
                }

                // Ask if they would like to bookmark the location and leave a review
                if (sc.user instanceof RegisteredUser) {
                    sc.bookmarkLocation(location, (RegisteredUser) sc.user);
                    sc.leaveReview(location, (RegisteredUser) sc.user);

                }

                // Ask whether they'd like to search again
                System.out.println("Would you like to search again (Y/N)?\t");
                String searchAgain = scn.nextLine();
                if (searchAgain.equalsIgnoreCase("N")) {
                    search_flag = false;
                }
            }

            // Ask whether they'd like to return to the main menu
            System.out.println("Would you like to return to the main menu (Y/N)?\t");
            String toMainMenu = scn.nextLine();
            if (toMainMenu.equalsIgnoreCase("N")) {
                flag = false;
            }
        }
        System.out.println("Note: AARVES is not the name of the app/program, it's a placeholder.");
    }
}
