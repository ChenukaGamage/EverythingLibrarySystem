/**
 * The `IOOperation` interface defines the contract for operations that can be performed in the library system.
 */
public interface IOOperation 
{
   /**
     * Performs a specific operation using the given library database and user.
     *
     * @param database The library database.
     * @param user     The user on which the operation will be performed.
     */
   public void oper(CDatabase database, CUser user);
}
