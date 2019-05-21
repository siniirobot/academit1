package ru.academItSchool.gorbunov.Model.TemperatureScales;

import ru.academItSchool.gorbunov.Model.TemperatureConversion;

public class Celsius implements TemperatureConversion {
    @Override
    public Character getChar() {
        return '\u2103';
    }

    @Override
    public double getKelvin(double temperature) {
        double result = temperature + 273.15;

        catchAbsoluteZero(result);

        return result;
    }

    @Override
    public double getFahrenheit(double temperature) {
        double result = (temperature * 9 / 5) + 32;

        catchAbsoluteZero(result);

        return result;
    }

    @Override
    public double getCelsius(double temperature) {
        catchAbsoluteZero(temperature);

        return temperature;
    }

    @Override
    public void catchAbsoluteZero(double result) {
        if (result < -273.15) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
