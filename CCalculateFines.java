import java.util.Scanner;

/**
 * Class representing an operation to calculate fines for a user based on the borrowed book.
 */
public class CCalculateFines implements IOOperation
{
   /**
    * Calculates fines for a user based on the borrowed book.
    *
    * @param database The database containing book and borrowing information.
    * @param user     The user for whom fines are calculated.
    */
   public void oper(CDatabase database, CUser user)
   {
      System.out.println("Please enter the book name:");
      Scanner scan = new Scanner(System.in);
      String bName = scan.next();

      for(CBorrowing borrow : database.getBorrows())
      {
         if(borrow.getBook().getName().matches(bName) && borrow.getPatron().getEmail().matches(user.getEmail()))
         {
            if(borrow.getDaysLeft() < 0)
            {
               System.out.println("You have incurred a fine of $ " + Math.abs(borrow.getDaysLeft()) * 10);
            }
            else
            {
               System.out.println("You have " + borrow.getDaysLeft() + "'s left.\nEnjoy!");
            }
         }
      }

      user.menu(database, user);
      scan.close();
   }
}
