import java.time.LocalDate;
import java.util.ArrayList;

import handlers.UserHandler;
import models.User;
import utils.ScannerUtils;

public class UserManagementSystem {
    private final ScannerUtils scanner;
    private final UserHandler handler;
    private boolean isRunning = true;

    public UserManagementSystem(ScannerUtils scanner, UserHandler handler) {
        this.scanner = scanner;
        this.handler = handler;
    }

    public void run() {
        while (isRunning) {
            showMenu();
            int selection = scanner.inputNumber("Your choice: ");
            handleSelection(selection);
        }
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

    private void handleSelection(int selection) {
        switch (selection) {
            case 1 -> handleRegister();
            case 2 -> handleViewUser();
            case 3 -> login();
            case 4 -> isRunning = false;
            default -> System.out.println("Choose 1 or 2 or 3 only");
        }
    }

    private void handleRegister() {
        String firstname = scanner.inputString("fist name: ");
        String lastname = scanner.inputString("last name: ");
        LocalDate dob = scanner.inputDate("dob (YYYY-MM-dd): ");
        String username = scanner.inputString("username: ");
        String password = scanner.inputString("password: ");

        handler.register(firstname, lastname, dob, username, password);

        System.out.println("User Register Successful !!!");
    }

    private void displayAllUsers() {
        ArrayList<User> users = handler.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    private void searchByName() {
        String searchText = scanner.inputString("Find user by first name or last name: ");
        ArrayList<User> users = handler.getByName(searchText);

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
        int subOption = scanner.inputNumber("Your choice: ");

        switch (subOption) {
            case 1 -> displayAllUsers();
            case 2 -> searchByName();
            default -> System.out.println("Choose 1 or 2 only");
        }
    }

    private void login() {
        String username = scanner.inputString("username: ");
        String password = scanner.inputString("password: ");
        int result = handler.login(username, password);

        switch (result) {
            case 1 -> System.out.println("Login successful");
            case -1 -> System.out.println("User is locked !!!");
            default -> System.out.println("Username or password is wrong");
        }
    }
}
