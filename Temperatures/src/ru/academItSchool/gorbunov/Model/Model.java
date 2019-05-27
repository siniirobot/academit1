package ru.academItSchool.gorbunov.Model;

import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter.Celsius;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter.Fahrenheit;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter.Kelvin;

public class Model {
    private TemperatureConverter[] temperatureConversions;

    public Model() {
        this.temperatureConversions = new TemperatureConverter[]{
                new Celsius(),
                new Fahrenheit(),
                new Kelvin(),
        };
    }

    public TemperatureConverter getScale(Character character) {
        TemperatureConverter scale = null;

        for (TemperatureConverter sc: this.temperatureConversions) {
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

    public double changeTemperature(double temperature, TemperatureConverter from, TemperatureConverter to) {
      return from.changeTemperatureTo(temperature,to);
    }
}
