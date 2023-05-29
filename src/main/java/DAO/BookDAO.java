package DAO;

import DataObject.Book;

import java.util.List;
/**
 * The BookDAO interface provides methods for accessing and manipulating book data in a data storage system.
 */
public interface BookDAO {
    /**
     * Retrieves a list of all books in the data storage system.
     *
     * @return a list of all books
     */
    List<Book> getAllBooks();
    /**
     * Retrieves a book from the data storage system based on its unique identifier.
     *
     * @param bookID the unique identifier of the book
     * @return the book with the specified bookID, or null if not found
     */
    Book getBookByID(String bookID);
    /**
     * Adds a new book to the data storage system.
     *
     * @param book the book to add
     * @return the unique identifier assigned to the newly added book
     */
    String addBook(Book book);
    /**
     * Updates an existing book in the data storage system.
     *
     * @param book the updated book object
     */
    void updateBook(Book book);
    /**
     * Deletes a book from the data storage system based on its unique identifier.
     *
     * @param bookID the unique identifier of the book to delete
     */
    void deleteBook(String bookID);
}
