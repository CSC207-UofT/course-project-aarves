import java.util.Scanner;

/**
 * Not a functional class. Just created to test out the written scenario with the skeleton program.
 */

public class Scenario {

    private static AccountManager am = new AccountManager();
    private AccountCreator ac = new AccountCreator();
    private Scanner scn = new Scanner(System.in);

    public Scenario() {
        am.addUser("billy123", "iambilly");
        am.addUser("javalover", "neverevercpp");
        am.addUser("rickastley", "getrolled");
    }

    public String mainMenu() {
        // Ask the user whether they want to signup or login (or continue as guest)
        System.out.println("AARVES --- Signup/Login\n[1] Signup\n[2] Login\n[3] Continue as guest");
        return scn.nextLine();
    }

    public void userSignup() {

        System.out.println("AARVES --- Signup");
        System.out.print("Username:\t");
        String username = scn.nextLine();
        boolean flag = true;
        while (flag) {
            // Check if the account exists
            if (!am.isExistingAccount(username)) {
                flag = false;
            } else {
                System.out.println("That username is taken, please enter a new one.");
                System.out.print("Username:\t");
                username = scn.nextLine();
            }
        }
        // Ask for the user's preferred password
        System.out.print("Password:\t");
        String password = scn.nextLine();
        // Create the account
        ac.createAccount(am, username, password);
        System.out.println("Your account has been successfully created! Please login.");

    }

    public void userLogin() {

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
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Scenario sc = new Scenario();
        boolean flag = true;

        // Below loop is to test account creation/main menu function.
        while (flag) {
            String choice = sc.mainMenu();
            System.out.println();

            // Branch options based off their choice
            if ("1".equals(choice)) {
                sc.userSignup();
                System.out.println();
                sc.userLogin();
            } else if ("2".equals(choice)) {
                sc.userLogin();
            } else if ("3".equals(choice)) {
                System.out.println("Welcome to AARVES!");
            }

            // Ask whether they'd like to return to the main menu
            System.out.println();
            System.out.println("Would you like to return to the main menu (Y/N)?\t");
            String toMainMenu = scn.nextLine();
            if (toMainMenu.equalsIgnoreCase("N")) {
                flag = false;
            }
        }
        System.out.println("Note: AARVES is not the name of the app/program, it's a placeholder.");
    }
}
