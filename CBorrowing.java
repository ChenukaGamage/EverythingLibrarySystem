import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Class representing the borrowing information for a book.
 */
public class CBorrowing 
{
    Scanner _scan = new Scanner(System.in);

    LocalDate _start;
    LocalDate _finish;
    int _daysLeft;
    CBook _book;
    CUser _patron;

    DateTimeFormatter _formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Constructor for creating a new borrowing instance with the current date as the start date,
     * a due date 14 days later, and initializing book and patron information.
     *
     * @param aBook The book being borrowed.
     * @param aUser The user borrowing the book.
     */
    public CBorrowing(CBook aBook, CUser aUser) 
    {
        this._start = LocalDate.now();
        this._finish = _start.plusDays(14);
        this._daysLeft = Period.between(_start, _finish).getDays();
        this._book = aBook;
        this._patron = aUser;
    }

    /**
     * Constructor for creating a borrowing instance with specified start and finish dates,
     * along with book and patron information.
     *
     * @param aStart  The start date of the borrowing.
     * @param aFinish The due date of the borrowing.
     * @param aBook   The book being borrowed.
     * @param aUser   The user borrowing the book.
     */
    public CBorrowing(LocalDate aStart, LocalDate aFinish, CBook aBook, CUser aUser) 
    {
        this._start = aStart;
        this._finish = aFinish;
        this._daysLeft = Period.between(LocalDate.now(), aFinish).getDays();
        this._book = aBook;
        this._patron = aUser;
    }

    /**
     * Get the formatted start date of the borrowing.
     *
     * @return The formatted start date.
     */
    public String getStart() 
    {
        return _formatter.format(_start);
    }

    /**
     * Get the formatted due date of the borrowing.
     *
     * @return The formatted due date.
     */
    public String getFinish() 
    {
        return _formatter.format(_finish);
    }

    /**
     * Get the number of days left until the due date.
     *
     * @return The number of days left.
     */
    public int getDaysLeft() 
    {
        return Period.between(LocalDate.now(), _finish).getDays();
    }

    /**
     * Get the book being borrowed.
     *
     * @return The book.
     */
    public CBook getBook() 
    {
        return _book;
    }

    /**
     * Set the book being borrowed.
     *
     * @param aBook The book to set.
     */
    public void setBook(CBook aBook) 
    {
        this._book = aBook;
    }

    /**
     * Get the user borrowing the book.
     *
     * @return The user.
     */
    public CUser getPatron() 
    {
        return _patron;
    }

    /**
     * Set the user borrowing the book.
     *
     * @param aPatron The user to set.
     */
    public void setPatron(CUser aPatron) 
    {
        this._patron = aPatron;
    }

    /**
     * Get a string representation of the borrowing information.
     *
     * @return A string representation.
     */
    public String toString() 
    {
        return ("Borrowing Time: " + _start + "\nDue Date: " + _finish + "\nDays Left: " + _daysLeft);
    }

    /**
     * Get a formatted string for saving borrowing information to a file.
     *
     * @return The formatted string.
     */
    public String toString2() 
    {
        String toReturn = getStart() + "<N/>" + getFinish() + "<N/>" + getDaysLeft() + "<N/>" + _book.getName() + "<N/>" + _patron.getFirstName();
        return toReturn;
    }
}