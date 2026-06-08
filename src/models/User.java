package models;

import java.time.LocalDate;
import lombok.Data;

@Data
public class User {
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String username;
    private String password;
    private int failedTime = 0;

    public User(String firstname, String lastname, LocalDate dob, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.username = username;
        this.password = password;
    }

    public User(String firstname, String lastname, LocalDate dob, String username, String password, int failedTime) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.failedTime = failedTime;
    }

    public String mappingToRawData() {
        return String.format("%s,%s,%s,%s,%s,%d", firstname, lastname, dob, username, password, failedTime);
    }

    public boolean isLooked() {
        return failedTime == 3;
    }

    public boolean checkCredential(String username, String password) {
        if (!this.username.equals(username))
            return false;

        if (!this.password.equals(password)) {
            failedTime++;
            return false;
        }

        failedTime = 0;
        return true;
    }

    public boolean hasName(String searchText) {
        String lowerText = searchText.toLowerCase();
        return firstname.toLowerCase().contains(lowerText) || lastname.toLowerCase().contains(lowerText);
    }

    @Override
    public String toString() {
        return String.format("First name: %s - Last name: %s - Dob: %s - Username: %s", firstname, lastname, dob, username);
    }
}