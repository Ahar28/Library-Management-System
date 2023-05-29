package DBConnTest;

import DBConnTest.IDataBaseConnection;
import DBConnTest.MockDataBaseConnection;
import Exceptions.SpecificExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MockDataBaseConnectionTest {

    private IDataBaseConnection connection;

    @BeforeEach
    public void setup() {
        connection = new MockDataBaseConnection();
    }

    @Test
    public void testConnect_SuccessfulConnection() {
        try {
            boolean isConnected = connection.connect();
            assertTrue(isConnected);
        } catch (SpecificExceptions e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testConnect_AlreadyConnected_ExceptionThrown() {
        try {
            connection.connect();
            assertThrows(SpecificExceptions.class, () -> connection.connect());
        } catch (SpecificExceptions e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testDisconnect_SuccessfulDisconnection() {
        try {
            connection.connect();
            boolean isDisconnected = connection.disconnect();
            assertTrue(isDisconnected);
        } catch (SpecificExceptions e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testDisconnect_NotConnected_ExceptionThrown() {
        assertThrows(SpecificExceptions.class, () -> connection.disconnect());
    }
}



