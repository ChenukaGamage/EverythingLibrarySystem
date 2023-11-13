import java.util.Scanner;

/**
 * Class representing the operation to delete a user from the library system.
 */
public class CDeleteUser implements IOOperation
{
   /**
     * Performs the operation to delete a user.
     *
     * @param database The database containing user information.
     * @param user     The user performing the operation.
     */
   public void oper(CDatabase database, CUser user)
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Please enter the user email");
      String uEmail = scan.next();

      int uIndex = database.getUser(uEmail);
      if (uIndex > -1)
      {
         database.deleteUser(uIndex);
         System.out.println("User " + uEmail + " Deleted Successfully");
      }
      else
      {
            System.out.println("User does not exist");
      }
      user.menu(database, user);
      scan.close();
   }
}
