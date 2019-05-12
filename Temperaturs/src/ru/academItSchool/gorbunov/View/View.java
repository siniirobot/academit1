package ru.academItSchool.gorbunov.View;

import ru.academItSchool.gorbunov.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    public static final Character CELSIUS = '\u2103';
    public static final Character FAHRENHEIT = '\u2109';
    public static final Character KELVIN = '\u212A';

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
    private JOptionPane warning;

    public void view(Container container) {
        firstLine = new JPanel();
        fromLabel = new JLabel("Перевести из");
        fromComBox = new JComboBox<>(
                new Character[]{CELSIUS, FAHRENHEIT, KELVIN}
        );
        textField = new JTextField("0", 11);
        toLabel = new JLabel("Перевести в");
        toComBox = new JComboBox<>(
                new Character[]{CELSIUS, FAHRENHEIT, KELVIN}
        );
        calc = new JButton("Вычислить");

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

        warning = new JOptionPane();
        calc.addActionListener((e) -> {
            Controller controller = new Controller(this.textField, result,
                    (Character) fromComBox.getSelectedItem(), (Character) toComBox.getSelectedItem());
            controller.actionPerformed(e);
        });
    }
}
