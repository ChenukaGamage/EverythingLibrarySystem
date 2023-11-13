import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Class representing the database for the Everything Library System.
 */
public class CDatabase 
{
    private ArrayList<CUser> users = new ArrayList<CUser>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<CBook> books = new ArrayList<CBook>();
    private ArrayList<String> booknames = new ArrayList<String>();
    private ArrayList<COrder> orders = new ArrayList<COrder>();
    private ArrayList<CBorrowing> borrowings = new ArrayList<CBorrowing>();
    private File borrowingsfile = new File(".\\EverythingLibrarySystem\\Data\\borrowings");
    private File folder = new File(".\\EverythingLibrarySystem\\data");
    private File usersfile = new File(".\\EverythingLibrarySystem\\data\\Users");
    private File booksfile = new File(".\\EverythingLibrarySystem\\data\\Books");
    private File ordersfile = new File(".\\EverythingLibrarySystem\\Data\\Orders");

    /**
     * Constructor for the CDatabase class. Initializes necessary files and folders and loads existing data.
     */
    public CDatabase() 
    {
        if (!folder.exists()) 
        {
            folder.mkdirs();
        }

        if (!usersfile.exists()) 
        {
            try 
            {
                usersfile.createNewFile();
            } 
            catch (Exception e) 
            {
            }
        }

        if (!booksfile.exists()) 
        {
            try 
            {
                booksfile.createNewFile();
            } 
            catch (Exception e) 
            {
            }
        }

        if (!ordersfile.exists()) 
        {
            try 
            {
                ordersfile.createNewFile();
            } 
            catch (Exception e) 
            {
            }
        }
        if (!borrowingsfile.exists()) 
        {
            try 
            {
                borrowingsfile.createNewFile();
            } 
            catch (Exception e) 
            {
            }
        }

        getUsers();
        getBooks();
        getOrders();
        getBorrowings();
    }

    /**
     * Adds a user to the database.
     *
     * @param aPerson The user to be added.
     */
    public void addUser(CUser aPerson) 
    {
        users.add(aPerson);
        usernames.add(aPerson.getFirstName());
        saveUsers();
    }

    /**
     * Logs in a user based on email and password.
     *
     * @param aEmail The user's email.
     * @param aPass  The user's password.
     * @return The index of the user if found, otherwise -1.
     */
    public int login(String aEmail, String aPass) 
    {
        int index = -1;
        for (CUser c : users) 
        {
            if (c.getEmail().matches(aEmail) && c.getPassword().matches(aPass)) 
            {
                index = users.indexOf(c);
                break;
            }
        }
        return index;
    }


    /**
     * Retrieves a user based on the given index.
     *
     * @param aIndex The index of the user.
     * @return The user at the specified index.
     */
    public CUser getUserIndex(int aIndex) 
    {
        return users.get(aIndex);
    }


    /**
     * Adds a new book to the database.
     *
     * @param aNewBook The book to be added.
     */
    public void addBook(CBook aNewBook) 
    {
        books.add(aNewBook);
        booknames.add(aNewBook.getName());
        saveBooks();
    }

	
    /**
     * Reads user data from the file and populates the users list.
     */
    private void getUsers() 
    {
        String text1 = "";
        try 
        {
            BufferedReader read = new BufferedReader(new FileReader(usersfile));
            String line;
            while ((line = read.readLine()) != null) 
            {
                text1 = text1 + line;
            }
            read.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) 
        {
            String[] attribute1 = text1.split("<NewUser/>");
            for (String att : attribute1) 
            {
                String[] attribute2 = att.split("<N/>");
                if (attribute2[attribute2.length - 1].matches("Admin")) 
                {
                    CUser user = new CAdmin(attribute2[0], attribute2[1], attribute2[2], attribute2[3]);
                    addUser(user);
                } 
                else 
                {
                    CUser user = new CPatron(attribute2[0], attribute2[1], attribute2[2], attribute2[3]);
                    addUser(user);
                }
            }
        }
    }

