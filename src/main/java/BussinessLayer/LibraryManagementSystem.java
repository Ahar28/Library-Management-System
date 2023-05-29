package BussinessLayer;

import DAO.BookDAO;
import DAO.UserDAO;
import DataObject.Book;
import DataObject.User;

import java.io.DataOutput;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private BookDAO bookDAO;
    private UserDAO userDAO;
    private Scanner scanner;
    public boolean exit = false;


    private int choice=-1;

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public LibraryManagementSystem(BookDAO bookDAO, UserDAO userDAO) {
        this.bookDAO = bookDAO;
        this.userDAO = userDAO;
        this.scanner = new Scanner(System.in);
    }

    public void CLI() {

        while (!exit) {
            System.out.println("============================");
            System.out.println("Library Management System");
            System.out.println("============================");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. View all users");
            System.out.println("6. Add a user");
            System.out.println("7. Update a user");
            System.out.println("8. Delete a user");
            System.out.println("9. Find a user by FirstName");
            System.out.println("10.Find a user by LastName");
            System.out.println("11.Find a user by Email");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    viewAllUsers();
                    break;
                case 6:
                    addUser();
                    break;
                case 7:
                    updateUser();
                    break;
                case 8:
                    deleteUser();
                    break;
                case 9:
                    FindUserByFirstName();
                    break;
                case 10:
                    FindUserByLastName();
                    break;
                case 11:
                    FindUserByEmail();
                    break;
                case 12:
                    FindBookByTitle();
                    break;
                case 13:
                    FindBookbyAuthor();
                    break;
                case 14:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
        System.out.println("Library Management System has been closed.");

    }

    private void FindBookByTitle() {
        List<Book> books = bookDAO.getAllBooks();
        boolean foundbookTitle = false;

        System.out.println("Enter Title to find the book:");
        String Title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(Title)) {
                System.out.println("Book found:");
                System.out.println( book.getTitle()+ "by" + book.getAuthor() );
                foundbookTitle = true;
            }
        }

        if (!foundbookTitle) {
            System.out.println("No Book found with the title: " + foundbookTitle);
        }

    }

    private void FindBookbyAuthor() {
        List<Book> books = bookDAO.getAllBooks();
        boolean foundBookAuthor = false;

        System.out.println("Enter Author to find the book:");
        String Author = scanner.nextLine();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(Author)) {
                System.out.println("Book found:");
                System.out.println( book.getTitle()+ "by" + book.getAuthor() );
                foundBookAuthor = true;
            }
        }

        if (!foundBookAuthor) {
            System.out.println("No Book found with the Author: " + foundBookAuthor);
        }
    }

    private void FindUserByFirstName() {

        List<User> users = userDAO.getAllUsers();
        boolean foundfirstName = false;

        System.out.println("Enter FirstName to find the user:");
        String Firstname = scanner.nextLine();

        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(Firstname)) {
                System.out.println("User found:");
                System.out.println(user.getUsername() + " (" + user.getFirstName() + " " + user.getLastName() + ")");
                foundfirstName = true;
            }
        }

        if (!foundfirstName) {
            System.out.println("No user found with the firstname: " + Firstname);
        }

    }

    private void FindUserByLastName() {
        List<User> users = userDAO.getAllUsers();
        boolean foundLastname = false;

        System.out.println("Enter LastName to find the user:");
        String LastName = scanner.nextLine();

        for (User user : users) {
            if (user.getLastName().equalsIgnoreCase(LastName)) {
                System.out.println("User found:");
                System.out.println(user.getUsername() + " (" + user.getFirstName() + " " + user.getLastName() + ")");
                foundLastname = true;
            }
        }

        if (!foundLastname) {
            System.out.println("No user found with the foundLastname: " + LastName);
        }
    }

    private void FindUserByEmail() {
        {

            List<User> users = userDAO.getAllUsers();
            boolean foundemail = false;

            System.out.println("Enter email to find the user:");
            String email = scanner.nextLine();

            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("User found:");
                    System.out.println(user.getUsername() + " (" + user.getFirstName() + " " + user.getLastName() + ")");
                    foundemail = true;
                }
            }

            if (!foundemail) {
                System.out.println("No user found with the email: " + email);
            }
        }
    }

    public void viewAllBooks() {
        System.out.println("Books:");
        List<Book> books = bookDAO.getAllBooks();
        for (Book book : books) {
            book.isAvailable();
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public String addBook() {
        List<Book> books = bookDAO.getAllBooks();

        System.out.print("Enter the book ID: ");
        String bookID = scanner.nextLine();
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter the ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter the publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the genre: ");
        String genre = scanner.nextLine();

        Book book = new Book(bookID, title, author, isbn, year, genre,true);
        bookDAO.addBook(book);

        System.out.println("Book added successfully");
        return "Book added successfully";
    }

    public void updateBook() {
        System.out.print("Enter the book ID to update: ");
        String bookID = scanner.nextLine();
        Book book = bookDAO.getBookByID(bookID);


        if (book != null) {
            System.out.print("Enter the new title (current: " + book.getTitle() + "): ");
            String title = scanner.nextLine();
            System.out.print("Enter the new author (current: " + book.getAuthor() + "): ");
            String author = scanner.nextLine();
            System.out.print("Enter the new ISBN (current: " + book.getIsbn() + "): ");
            String isbn = scanner.nextLine();
            System.out.print("Enter the new publication year (current: " + book.getYear() + "): ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the new genre (current: " + book.getGenre() + "): ");
            String genre = scanner.nextLine();

            book.setBookID(bookID);
            book.setTitle(title);
            book.setAuthor(author);
            book.setIsbn(isbn);
            book.setYear(year);
            book.setGenre(genre);

            bookDAO.updateBook(book);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void deleteBook() {
        System.out.print("Enter the book ID to delete: ");
        String bookID = scanner.nextLine();
        Book book = bookDAO.getBookByID(bookID);

        if (book != null) {
            bookDAO.deleteBook(bookID);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void viewAllUsers() {
        System.out.println("Users:");
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            System.out.println(user.getUsername() + " (" + user.getFirstName() + " " + user.getLastName() + ")");
        }
    }

    public void addUser() {
        System.out.print("Enter the user ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter the username: ");
        String username = scanner.nextLine();
        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter the email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();

        User user = new User(userID, username, firstName, lastName, email, phoneNumber,true);
        userDAO.addUser(user);

        System.out.println("User added successfully.");
    }

    public void updateUser() {
        System.out.print("Enter the user ID to update: ");
        String userID = scanner.nextLine();
        User user = userDAO.getUserByID(userID);

        if (user != null) {
            System.out.print("Enter the new username (current: " + user.getUsername() + "): ");
            String username = scanner.nextLine();
            System.out.print("Enter the new first name (current: " + user.getFirstName() + "): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter the new last name (current: " + user.getLastName() + "): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter the new email address (current: " + user.getEmail() + "): ");
            String email = scanner.nextLine();
            System.out.print("Enter the new phone number (current: " + user.getPhoneNumber() + "): ");
            String phoneNumber = scanner.nextLine();

            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);

            userDAO.updateUser(user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found!");
        }
    }

    public void deleteUser() {
        System.out.print("Enter the user ID to delete: ");
        String userID = scanner.nextLine();
        User user = userDAO.getUserByID(userID);

        if (user != null) {
            userDAO.deleteUser(userID);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found!");
        }
    }

}

