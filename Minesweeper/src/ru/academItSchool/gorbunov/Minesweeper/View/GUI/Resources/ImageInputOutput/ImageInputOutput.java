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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                chooseMenu.setPreferredSize(new Dimension(200, 250));

                JPanel textFieldPanel = new JPanel();
                textFieldPanel.setPreferredSize(new Dimension(120, 200));

                JLabel height = new JLabel(
                        "<html>" +
                                "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите высоту</p>" +
                                "<p>игрового поля (9 - 24)</p>" +
                                "<html>");
                JTextField heightTextField = new JTextField("9", 11);


                JLabel weight = new JLabel(
                        "<html>" +
                                "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите ширину</p>" +
                                "<p>игрового поля (9 - 30)</p>" +
                                "<html>");
                JTextField weightTextField = new JTextField("9", 11);

                int maxMines =
                        ((Integer.parseInt(heightTextField.getText()) * Integer.parseInt(weightTextField.getText())) * 75) / 100;

                JLabel mineCount = new JLabel(
                        "<html>" +
                                "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите количество мин</p>" +
                                "<p>на игровом поле (9 - " + maxMines + ")</p>" +
                                "<html>");


                JTextField mineCountTextField = new JTextField("10", 11);

                heightTextField.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        int maxMines =
                                ((Integer.parseInt(heightTextField.getText()) * Integer.parseInt(weightTextField.getText())) * 75) / 100;
                        mineCount.setText("<html>" +
                                "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите количество мин</p>" +
                                "<p>на игровом поле (9 - " + maxMines + ")</p>" +
                                "<html>");
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {

                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {

                    }
                });

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
                        try {
                            String height = heightTextField.getText();
                            throwExceptionForLetters(height);

                            String weight = weightTextField.getText();
                            throwExceptionForLetters(weight);

                            String mineCount = mineCountTextField.getText();
                            throwExceptionForLetters(mineCount);

                            getNewPanel(getGameProcess(new Arbitrary(
                                    Integer.parseInt(height),
                                    Integer.parseInt(weight),
                                    Integer.parseInt(mineCount))));
                            chooseMenu.dispose();
                        } catch (IllegalArgumentException e1) {
                            JOptionPane.showMessageDialog(null, e1.getMessage());

                        }
                    }
                });

                chooseMenu.add(textFieldPanel, BorderLayout.NORTH);
                chooseMenu.add(input, BorderLayout.SOUTH);
                chooseMenu.pack();
                chooseMenu.setLocationRelativeTo(null);
                chooseMenu.setVisible(true);
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
                addComponent(gridBagConstraints, 0, 0, 1, 1));

        jPanel.add(new JLabel(difficult.getName().toString()),
                addComponent(gridBagConstraints, 0, 1, 1, 1));

        jPanel.add(mineCount,
                addComponent(gridBagConstraints, 0, 2, 1, 1));

        jPanel.add(printGameField(model, mineCount, printTimer, timerTask),
                addComponent(gridBagConstraints, 1, 0, 0, 3));

        frame.add(jPanel);
        return jPanel;
    }

    private GridBagConstraints addComponent(GridBagConstraints gridBagConstraints, int row, int col, int rowNumber,
                                            int columnNumber) {
        gridBagConstraints.gridx = col;
        gridBagConstraints.gridy = row;
        gridBagConstraints.gridwidth = columnNumber;
        gridBagConstraints.gridheight = rowNumber;
        gridBagConstraints.weightx = 1;
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

    private void throwExceptionForLetters(String text) {
        Matcher matcher = Pattern.compile("[+-]?([0-9])?[0-9]+").matcher(text);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Введите целочисленное число.");
        }
    }
}
