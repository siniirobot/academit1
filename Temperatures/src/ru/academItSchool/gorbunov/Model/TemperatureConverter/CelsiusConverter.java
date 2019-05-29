package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public class CelsiusConverter implements TemperatureConverter {
    @Override
    public String getScaleChar() {
        return "\u2103";
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter to) {
        return to.toCelsius(temperature);
    }

    @Override
    public double toCelsius(double temperature) {
        throwAbsoluteZero(temperature);

        return temperature;
    }

    @Override
    public void throwAbsoluteZero(double result) {
        if (result < -273.15) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
