import repositories.BankCardRepository;
import repositories.TransactionRepository;
import repositories.UserRepository;
import services.AuthService;
import services.BankCardService;
import services.TransactionService;
import services.UserService;
import utils.ScannerUtils;

class Main {
  public static void main(String[] args) {
    UserRepository userRepository = new UserRepository("user.txt");
    TransactionRepository transactionRepository = new TransactionRepository("transactions.txt");
    BankCardRepository bankCardRepository = new BankCardRepository("cards.txt");

    UserService userService = new UserService(userRepository);
    AuthService authService = new AuthService(userRepository);
    TransactionService transactionService = new TransactionService(transactionRepository);
    BankCardService bankCardService = new BankCardService(bankCardRepository, transactionService, authService);

    new UserManagementSystem(userService, authService, transactionService, bankCardService).run();

    ScannerUtils.close();
  }
}
