package services;

import interfaces.IRepository;
import models.User;
import enums.LoginStatusEnum;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DisplayName("AuthService")
public class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void init() {
        authService = new AuthService(new FakeUserRepository());
    }

    @Test
    @DisplayName("register should not throw when username does not exist")
    void register_doesNotThrow_whenUsernameNotExisted() {
        assertDoesNotThrow(() -> authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass"));
    }

    @Test
    @DisplayName("register should throw IllegalArgumentException when username already exists")
    void register_throwException_whenUsernameAlreadyExisted() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        assertThrows(IllegalArgumentException.class,
                () -> authService.register("Jane", "Doe", LocalDate.of(1991, 1, 1), "john", "pass2"));
    }

    @Test
    @DisplayName("login should return Success and set authUser when credentials are correct")
    void login_returnSuccess_whenCorrectCredentials() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        LoginStatusEnum status = authService.login("john", "pass");
        assertEquals(LoginStatusEnum.Success, status);
        assertNotNull(authService.getUser());
        assertTrue(authService.isAuth());
    }

    @Test
    @DisplayName("login should return Fail when password is wrong")
    void login_returnFail_whenWrongPassword() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        LoginStatusEnum status = authService.login("john", "wrong");
        assertEquals(LoginStatusEnum.Fail, status);
    }

    @Test
    @DisplayName("login should return Locked when account failedTime reaches 3")
    void login_returnLocked_whenAccountIsLocked() {
        authService.register("John", "Doe", LocalDate.of(1990, 1, 1), "john", "pass");
        authService.login("john", "wrong");
        authService.login("john", "wrong");
        authService.login("john", "wrong");
        LoginStatusEnum status = authService.login("john", "pass");
        assertEquals(LoginStatusEnum.Locked, status);
    }

    @Test
    @DisplayName("login should return Fail when username is not found")
    void login_returnFail_whenUsernameNotFound() {
        LoginStatusEnum status = authService.login("nobody", "pass");
        assertEquals(LoginStatusEnum.Fail, status);
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
        private List<User> data = new ArrayList<>();

        @Override
        public void save(List<User> users) {
            this.data = new ArrayList<>(users);
        }

        @Override
        public List<User> load() {
            return new ArrayList<>(data);
        }
    }
}
