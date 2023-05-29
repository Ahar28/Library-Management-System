Library Management System:

The Library Management System is a Java application that provides functionality for managing books and users in a library. It allows users to perform various operations such as viewing books, adding books, updating books, deleting books, viewing users, adding users, updating users, and deleting users.

Features:-
The Library Management System includes the following features:

1)View all books: Displays a list of all books available in the library.
2)Add a book: Allows the user to add a new book to the library.
3)Update a book: Allows the user to update the details of an existing book.
4)Delete a book: Allows the user to delete a book from the library.
5)View all users: Displays a list of all users registered in the library system.
6)Add a user: Allows the user to add a new user to the library system.
7)Update a user: Allows the user to update the details of an existing user.
8)Delete a user: Allows the user to delete a user from the library system.
9)Exit: Exits the application.

Structure:
DataObject: Contains the data objects representing books and users.
DAO layer: Defines the interfaces for data access objects (DAO) used to interact with the database or data source.
DAOImp: Implements the DAO interfaces and provides in-memory data storage for books and users.
IDataBaseConnection database interfaces
MockDataBaseConnection Implements the IDataBaseConnection interface
