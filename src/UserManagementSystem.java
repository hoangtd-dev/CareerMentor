import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import constants.BankEnum;
import enums.LoginStatus;
import models.Transaction;
import models.User;
import models.base.BankCard;
import services.AuthService;
import services.BankCardService;
import services.TransactionService;
import services.UserService;
import utils.ScannerUtils;

public class UserManagementSystem {
    private final UserService userService;
    private final AuthService authService;
    private final TransactionService transactionService;
    private final BankCardService bankCardService;
    private boolean isRunning = true;

    public UserManagementSystem(
            UserService userService,
            AuthService authService,
            TransactionService transactionService,
            BankCardService bankCardService) {
        this.userService = userService;
        this.authService = authService;
        this.bankCardService = bankCardService;
        this.transactionService = transactionService;
    }

    public void run() {
        int selection;
        while (isRunning) {
            clearScreen();
            if (authService.isAuth()) {
                showAuthMenu();
                selection = ScannerUtils.inputNumber("Your choice: ");
                handleAuthServiceSelection(selection);
            } else {
                showMenu();
                selection = ScannerUtils.inputNumber("Your choice: ");
                handleSelection(selection);
            }
            System.out.println("---------------------");
            ScannerUtils.inputString("Enter to continue !!!");
        }
    }

    private void showAuthMenu() {
        System.out.println("---------------------");
        System.out.println("1. Register New Card");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. View Balance");
        System.out.println("5. View Transaction History");
        System.out.println("6 Logout");
    }

    private void showMenu() {
        System.out.println("---------------------");
        System.out.println("1. Register");
        System.out.println("2. View User");
        System.out.println("3. Login");
        System.out.println("4. Exit");
    }

    private void showUserMenu() {
        System.out.println("---------------------");
        System.out.println("1. Show all");
        System.out.println("2. Find by name");
    }

    private void handleAuthServiceSelection(int selection) {
        switch (selection) {
            case 1 -> registerNewCard();
            case 2 -> deposit();
            case 3 -> withdraw();
            case 4 -> viewBalance();
            case 5 -> viewTransactionHistory();
            case 6 -> logout();
            default -> System.out.println("Choose 1/2/3/4/5/6 only");
        }
    }

    private BankEnum getBankName(int option) {
        return (switch (option) {
            case 1 -> BankEnum.ANZ;
            case 2 -> BankEnum.NAB;
            case 3 -> BankEnum.CMW;
            default -> null;
        });
    }

    private void registerNewCard() {
        int bankNameOption = 0;
        while (bankNameOption < 1 || bankNameOption > 3) {
            bankNameOption = ScannerUtils.inputNumber("1.ANZ\n2.NAB\n3.CMW\nChoose your bank: ");
        }
        BankEnum bankName = getBankName(bankNameOption);

        String cardNumber = "";
        while (!cardNumber.matches("\\d{10}")) {
            cardNumber = ScannerUtils.inputString("Card number (10 digit): ");
        }

        boolean result = bankCardService.registerNewCard(bankName, cardNumber, BigDecimal.ZERO);

        if (result) {
            System.out.println("Card Created successfully !!!");
        } else {
            System.out.println("Card number is existed in system !!!");
        }
    }

    private void deposit() {
        if (!checkCardExisted())
            return;

        String amountStr = ScannerUtils.inputString("How much do you want to deposit?: ");

        try {
            BigDecimal amount = new BigDecimal(amountStr);
            bankCardService.deposit(amount);
            System.out.println("Deposit successfully !!!");
        } catch (NumberFormatException e) {
            System.out.println("Amount should be a number");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void withdraw() {
        if (!checkCardExisted())
            return;

        String amountStr = ScannerUtils.inputString("How much do you want to withdraw?: ");

        try {
            BigDecimal amount = new BigDecimal(amountStr);
            bankCardService.withdraw(amount);
            System.out.println("Withdraw successfully !!!");
        } catch (NumberFormatException e) {
            System.out.println("Amount should be a number");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewBalance() {
        if (!checkCardExisted())
            return;

        System.out.println(bankCardService.getBalanceMessage());
    }

    private void viewTransactionHistory() {
        if (!checkCardExisted())
            return;

        BankCard card = bankCardService.getCurrentCard();

        try {
            List<Transaction> transactions = transactionService.getTransactionHistory(card.getCardNumber(),
                    card.numberOfTransactionDisplayed());

            for (int i = 1; i <= transactions.size(); i++) {
                System.out.println(i + ". " + transactions.get(i - 1).toString());
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkCardExisted() {
        if (!bankCardService.hasCard()) {
            System.out.println("Please add your card first !!!");
            registerNewCard();
            return false;
        }

        String option = ScannerUtils
                .inputString("Press 'Y' to use the current card, or any other key to add a new card: ");
        if (!option.toLowerCase().equals("y")) {
            registerNewCard();
            return false;
        }

        return true;
    }

    private void logout() {
        authService.logout();
    }

    private void handleSelection(int selection) {
        switch (selection) {
            case 1 -> handleRegister();
            case 2 -> handleViewUser();
            case 3 -> login();
            case 4 -> isRunning = false;
            default -> System.out.println("Choose 1/2/3/4 only");
        }
    }

    private void handleRegister() {
        String firstname = ScannerUtils.inputString("first name: ");
        String lastname = ScannerUtils.inputString("last name: ");
        LocalDate dob = ScannerUtils.inputDate("dob (YYYY-MM-dd): ");
        String username = ScannerUtils.inputString("username: ");
        String password = ScannerUtils.inputString("password: ");

        boolean result = authService.register(firstname, lastname, dob, username, password);

        if (result) {
            System.out.println("User Register Successful !!!");
        } else {
            System.out.println("Username is existed !!!");
        }
    }

    private void displayAllUsers() {
        ArrayList<User> users = userService.getAllUsers();
        users.forEach(user -> System.out.println(user.toString()));
    }

    private void searchByName() {
        String searchText = ScannerUtils.inputString("Find user by first name or last name: ");
        List<User> users = userService.getByName(searchText);

        if (users.size() > 0) {
            users.forEach(user -> System.out.println(user.toString()));
        } else {
            System.out.println("No user found with name: " + searchText);
        }
    }

    private void handleViewUser() {
        showUserMenu();
        int subOption = ScannerUtils.inputNumber("Your choice: ");

        switch (subOption) {
            case 1 -> displayAllUsers();
            case 2 -> searchByName();
            default -> System.out.println("Choose 1 or 2 only");
        }
    }

    private void login() {
        String username = ScannerUtils.inputString("username: ");
        String password = ScannerUtils.inputString("password: ");
        LoginStatus result = authService.login(username, password);

        switch (result) {
            case LoginStatus.Success -> System.out.println("Login successful");
            case LoginStatus.Locked -> System.out.println("User is locked !!!");
            default -> System.out.println("Username or password is wrong");
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J\033[3J");
    }
}
