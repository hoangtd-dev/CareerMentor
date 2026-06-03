import java.time.LocalDate;
import java.util.ArrayList;

import handlers.UserHandler;
import models.User;
import utils.ScannerUtils;

public class UserManagementSystem {
    private final ScannerUtils _scanner;
    private final UserHandler _handler;
    private boolean _isRunning = true;

    public UserManagementSystem(ScannerUtils scanner, UserHandler handler) {
        _scanner = scanner;
        _handler = handler;
    }

    public void run() {
        while (_isRunning) {
            _showMenu();
            int selection = _scanner.inputNumber("Your choice: ");
            _handleSelection(selection);
        }
    }

    private void _showMenu() {
        System.out.println("---------------------");
        System.out.println("1. Register");
        System.out.println("2. View User");
        System.out.println("3. Login");
        System.out.println("4. Exit");
    }

    private void _showUserMenu() {
        System.out.println("---------------------");
        System.out.println("1. Show all");
        System.out.println("2. Find by name");
    }

    private void _handleSelection(int selection) {
        switch (selection) {
            case 1 -> _handleRegister();
            case 2 -> _handleViewUser();
            case 3 -> _login();
            case 4 -> _isRunning = false;
            default -> System.out.println("Choose 1 or 2 or 3 only");
        }
    }

    private void _handleRegister() {
        String firstname = _scanner.inputString("fist name: ");
        String lastname = _scanner.inputString("last name: ");
        LocalDate dob = _scanner.inputDate("dob (YYYY-MM-dd): ");
        String username = _scanner.inputString("username: ");
        String password = _scanner.inputString("password: ");

        _handler.register(firstname, lastname, dob, username, password);

        System.out.println("User Register Successful !!!");
    }

    private void _displayAllUsers() {
        ArrayList<User> users = _handler.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    private void _searchByName() {
        String searchText = _scanner.inputString("Find user by first name or last name: ");
        ArrayList<User> users = _handler.getByName(searchText);

        if (users.size() > 0) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("No user found with name: " + searchText);
        }
    }

    private void _handleViewUser() {
        _showUserMenu();
        int subOption = _scanner.inputNumber("Your choice: ");

        switch (subOption) {
            case 1 -> _displayAllUsers();
            case 2 -> _searchByName();
            default -> System.out.println("Choose 1 or 2 only");
        }
    }

    private void _login() {
        String username = _scanner.inputString("username: ");
        String password = _scanner.inputString("password: ");
        int result = _handler.login(username, password);

        switch (result) {
            case 1 -> System.out.println("Login successful");
            case -1 -> System.out.println("User is locked !!!");
            default -> System.out.println("Username or password is wrong");
        }
    }
}
