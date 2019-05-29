package ru.academItSchool.gorbunov.View;

import ru.academItSchool.gorbunov.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class View {
    private Model model = new Model();

    public void startGUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Temperatures master");
                getGUIContent(frame.getContentPane());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setIconImage(icon);
                frame.setResizable(false);
                frame.setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }

    private void getGUIContent(Container container) {
        JPanel firstLine = new JPanel();
        JLabel fromLabel = new JLabel("Перевести из");
        JTextField textField = new JTextField("0", 11);
        JLabel toLabel = new JLabel("Перевести в");
        JButton calc = new JButton("Вычислить");

        JComboBox fromComBox = new JComboBox<>(
                model.getScaleArray()
        );

        JComboBox toComBox = new JComboBox<>(
                model.getScaleArray()
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

        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(firstLine);
        mainPanel.add(endLine);
        container.add(mainPanel);

        ActionListener calcResult = (event) -> {
            try {
                model.throwExceptionForLetters(textField.getText());

                result.setText(((Double) model.changeTemperature(Double.parseDouble(textField.getText()),
                        model.getScale((String) fromComBox.getSelectedItem()),
                        model.getScale((String) toComBox.getSelectedItem()))).toString());
            } catch (IllegalArgumentException error) {
                JOptionPane.showMessageDialog(null, error.getMessage());
            }
        };

        textField.addActionListener(calcResult);
        calc.addActionListener(calcResult);
    }
}
