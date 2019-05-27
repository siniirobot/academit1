package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public interface TemperatureConverter {
    Character getChar();

    double changeTemperatureTo(double temperature, TemperatureConverter to);

    double toCelsius(double temperature);

    void catchAbsoluteZero(double result);
}
