package ExeptionProject.ExceptionProject.src.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ExeptionProject.ExceptionProject.src.View.ConsoleUI;
import ExeptionProject.ExceptionProject.src.model.CheckValidityInput;
import ExeptionProject.ExceptionProject.src.model.UserData;

public class Service {
    private ConsoleUI view;
    private Scanner scanner;
    private CheckValidityInput validityInput;
    private UserData userData;
    private List<UserData> usersList;

    public Service(ConsoleUI view) {
        this.view = view;
        scanner = new Scanner(System.in);
        validityInput = new CheckValidityInput();
        usersList = new ArrayList<>();
    }

    public String[] inputData() {
        while (true) {
            String data = scanner.nextLine();
            if (validityInput.checkInputArray(data, " ", 6) == 0) {
                // scanner.close();
                return data.split(" ");
            }
            if (validityInput.checkInputArray(data, " ", 6) == 1) {
                System.err.println("Вы ввели больше 6 полей данных!");
                continue;
            }
            if (validityInput.checkInputArray(data, " ", 6) == -1) {
                System.err.println("Вы ввели меньше 6 полей данных!");
                continue;
            }
        }
    }

    public void addData(String[] input) throws Exception {
        userData = new UserData();
        setSurname(input[0]);
        setName(input[1]);
        setSecondName(input[2]);
        setBirthday(input[3]);
        setPhoneNumber(input[4]);
        setGender(input[5]);
        getInfo();
        usersList.add(userData);
    }

    private void setSurname(String string) throws Exception {
        if (validityInput.checkTextForOnlySymbols(string)) {
            userData.setSurname(string);
        } else {
            throw new IllegalAccessException(
                    "Неправильно заполнено поле 'Фамилия'. Поле должно содержать только символы.");
        }
    }

    private void setName(String string) throws Exception {
        if (validityInput.checkTextForOnlySymbols(string)) {
            userData.setName(string);
        } else {
            throw new IllegalAccessException(
                    "Неправильно заполнено поле 'Имя'. Поле должно содержать только символы.");
        }
    }

    private void setSecondName(String string) throws Exception {
        if (validityInput.checkTextForOnlySymbols(string)) {
            userData.setSecondName(string);
        } else {
            throw new IllegalAccessException(
                    "Неправильно заполнено поле 'Отчество'. Поле должно содержать только символы.");
        }
    }

    private void setBirthday(String string) throws Exception {
        int year = 0;
        int month = 0;
        int day = 0;
        if (validityInput.checkInputArray(string, "\\.", 3) == 0) {
            String[] localData = string.split("\\.");
            if (validityInput.checkYear(localData[2])) {
                year = Integer.parseInt(localData[2]);
            } else {
                throw new IllegalAccessException(
                        "Неправильно заполнено поле 'Дата рождения'.\n"
                                + "Год не может быть меньше 1900 и больше текущего!");
            }
            if (validityInput.checkMonth(localData[1], year)) {
                month = Integer.parseInt(localData[1]);
            } else {
                throw new IllegalAccessException(
                        "Неправильно заполнено поле 'Дата рождения'.\n"
                                + "Месяц не может быть больше текущего в этом году!");
            }
            if (validityInput.checkDay(localData[0], year, month)) {
                day = Integer.parseInt(localData[0]);
            } else {
                throw new IllegalAccessException(
                        "Неправильно заполнено поле 'Дата рождения'.\n"
                                + "Дата не может быть больше текущей в этом году!");
            }
            userData.setBirthday(LocalDate.of(year, month, day));
        } else {
            throw new IllegalAccessException(
                    "Неправильно заполнено поле 'Дата рождения'. Поле должно иметь формат (dd.mm.yyyy).");
        }
    }

    private void setPhoneNumber(String string) throws Exception {
        if (validityInput.checkTextForOnlyDigits(string)) {
            userData.setPhoneNumber((int) Integer.parseInt(string));
        } else {
            throw new IllegalAccessException(
                    "Неправильно заполнено поле 'Номер телефона'. Поле должно содержать только цифры.");
        }
    }

    private void setGender(String string) throws Exception {
        if (validityInput.checkGender(string)) {
            char[] charArray = string.toCharArray();
            userData.setGender(charArray[0]);
        } else {
            throw new IllegalAccessException(
                    "Неправильно заполнено поле 'Пол'. Поле должно содержать только символ m или f.");
        }
    }

    public String getInfo() {
        return userData.toString();
    }

    public String getName() {
        return userData.getSurname();
    }
}
