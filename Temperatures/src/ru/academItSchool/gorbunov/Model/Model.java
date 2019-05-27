package ru.academItSchool.gorbunov.Model;

import ru.academItSchool.gorbunov.Model.TemperatureConverter.CelsiusConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.FahrenheitConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.KelvinConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter;

import java.util.Arrays;

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
        return Arrays.stream(this.temperatureConversions)
                .filter(x->x.getStringChar().equals(character)).findFirst().orElse(null);
    }

    public String[] getToStringArray() {
        return Arrays.stream(this.temperatureConversions).map(TemperatureConverter::getStringChar).toArray(String[]::new);
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
