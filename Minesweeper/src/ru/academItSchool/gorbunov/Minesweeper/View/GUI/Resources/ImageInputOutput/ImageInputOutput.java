package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.ImageInputOutput;


import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.GridBagConstraints.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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

    @Override
    public Container getMainMenu() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(200, 150));
        buttonPanel.setLayout(new GridLayout(3, 1));

        JButton startGame = new JButton("Начать игру");
        startGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getSettingMenu());
            }
        });

        JButton heightScoreMenu = new JButton("Таблица рекордов");
        heightScoreMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getHeightScoreMenu());
            }
        });

        JButton exit = new JButton("Выход из игры");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getEndGameMenu());
            }
        });

        buttonPanel.add(startGame);
        buttonPanel.add(heightScoreMenu);
        buttonPanel.add(exit);

        JLabel title = new JLabel("САПЁР");
        title.setFont(new Font("AriaBOLD", Font.PLAIN, 36));

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(250, 230));
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        return mainPanel;
    }

    @Override
    public Container getSettingMenu() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.setPreferredSize(new Dimension(200, 200));

        JButton easy = new JButton("Легкая");
        easy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getGameProcess(new Easy()));
            }
        });

        JButton norm = new JButton("Нормальная");
        norm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getGameProcess(new Norm()));
            }
        });

        JButton hard = new JButton("Тяжелая");
        hard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getGameProcess(new Hard()));
            }
        });

        JButton arbitrary = new JButton("Произвольная");
        arbitrary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JDialog chooseMenu = new JDialog();
                chooseMenu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                chooseMenu.setSize(180, 250);
                chooseMenu.setVisible(true);
                chooseMenu.setLocationRelativeTo(null);

                JPanel textFieldPanel = new JPanel();
                textFieldPanel.setLayout(new GridLayout(6,1));
                JLabel height = new JLabel("Введите высоту 9 - 24");
                JTextField heightTextField = new JTextField("9", 11);

                JLabel weight = new JLabel("Введите ширину 9 - 30");
                JTextField weightTextField = new JTextField("9", 11);

                int maxMines =
                        ((Integer.parseInt(heightTextField.getText()) * Integer.parseInt(weightTextField.getText())) * 75) / 100;
                JLabel mineCount = new JLabel("Введите ширину 10 - " + maxMines);
                JTextField mineCountTextField = new JTextField("10", 11);

                textFieldPanel.add(height);
                textFieldPanel.add(heightTextField);
                textFieldPanel.add(weight);
                textFieldPanel.add(weightTextField);
                textFieldPanel.add(mineCount);
                textFieldPanel.add(mineCountTextField);

                JButton input = new JButton("Ок");
                input.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        chooseMenu.dispose();
                        getNewPanel(getGameProcess(new Arbitrary(
                                Integer.parseInt(heightTextField.getText()),
                                Integer.parseInt(weightTextField.getText()),
                                Integer.parseInt(mineCountTextField.getText()))));
                    }
                });

                chooseMenu.add(textFieldPanel,BorderLayout.NORTH);
                chooseMenu.add(input,BorderLayout.SOUTH);
                chooseMenu.pack();

            }
        });

        JButton back = new JButton("Назад");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getMainMenu());
            }
        });

        buttonPanel.add(easy);
        buttonPanel.add(norm);
        buttonPanel.add(hard);
        buttonPanel.add(arbitrary);
        buttonPanel.add(back);

        JLabel title = new JLabel("Выбирете сложность");
        title.setFont(new Font("AriaBOLD", Font.PLAIN, 18));

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(250, 250));

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
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

    private Container getGameProcess(Difficult difficult) {
        Model model = new Model(new GameField(difficult.getLineCount(), difficult.getColumnCount(), difficult.getMines(),
                characters));

        MyTimer myTimer = new MyTimer();


        return getPrintGame(model, difficult, myTimer);
    }

    @Override
    public Container getPrintGame(Model model, Difficult difficult, MyTimer myTimer) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        JLabel time = new JLabel("0");
        Timer printTimer = new Timer();

        TimerTask timerTask = new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                for (; i <= 9999; i++) {
                    time.setText(((Integer) i).toString());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

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

        jPanel.add(printGameField(model, mineCount, printTimer, timerTask),
                addComponent(gridBagConstraints, 1, 0, 0, 3, 1));

        frame.add(jPanel);
        return jPanel;
    }

    private GridBagConstraints addComponent(GridBagConstraints gridBagConstraints, int row, int col, int rowNumber,
                                            int columnNumber, int position) {
        gridBagConstraints.gridx = col;
        gridBagConstraints.gridy = row;
        gridBagConstraints.gridwidth = columnNumber;
        gridBagConstraints.gridheight = rowNumber;
        gridBagConstraints.weightx = position;
        return gridBagConstraints;
    }

    private JPanel printGameField(Model model, JLabel mineCount, Timer timer, TimerTask timerTask) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(model.getGameField().getGameField().length, model.getGameField().getGameField()[0].length));
        JButton[][] jButtons = new JButton[model.getGameField().getGameField().length][model.getGameField().getGameField()[0].length];
        final boolean[] firstClick = {false};
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
                            if (!firstClick[0]) {
                                firstClick[0] = true;
                                timer.schedule(timerTask, 0);
                            }
                            if (model.getGameField().getMineCount() != 0) {
                                if (e.getButton() == 3) {
                                    model.clickMove(finalI, finalJ, 2);
                                } else {
                                    model.clickMove(finalI, finalJ, 1);
                                }
                                mineCount.setText(((Integer) model.getPrintCountMine()).toString());
                            }

                        } catch (Boom boom) {
                            for (int i = 0; i < jButtons.length; i++) {
                                for (int j = 0; j < jButtons[0].length; j++) {
                                    if (model.getGameField().getGameField()[i][j].isVisible()) {
                                        jButtons[i][j].setIcon((ImageIcon) model.getGameField().getGameField()[i][j].getContent());
                                    }
                                }
                            }
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
