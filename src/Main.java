import interfaces.IRepository;
import models.User;
import repositories.UserRepository;
import services.AuthService;
import services.UserService;
import utils.ScannerUtils;

class Main {
  public static void main(String[] args) {
    IRepository<User> userRepository = new UserRepository("user.txt");
    UserService userService = new UserService(userRepository);
    AuthService authService = new AuthService(userRepository);

    new UserManagementSystem(userService, authService).run();

    ScannerUtils.close();
  }
}
