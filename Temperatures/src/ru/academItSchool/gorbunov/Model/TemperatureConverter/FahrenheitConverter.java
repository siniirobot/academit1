package ru.academItSchool.gorbunov.Model.TemperatureConverter;


public class FahrenheitConverter implements TemperatureConverter {
    @Override
    public String getScaleChar() {
        return "\u2109";
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter to) {
        throwAbsoluteZeroInput(temperature);
        double result = (to.toCelsius(temperature) - 32) * 5 / 9;
        to.throwAbsoluteZeroOutput(result);

        return result;
    }

    @Override
    public double toCelsius(double temperature) {
        return (temperature * 9 / 5) + 32;
    }

    @Override
    public void throwAbsoluteZeroOutput(double temperature) {
        if (temperature < -459.67) {
            throw new IllegalArgumentException("Температура получилась ниже абсолютного нуля.");
        }
    }

    @Override
    public void throwAbsoluteZeroInput(double temperature) {
        if (temperature < -459.67) {
            throw new IllegalArgumentException("Введеная температура ниже абсолютного нуля.");
        }
    }
}
