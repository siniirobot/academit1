package ru.academItSchool.gorbunov.Controller;

import ru.academItSchool.gorbunov.Model.Model;

import javax.swing.*;

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

    public void calculateResult(JTextField temperature, JLabel result, Character from, Character to) {
        String text = temperature.getText();
        throwExceptionForLetters(text);

        Model model = new Model();

        result.setText(((Double) model.changeTemperature((Double.parseDouble(text)), from, to)).toString());
    }
}