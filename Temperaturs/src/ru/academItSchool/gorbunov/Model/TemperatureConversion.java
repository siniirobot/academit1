package ru.academItSchool.gorbunov.Model;

public interface TemperatureConversion {
    Character getChar();

    double getKelvin(double temperature);

    double getFahrenheit(double temperature);

    double getCelsius(double temperature);

    void catchAbsoluteZero(double result);
}
