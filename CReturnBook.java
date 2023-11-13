import java.util.Scanner;

/**
 * The `CReturnBook` class represents an operation where a user returns a borrowed book.
 * This class implements the `IOOperation` interface.
 */
public class CReturnBook implements IOOperation 
{
    /**
     * Executes the return book operation by interacting with the user and updating the database.
     *
     * @param database The library database.
     * @param user     The logged-in user.
     */
    public void oper(CDatabase database, CUser user) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the book name: ");
        String bName = scan.next();

        if (!database.getBorrows().isEmpty()) 
        {
            for (CBorrowing borrow : database.getBorrows()) 
            {
                if ((borrow.getBook().getName().matches(bName)) && (borrow.getPatron().getFirstName().matches(user.getFirstName()))) 
                {
                    CBook book = borrow.getBook();
                    int bookIndex = database.getAllBooks().indexOf(book);

                    if (borrow.getDaysLeft() < 0) 
                    {
                        System.out.println("You have incurred a fine, please pay at the front desk to continue using us.");
                        new CCalculateFines();
                    }

                    book.setStock(book.getStock() + 1);
                    database.returnBook(borrow, book, bookIndex);
                    System.out.println("Book returned\nThank you!\n");
                    break;
                } 
                else 
                {
                    System.out.println("You have not borrowed this book.");
                }
            }
        } 
        else 
        {
            System.out.println("You have no borrows.");
        }
        
        user.menu(database, user);
        scan.close();
    }
}
