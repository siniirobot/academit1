package ru.academItSchool.gorbunov.View;

import ru.academItSchool.gorbunov.Controller.Controller;
import ru.academItSchool.gorbunov.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private Controller controller = new Controller();
    private static JPanel mainPanel;
    private JPanel firstLine;
    private JLabel fromLabel;
    private JComboBox<Character> fromComBox;
    private JTextField textField;
    private JLabel toLabel;
    private JComboBox<Character> toComBox;
    private JButton calc;
    private JPanel endLine;
    private JLabel result;

    public void view(Container container) {
        firstLine = new JPanel();
        fromLabel = new JLabel("Перевести из");
        textField = new JTextField("0", 11);
        toLabel = new JLabel("Перевести в");
        calc = new JButton("Вычислить");

        fromComBox = new JComboBox<>(
                new Character[]{Model.CELSIUS, Model.FAHRENHEIT, Model.KELVIN}
        );

        toComBox = new JComboBox<>(
                new Character[]{Model.CELSIUS, Model.FAHRENHEIT, Model.KELVIN}
        );

        firstLine.add(fromLabel);
        firstLine.add(fromComBox);
        firstLine.add(textField);
        firstLine.add(toLabel);
        firstLine.add(toComBox);
        firstLine.add(calc);

        endLine = new JPanel();
        result = new JLabel();
        endLine.add(result);

        mainPanel = new JPanel();
        mainPanel.add(firstLine, BorderLayout.LINE_START);
        mainPanel.add(endLine, BorderLayout.CENTER);
        container.add(mainPanel);

        ActionListener calcResult = (e) -> {
            try {
                controller.calculateResult(textField, result, (Character) fromComBox.getSelectedItem(),
                        (Character) toComBox.getSelectedItem());
            } catch (IllegalArgumentException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        };

        textField.addActionListener(calcResult);
        calc.addActionListener(calcResult);
    }
}
