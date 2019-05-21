package ru.academItSchool.gorbunov.Model.TemperatureScales;

import ru.academItSchool.gorbunov.Model.TemperatureConversion;

public class Fahrenheit implements TemperatureConversion {
    @Override
    public Character getChar() {
        return '\u2109';
    }

    @Override
    public double getKelvin(double temperature) {
        double result = (temperature - 32) * 5 / 9 + 273.15;

        catchAbsoluteZero(result);

        return result;
    }

    @Override
    public double getFahrenheit(double temperature) {
        catchAbsoluteZero(temperature);

        return temperature;
    }

    @Override
    public double getCelsius(double temperature) {
        double result = (temperature - 32) * 5 / 9;

        catchAbsoluteZero(result);

        return result;
    }

    @Override
    public void catchAbsoluteZero(double result) {
        if (result < -459.67) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
