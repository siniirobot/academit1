package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.ImageInputOutput;


import com.sun.org.apache.xpath.internal.operations.Mod;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import static java.awt.GridBagConstraints.*;

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
        MyTimer myTimer = new MyTimer();
        java.util.Timer timer = new Timer();
        timer.schedule(myTimer,0);

        container.add(getPrintGame(new Model(
                new GameField(9, 9, 10, new CharactersImage())
        ), new Easy(), myTimer));

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
    public Container getPrintGame(Model model, Difficult difficult, MyTimer myTimer) throws IOException {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        JLabel time = new JLabel();
        time.setText(((Integer)myTimer.getTime()).toString());
        JLabel mineCount = new JLabel();
        mineCount.setText(((Integer)model.getPrintCountMine()).toString());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = NONE;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 1;
        jPanel.add(time,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        jPanel.add(new JLabel(difficult.getName().toString()),gridBagConstraints);
        gridBagConstraints.gridx = 2;
        jPanel.add(mineCount,gridBagConstraints);
        gridBagConstraints.fill = NONE;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        jPanel.add(printGameField(model),gridBagConstraints);
        return jPanel;
    }

    public JPanel printGameField(Model model) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(model.getGameField().getGameField().length, model.getGameField().getGameField()[0].length));
        JButton[][] jButtons = new JButton[model.getGameField().getGameField().length][model.getGameField().getGameField()[0].length];

        for (int i = 0; i < jButtons.length; i++) {
            for (int j = 0; j < jButtons[0].length; j++) {
                jButtons[i][j] = new JButton();
                jButtons[i][j].setIcon((ImageIcon) new CharactersImage().getCharacters()[9]);
                jButtons[i][j].setBorderPainted(false);
                jButtons[i][j].setFocusPainted(false);
                jButtons[i][j].setContentAreaFilled(false);
                jButtons[i][j].setPreferredSize(new Dimension(20, 20));
                int finalI = i;
                int finalJ = j;
                jButtons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            if (e.getButton() == 3) {
                                model.clickMove(finalI, finalJ, 2);
                            } else {
                                model.clickMove(finalI, finalJ, 1);
                            }

                        } catch (Boom boom) {
                            JOptionPane.showMessageDialog(null, boom.getMessage());
                            getMainMenu();
                        } finally {
                            for (int i = 0; i < jButtons.length; i++) {
                                for (int j = 0; j < jButtons[0].length; j++) {
                                    if (model.getGameField().getGameField()[i][j].isVisible()) {
                                        jButtons[i][j].setIcon((ImageIcon) model.getGameField().getGameField()[i][j].getContent());
                                    } else {
                                        jButtons[i][j].setIcon((ImageIcon) new CharactersImage().getCharacters()[9]);
                                    }
                                }
                            }
                        }
                    }
                });

            jPanel.add(jButtons[i][j]);
        }
    }
        return jPanel;
}

    @Override
    public boolean getHighScoreWrite(MyTimer myTimer, Difficult difficult) {
        return false;
    }
}
