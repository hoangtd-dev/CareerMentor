import handlers.UserHandler;
import interfaces.IRepository;
import models.User;
import repositories.UserRepository;
import utils.ScannerUtils;

class Main {
  public static void main(String[] args) {
    IRepository<User> userRepository = new UserRepository("user.txt");
    UserHandler handler = new UserHandler(userRepository);

    new UserManagementSystem(handler).run();

    ScannerUtils.close();
  }
}
