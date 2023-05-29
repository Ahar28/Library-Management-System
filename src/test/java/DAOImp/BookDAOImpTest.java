package DAOImp;

import DAO.BookDAO;
import DataObject.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookDAOImpTest {

    private BookDAO bookDAO;

    @BeforeEach
    public void setup() {
        bookDAO = new BookDAOImp();
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testGetBookByID_ExistingBook_ReturnsBook() {
        String bookID = "B001";
        Book book = bookDAO.getBookByID(bookID);
        assertNotNull(book);
        assertEquals(bookID, book.getBookID());
    }

    @Test
    public void testGetBookByID_NonExistingBook_ReturnsNull() {
        String bookID = "B003";
        Book book = bookDAO.getBookByID(bookID);
        assertNull(book);
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("B003", "Book 3", "Author 3", "ISBN-003", 2021, "Genre 3", true);
        bookDAO.addBook(newBook);

        List<Book> books = bookDAO.getAllBooks();
        assertEquals(3, books.size());
        assertTrue(books.contains(newBook));
    }

    @Test
    public void testUpdateBook_ExistingBook_SuccessfullyUpdated() {
        String bookID = "B001";
        Book bookToUpdate = new Book(bookID, "Updated Book", "Updated Author", "ISBN-001", 2020, "Genre 1", true);
        bookDAO.updateBook(bookToUpdate);

        Book updatedBook = bookDAO.getBookByID(bookID);
        assertNotNull(updatedBook);
        assertEquals("Updated Book", updatedBook.getTitle());
        assertEquals("Updated Author", updatedBook.getAuthor());
    }

    @Test
    public void testUpdateBook_NonExistingBook_NoUpdatePerformed() {
        String bookID = "B003";
        Book bookToUpdate = new Book(bookID, "Updated Book", "Updated Author", "ISBN-003", 2021, "Genre 3", true);
        bookDAO.updateBook(bookToUpdate);

        Book nonExistingBook = bookDAO.getBookByID(bookID);
        assertNull(nonExistingBook);
    }

    @Test
    public void testDeleteBook_ExistingBook_SuccessfullyDeleted() {
        String bookID = "B001";
        bookDAO.deleteBook(bookID);

        Book deletedBook = bookDAO.getBookByID(bookID);
        assertNull(deletedBook);

        List<Book> books = bookDAO.getAllBooks();
        assertEquals(1, books.size());
    }

    @Test
    public void testDeleteBook_NonExistingBook_NoDeletePerformed() {
        String bookID = "B003";
        bookDAO.deleteBook(bookID);

        List<Book> books = bookDAO.getAllBooks();
        assertEquals(2, books.size());
    }
}
