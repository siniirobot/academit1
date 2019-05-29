package ru.academItSchool.gorbunov.View;

import ru.academItSchool.gorbunov.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private Model model = new Model();

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

        mainPanel.add(firstLine, BorderLayout.LINE_START);
        mainPanel.add(endLine, BorderLayout.CENTER);
        container.add(mainPanel);

        ActionListener calcResult = (event) -> {
            try {
                model.throwExceptionForLetters(textField.getText());

                result.setText(((Double)model.changeTemperature(Double.parseDouble(textField.getText()),
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
