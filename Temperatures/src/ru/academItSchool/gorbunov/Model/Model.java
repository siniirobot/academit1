package ru.academItSchool.gorbunov.Model;

import ru.academItSchool.gorbunov.Model.TemperatureConverter.CelsiusConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.FahrenheitConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.KelvinConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    private TemperatureConverter[] temperatureConversions;

    public Model() {
        this.temperatureConversions = new TemperatureConverter[]{
                new CelsiusConverter(),
                new FahrenheitConverter(),
                new KelvinConverter(),
        };
    }

    public TemperatureConverter getScale(String character) {
        return Arrays
                .stream(this.temperatureConversions)
                .filter(x -> x.getScaleChar().equals(character))
                .findFirst()
                .orElse(null);
    }

    public String[] getScaleArray() {
        return Arrays
                .stream(this.temperatureConversions)
                .map(TemperatureConverter::getScaleChar)
                .toArray(String[]::new);
    }

    public double changeTemperature(double temperature, TemperatureConverter from, TemperatureConverter to) {
        return to.changeTemperatureTo(temperature, from);
    }

    public void throwExceptionForLetters(String text) {
        Matcher matcher = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+").matcher(text);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Введите температуру целочисленным или вещественным числом.");
        }
    }
}
