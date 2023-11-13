/**
 * The `CViewOrders` class implements the `IOOperation` interface.
 * It provides functionality to display information about all the orders in the library.
 * NOTE: The implementation is marked as "NOT WORKING."
 */
public class CViewOrders implements IOOperation 
{
   /**
    * Displays information about all the orders in the library.
    *
    * @param database The library database.
    * @param user    The logged-in user.
    */
   public void oper(CDatabase database, CUser user)
   {
      // Display information about each order
      System.out.println("------------------View Orders------------------------");
      for (COrder order : database.getAllOrders())
      {
         System.out.println("Book name: " + order.getBook().getName() +
            "\nUser: " + order.getUser().getFirstName() +
            "\nQuantity: " + order.getStock());
         System.out.println("------------------------------------------\n");
      }

      // Return to the user menu
      user.menu(database, user);
   }
}
