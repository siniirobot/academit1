package ru.academItSchool.gorbunov.Model;

import ru.academItSchool.gorbunov.Model.TemperatureConverter.CelsiusConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.FahrenheitConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.KelvinConverter;
import ru.academItSchool.gorbunov.Model.TemperatureConverter.TemperatureConverter;

public class Model {
    private TemperatureConverter[] temperatureConversions;

    public Model() {
        this.temperatureConversions = new TemperatureConverter[]{
                new CelsiusConverter(),
                new FahrenheitConverter(),
                new KelvinConverter(),
        };
    }

    public TemperatureConverter getScale(String character) {
        TemperatureConverter scale = null;

        for (TemperatureConverter sc : this.temperatureConversions) {
            if (sc.getStringChar().equals(character)) {
                scale = sc;
            }
        }
        return scale;
    }

    public String[] getToStringArray() {
        String[] charArray = new String[this.temperatureConversions.length];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = this.temperatureConversions[i].getStringChar();
        }
        return charArray;
    }

    public double changeTemperature(double temperature, TemperatureConverter from, TemperatureConverter to) {
        return from.changeTemperatureTo(temperature, to);
    }
}
