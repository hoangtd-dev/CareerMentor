package models;

import java.time.LocalDate;
import java.util.UUID;

import interfaces.IBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User implements IBaseEntity {
    private String id;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String username;
    private String password;
    private int failedTime = 0;

    public User(String firstname, String lastname, LocalDate dob, String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.username = username;
        this.password = password;
    }

    @Override
    public String mappingToRawData() {
        return String.format("%s,%s,%s,%s,%s,%s,%d", id, firstname, lastname, dob, username, password, failedTime);
    }

    public boolean isLooked() {
        return failedTime == 3;
    }

    public boolean checkCredential(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            failedTime = 0;
            return true;
        }

        if (!this.password.equals(password)) {
            failedTime++;
        }

        return false;
    }

    public boolean hasName(String searchText) {
        String lowerText = searchText.toLowerCase();
        return firstname.toLowerCase().contains(lowerText) || lastname.toLowerCase().contains(lowerText);
    }

    @Override
    public String toString() {
        return String.format("First name: %s - Last name: %s - Dob: %s - Username: %s", firstname, lastname, dob,
                username);
    }
}