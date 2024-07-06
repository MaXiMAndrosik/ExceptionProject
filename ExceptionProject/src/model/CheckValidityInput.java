package ExeptionProject.ExceptionProject.src.model;

import java.time.LocalDate;

public class CheckValidityInput {

    public int checkInputArray (String text, String split, int count) {
        if (text.split(split).length > count) {
            return 1;
        }
        if (text.split(split).length < count) {
            return -1;
        }
        return 0;
    }

    public boolean checkTextForOnlySymbols(String text) {
        boolean flag = true;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean checkTextForOnlyDigits(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

    // Если в тексте есть цифры
    public boolean checkTextForDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkGender(String text) {
        if (text.equalsIgnoreCase("f") | text.equalsIgnoreCase("m")) {
            return true;
        }
        return false;
    }

    public boolean checkYear(String text) {
        if (checkTextForOnlyDigits(text)) {
            int temp = Integer.parseInt(text);
            if (temp > 1900 && temp <= LocalDate.now().getYear()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkMonth(String text, int year) {
        if (checkTextForOnlyDigits(text)) {
            int temp = Integer.parseInt(text);
            if (year == LocalDate.now().getYear()) {
                if (temp > 0 && temp <= LocalDate.now().getMonthValue()) {
                    return true;
                }
            } else {
                if (temp > 0 && temp <= 12) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDay(String text, int year, int month) {
        if (checkTextForOnlyDigits(text)) {
            int temp = Integer.parseInt(text);
            if (year == LocalDate.now().getYear() && month == LocalDate.now().getMonthValue()) {
                if (temp > 0 && temp <= LocalDate.now().getDayOfMonth()) {
                    return true;
                }
            } else {
                if (year % 4 == 0 && month == 2 && temp > 0 && temp <= 29) {
                    return true;
                }
                if (year % 4 != 0 && month == 2 && temp > 0 && temp <= 28) {
                    return true;
                }
                if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                        && temp > 0 && temp <= 31) {
                    return true;
                }
                if ((month == 4 || month == 6 || month == 8 || month == 11) && temp > 0 && temp <= 30) {
                    return true;
                }
            }
        }
        return false;
    }

}