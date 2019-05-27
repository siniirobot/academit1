package ru.academItSchool.gorbunov.Model;

import ru.academItSchool.gorbunov.Model.TemperatureConverter.CelsiusConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.FahrenheitConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.KelvinConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter;

public class Model {
    private TemperatureConverter[] temperatureConversions;

    public Model() {
        this.temperatureConversions = new TemperatureConverter[]{
                new CelsiusConverter(),
                new FahrenheitConverter(),
                new KelvinConverter(),
        };
    }

    private TemperatureConverter getScale(String character) {
        TemperatureConverter scale = null;

        for (TemperatureConverter sc : this.temperatureConversions) {
            if (sc.getStringChar().equals(character)) {
                scale = sc;
            }
        }
        return scale;
    }

    public String[] getToStringArray() {
        String[] charArray = new String[this.temperatureConversions.length];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = this.temperatureConversions[i].getStringChar();
        }
        return charArray;
    }

    public double changeTemperature(String temperature, String from, String to) {
        throwExceptionForLetters(temperature);

        return getScale(from).changeTemperatureTo(Double.parseDouble(temperature), getScale(to));
    }

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
}
