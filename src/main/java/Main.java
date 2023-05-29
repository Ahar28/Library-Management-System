    import BussinessLayer.LibraryManagementSystem;
    import DAO.BookDAO;
    import DAO.UserDAO;
    import DAOImp.BookDAOImp;
    import DAOImp.UserDAOImp;

    public class Main {

        public static void main(String[] args) {
            BookDAO bookDAO = new BookDAOImp();
            UserDAO userDAO = new UserDAOImp();
    
            LibraryManagementSystem lms = new LibraryManagementSystem(bookDAO, userDAO);
            lms.CLI();
        }
    
    }
