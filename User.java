import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private String _firstname;
    private String _lastname;
    private LocalDate _dob;
    private String _username;
    private String _password;
    private int _failedTime = 0;

    public User(String firstname, String lastname, String dob, String username, String password) {
        _firstname = firstname;
        _lastname = lastname;
        _dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-M-d"));
        _username = username;
        _password = password;
    }

    public User(String firstname, String lastname, String dob, String username, String password, int failedTime) {
        _firstname = firstname;
        _lastname = lastname;
        _dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-M-d"));
        _username = username;
        _password = password;
        _failedTime = failedTime;
    }

    public void displayInformation() {
        System.out.println("Firstname: " + _firstname + " - Lastname: " + _lastname + " - Dob: " + _dob);
    }

    public int checkCredential(String username, String password) {
        if (!_username.equals(username)) return 0;

        if (_failedTime == 3) {
            System.out.println("Account is locked !!!");
            return 0;
        }

        if (!_password.equals(password)) {
            _failedTime++;
            return -1;
        }

        _failedTime = 0;
        return 1;
    }

    public boolean searchByName(String searchText) {
        return _firstname.contains(searchText) || _lastname.contains(searchText);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%d", _firstname, _lastname, _dob, _username, _password, _failedTime);
    }
}