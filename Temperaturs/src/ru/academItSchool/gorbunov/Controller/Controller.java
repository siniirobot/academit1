package ru.academItSchool.gorbunov.Controller;

import ru.academItSchool.gorbunov.Model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends AbstractAction {
    Model model = new Model();
    JTextField temperature;
    JLabel result;
    Character from;
    Character to;

    public Controller(JTextField temperature, JLabel result, Character from, Character to) {
        this.temperature = temperature;
        this.result = result;
        this.from = from;
        this.to = to;
    }

    public double getResult() {
        return model.changeTemperature((Double.parseDouble(this.temperature.getText())), this.from, this.to);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.result.setText(((Double)getResult()).toString());
    }

    public void filter(KeyEvent event) {
        char a = event.getKeyChar();
        if (!Character.isDigit(a)) {
            event.consume();
        }
    }
}
