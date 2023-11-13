import java.util.Scanner;

/**
 * The `CPlaceOrder` class represents an operation where a clerk places an order for customer requests.
 * This class implements the `IOOperation` interface.
 */
public class CPlaceOrder implements IOOperation 
{
    /**
     * Executes the place order operation by interacting with the user and updating the database.
     *
     * @param database The library database.
     * @param user     The logged-in user (clerk).
     */
    public void oper(CDatabase database, CUser user) 
    {
        COrder order = new COrder();
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter the book name: ");
        String bName = scan.next();
        int index = database.getBook(bName);

        if (index <= -1) 
        {
            System.out.println("Book does not exist in this Library!");
        } 
        else 
        {
            CBook book = database.getBook(index);
            order.setBook(book);
            order.setUser(user);

            System.out.println("Please enter the quantity you want to order: ");
            int quantity = scan.nextInt();
            order.setStock(quantity);

            System.out.println("The total price for this transaction would be: " + (100 * order.getStock()));
            System.out.println("Please pay at the reception when you come to collect the book(s)");
        }
        
        user.menu(database, user);
        scan.close();
    }
}
