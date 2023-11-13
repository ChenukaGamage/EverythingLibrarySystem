import java.util.Scanner;

/**
 * Main class for the Everything Library System.
 */
public class CMain 
{
    public static Scanner string_Scan = new Scanner(System.in);
    public static Scanner int_Scan = new Scanner(System.in);
    public static CDatabase database;
    private static final Integer ADMIN_PASSWORD = 1234;

    /**
     * Main method to start the program.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) 
    {
        database = new CDatabase();
        int userInput;
        System.out.println("Welcome to the Everything Library System!!");
        System.out.println("0. Exit\n1. Login\n2. Sign Up as a new patron\n");
        userInput = int_Scan.nextInt();

        while ((userInput > 2) || (userInput < 0)) 
        {
            System.out.println("Please enter a valid input!");
            userInput = int_Scan.nextInt();
        }

        if (userInput == 0) 
        {
            System.out.println("----------------------Thank you for using us!----------------------");
            System.exit(0);
        } 
        else if (userInput == 1) 
        {
            login();
        } 
        else if (userInput == 2) 
        {
            createNewUser();
        }
    }

    /**
     * Handles the login functionality, allowing existing users to log in.
     */
    public static void login() 
    {
        System.out.println("------------------Login------------------------");
        System.out.print("\nEnter your email address: ");
        String email = string_Scan.nextLine();
        System.out.print("\nEnter your password: ");
        String password = string_Scan.nextLine();
        int index = database.login(email, password);

        if (index != -1) 
        {
            CUser user = database.getUserIndex(index);
            System.out.println();
            System.out.println("---------------------------Welcome " + user.getFirstName() + "---------------------------");
            user.menu(database, user);
        } 
        else 
        {
            System.out.println("\nUser does not exist\n");
            main(null);
        }
    }

    /**
     * Manages the creation of a new user account.
     */
    public static void createNewUser() 
    {
        System.out.println("------------------Create New User------------------------");
        System.out.print("\nEnter your first name: ");
        String fName = string_Scan.nextLine();
        System.out.print("\nEnter your last name: ");
        String lName = string_Scan.nextLine();
        System.out.print("\nEnter your email address: ");
        String email = string_Scan.nextLine();

        if (database.emailExists(email)) 
        {
            System.out.println("There is already a user with that email.");
            main(null);
        }

        System.out.print("\nEnter a password: ");
        String password = string_Scan.nextLine();

        System.out.print("\nWho is this account for?\n" + "1. Admin\nor Normal Patron\n");
        int userInput = int_Scan.nextInt();
        CUser user;

        if (userInput == 1) 
        {
            System.out.println("Please enter the admin creation code");
            Integer adminPass = int_Scan.nextInt();
            if (!adminPass.equals(ADMIN_PASSWORD)) 
            {
                System.out.println("Please enter the correct admin passcode");
                createNewUser();
            }
            user = new CAdmin(fName, lName, email, password);
        } 
        else 
        {
            user = new CPatron(fName, lName, email, password);
        }

        database.addUser(user);
        System.out.println("\nAccount created successfully!\n");
        user.menu(database, user);
    }
}