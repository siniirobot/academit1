package ru.academItSchool.gorbunov;

import ru.academItSchool.gorbunov.View.View;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Temperatures master");
                frame.setSize(540, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
                (new View()).view(frame.getContentPane());
                frame.setIconImage(icon);
                frame.setResizable(false);
                frame.setVisible(true);
            } catch (Exception e) {
            }
        });
    }
}
