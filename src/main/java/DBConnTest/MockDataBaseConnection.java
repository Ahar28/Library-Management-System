package DBConnTest;

import Exceptions.SpecificExceptions;

public class MockDataBaseConnection implements IDataBaseConnection{

    private boolean isConnected;

    public MockDataBaseConnection() {
        this.isConnected = false;
    }

    @Override
    public boolean connect() throws SpecificExceptions {
            if (isConnected) {
                throw new SpecificExceptions("Already connected to the database.");
            }


            isConnected = true;
            System.out.println("Connected to the database.");
            return true;
        }

    @Override
    public boolean disconnect() throws SpecificExceptions {
        if (!isConnected) {
            throw new SpecificExceptions("Not connected to the database.");
        }

        isConnected = false;
        System.out.println("Disconnected from the database.");
        return true;
    }
}
