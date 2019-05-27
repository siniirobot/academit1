package ru.academItSchool.gorbunov.Controller;

import ru.academItSchool.gorbunov.Model.Model;

public class Controller {


    public String calculateResult(String temperature, String from, String to) {
        Model model = new Model();

        return ((Double)model.changeTemperature(temperature, from, to)).toString();
    }
}