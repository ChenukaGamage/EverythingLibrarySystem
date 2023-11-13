/**
 * The `CUser` class is an abstract class representing a library user.
 * It provides common attributes and methods for both administrators and patrons.
 */
public abstract class CUser
{
    // Protected attributes for user information
    protected String fName, lName, email, password;
    
    // Array to store operations applicable to the user
    protected IOOperation[] operations;

    /**
     * Default constructor for the `CUser` class.
     */
    public CUser() {}

    /**
     * Constructor for the `CUser` class with the first name parameter.
     *
     * @param aFirstName The first name of the user.
     */
    public CUser(String aFirstName)
    {
        this.fName = aFirstName;
    }

    /**
     * Constructor for the `CUser` class with all user information parameters.
     *
     * @param aFirstName The first name of the user.
     * @param aLastName  The last name of the user.
     * @param aEmailID   The email ID of the user.
     * @param aPass      The password of the user.
     */
    public CUser(String aFirstName, String aLastName, String aEmailID, String aPass)
    {
        this.fName = aFirstName;
        this.lName = aLastName;
        this.email = aEmailID;
        this.password = aPass;
    }

    // Getter methods
    public String getFirstName() {return this.fName;}
    public String getLastName() {return this.lName;}
    public String getEmail() {return this.email;}
    public String getPassword() {return this.password;}

    // Setter methods
    public void setFirstName(String newFirstName) {this.fName = newFirstName;}
    public void setLastName(String newLastName) {this.lName = newLastName;}
    public void setEmail(String newEmail) {this.email = newEmail;}
    public void setPassword(String newPassword) {this.password = newPassword;}

    /**
     * Abstract method to be implemented by subclasses to provide a string representation.
     *
     * @return A string representation of the user.
     */
    abstract public String toString();

    /**
     * Abstract method to be implemented by subclasses to display the user menu.
     *
     * @param database The library database.
     * @param user     The logged-in user.
     */
    abstract public void menu(CDatabase database, CUser user);
}
