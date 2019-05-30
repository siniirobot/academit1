package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public class CelsiusConverter implements TemperatureConverter {
    @Override
    public String getScaleChar() {
        return "\u2103";
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter to) {
        throwAbsoluteZeroInput(temperature);
        double result = to.toCelsius(temperature);
        to.throwAbsoluteZeroOutput(result);
        return result;
    }

    @Override
    public double toCelsius(double temperature) {
        return temperature;
    }

    @Override
    public void throwAbsoluteZeroOutput(double temperature) {
        if (temperature < -273.15) {
            throw new IllegalArgumentException("Температура получилась ниже абсолютного нуля.");
        }
    }

    @Override
    public void throwAbsoluteZeroInput(double temperature) {
        if (temperature < -273.15) {
            throw new IllegalArgumentException("Введеная температура ниже абсолютного нуля.");
        }
    }
}
