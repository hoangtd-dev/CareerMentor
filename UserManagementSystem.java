import java.util.ArrayList;

public class UserManagementSystem {
    private final ArrayList<User> _user;
    private final FileDB _db;

    private ScannerUtils scanner;
    private boolean _isRunning = true;

    public UserManagementSystem(ScannerUtils scanner) {
        _user = new ArrayList<>();
        _db = new FileDB("user.txt");
        this.scanner = scanner;
        ArrayList<String> rawData = _db.readTxtFile();
        _mappingUser(rawData);
    }

    public void run() {
        while (_isRunning) {
            _menu();
            System.out.print("Your choice: ");
            int selection = scanner.InputNumber();
            _handleSelection(selection);
        }
    }

    private void _mappingUser(ArrayList<String> rawData) {
        for (String data : rawData) {
            String[] splitData = data.split(",");
            _user.add(new User(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4], Integer.parseInt(splitData[5])));
        }
    }

    private void _updateDatabase() {
        String data = "";

        for (User user : _user) {
            data += user.mappingToRawData() + "\n";
        }

        _db.writeTxtFile(data);
    }

    private void _menu() {
        System.out.println("---------------------");
        System.out.println("1. Register");
        System.out.println("2. View User");
        System.out.println("3. Login");
        System.out.println("4. Exit");
    }

    private void _viewUserMenu() {
        System.out.println("---------------------");
        System.out.println("1. Show all");
        System.out.println("2. Find by name");
    }

    private void _register() {
        System.out.print("fist name: ");
        String firstname = scanner.InputString();
        System.out.print("last name: ");
        String lastname = scanner.InputString();
        System.out.print("dob (YYYY-MM-dd): ");
        String dob = scanner.InputString();
        System.out.print("username: ");
        String username = scanner.InputString();
        System.out.print("password: ");
        String password = scanner.InputString();

        _user.add(new User(firstname, lastname, dob, username, password));

        _updateDatabase();

        System.out.println("User Register Successful !!!");
    }

    private void _displayAllUsers() {
        for (User user : _user) {
            System.out.println(user.toString());
        }
    }

    private void _searchByName() {
        System.out.print("Find user by first name or last name: ");
        String searchText = scanner.InputString();

        for (User user : _user) {
            boolean result = user.searchByName(searchText);

            if (result) {
                System.out.println(user.toString());
            }
        }
    }

    private void _viewUser() {
        _viewUserMenu();
        System.out.print("Your choice: ");
        int subOption = scanner.InputNumber();

        switch (subOption) {
            case 1:
                _displayAllUsers();
                break;
            case 2:
                _searchByName();
                break;
            default:
                System.out.println("Choose 1 or 2 only");
                break;
        }
    }

    private void _login() {
        System.out.print("username: ");
        String username = scanner.InputString();
        System.out.print("password: ");
        String password = scanner.InputString();
        int result = 0;

        for (User user : _user) {
            result = user.checkCredential(username, password);

            if (result == -1 || result == 1) {
                _updateDatabase();
            }

            if (result == 1) {
                System.out.println("Login successful");
                break;
            }
        }

        if (result == 0 || result == -1) {
            System.out.println("Username or password is wrong");
        }
    }

    private void _handleSelection(int selection) {
        switch (selection) {
            case 1:
                _register();
                break;
            case 2:
                _viewUser();
                break;
            case 3:
                _login();
                break;
            case 4:
                _isRunning = false;
                break;
            default:
                System.out.println("Choose 1 or 2 or 3 only");
                break;
        }
    }
}
