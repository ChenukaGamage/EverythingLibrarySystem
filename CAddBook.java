import java.util.Scanner;

/**
 * CAddBook class implements the IOOperation interface to define the operation of adding a book to the library database.
 */
public class CAddBook implements IOOperation
{
   /**
    * Overrides the oper method from the IOOperation interface to add a book to the library database.
    * @param database The CDatabase object representing the library database.
    * @param user The CUser object representing the user performing the operation.
    */
   @Override
   public void oper(CDatabase database, CUser user)
   {
      Scanner scan = new Scanner(System.in);
      CBook book = new CBook();

      // Get book details from the user
      System.out.println("Please enter a book name: ");
      String name = scan.nextLine();

      // Check if the book already exists in the database
      if(database.getBook(name) > -1)
      {
         System.out.println("This book already exists\n");
      }
      else
      {      
         // Set book details
         book.setName(name);
         System.out.println("Please enter the author: ");
         book.setAuthor(scan.nextLine());
         System.out.println("Please enter the publisher: ");
         book.setPublisher(scan.nextLine());
         System.out.println("Please enter the status: ");
         book.setStatus(scan.nextLine());
         System.out.println("Please enter the stock: ");
         book.setStock(scan.nextInt());

         // Add the book to the database
         database.addBook(book);
         System.out.println("Book added successfully! ");
      }

      // Return to the user menu
      user.menu(database, user);
      scan.close();
   }   
}
