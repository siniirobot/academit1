package ru.academItSchool.gorbunov.Model;

public class Model {
    public static final Character CELSIUS = '\u2103';
    public static final Character FAHRENHEIT = '\u2109';
    public static final Character KELVIN = '\u212A';

    public double changeTemperature(double temperature, Character from, Character to) {
        if (from == CELSIUS && to == KELVIN) {
            return temperature + 273.15;
        } else if (from == CELSIUS && to == FAHRENHEIT) {
            return (temperature * 9 / 5) + 32;
        } else if (from == FAHRENHEIT && to == KELVIN) {
            return (temperature - 32) * 5 / 9 + 273.15;
        } else if (from == FAHRENHEIT && to == CELSIUS) {
            return (temperature - 32) * 5 / 9;
        } else if (from == KELVIN && to == FAHRENHEIT) {
            return (temperature - 273.15) * 9 / 5 + 32;
        } else if (from == KELVIN && to == CELSIUS) {
            return temperature - 273.15;
        } else {
            return temperature;
        }
    }
}
