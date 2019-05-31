package ru.academItSchool.gorbunov.Model.TemperatureConverter;


public class FahrenheitConverter implements TemperatureConverter {
    @Override
    public String getScaleChar() {
        return "\u2109";
    }

    @Override
    public double changeTemperatureTo(double temperature, TemperatureConverter from) {
        from.throwAbsoluteZeroInput(temperature);
        double result = (from.toCelsius(temperature)* 9 / 5) + 32;
        throwAbsoluteZeroOutput(result);

        return result;
    }

    @Override
    public double toCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
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
