import java.util.Scanner;

/**
 * Class representing the operation to delete a book from the library system.
 */
public class CDeleteBook implements IOOperation
{
   /**
     * Performs the operation to delete a book.
     *
     * @param database The database containing book information.
     * @param user     The user performing the operation.
     */
   public void oper(CDatabase database, CUser user)
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Please enter the book name");
      String bName = scan.next();

      int bIndex = database.getBook(bName);
      if (bIndex > -1)
      {
         database.deleteBook(bIndex);
         System.out.println("Book " + bName + " Deleted Successfully");
      }
      else
      {
            System.out.println("Book does not exist");
      }
      user.menu(database, user);
      scan.close();
   }
}
