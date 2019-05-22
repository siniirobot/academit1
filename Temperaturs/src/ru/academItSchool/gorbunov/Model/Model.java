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

    public TemperatureConversion getScale(Character character) {
        TemperatureConversion scale = null;

        for (TemperatureConversion sc: this.temperatureConversions) {
            if (sc.getChar().equals(character)) {
                scale = sc;
            }
        }
        return scale;
    }

    public Character[] getToCharArray() {
        Character[] charArray = new Character[this.temperatureConversions.length];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = this.temperatureConversions[i].getChar();
        }
        return charArray;
    }

    public double changeTemperature(double temperature, TemperatureConversion from, TemperatureConversion to) {
      return from.changeTemperatureTo(temperature,to);
    }
}
