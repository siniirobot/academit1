package ru.academItSchool.gorbunov.Minesweeper.View.GUI;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.ImageInputOutput.ImageInputOutput;

import javax.swing.*;
import java.awt.*;

public class ViewGUI {
    public void getGUI() {
        Image icon = Toolkit.getDefaultToolkit()
                .getImage("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/icon.png");

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Minesweeper");
                ImageInputOutput imageInputOutput = new ImageInputOutput(frame);
                frame.getContentPane().add(imageInputOutput.getPrintHighScoreTableInPlane(new Easy()));

                //frame.getContentPane().add(imageInputOutput.getMainMenu());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setIconImage(icon);
                frame.setResizable(false);
                frame.setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
