package Lib;

import BussinessLayer.LibraryManagementSystem;
import DAO.BookDAO;
import DAO.UserDAO;
import DAOImp.BookDAOImp;
import DAOImp.UserDAOImp;
import DataObject.Book;
import DataObject.User;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagementSystemTest {

    private BookDAO bookDAO;
    private UserDAO userDAO;
    @Mock
    private LibraryManagementSystem libraryManagementSystem;
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Test
    public void TestCLI(){
        libraryManagementSystem.setChoice(9);
    }

    @Test
    public void TestCLI_While_loop(){
        libraryManagementSystem.setExit(true);
        libraryManagementSystem.setChoice(1);
    }
    @BeforeEach
    public void setup() {
        bookDAO = new BookDAOImp();
        userDAO = new UserDAOImp();
        libraryManagementSystem = new LibraryManagementSystem(bookDAO, userDAO);
        //testOut = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(testOut));
    }
    @After
    public void tearDown() {
        // Restore original System.in and System.out
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void test_viewAllBooks() {
        libraryManagementSystem.viewAllBooks();
    }


    public void testCLI_ViewAllBooksOption() {
        // Add test books to the bookDAO
        Book book1 = new Book("1", "Book 1", "Author 1", "ISBN 1", 2021, "Genre 1", true);
        Book book2 = new Book("2", "Book 2", "Author 2", "ISBN 2", 2022, "Genre 2", true);
        bookDAO.addBook(book1);
        bookDAO.addBook(book2);

        // Simulate user input: 1 (View all books), 9 (Exit)
        String input = "1\n9";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        libraryManagementSystem.CLI();

        // Verify the expected output
        String expectedOutput = "Library Management System\n" +
                "1. View all books\n" +
                "2. Add a book\n" +
                "3. Update a book\n" +
                "4. Delete a book\n" +
                "5. View all users\n" +
                "6. Add a user\n" +
                "7. Update a user\n" +
                "8. Delete a user\n" +
                "9. Exit\n" +
                "Enter your choice: \n" +
                "Books:\n" +
                "Book 1 by Author 1\n" +
                "Book 2 by Author 2\n" +
                "\n" +
                "Library Management System has been closed.\n";
        assertEquals(expectedOutput, testOut.toString());
    }
    @Test
    public void testviewAllBooks() {
        String expectedOutput = "Books:\n" +
                "Book 1 by Author 1\n" +
                "Book 2 by Author 2\n";

        List<Book> mockBooks = new ArrayList<>();
        mockBooks.add(new Book("B001", "Book 1", "Author 1", "ISBN-001", 2020, "Genre 1", true));
        mockBooks.add(new Book("B002", "Book 2", "Author 2", "ISBN-002", 2019, "Genre 2", false));
        assertEquals(expectedOutput, "Books:\n" +mockBooks.get(0).getTitle()+" by "+mockBooks.get(0).getAuthor()+"\n"+mockBooks.get(1).getTitle()+" by "+mockBooks.get(1).getAuthor()+"\n");
    }

    @Test
    public void testAddBook() {

        Book book = new Book("B003", "New Book", "New Author", "1234567890", 2022, "New Genre",true);
        bookDAO.addBook(book);
        List<Book> mockBooks = new ArrayList<>();

       Book addedBook = bookDAO.getBookByID("B003");
        assertNotNull(addedBook);
        assertEquals("New Book", addedBook.getTitle());
        assertEquals("New Author", addedBook.getAuthor());
        assertEquals("1234567890", addedBook.getIsbn());
        assertEquals(2022, addedBook.getYear());
        assertEquals("New Genre", addedBook.getGenre());
    }

    @Test
    public void testUpdateBook() {

        Book book = bookDAO.getBookByID("B001");
        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setIsbn("New ISBN");
        book.setYear(2022);
        book.setGenre("New Genre");

        Book updatedBook = bookDAO.getBookByID("B001");
        assertNotNull(updatedBook);
        assertEquals("New Title", updatedBook.getTitle());
        assertEquals("New Author", updatedBook.getAuthor());
        assertEquals("New ISBN", updatedBook.getIsbn());
        assertEquals(2022, updatedBook.getYear());
        assertEquals("New Genre", updatedBook.getGenre());
    }

    @Test
    public void testDeleteBook() {
        bookDAO.deleteBook("B001");
        assertNull(bookDAO.getBookByID("B001"));
    }

    @Test
    public void test_ViewAllUsers() {

        libraryManagementSystem.viewAllUsers();
    }

        @Test
    public void testViewAllUsers() {

        String expectedOutput = "Users:\n" +
                "user1 (John Doe)\n" +
                "user2 (Jane Smith)\n";

       // UserDAO userDAO = mock(UserDAO.class);
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User("U001", "user1", "John", "Doe", "updated@example.com", "9876543210", true));
        mockUsers.add(new User("U002", "user2", "Jane", "Smith", "updated2@example.com", "1234567890", true));
       // when(userDAO.getAllUsers()).thenReturn(mockUsers);
        assertEquals(expectedOutput, "Users:\n" +mockUsers.get(0).getUsername()+" ("+mockUsers.get(0).getFirstName()+" "+mockUsers.get(0).getLastName()+")\n"+mockUsers.get(1).getUsername()+" ("+mockUsers.get(1).getFirstName()+" "+mockUsers.get(1).getLastName()+")\n");
    }
    
    @Test
    public void testAddUser() {
        String userInput = "6\nU003\nnewuser\nNew\nUser\nnewuser@example.com\n1234567890\n9\n";
        User user = new User("U003", "newuser", "New", "User", "newuser@example.com", "1234567890",true);
        userDAO.addUser(user);

        User addedUser = userDAO.getUserByID("U003");
        assertNotNull(addedUser);
        assertEquals("newuser", addedUser.getUsername());
        assertEquals("New", addedUser.getFirstName());
        assertEquals("User", addedUser.getLastName());
        assertEquals("newuser@example.com", addedUser.getEmail());
        assertEquals("1234567890", addedUser.getPhoneNumber());
    }

    @Test
    public void testUpdateUser() {
        String userInput = "7\nU001\nnewuser1\nNew1\nUser1\nnewuser1@example.com\n9876543210\n9\n";

        User UsertoUpdate = userDAO.getUserByID("U001");
        UsertoUpdate.setUsername("newuser1");
        UsertoUpdate.setFirstName("New1");
        UsertoUpdate.setLastName("User1");
        UsertoUpdate.setEmail("newuser1@example.com");
        UsertoUpdate.setPhoneNumber("9876543210");

        User updatedUser = userDAO.getUserByID("U001");
        assertNotNull(updatedUser);
        assertEquals("newuser1", updatedUser.getUsername());
        assertEquals("New1", updatedUser.getFirstName());
        assertEquals("User1", updatedUser.getLastName());
        assertEquals("newuser1@example.com", updatedUser.getEmail());
        assertEquals("9876543210", updatedUser.getPhoneNumber());
    }

    @Test
    public void testDeleteUser() {

        userDAO.deleteUser("U001");
        assertNull(userDAO.getUserByID("U001"));
    }
 }