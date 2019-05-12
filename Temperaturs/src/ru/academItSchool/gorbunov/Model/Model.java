package ru.academItSchool.gorbunov.Model;

import ru.academItSchool.gorbunov.View.View;

public class Model {

    public double changeTemperature(double temperature, Character from, Character to) {
        if (from == View.CELSIUS && to == View.KELVIN) {
            return temperature + 273.15;
        } else if (from == View.CELSIUS && to == View.FAHRENHEIT) {
            return (temperature * 9 / 5) + 32;
        } else if (from == View.FAHRENHEIT && to == View.KELVIN) {
            return (temperature - 32) * 5 / 9 + 273.15;
        } else if (from == View.FAHRENHEIT && to == View.CELSIUS) {
            return (temperature - 32) * 5 / 9;
        } else if (from == View.KELVIN && to == View.FAHRENHEIT) {
            return (temperature - 273.15) * 9 / 5 + 32;
        } else if (from == View.KELVIN && to == View.CELSIUS) {
            return temperature - 273.15;
        } else {
            return temperature;
        }
    }
}
