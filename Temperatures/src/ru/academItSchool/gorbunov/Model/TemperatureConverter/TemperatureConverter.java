package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public interface TemperatureConverter {
    String getStringChar();

    double changeTemperatureTo(double temperature, TemperatureConverter to);

    double toCelsius(double temperature);

    void catchAbsoluteZero(double result);
}