    /**
     * Saves user data to the file.
     */
    private void saveUsers() 
    {
        String text1 = "";
        for (CUser user : users) 
        {
            text1 = text1 + user.toString() + "<NewUser/>\n";
        }
        try 
        {
            PrintWriter writer = new PrintWriter(usersfile);
            writer.print(text1);
            writer.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }
    }


    /**
     * Saves book data to the file.
     */
    private void saveBooks() 
    {
        String text1 = "";
        for (CBook book : books) 
        {
            text1 = text1 + book.toString2() + "<NewBook/>\n";
        }
        try 
        {
            PrintWriter writer = new PrintWriter(booksfile);
            writer.print(text1);
            writer.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }
    }

    /**
     * Parses book attributes from a string and creates a book object.
     *
     * @param aAttribute The string containing book attributes.
     * @return The created book object.
     */
    public CBook parseBook(String aAttribute) 
    {
        String[] attribute = aAttribute.split("<N/>");
        CBook book = new CBook(attribute[0], attribute[1], attribute[2], attribute[3], Integer.parseInt(attribute[4]));
        return book;
    }

    /**
     * Reads book data from the file and populates the books list.
     */
    private void getBooks() 
    {
        String text1 = "";
        try 
        {
            BufferedReader read = new BufferedReader(new FileReader(booksfile));
            String line;
            while ((line = read.readLine()) != null) 
            {
                text1 = text1 + line;
            }
            read.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) 
        {
            String[] attribute1 = text1.split("<NewBook/>");
            for (String att : attribute1) 
            {
                CBook book = parseBook(att);
                addBook(book);
            }
        }
    }

    /**
     * Retrieves a list of all books in the database.
     *
     * @return The list of all books.
     */
    public ArrayList<CBook> getAllBooks() 
    {
        return books;
    }

    /**
     * Gets the index of a book with the specified name.
     *
     * @param bookName The name of the book to search for.
     * @return The index of the book, or -1 if not found.
     */
    public int getBook(String bookName) 
    {
        int index = -1;
        for (CBook book : books) 
        {
            if (book.getName().matches(bookName)) 
            {
                index = books.indexOf(book);
            }
        }
        return index;
    }

    /**
     * Retrieves the book at the specified index.
     *
     * @param aIndex The index of the book.
     * @return The book at the specified index.
     */
    public CBook getBook(int aIndex) 
    {
        return books.get(aIndex);
    }

    /**
     * Deletes a book at the specified index.
     *
     * @param aIndex The index of the book to delete.
     */
    public void deleteBook(int aIndex) 
    {
        books.remove(aIndex);
        booknames.remove(aIndex);
        saveBooks();
    }

    /**
     * Deletes a user at the specified index.
     *
     * @param aIndex The index of the user to delete.
     */
    public void deleteUser(int aIndex) 
    {
        users.remove(aIndex);
        usernames.remove(aIndex);
        saveUsers();
    }

    /**
     * Adds an order to the database.
     *
     * @param aOrder The order to be added.
     */
    public void addOrder(COrder aOrder) 
    {
        orders.add(aOrder);
        saveOrders();
    }

    /**
     * Saves order data to the file.
     */
    private void saveOrders() 
    {
        String text1 = "";
        for (COrder order : orders) 
        {
            text1 = text1 + order.toString2() + "<NewOrder/>\n";
        }
        try 
        {
            PrintWriter writer = new PrintWriter(ordersfile);
            writer.print(text1);
            writer.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }
    }

    /**
     * Reads order data from the file and populates the orders list.
     */
    private void getOrders() 
    {
        String text1 = "";
        try 
        {
            BufferedReader read = new BufferedReader(new FileReader(ordersfile));
            String line;
            while ((line = read.readLine()) != null) 
            {
                text1 = text1 + line;
            }
            read.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) 
        {
            String[] attribute1 = text1.split("<NewOrder/>");
            for (String att : attribute1) 
            {
                COrder order = parseOrder(att);
                orders.add(order);
            }
        }
    }

