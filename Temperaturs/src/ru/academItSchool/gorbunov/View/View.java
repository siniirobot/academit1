package ru.academItSchool.gorbunov.View;

import javax.swing.*;
import java.awt.*;

public class View {

    public void view() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Temperatures master");
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Image img = Toolkit.getDefaultToolkit().getImage("icon.png");
                frame.setIconImage(img);
                frame.setVisible(true);
            } catch (Exception e) {
            }
        });
    }
}
