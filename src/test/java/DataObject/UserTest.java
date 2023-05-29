package DataObject;

import DataObject.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testIsActiveUser() {
        // Create a user object
        User user = new User("123", "john.doe", "John", "Doe", "john.doe@example.com", "1234567890", true);

        // Assert that the user is an active user by default
        assertTrue(user.isActiveUser(), "User should be an active user by default");

        // Set the user as an inactive user
        user.setActiveUser(false);

        // Assert that the user is now an inactive user
        assertFalse(user.isActiveUser(), "User should be an inactive user");
    }


    @Test
    public void testSetUserId() {
        // Create a user object
        User user = new User("123", "john.doe", "John", "Doe", "john.doe@example.com", "1234567890", true);

        // Set a user ID for the user
        user.setUserId("456");

        // Get the user ID from the user
        String userId = user.getUserId();

        // Assert that the retrieved user ID matches the one set
        assertEquals("456", userId, "User ID should match the one set");
    }


}
