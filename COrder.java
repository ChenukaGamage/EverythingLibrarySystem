/**
 * Represents an order for a book placed by a user.
 */
public class COrder 
{
    private CBook _book;
    private CUser _user;
    private int _stock;

    /**
     * Default constructor.
     */
    public COrder() 
    {

    }

    /**
     * Parameterized constructor to create an order with specified book, user, and stock.
     *
     * @param aBook  The book for the order.
     * @param aUser  The user who placed the order.
     * @param aStock The quantity of books in the order.
     */
    public COrder(CBook aBook, CUser aUser, int aStock) 
    {
        this._book = aBook;
        this._user = aUser;
        this._stock = aStock;
    }

    /**
     * Get the book associated with the order.
     *
     * @return The book.
     */
    public CBook getBook() 
    {
        return _book;
    }

    /**
     * Set the book for the order.
     *
     * @param aBook The book to set.
     */
    public void setBook(CBook aBook) 
    {
        this._book = aBook;
    }

    /**
     * Get the user who placed the order.
     *
     * @return The user.
     */
    public CUser getUser() 
    {
        return _user;
    }

    /**
     * Set the user for the order.
     *
     * @param aUser The user to set.
     */
    public void setUser(CUser aUser) 
    {
        this._user = aUser;
    }

    /**
     * Get the quantity of books in the order.
     *
     * @return The stock quantity.
     */
    public int getStock() 
    {
        return _stock;
    }

    /**
     * Set the quantity of books in the order.
     *
     * @param aStock The stock quantity to set.
     */
    public void setStock(int aStock) 
    {
        this._stock = aStock;
    }

    /**
     * Get a string representation of the order.
     *
     * @return A string with book name, username, and quantity.
     */
    public String toString() 
    {
        return ("_book name: " + _book.getName() + "\nUsername: " + _user.getFirstName() + "\nQuantity" + _stock);
    }

    /**
     * Get a formatted string representation of the order for storage.
     *
     * @return A string with book name, username, and quantity separated by "<N/>".
     */
    public String toString2() 
    {
        String toReturn = _book.getName() + "<N/>" + _user.getFirstName() + "<N/>" + _stock;
        return toReturn;
    }
}
