package models;

import java.time.LocalDate;

public class User {
    private String _firstname;
    private String _lastname;
    private LocalDate _dob;
    private String _username;
    private String _password;
    private int _failedTime = 0;

    public User(String firstname, String lastname, LocalDate dob, String username, String password) {
        _firstname = firstname;
        _lastname = lastname;
        _dob = dob;
        _username = username;
        _password = password;
    }

    public User(String firstname, String lastname, LocalDate dob, String username, String password, int failedTime) {
        _firstname = firstname;
        _lastname = lastname;
        _dob = dob;
        _username = username;
        _password = password;
        _failedTime = failedTime;
    }

    public String mappingToRawData() {
        return String.format("%s,%s,%s,%s,%s,%d", _firstname, _lastname, _dob, _username, _password, _failedTime);
    }

    public boolean isLooked() {
        return _failedTime == 3;
    }

    public boolean checkCredential(String username, String password) {
        if (!_username.equals(username))
            return false;

        if (!_password.equals(password)) {
            _failedTime++;
            return false;
        }

        _failedTime = 0;
        return true;
    }

    public boolean hasName(String searchText) {
        String lowerText = searchText.toLowerCase();
        return _firstname.toLowerCase().contains(lowerText) || _lastname.toLowerCase().contains(lowerText);
    }

    @Override
    public String toString() {
        return String.format("First name: %s - Last name: %s - Dob: %s - Username: %s", _firstname, _lastname, _dob, _username);
    }
}