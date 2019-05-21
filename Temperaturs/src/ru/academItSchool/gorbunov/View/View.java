package ru.academItSchool.gorbunov.View;

import ru.academItSchool.gorbunov.Controller.Controller;
import ru.academItSchool.gorbunov.Model.Model;
import ru.academItSchool.gorbunov.Model.TemperatureConversion;
import ru.academItSchool.gorbunov.Model.TemperatureScales.Celsius;
import ru.academItSchool.gorbunov.Model.TemperatureScales.Fahrenheit;
import ru.academItSchool.gorbunov.Model.TemperatureScales.Kelvin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {

    public void startGUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Temperatures master");
                frame.setSize(540, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
                getGUIContent(frame.getContentPane());
                frame.setIconImage(icon);
                frame.setResizable(false);
                frame.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    private void getGUIContent(Container container) {
        JPanel firstLine = new JPanel();
        JLabel fromLabel = new JLabel("Перевести из");
        JTextField textField = new JTextField("0", 11);
        JLabel toLabel = new JLabel("Перевести в");
        JButton calc = new JButton("Вычислить");

        Model model = new Model();


        JComboBox fromComBox = new JComboBox<>(
                model.getCharArray()
        );

        JComboBox toComBox = new JComboBox<>(
                model.getCharArray()
        );

        firstLine.add(fromLabel);
        firstLine.add(fromComBox);
        firstLine.add(textField);
        firstLine.add(toLabel);
        firstLine.add(toComBox);
        firstLine.add(calc);

        JPanel endLine = new JPanel();
        JLabel result = new JLabel();

        endLine.add(result);

        JPanel mainPanel = new JPanel();

        mainPanel.add(firstLine, BorderLayout.LINE_START);
        mainPanel.add(endLine, BorderLayout.CENTER);
        container.add(mainPanel);

        Controller controller = new Controller();

        ActionListener calcResult = (event) -> {
            try {
                result.setText(controller.calculateResult(textField.getText(), (Character) fromComBox.getSelectedItem(),
                        (Character) toComBox.getSelectedItem()));
            } catch (IllegalArgumentException error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        };

        textField.addActionListener(calcResult);
        calc.addActionListener(calcResult);
    }
}