    /**
     * Checks if an email already exists in the database.
     *
     * @param aEmail The email to check.
     * @return True if the email exists, false otherwise.
     */
    public boolean emailExists(String aEmail) 
    {
        boolean check = false;
        for (CUser u : users) 
        {
            if (u.getEmail().matches(aEmail)) 
            {
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * Retrieves a user with the specified first name.
     *
     * @param aFName The first name of the user to retrieve.
     * @return The user with the specified first name.
     */
    private CUser getUserByName(String aFName) 
    {
        CUser user = new CPatron("");
        for (CUser u : users) 
        {
            if (u.getFirstName().matches(aFName)) 
            {
                user = u;
                break;
            }
        }
        return user;
    }

    /**
     * Parses order information from a string and creates an order object.
     *
     * @param info The string containing order information.
     * @return The created order object.
     */
    private COrder parseOrder(String info) 
    {
        String[] attribute = info.split("<N/>");
        COrder order = new COrder(books.get(getBook(attribute[0])), getUserByName(attribute[1]), Integer.parseInt(attribute[2]));
        return order;
    }

    /**
     * Retrieves a list of all orders in the database.
     *
     * @return The list of all orders.
     */
    public ArrayList<COrder> getAllOrders() 
    {
        return orders;
    }

    /**
     * Saves borrowing data to the file.
     */
    public void saveBorrowing() 
    {
        String text1 = "";
        for (CBorrowing borrow : borrowings) 
        {
            text1 = text1 + borrow.toString2() + "<NewBorrow/>\n";
        }
        try 
        {
            PrintWriter writer = new PrintWriter(borrowingsfile);
            writer.print(text1);
            writer.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }
    }


    /**
     * Reads borrowing data from the file and populates the borrowings list.
     */
    public void getBorrowings() 
    {
        String text1 = "";
        try 
        {
            BufferedReader read = new BufferedReader(new FileReader(borrowingsfile));
            String line;
            while ((line = read.readLine()) != null) 
            {
                text1 = text1 + line;
            }
            read.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) 
        {
            String[] attribute1 = text1.split("<NewBorrow/>");
            for (String att : attribute1) 
            {
                CBorrowing borrow = parseCborrowing(att);
                borrowings.add(borrow);
            }
        }
    }

    /**
     * Parses borrowing information from a string and creates a borrowing object.
     *
     * @param aLines The string containing borrowing information.
     * @return The created borrowing object.
     */
    private CBorrowing parseCborrowing(String aLines) 
    {
        String[] attribute = aLines.split("<N/>");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(attribute[0], formatter);
        LocalDate finish = LocalDate.parse(attribute[1], formatter);
        CBook book = getBook(getBook(attribute[3]));
        CUser user = getUserByName(attribute[4]);
        CBorrowing borrow = new CBorrowing(start, finish, book, user);
        return borrow;
    }

    /**
     * Borrows a book, adds the borrowing to the list, and updates book and borrowing data in the files.
     *
     * @param aBorrow The borrowing to be added.
     * @param aBook The book to be borrowed.
     * @param bIndex The index of the book.
     */
    public void borrowBook(CBorrowing aBorrow, CBook aBook, int bIndex) 
    {
        borrowings.add(aBorrow);
        books.set(bIndex, aBook);
        saveBorrowing();
        saveBooks();
    }

    /**
     * Retrieves a list of all borrowings in the database.
     *
     * @return The list of all borrowings.
     */
    public ArrayList<CBorrowing> getBorrows() 
    {
        return borrowings;
    }

    /**
     * Returns a book, removes the borrowing from the list, and updates book and borrowing data in the files.
     *
     * @param aBorrow The borrowing to be removed.
     * @param aBook The book to be returned.
     * @param aBookIndex The index of the book.
     */
    public void returnBook(CBorrowing aBorrow, CBook aBook, int aBookIndex) 
    {
        borrowings.remove(aBorrow);
        books.set(aBookIndex, aBook);
        saveBorrowing();
        saveBooks();
    }

    /**
     * Retrieves the index of a user with the specified email ID.
     *
     * @param aEmailID The email ID of the user.
     * @return The index of the user.
     */
    public int getUser(String aEmailID) 
    {
        int index = -1;
        for (CUser user : users) 
        {
            if (user.getEmail().matches(aEmailID)) 
            {
                index = users.indexOf(user);
            }
        }
        return index;
    }
}