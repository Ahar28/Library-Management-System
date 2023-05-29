package DAOImp;

import DAO.BookDAO;
import DataObject.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * The BookDAOImp class is an implementation of the BookDAO interface that provides methods for accessing and manipulating book data in a data storage system.
 */
public class BookDAOImp implements BookDAO {
      private List<Book> bookList;

    /**
     * Constructs a BookDAOImp object and initializes the book list with sample data.
     */
      public BookDAOImp() {
          // Initialize the book list (mocking the database)
          bookList = new ArrayList<>();


          bookList.add(new Book("B001", "Book 1", "Author 1", "ISBN-001", 2020, "Genre 1",true));
          bookList.add(new Book("B002", "Book 2", "Author 2", "ISBN-002", 2019, "Genre 2",false));
      }

    /**
     * Retrieves a list of all books stored in the data storage system.
     *
     * @return a list of all books
     */
      @Override
      public List<Book> getAllBooks() {
          return bookList;
      }

    /**
     * Retrieves a specific book from the data storage system based on its unique identifier.
     *
     * @param bookID the unique identifier of the book
     * @return the book with the specified bookID, or null if not found
     */
      @Override
      public Book getBookByID(String bookID) {
          for (Book book : bookList) {
              if (book.getBookID().equals(bookID)) {
                  return book;
              }
          }
          return null;
      }

    /**
     * Adds a new book to the data storage system.
     *
     * @param book the book to add
     * @return a success message indicating the book was added successfully
     */
      @Override
      public String addBook(Book book) {
          bookList.add(book);
          return "Book added successfully";
      }

    /**
     * Updates an existing book in the data storage system.
     *
     * @param book the updated book object
     */
      @Override
      public void updateBook(Book book) {
          // Find the book in the list and update its details
          for (int i = 0; i < bookList.size(); i++) {
              if (book.isAvailable()){
                  bookList.get(i).setBookID(bookList.get(i).getBookID());
                  if (bookList.get(i).getBookID().equals(book.getBookID())) {
                      bookList.set(i, book);
                      break;
                  }
              }
              }

      }

    /**
     * Deletes a book from the data storage system based on its unique identifier.
     *
     * @param bookID the unique identifier of the book to delete
     */
      @Override
      public void deleteBook(String bookID) {
          // Find the book in the list and remove it
          for (int i = 0; i < bookList.size(); i++) {
              if (bookList.get(i).getBookID().equals(bookID)) {
                  bookList.remove(i);
                  break;
              }
          }
      }
  }