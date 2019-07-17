package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.ImageInputOutput;


import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageInputOutput implements InputOutputMenus {

    public void getGUI() {
        Image icon = Toolkit.getDefaultToolkit()
                .getImage("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/icon.png");

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Minesweeper");
                getGUIContent(frame.getContentPane());
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

    public void getGUIContent(Container container) throws IOException {
        JPanel jPanel = (JPanel) getPrintGame(new Model(
                new GameField(9, 9, 10, new CharactersImage())
        ), new Easy(), new MyTimer());
        container.add(jPanel);
    }

    @Override
    public Container getMainMenu() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        return null;
    }

    @Override
    public Container getSettingMenu() {
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
    public Container getPrintGame(Model model, Difficult difficult, MyTimer myTimer) throws IOException {
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridLayout(model.getGameField().getGameField().length, model.getGameField().getGameField()[0].length));
        for (Cell[] arr : model.getGameField().getGameField()) {
            for (Cell cell : arr) {
                BufferedImage bufferedImage = ImageIO.read(new File( (String) cell.getContent()));
                JButton button = new JButton(new ImageIcon(bufferedImage));
                button.setBorderPainted(false);
                button.setFocusPainted(false);
                button.setContentAreaFilled(false);
                button.setRolloverIcon((Icon) cell.getContent());
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                    }
                });
                jPanel.add(button);
            }
        }
        return jPanel;
    }

    @Override
    public boolean getHighScoreWrite(MyTimer myTimer, Difficult difficult) {
        return false;
    }
}
