import java.util.Scanner;

/**
 * The CAdmin class represents an administrator user in the library system.
 */
public class CAdmin extends CUser 
{
    /**
     * Constructs a CAdmin object with the given first name.
     *
     * @param aFName The first name of the administrator.
     */
    public CAdmin(String aFName) 
    {
        super(aFName);
        this.operations = new IOOperation[] // Admin permissions
        {
            new CViewBooks(),
            new CAddBook(),
            new CDeleteBook(),
            new CDeleteUser(),
            new CSearch(),
            new CPlaceOrder(),
            new CViewOrders(),
            new CExit()
        };
    }

    /**
     * Constructs a CAdmin object with the given details.
     *
     * @param aFirstName The first name of the administrator.
     * @param aLastName  The last name of the administrator.
     * @param aEmailID   The email ID of the administrator.
     * @param aPass      The password of the administrator.
     */
    public CAdmin(String aFirstName, String aLastName, String aEmailID, String aPass) 
    {
        super(aFirstName, aLastName, aEmailID, aPass);
        this.operations = new IOOperation[]
        {
            new CViewBooks(),
            new CAddBook(),
            new CDeleteBook(),
            new CDeleteUser(),
            new CSearch(),
            new CPlaceOrder(),
            new CViewOrders(),
            new CExit()
        };
    }

    /**
     * Displays the main menu for the administrator and performs the selected operation.
     *
     * @param database The database containing library information.
     * @param user     The current user (administrator) performing the operation.
     */
    @Override
    public void menu(CDatabase database, CUser user) 
    {
        System.out.println("\n---------------------Main Menu------------------------");
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Delete User");
        System.out.println("5. Search");
        System.out.println("6. Buy Book(s)");
        System.out.println("7. View Orders");
        System.out.println("8. Exit");

        Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();
        this.operations[val - 1].oper(database, user);
        scan.close();
    }

    /**
     * Converts the CAdmin object to a string representation.
     *
     * @return A string representation of the CAdmin object.
     */
    @Override
    public String toString() 
    {
        String toReturn = fName + "<N/>" + lName + "<N/>" + email + "<N/>" + password + "<N/>" + "Admin";
        return toReturn;
    }
}