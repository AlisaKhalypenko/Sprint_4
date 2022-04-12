package com.ya;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() throws Exception{
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        int spaces = name.length() - name.replace(" ", "").length();
        if (name.length() >= 3 &&
                name.length() <= 19 &&
                !name.endsWith(" ") &&
                !name.startsWith(" ") &&
                name.contains(" ") &&
                !name.isEmpty() &&
                spaces == 1) {
                return true;
        }else if (name == null) {
            throw new Exception();
        } else {
            return false;
        }

    }

}