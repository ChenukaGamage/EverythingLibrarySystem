public class CBook 
{
    private String _name, _author, _publisher, _status;
    private int _stock;

    // Default constructor
    public CBook() {}

    // Parameterized constructor
    public CBook(String aBookName, String aBookAuthor, String aBookPublisher, String aBookStatus, int aQty) 
    {
        this._name = aBookName;
        this._author = aBookAuthor;
        this._publisher = aBookPublisher;
        this._status = aBookStatus;
        this._stock = aQty;
    }

    // Getter for book name
    public String getName() 
    {
        return _name;
    }

    // Setter for book name
    public void setName(String aName) 
    {
        this._name = aName;
    }

    // Getter for book author
    public String getAuthor() 
    {
        return _author;
    }

    // Setter for book author
    public void setAuthor(String aAuthor) 
    {
        this._author = aAuthor;
    }

    // Getter for book publisher
    public String getPublisher() 
    {
        return _publisher;
    }

    // Setter for book publisher
    public void setPublisher(String aPublisher) 
    {
        this._publisher = aPublisher;
    }

    // Getter for book status
    public String getStatus() 
    {
        return _status;
    }

    // Setter for book status
    public void setStatus(String aStatus) 
    {
        this._status = aStatus;
    }

    // Getter for book stock
    public int getStock() 
    {
        return _stock;
    }

    // Setter for book stock
    public void setStock(int aStock) 
    {
        this._stock = aStock;
    }

    // String representation of the book
    public String toString() 
    {
        return "Book name: " + _name + "\nBook Author: " + _author + "\nBook Publisher: " + _publisher +
            "\nBook Status: " + _status + "\nBook Quantity: " + _stock + "\n";
    }

    // Convert book information to a string for saving to a file
    public String toString2() 
    {
        return _name + "<N/>" + _author + "<N/>" + _publisher + "<N/>" + _status + "<N/>" + _stock;
    }
}
