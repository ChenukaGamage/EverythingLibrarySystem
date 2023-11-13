import java.util.ArrayList;

/**
 * The `CViewBooks` class implements the `IOOperation` interface.
 * It provides functionality to display information about all the books in the library.
 */
public class CViewBooks implements IOOperation 
{
   /**
    * Displays information about all the books in the library.
    *
    * @param database The library database.
    * @param user    The logged-in user.
    */
   public void oper(CDatabase database, CUser user)
   {
      // Retrieve all books from the database
      ArrayList<CBook> books = database.getAllBooks();

      // Display information about each book
      System.out.println("------------------View Books------------------------");
      for(CBook book : books)
      {
         System.out.println("Name: " + book.getName() +
            "\nAuthor: " + book.getAuthor() +
            "\nPublisher: " + book.getPublisher() +
            "\nStatus: " + book.getStatus() +
            "\nStock: " + book.getStock() + "\n");
         System.out.println("------------------------------------------\n");
      }

      // Return to the user menu
      user.menu(database, user);
   }
}
