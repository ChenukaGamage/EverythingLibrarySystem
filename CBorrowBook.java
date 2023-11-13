import java.util.Scanner;

/**
 * Class representing the operation of borrowing a book.
 * Implements the IOOperation interface.
 */
public class CBorrowBook implements IOOperation 
{
    /**
     * Executes the borrow book operation.
     * 
     * @param database The database where book and user information is stored.
     * @param user The user performing the operation.
     */
    @Override
    public void oper(CDatabase database, CUser user)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the book name");
        String bName = scan.next();

        // Get the index of the book in the database
        int bIndex = database.getBook(bName);
        if (bIndex > -1)
        {
            // Book exists in the database
            CBook book = database.getBook(bIndex);
            if (book.getStock() >= 1)
            {
                // Sufficient stock available for borrowing
                CBorrowing borrowing = new CBorrowing(book, user);
                book.setStock(book.getStock() - 1);
                database.borrowBook(borrowing, book, bIndex);
                System.out.println("You must return the book before 14 days\n" + 
                    "Expiry date: " + borrowing._finish + "\nEnjoy!\n");
            }
            else
            {
                System.out.println("All copies are loaned out.");
            }
        }
        else
        {
            // Book does not exist in the database
            System.out.println("Book doesn't exist\n");
        }
        user.menu(database, user);
        scan.close();
    }
}
