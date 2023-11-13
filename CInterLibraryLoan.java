import java.util.Scanner;

/**
 * Class representing the operation to request an inter-library loan.
 */
public class CInterLibraryLoan implements IOOperation
{
    /**
     * Performs the operation to request an inter-library loan.
     *
     * @param database The database containing system information.
     * @param user     The user performing the operation.
     */
    public void oper(CDatabase database, CUser user)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the book information to order");
        CBook book = new CBook();
        System.out.println("Please enter the book name: ");
        String name = scan.nextLine();
        if (database.getBook(name) > -1)
        {
            System.out.println("This book is already available\n");
        }
        else
        {
            book.setName(name);
            System.out.println("Please enter the author: ");
            book.setAuthor(scan.nextLine());
            System.out.println("Please enter the publisher: ");
            book.setPublisher(scan.nextLine());
            System.out.println("The order has been sent for review\nWe will update you at: " + user.getEmail());
        }
        user.menu(database, user);
        scan.close();
    }
}
