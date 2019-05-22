package ru.academItSchool.gorbunov.Model.TemperatureScales;

import ru.academItSchool.gorbunov.Model.TemperatureConversion;

public class Celsius implements TemperatureConversion {
    @Override
    public Character getChar() {
        return '\u2103';
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConversion to) {
        return to.toCelsius(temperature);
    }

    @Override
    public double toCelsius(double temperature) {
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
