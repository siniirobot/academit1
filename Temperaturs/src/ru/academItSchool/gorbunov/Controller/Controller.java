package ru.academItSchool.gorbunov.Controller;

import ru.academItSchool.gorbunov.Model.Model;

public class Controller {
    private void throwExceptionForLetters(String text) {
        boolean onePoint = false;
        boolean oneMinus = false;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                continue;
            }

            if ((text.charAt(i) == '.' && !onePoint)) {
                onePoint = true;
                continue;
            }

            if ((text.charAt(i) == '-' && !oneMinus)) {
                oneMinus = true;
                continue;
            }

            throw new IllegalArgumentException("Введите температуру целочисленным или вещественным числом.");

        }
    }

    public String calculateResult(String temperature, Character from, Character to) {
        throwExceptionForLetters(temperature);

        Model model = new Model();

        return ((Double) model.changeTemperature((Double.parseDouble(temperature)), model.getScale(from), model.getScale(to))).toString();
    }
}