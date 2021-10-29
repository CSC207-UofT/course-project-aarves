import java.util.Scanner;

public class CommandLine {

    InputController ic = new InputController();
    InputGateway ig = new InputGateway();
    int userType;
    RegisteredUser user;

    public void loginMenu() {
        System.out.println("Enter the number corresponding to your choice:\n" +
                "[1]\tLogin\n" +
                "[2]\tRegister\n" +
                "[3]\tGuest");

        // Get the input
        Scanner scanner = new Scanner(System.in);
        String accessType = scanner.nextLine();

        // Pass input to InputController
        this.userType = this.ic.userAccessType(accessType);

        // If the user inputs wrong input, the program will ask again
        if (this.userType == 0) {
            System.out.println("Invalid input");
            this.loginMenu();
        } else if (this.userType == 2) {
            boolean flag = true;
            while (flag) {
                System.out.print("Enter your username:\t");
                String username = scanner.nextLine();
                System.out.print("Enter your password:\t");
                String password = scanner.nextLine();

                if (this.ic.createUser(username, password)) {
                    System.out.println("User created successfully");
                    this.user = this.ig.getUser(username);
                    flag = false;
                } else {
                    System.out.println("Username already exists. Please enter a new one.\n");
                }
            }
        }

        this.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Enter the number corresponding to your choice:\n" +
                "[1]\tView the map\n" +
                "[2]\tSearch\n" +
                "[3]\tYour bookmarks\n" +
                "[4]\tYour reviews\n" +
                "[5]\tExit");

        // Get the input
        Scanner scanner = new Scanner(System.in);
        String menuChoice = scanner.nextLine();

        switch (menuChoice) {
            case "1":
                // TODO: View the map
                break;
            case "2":
                // TODO: Search
                break;
            case "3":
                this.bookmarkMenu();
                break;
            case "4":
                // TODO: Reviews
                break;
            case "5":
                // TODO: Exit
                break;
        }
    }

    public void bookmarkMenu() {
        // Check if this.user is initialized
        if (this.user != null) {
            this.loggedInBookmarkMenu();
        } else {
            this.guestBookmarkMenu();
        }
    }

    public void loggedInBookmarkMenu() {
        System.out.println("Enter the number corresponding to your choice:\n" +
                "[1]\tAdd bookmark\n" +
                "[2]\tView bookmarks\n" +
                "[3]\tDelete bookmark\n" +
                "[4]\tSearch bookmarks\n" +
                "[5]\tLogout");

        // Get the input
        Scanner scanner = new Scanner(System.in);
        String bookmarkChoice = scanner.nextLine();

        // Pass input to InputController
        this.userType = this.ic.userBookmarks(bookmarkChoice);

        switch (this.userType) {
            case 1:
                System.out.println("Added Bookmark");
            case 2:
                System.out.println(this.ig.getBookmarks(user));
            case 3:
                System.out.println("Deleted Bookmark");
            case 4:
                System.out.println("Searched Bookmark");
            case 5:
                System.out.println("Logged Out");
            default:
                System.out.println("Invalid input");
        }
    }

    public void guestBookmarkMenu() {
        System.out.println("You must be logged in to access bookmarks. Would you like to return to the login menu (Y/N)?\t");
        // Get the input
        Scanner scanner = new Scanner(System.in);
        String loginChoice = scanner.nextLine();

        if (loginChoice.equalsIgnoreCase("y")) {
            this.loginMenu();
        } else if (!loginChoice.equalsIgnoreCase("y") && !loginChoice.equalsIgnoreCase("n")) {
            System.out.println("You've entered an invalid input. Please enter Y or N.\n");
            this.guestBookmarkMenu();
        }
    }

    public static void main(String[] args) {
        CommandLine cl = new CommandLine();
        cl.loginMenu();
    }
}
