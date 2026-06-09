import interfaces.IRepository;
import models.Transaction;
import models.User;
import models.base.BankCard;
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
    IRepository<User> userRepository = new UserRepository("user.txt");
    IRepository<Transaction> transactionRepository = new TransactionRepository("transactions.txt");
    IRepository<BankCard> bankCardRepository = new BankCardRepository("cards.txt");

    UserService userService = new UserService(userRepository);
    AuthService authService = new AuthService(userRepository);
    TransactionService transactionService = new TransactionService(transactionRepository);
    BankCardService bankCardService = new BankCardService(bankCardRepository, transactionService, authService);

    new UserManagementSystem(userService, authService, transactionService, bankCardService).run();

    ScannerUtils.close();
  }
}
