package DAOImp;

import DAO.UserDAO;
import DAOImp.UserDAOImp;
import DataObject.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOImpTest {

    private UserDAO userDAO;

    @BeforeEach
    public void setup() {
        userDAO = new UserDAOImp();
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = userDAO.getAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    public void testGetUserByID_ExistingUser_ReturnsUser() {
        String userID = "U001";
        User user = userDAO.getUserByID(userID);
        assertNotNull(user);
        assertEquals(userID, user.getUserId());
    }

    @Test
    public void testGetUserByID_NonExistingUser_ReturnsNull() {
        String userID = "U003";
        User user = userDAO.getUserByID(userID);
        assertNull(user);
    }

    @Test
    public void testAddUser() {
        User newUser = new User("U003", "user3", "Alice", "Johnson", "user3@example.com", "9876543210", true);
        userDAO.addUser(newUser);

        List<User> users = userDAO.getAllUsers();
        assertEquals(3, users.size());
        assertTrue(users.contains(newUser));
    }

    @Test
    public void testUpdateUser_ExistingUser_SuccessfullyUpdated() {
        String userID = "U001";
        User userToUpdate = new User(userID, "user1", "John", "Doe", "updated@example.com", "1234567890", true);
        userDAO.updateUser(userToUpdate);

        User updatedUser = userDAO.getUserByID(userID);
        assertNotNull(updatedUser);
        assertEquals("updated@example.com", updatedUser.getEmail());
    }

    @Test
    public void testUpdateUser_NonExistingUser_NoUpdatePerformed() {
        String userID = "U003";
        User userToUpdate = new User(userID, "user3", "Alice", "Johnson", "updated@example.com", "9876543210", true);
        userDAO.updateUser(userToUpdate);

        User nonExistingUser = userDAO.getUserByID(userID);
        assertNull(nonExistingUser);
    }

    @Test
    public void testDeleteUser_ExistingUser_SuccessfullyDeleted() {
        String userID = "U001";
        userDAO.deleteUser(userID);

        User deletedUser = userDAO.getUserByID(userID);
        assertNull(deletedUser);

        List<User> users = userDAO.getAllUsers();
        assertEquals(1, users.size());
    }

    @Test
    public void testDeleteUser_NonExistingUser_NoDeletePerformed() {
        String userID = "U003";
        userDAO.deleteUser(userID);

        List<User> users = userDAO.getAllUsers();
        assertEquals(2, users.size());
    }
}
