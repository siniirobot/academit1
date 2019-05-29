package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public class KelvinConverter implements TemperatureConverter {
    @Override
    public String getScaleChar() {
        return "\u212A";
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter to) {
        double result = to.toCelsius(temperature) - 273.15;

        throwAbsoluteZero(result);

        return result;
    }

    @Override
    public double toCelsius(double temperature) {
        return temperature + 273.15;
    }

    @Override
    public void throwAbsoluteZero(double result) {
        if (result < 0) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
