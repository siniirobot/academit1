package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.ImageInputOutput;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import javax.swing.*;
import java.awt.*;

public class ImageInputOutput implements InputOutputMenus {

    public void getGUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Minesweeper");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Image icon = Toolkit.getDefaultToolkit()
                        .getImage("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                                "/ViewText/Resources/GUI/ImageInputOutput/icon.png");
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setIconImage(icon);
                frame.setResizable(false);
                frame.setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }

    @Override
    public String getMainMenu() {
        return null;
    }

    @Override
    public String getSettingMenu() {
        return null;
    }

    @Override
    public String getHeightScoreMenu() {
        return null;
    }

    @Override
    public String getEndGameMenu() {
        return null;
    }

    @Override
    public String getMenuMessage(int from, int to) {
        return null;
    }

    @Override
    public int getInput(int from, int to, String message) {
        return 0;
    }

    @Override
    public void getPrintGame(Model model, Difficult difficult, MyTimer myTimer) {

    }

    @Override
    public boolean getHighScoreWrite(MyTimer myTimer, Difficult difficult) {
        return false;
    }
}
