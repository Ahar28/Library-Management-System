package DataObject;
/**
 * The Book class represents a book object with various properties such as bookID, title, author, ISBN, year, genre, and availability.
 */
public class Book {
    private String bookID;
    private String title;
    private String author;
    private String isbn;
    private int year;
    private String genre;
    private boolean available=true;
    /**
     * Constructs a Book object with the provided details.
     *
     * @param bookID     the unique identifier of the book
     * @param title      the title of the book
     * @param author     the author of the book
     * @param isbn       the ISBN (International Standard Book Number) of the book
     * @param year       the publication year of the book
     * @param genre      the genre of the book
     * @param available  the availability status of the book
     */
    public Book(String bookID, String title, String author, String isbn, int year, String genre, boolean available) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.genre = genre;
        this.available = available;
    }

    /**
     * Retrieves the book's unique identifier.
     *
     * @return the book's unique identifier
     */
    public String getBookID() {
        return bookID;
    }
    /**
     * Sets the book's unique identifier.
     *
     * @param bookID the unique identifier to set
     */
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    /**
     * Retrieves the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of the book.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Retrieves the author of the book.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Sets the author of the book.
     *
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Retrieves the ISBN (International Standard Book Number) of the book.
     *
     * @return the ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Sets the ISBN (International Standard Book Number) of the book.
     *
     * @param isbn the ISBN to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * Retrieves the publication year of the book.
     *
     * @return the publication year of the book
     */
    public int getYear() {
        return year;
    }
    /**
     * Sets the publication year of the book.
     *
     * @param year the publication year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * Retrieves the genre of the book.
     *
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }
    /**
     * Sets the genre of the book.
     *
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    /**
     * Checks if the book is currently available.
     *
     * @return true if the book is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }
    /**
     * Sets the availability status of the book.
     *
     * @param available the availability status to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
