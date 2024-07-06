package ExeptionProject.ExceptionProject.src.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserData {
    private String surname;
    private String name;
    private String secondName;
    private LocalDate birthday;
    private int phoneNumber;
    private char gender;

    public UserData(String surname, String name, String secondName, LocalDate birthday, int phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public UserData() {
        this(null, null, null, null, 0, 'f');
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return surname + " " + name + " " + secondName + " "
                + dtf.format(birthday) + " " + phoneNumber + " " + gender;
    }

}
