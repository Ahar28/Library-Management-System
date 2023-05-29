package DAO;
import DataObject.User;

import java.util.List;
/**
 * The UserDAO interface provides methods for accessing and manipulating user data in a data storage system.
 */

public interface UserDAO {
    /**
     * Retrieves a list of all users in the data storage system.
     *
     * @return a list of all users
     */
    List<User> getAllUsers();
    /**
     * Retrieves a user from the data storage system based on their unique identifier.
     *
     * @param userID the unique identifier of the user
     * @return the user with the specified userID, or null if not found
     */
    User getUserByID(String userID);
    /**
     * Adds a new user to the data storage system.
     *
     * @param user the user to add
     */
    void addUser(User user);
    /**
     * Updates an existing user in the data storage system.
     *
     * @param user the updated user object
     *//**
     * Updates an existing user in the data storage system.
     *
     * @param user the updated user object
     */
    void updateUser(User user);
    /**
     * Deletes a user from the data storage system based on their unique identifier.
     *
     * @param userID the unique identifier of the user to delete
     */
    void deleteUser(String userID);
}
