import java.util.Scanner;

/**
 * Class representing the operation to exit the library system.
 */
public class CExit implements IOOperation
{
   /**
    * Performs the operation to exit the library system.
    *
    * @param database The database containing system information.
    * @param user    The user performing the operation.
    */
   public void oper(CDatabase database, CUser user)
   {
      System.out.println("\nAre you sure you want to quit?\n1. Yes\n2. Sign out");
      Scanner scan = new Scanner(System.in);

      int userInput = scan.nextInt();
      if (userInput == 1)
      {
         scan.close();
         System.out.println("----------------------Thank you for using us!----------------------");
      }
      else
      {
         CMain.main(null);
      }
   }
}
