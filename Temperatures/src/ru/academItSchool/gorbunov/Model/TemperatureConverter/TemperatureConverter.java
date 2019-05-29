package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public interface TemperatureConverter {
    String getScaleChar();

    double changeTemperatureTo(double temperature, TemperatureConverter to);

    double toCelsius(double temperature);

    void throwAbsoluteZero(double result);
}
