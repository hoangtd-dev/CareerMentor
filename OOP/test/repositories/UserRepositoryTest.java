package repositories;

import models.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DisplayName("UserRepository")
public class UserRepositoryTest {

    @TempDir
    Path tempDir;

    private UserRepository repository;

    @BeforeEach
    void init() {
        repository = new UserRepository(tempDir.resolve("users.txt").toString());
    }

    @Test
    @DisplayName("load should return empty list when file is empty")
    void load_returnEmptyList_whenFileIsEmpty() {
        List<User> result = repository.load();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("save and load should return original data after saving")
    void saveAndLoad_returnOriginalData_whenDataIsSaved() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass"));

        repository.save(users);
        List<User> loaded = repository.load();

        assertEquals(1, loaded.size());
        assertEquals("john", loaded.get(0).getUsername());
        assertEquals("John", loaded.get(0).getFirstname());
        assertEquals("Doe", loaded.get(0).getLastname());
        assertEquals(LocalDate.of(1990, 1, 1), loaded.get(0).getDob());
    }
}
