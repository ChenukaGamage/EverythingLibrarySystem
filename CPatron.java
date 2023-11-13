import java.util.Scanner;

/**
 * The `CPatron` class represents a library user with patron privileges.
 * It extends the `CUser` class and provides specific operations available to patrons.
 */
public class CPatron extends CUser 
{
    /**
     * Constructs a patron with the given first name, inheriting from the `CUser` constructor.
     * Initializes the operations array with patron-specific permissions.
     *
     * @param fName The first name of the patron.
     */
    public CPatron(String fName) 
    {
        super(fName);
        this.operations = new IOOperation[] // Admin permissions
        {
            new CViewBooks(),
            new CSearch(),
            new CInterLibraryLoan(),
            new CBorrowBook(),
            new CReturnBook(),
            new CCalculateFines(),
            new CExit()
        };
    }

    /**
     * Constructs a patron with the given details, inheriting from the `CUser` constructor.
     * Initializes the operations array with patron-specific permissions.
     *
     * @param aFirstName The first name of the patron.
     * @param aLastName  The last name of the patron.
     * @param aEmailID   The email ID of the patron.
     * @param aPass      The password of the patron.
     */
    public CPatron(String aFirstName, String aLastName, String aEmailID, String aPass) 
    {
        super(aFirstName, aLastName, aEmailID, aPass);
        this.operations = new IOOperation[] 
        {
            new CViewBooks(),
            new CSearch(),
            new CInterLibraryLoan(),
            new CBorrowBook(),
            new CReturnBook(),
            new CCalculateFines(),
            new CExit()
        };
    }

    /**
     * Overrides the `menu` method from the parent class to display patron-specific menu options.
     * Takes user input to execute the selected operation.
     *
     * @param database The library database.
     * @param user     The logged-in user (patron).
     */
    @Override
    public void menu(CDatabase database, CUser user) 
    {
        System.out.println("\n---------------------Main Menu------------------------");
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Inter-Library Loans");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Calculate Fines");
        System.out.println("7. Exit");
        
        Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();
        this.operations[val - 1].oper(database, user);
        scan.close();
    }

    /**
     * Overrides the `toString` method to represent the `CPatron` object as a string.
     *
     * @return A string representation of the `CPatron` object.
     */
    public String toString() 
    {
        String toReturn = fName + "<N/>" + lName + "<N/>" + email + "<N/>" + password + "<N/>" + "Normal";
        return toReturn;
    }
}
