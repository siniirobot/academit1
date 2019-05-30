package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public interface TemperatureConverter {
    String getScaleChar();

    double changeTemperatureTo(double temperature, TemperatureConverter to);

    double toCelsius(double temperature);

    void throwAbsoluteZeroOutput(double temperature);

    void throwAbsoluteZeroInput(double temperature);

}
