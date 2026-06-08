import java.time.LocalDate;
import java.util.ArrayList;

import enums.LoginStatus;
import models.User;
import services.AuthService;
import services.UserService;
import utils.ScannerUtils;

public class UserManagementSystem {
    private final UserService userService;
    private final AuthService authService;
    private boolean isRunning = true;

    public UserManagementSystem(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
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

    private void registerNewCard() {
        System.out.println("registerNewCard");
    }

    private void deposit() {
        System.out.println("deposit");
    }

    private void withdraw() {
        System.out.println("withdraw");
    }

    private void viewBalance() {
        System.out.println("viewBalance");
    }

    private void viewTransactionHistory() {
        System.out.println("viewTransactionHistory");
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

        authService.register(firstname, lastname, dob, username, password);

        System.out.println("User Register Successful !!!");
    }

    private void displayAllUsers() {
        ArrayList<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    private void searchByName() {
        String searchText = ScannerUtils.inputString("Find user by first name or last name: ");
        ArrayList<User> users = userService.getByName(searchText);

        if (users.size() > 0) {
            for (User user : users) {
                System.out.println(user.toString());
            }
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
