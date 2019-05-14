package ru.academItSchool.gorbunov.Model;

public class Model {
    public static final Character CELSIUS = '\u2103';
    public static final Character FAHRENHEIT = '\u2109';
    public static final Character KELVIN = '\u212A';

    public double changeTemperature(double temperature, Character from, Character to) {
        if (from == CELSIUS && to == KELVIN) {
            double result = temperature + 273.15;

            absoluteZeroForKelvin(result);

            return result;
        } else if (from == CELSIUS && to == FAHRENHEIT) {
            double result = (temperature * 9 / 5) + 32;

            absoluteZeroForFahrenheit(result);

            return result;
        } else if (from == FAHRENHEIT && to == KELVIN) {
            double result = (temperature - 32) * 5 / 9 + 273.15;

            absoluteZeroForKelvin(result);

            return result;
        } else if (from == FAHRENHEIT && to == CELSIUS) {
            double result = (temperature - 32) * 5 / 9;

            absoluteZeroForCelsius(result);

            return result;
        } else if (from == KELVIN && to == FAHRENHEIT) {
            double result = (temperature - 273.15) * 9 / 5 + 32;

            absoluteZeroForFahrenheit(result);

            return result;
        } else if (from == KELVIN && to == CELSIUS) {
            double result = temperature - 273.15;

            absoluteZeroForCelsius(result);

            return result;
        } else {
            return temperature;
        }
    }

    private void absoluteZeroForCelsius(double result) {
        if (result < -273.15) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }

    private void absoluteZeroForFahrenheit(double result) {
        if (result < -459.67) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }

    private void absoluteZeroForKelvin(double result) {
        if (result < 0) {
            throw new IllegalArgumentException(" Эта температура ниже абсолютного нуля.");
        }
    }
}
