package services;

import interfaces.IRepository;
import models.User;
import enums.LoginStatus;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

@DisplayName("AuthService")
public class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void init() {
        authService = new AuthService(new FakeUserRepository());
    }

    @Test
    @DisplayName("register should return true when username does not exist")
    void register_returnTrue_whenUsernameNotExisted() {
        boolean result = authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        assertTrue(result);
    }

    @Test
    @DisplayName("register should return false when username already exists")
    void register_returnFalse_whenUsernameAlreadyExisted() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        boolean result = authService.register("Jane", "Doe", LocalDate.of(1991, 1, 1), "john", "pass2");
        assertFalse(result);
    }

    @Test
    @DisplayName("login should return Success and set authUser when credentials are correct")
    void login_returnSuccess_whenCorrectCredentials() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        LoginStatus status = authService.login("john", "pass");
        assertEquals(LoginStatus.Success, status);
        assertNotNull(authService.getUser());
        assertTrue(authService.isAuth());
    }

    @Test
    @DisplayName("login should return Fail when password is wrong")
    void login_returnFail_whenWrongPassword() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        LoginStatus status = authService.login("john", "wrong");
        assertEquals(LoginStatus.Fail, status);
    }

    @Test
    @DisplayName("login should return Locked when account failedTime reaches 3")
    void login_returnLocked_whenAccountIsLocked() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        authService.login("john", "wrong");
        authService.login("john", "wrong");
        authService.login("john", "wrong");
        LoginStatus status = authService.login("john", "pass");
        assertEquals(LoginStatus.Locked, status);
    }

    @Test
    @DisplayName("login should return Fail when username is not found")
    void login_returnFail_whenUsernameNotFound() {
        LoginStatus status = authService.login("nobody", "pass");
        assertEquals(LoginStatus.Fail, status);
    }

    @Test
    @DisplayName("logout should set authUser to null so isAuth returns false")
    void logout_setAuthUserToNull() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        authService.login("john", "pass");
        authService.logout();
        assertFalse(authService.isAuth());
        assertNull(authService.getUser());
    }

    private static class FakeUserRepository implements IRepository<User> {
        private ArrayList<User> data = new ArrayList<>();

        @Override
        public void save(ArrayList<User> users) {
            this.data = new ArrayList<>(users);
        }

        @Override
        public ArrayList<User> load() {
            return new ArrayList<>(data);
        }
    }
}
