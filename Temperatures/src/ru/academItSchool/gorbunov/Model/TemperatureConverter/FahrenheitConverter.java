package ru.academItSchool.gorbunov.Model.TemperatureConverter;


public class FahrenheitConverter implements TemperatureConverter {
    @Override
    public String getStringChar() {
        return "\u2109";
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter to) {
        double result = (to.toCelsius(temperature) - 32) * 5 / 9;

        throwAbsoluteZero(result);

        return result;
    }

    @Override
    public double toCelsius(double temperature) {
        return (temperature * 9 / 5) + 32;
    }

    @Override
    public void throwAbsoluteZero(double result) {
        if (result < -459.67) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
