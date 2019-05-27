package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public class CelsiusConverter implements TemperatureConverter {
    @Override
    public Character getChar() {
        return '\u2103';
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter to) {
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
