package ru.academItSchool.gorbunov.Model;

import ru.academItSchool.gorbunov.Model.TemperatureScales.Celsius;
import ru.academItSchool.gorbunov.Model.TemperatureScales.Fahrenheit;
import ru.academItSchool.gorbunov.Model.TemperatureScales.Kelvin;

public class Model {
    private TemperatureConversion[] temperatureConversions;

    public Model() {
        this.temperatureConversions = new TemperatureConversion[]{
                new Celsius(),
                new Fahrenheit(),
                new Kelvin(),
        };
    }

    public Character[] getCharArray() {
        Character[] charArray = new Character[this.temperatureConversions.length];
        for (int i = 0; i < charArray.length;i++) {
            charArray[i] = this.temperatureConversions[i].getChar();
        }
        return charArray;
    }

    public double changeTemperature(double temperature, Character from, Character to) {
        for (TemperatureConversion scale : this.temperatureConversions) {
            if (scale.getChar().equals(from)) {
                switch (to) {
                    case '\u2103':
                        temperature = scale.getCelsius(temperature);
                        break;
                    case '\u2109':
                        temperature = scale.getFahrenheit(temperature);
                        break;
                    case '\u212A':
                        temperature = scale.getKelvin(temperature);
                        break;
                }
            }
        }
        return temperature;
    }
}
