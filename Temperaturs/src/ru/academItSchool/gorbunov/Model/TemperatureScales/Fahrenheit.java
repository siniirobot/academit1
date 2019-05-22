package ru.academItSchool.gorbunov.Model.TemperatureScales;

import ru.academItSchool.gorbunov.Model.TemperatureConversion;


public class Fahrenheit implements TemperatureConversion {
    @Override
    public Character getChar() {
        return '\u2109';
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConversion to) {
        double result = (to.toCelsius(temperature) - 32) * 5 / 9;

        catchAbsoluteZero(result);

        return result;
    }

    @Override
    public double toCelsius(double temperature) {
        return (temperature * 9 / 5) + 32;
    }

    @Override
    public void catchAbsoluteZero(double result) {
        if (result < -459.67) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
