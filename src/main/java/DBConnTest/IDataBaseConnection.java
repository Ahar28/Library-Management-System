package DBConnTest;
import Exceptions.SpecificExceptions;
public interface IDataBaseConnection {

    public boolean  connect() throws SpecificExceptions;;

    public boolean disconnect() throws SpecificExceptions;
}
