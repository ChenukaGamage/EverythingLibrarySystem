import java.util.Scanner;

/**
 * The `CSearch` class represents an operation where a user searches for a book by its name.
 * This class implements the `IOOperation` interface.
 */
public class CSearch implements IOOperation 
{
   /**
    * Executes the search operation by interacting with the user and displaying the book information.
    *
    * @param database The library database.
    * @param user    The logged-in user.
    */
   public void oper(CDatabase database, CUser user) 
   {
      Scanner scan = new Scanner(System.in);
      System.out.print("\nEnter book name to be searched: ");
      String bName = scan.next();

      int bIndex = database.getBook(bName);
      if (bIndex > -1) 
      {
         System.out.println(database.getBook(bIndex).toString());
      } 
      else 
      {
         System.out.println("Book does not exist.");
      }
      
      user.menu(database, user);
      scan.close();
   }
}
