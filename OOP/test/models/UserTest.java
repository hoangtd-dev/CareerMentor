package models;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@DisplayName("User")
public class UserTest {

    private User user;

    @BeforeEach
    void init() {
        user = new User("John", "Doe", LocalDate.of(1990, 1, 1), "johndoe", "password123");
    }

    @Test
    @DisplayName("checkCredential should return true and reset failedTime when credentials are correct")
    void checkCredential_returnTrue_whenCorrectCredentials() {
        user.setFailedTime(2);
        boolean result = user.checkCredential("johndoe", "password123");
        assertTrue(result);
        assertEquals(0, user.getFailedTime());
    }

    @Test
    @DisplayName("checkCredential should return false and increment failedTime when password is wrong")
    void checkCredential_returnFalse_andIncrementFailedTime_whenWrongPassword() {
        boolean result = user.checkCredential("johndoe", "wrongpassword");
        assertFalse(result);
        assertEquals(1, user.getFailedTime());
    }

    @Test
    @DisplayName("isLooked should return true when failedTime equals 3")
    void isLooked_returnTrue_whenFailedTimeEqualsThree() {
        user.setFailedTime(3);
        assertTrue(user.isLooked());
    }

    @Test
    @DisplayName("hasName should return true when search text partially matches firstname or lastname (case-insensitive)")
    void hasName_returnTrue_whenPartialCaseInsensitiveMatch() {
        assertTrue(user.hasName("joh"));
        assertTrue(user.hasName("JOH"));
        assertTrue(user.hasName("doe"));
        assertFalse(user.hasName("xyz"));
    }

    @Test
    @DisplayName("mappingToRawData should return string with all fields in correct order")
    void mappingToRawData_returnCorrectCsvFormat() {
        String raw = user.mappingToRawData();
        String[] parts = raw.split(",");
        assertEquals(7, parts.length);
        assertEquals("John", parts[1]);
        assertEquals("Doe", parts[2]);
        assertEquals("1990-01-01", parts[3]);
        assertEquals("johndoe", parts[4]);
        assertEquals("password123", parts[5]);
        assertEquals("0", parts[6]);
    }
}
