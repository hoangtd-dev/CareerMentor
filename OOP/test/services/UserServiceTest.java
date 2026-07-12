package services;

import interfaces.IRepository;
import models.User;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DisplayName("UserService")
public class UserServiceTest {

    private UserService userService;
    private FakeUserRepository fakeRepo;

    @BeforeEach
    void init() {
        fakeRepo = new FakeUserRepository();
        fakeRepo.data.add(new User("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass"));
        fakeRepo.data.add(new User("Jane", "Smith", LocalDate.of(1992, 5, 10), "jane", "pass"));
        fakeRepo.data.add(new User("Bob", "Johnson", LocalDate.of(1985, 3, 20), "bob", "pass"));
        userService = new UserService(fakeRepo);
    }

    @Test
    @DisplayName("getAllUsers should return all users in repository")
    void getAllUsers_returnAllUsers() {
        List<User> result = userService.getAllUsers();
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("getByName should return users whose firstname or lastname contains search text (case-insensitive)")
    void getByName_returnMatchingUsers_whenNameContainsSearchText() {
        List<User> result = userService.getByName("jo");
        // "John" and "Johnson" both contain "jo"
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(u -> u.getFirstname().equals("John")));
        assertTrue(result.stream().anyMatch(u -> u.getLastname().equals("Johnson")));
    }

    @Test
    @DisplayName("getByName should be case-insensitive")
    void getByName_returnMatchingUsers_whenSearchTextIsDifferentCase() {
        List<User> result = userService.getByName("JO");
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("getByName should return empty list when no user matches search text")
    void getByName_returnEmptyList_whenNoMatch() {
        List<User> result = userService.getByName("xyz");
        assertTrue(result.isEmpty());
    }

    private static class FakeUserRepository implements IRepository<User> {
        List<User> data = new ArrayList<>();
        @Override public void save(List<User> d) { this.data = new ArrayList<>(d); }
        @Override public List<User> load() { return new ArrayList<>(data); }
    }
}
