package DAOImp;

import DAO.UserDAO;
import DataObject.User;

import java.util.ArrayList;
import java.util.List;

/**
 * The UserDAOImp class is an implementation of the UserDAO interface that provides methods for accessing and manipulating user data in a data storage system.
 */
public class UserDAOImp implements UserDAO {

    private List<User> userList;

    /**
     * Constructs a UserDAOImp object and initializes the user list with sample data.
     */
    public UserDAOImp() {
        userList = new ArrayList<>();

        userList.add(new User("U001", "user1", "John", "Doe", "user1@example.com", "1234567890", true));
        userList.add(new User("U002", "user2", "Jane", "Smith", "user2@example.com", "0987654321", true));
    }

    /**
     * Retrieves a list of all users stored in the data storage system.
     *
     * @return a list of all users
     */
    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    /**
     * Retrieves a specific user from the data storage system based on their unique identifier.
     *
     * @param userID the unique identifier of the user
     * @return the user with the specified userID, or null if not found
     */
    @Override
    public User getUserByID(String userID) {
        for (User user : userList) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Adds a new user to the data storage system.
     *
     * @param user the user to add
     */
    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    /**
     * Updates an existing user in the data storage system.
     *
     * @param user the updated user object
     */
    @Override
    public void updateUser(User user) {

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserId().equals(user.getUserId())) {
                userList.set(i, user);
                break;
            }
        }
    }

    /**
     * Deletes a user from the data storage system based on their unique identifier.
     *
     * @param userID the unique identifier of the user to delete
     */
    @Override
    public void deleteUser(String userID) {
        // Find the user in the list and remove it
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserId().equals(userID)) {
                userList.remove(i);
                break;
            }
        }
    }
}

