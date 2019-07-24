package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.ImageInputOutput;


import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Hard;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Norm;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.GridBagConstraints.*;

public class ImageInputOutput implements InputOutputMenus {
    private JFrame frame;
    private Characters characters;

    public ImageInputOutput(JFrame frame) {
        this.frame = frame;
        this.characters = new CharactersImage();
    }

    private void getNewPanel(Container container) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(container);
        frame.getContentPane().validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private MouseListener getRewindButton(Container container) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(container);
            }
        };
    }

    @Override
    public Container getMainMenu() {
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(250,200));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(200,150));

        mainPanel.setLayout(new GridLayout(3, 1));

        JButton startGame = new JButton();

        startGame.setText("Начать игру");
        startGame.addMouseListener(getRewindButton(getSettingMenu()));

        mainPanel.add(startGame);

        JButton highScoreTable = new JButton("Таблица рекордов");
        highScoreTable.addMouseListener(getRewindButton(getHeightScoreMenu()));

        mainPanel.add(highScoreTable);

        JButton exit = new JButton("Выход из игры");
        exit.addMouseListener(getRewindButton(getEndGameMenu()));


        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(startGame);
        buttonPanel.add(highScoreTable);
        buttonPanel.add(exit);

        mainPanel.add(new JLabel("САПЁР"),BorderLayout.NORTH);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);
        return mainPanel;
    }

    @Override
    public Container getSettingMenu() {
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 400));
        mainPanel.setLayout(new GridLayout(6, 1));
        JLabel title = new JLabel("Выбирете сложность");

        JButton easy = new JButton("Легкая.");

        easy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getGameProcess(new Easy());
            }
        });

        JButton norm = new JButton("Средняя.");
        norm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getGameProcess(new Norm());

            }
        });

        JButton hard = new JButton("Тяжелая.");
        hard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getGameProcess(new Hard());

            }
        });

        JButton arbitrary = new JButton("Произвольная.");
        arbitrary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.removeAll();

            }
        });
        JButton back = new JButton("Назад.");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getMainMenu());
            }
        });

        mainPanel.add(title);
        mainPanel.add(easy);
        mainPanel.add(norm);
        mainPanel.add(hard);
        mainPanel.add(arbitrary);
        mainPanel.add(back);
        return mainPanel;
    }

    @Override
    public Container getHeightScoreMenu() {
        return null;
    }

    @Override
    public Container getEndGameMenu() {
        return null;
    }

    @Override
    public Container getMenuMessage(int from, int to) {
        return null;
    }

    private void getGameProcess(Difficult difficult) {
        Model model = new Model(new GameField(difficult.getLineCount(), difficult.getColumnCount(), difficult.getMines(),
                characters));

        MyTimer myTimer = new MyTimer();

        getNewPanel(getPrintGame(model, difficult, myTimer));
    }

    /* private void getGameProcess(Difficult difficult) {
        Model model = new Model(new GameField(difficult.getLineCount(), difficult.getColumnCount(), difficult.getMines(),
                characters));

        MyTimer myTimer = new MyTimer();
        Timer timer = new Timer();
        timer.schedule(myTimer,0);

        try {
            while (model.getGameField().getMineCount() != 0) {
                System.out.println(inputOutputMenus.getPrintGame(model, difficult, myTimer));
                int[] coordinate = inputOutputMenus.getCoordinate(model.getGameField());
                model.clickMove(coordinate[0], coordinate[1], coordinate[2]);
            }
        } catch (Boom b) {
            System.out.println(b.getMessage());
            inputOutputMenus.getPrintGame(model, difficult, myTimer);
            myTimer.cancel();
            return;
        }
        myTimer.cancel();
        if (inputOutputMenus.getHighScoreWrite(myTimer, difficult)) {
            highScores.printHighScores(difficult.getName());
        }
    }*/

    @Override
    public Container getPrintGame(Model model, Difficult difficult, MyTimer myTimer) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        JLabel time = new JLabel();
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                for (; i <= 9999; i++) {
                    time.setText(((Integer) myTimer.getTime()).toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        timer.schedule(timerTask, 0);
        JLabel mineCount = new JLabel();
        mineCount.setText(((Integer) model.getPrintCountMine()).toString());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = NONE;

        jPanel.add(time,
                addComponent(gridBagConstraints, 0, 0, 1, 1, 1));

        jPanel.add(new JLabel(difficult.getName().toString()),
                addComponent(gridBagConstraints, 0, 1, 1, 1, 1));

        jPanel.add(mineCount,
                addComponent(gridBagConstraints, 0, 2, 1, 1, 1));

        jPanel.add(printGameField(model, mineCount),
                addComponent(gridBagConstraints, 1, 0, 0, 3, 1));

        frame.add(jPanel);
        return jPanel;
    }

    public GridBagConstraints addComponent(GridBagConstraints gridBagConstraints, int row, int col, int rowNumber, int columnNumber, int position) {
        gridBagConstraints.gridx = col;
        gridBagConstraints.gridy = row;
        gridBagConstraints.gridwidth = columnNumber;
        gridBagConstraints.gridheight = rowNumber;
        gridBagConstraints.weightx = position;
        return gridBagConstraints;
    }

    public JPanel printGameField(Model model, JLabel mineCount) {
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
                            mineCount.setText(((Integer) model.getPrintCountMine()).toString());
                        } catch (Boom boom) {
                            JOptionPane.showMessageDialog(null, boom.getMessage());
                            getNewPanel(getMainMenu());
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

    /* public void getGUIContent(Container container) throws IOException {
        MyTimer myTimer = new MyTimer();
        java.util.Timer timer = new Timer();
        timer.schedule(myTimer, 0);

        container.add(getPrintGame(new Model(
                new GameField(9, 9, 10, new CharactersImage())
        ), new Easy(), myTimer));

    }*/
}
