package DataObject;

/*public class BookTest {
}*/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testIsAvailable() {
        // Create a book object with availability set to true
        Book book = new Book("123", "Sample Book", "John Doe", "9781234567890", 2023, "Fiction", true);

        // Assert that the book is available
        assertTrue(book.isAvailable(), "Book should be available");

        // Set the availability of the book to false
        book.setAvailable(false);

        // Assert that the book is no longer available
        assertFalse(book.isAvailable(), "Book should not be available");
    }
}
