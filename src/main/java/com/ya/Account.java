package com.ya;

import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Checking the text for validity")
    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name != null) {
            int spaces = name.length() - name.replace(" ", "").length();
            if (name.length() >= 3 &&
                    name.length() <= 19 &&
                    !name.endsWith(" ") &&
                    !name.startsWith(" ") &&
                    name.contains(" ") &&
                    spaces == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}

    /* Себе будущей: возможная другая реализация:
    if (name == null) {
    return false;
    } else {
    int spaces = name.length() - name.replace(" ", "").length();
    boolean isOneSpace = name.contains(" ") && spaces == 1;
    boolean isLengthValid = name.length() >= 3 && name.length() <= 19;
    boolean withOutOfEndsSpaces = !name.endsWith(" ") && !name.startsWith(" ");
    boolean isNotEmpty = !name.isEmpty();
    return isLengthValid && withOutOfEndsSpaces && isOneSpace && isNotEmpty;
    } */