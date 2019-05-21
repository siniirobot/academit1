package ru.academItSchool.gorbunov.Model.TemperatureScales;

import ru.academItSchool.gorbunov.Model.TemperatureConversion;

public class Kelvin implements TemperatureConversion {
    @Override
    public Character getChar() {
        return '\u212A';
    }

    @Override
    public double getKelvin(double temperature) {
        catchAbsoluteZero(temperature);

        return temperature;
    }

    @Override
    public double getFahrenheit(double temperature) {
        double result = (temperature - 273.15) * 9 / 5 + 32;

        catchAbsoluteZero(result);

        return result;
    }

    @Override
    public double getCelsius(double temperature) {
        double result = temperature - 273.15;

        catchAbsoluteZero(result);

        return result;
    }

    @Override
    public void catchAbsoluteZero(double result) {
        if (result < 0) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
