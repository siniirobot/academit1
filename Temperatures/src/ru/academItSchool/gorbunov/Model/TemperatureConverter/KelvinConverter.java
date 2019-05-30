package ru.academItSchool.gorbunov.Model.TemperatureConverter;

public class KelvinConverter implements TemperatureConverter {
    @Override
    public String getScaleChar() {
        return "\u212A";
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter to) {
        throwAbsoluteZeroInput(temperature);
        double result = to.toCelsius(temperature) - 273.15;
        to.throwAbsoluteZeroOutput(result);
        return result;
    }

    @Override
    public double toCelsius(double temperature) {
        return temperature + 273.15;
    }

    @Override
    public void throwAbsoluteZeroOutput(double temperature) {
        if (temperature < 0) {
            throw new IllegalArgumentException("Температура получилась ниже абсолютного нуля.");
        }
    }

    @Override
    public void throwAbsoluteZeroInput(double temperature) {
        if (temperature < 0) {
            throw new IllegalArgumentException("Введеная температура ниже абсолютного нуля.");
        }
    }
}
