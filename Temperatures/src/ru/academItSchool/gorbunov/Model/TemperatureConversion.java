package ru.academItSchool.gorbunov.Model;

public interface TemperatureConversion {
    Character getChar();

    double changeTemperatureTo(double temperature, TemperatureConversion to);

    double toCelsius(double temperature);

    void catchAbsoluteZero(double result);
}
