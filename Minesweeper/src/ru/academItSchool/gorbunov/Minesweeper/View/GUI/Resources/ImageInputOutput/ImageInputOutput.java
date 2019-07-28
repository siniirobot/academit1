package ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.ImageInputOutput;


import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Timer;

import static java.awt.GridBagConstraints.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ImageInputOutput {
    private JFrame frame;
    private Characters characters;

    public ImageInputOutput(JFrame frame) {
        this.frame = frame;
        this.characters = new CharactersImage();
    }

    /**
     * Создание нового окна в фрейме
     *
     * @param container новое окно
     */
    private void getNewPanel(Container container) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(container);
        frame.getContentPane().validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    /**
     * Создание меню с кнопками
     * -Начать игру
     * -Таблица рекордов
     * -Выход из игры
     *
     * @return основное меню
     */
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
                System.exit(0);
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

    /**
     * Создание меню настроек с кнопками
     * -Легкая игра
     * -Нормальная вода
     * -Сложная игра
     * -Произвольная игра
     * -Назад
     *
     * @return меню настроек
     */
    private Container getSettingMenu() {
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
                chooseMenu.setPreferredSize(new Dimension(200, 270));

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
                heightTextField.getDocument().addDocumentListener(checkForRightInputForArbitraryDifficult(
                        24, heightTextField, weightTextField, mineCount
                ));
                weightTextField.getDocument().addDocumentListener(checkForRightInputForArbitraryDifficult(
                        30, weightTextField, heightTextField, mineCount
                ));

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

                            String weight = weightTextField.getText();

                            String mineCount = mineCountTextField.getText();

                            getNewPanel(getGameProcess(new Arbitrary(
                                    Integer.parseInt(height),
                                    Integer.parseInt(weight),
                                    Integer.parseInt(mineCount))));
                            chooseMenu.dispose();
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "Введите целочисленое значение");
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

    /**
     * @param to             до скольки вводить ширину или высоту
     * @param checkJTexField контролируемое поле ввода
     * @param jTextField     второе поле для вычисления количества мин
     * @param jLabel         поле для отображения колличества мин
     * @return Создание DocumentListener для ввода данных для произвольной сложности.
     */
    private DocumentListener checkForRightInputForArbitraryDifficult(int to, JTextField checkJTexField,
                                                                     JTextField jTextField, JLabel jLabel) {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                int maxMines = 0;
                try {
                    int input = checkInputForArbitraryInput(9, to, Integer.parseInt(checkJTexField.getText()));

                    maxMines = ((input * Integer.parseInt(jTextField.getText())) * 75) / 100;
                    maxMines = checkInputForArbitraryInput(10, 540, maxMines);
                } catch (NumberFormatException num) {
                    maxMines = 10;
                } finally {
                    jLabel.setText("<html>" +
                            "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите количество мин</p>" +
                            "<p>на игровом поле (9 - " + maxMines + ")</p>" +
                            "<html>");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };
    }

    /**
     * Проверяет что введеное число попадает в диапозон проверки
     * если меньше нижнего диапазона то возвращает нижний диапазон если выше верхнего
     * диапазона то число вверхнего диапазона в противном случае само число
     *
     * @param from   от кого числа проверять
     * @param to     до кого числа проверять
     * @param number проверяемое число
     * @return результат проверки
     */
    private int checkInputForArbitraryInput(int from, int to, int number) {
        return number < from ? from : number > to ? to : number;
    }

    private Container getHeightScoreMenu() {
        return null;
    }

    private Container getEndGameMenu() {
        return null;
    }

    /**
     * Выводит игровое поле со всеми настройками
     *
     * @param difficult сложность
     * @return игровое поле
     */
    private Container getGameProcess(Difficult difficult) {
        Model model = new Model(new GameField(difficult, characters));

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        JLabel time = new JLabel("0");
        Timer printTimer = new Timer();

        MyTimer myTimer = new MyTimer(time);

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

        jPanel.add(printGameField(model, mineCount, printTimer, myTimer),
                addComponent(gridBagConstraints, 1, 0, 0, 3));

        frame.add(jPanel);
        return jPanel;
    }

    /**
     * Спецификации для размещения контейнеров
     *
     * @param gridBagConstraints настройки
     * @param row                линия расположения в сетке
     * @param col                колонка расположения в сетке
     * @param rowNumber          количество занимаемых линий в сетке
     * @param columnNumber       количество занимаемых колонок в сетке
     * @return готовые настройки
     */
    private GridBagConstraints addComponent(GridBagConstraints gridBagConstraints, int row, int col, int rowNumber,
                                            int columnNumber) {
        gridBagConstraints.gridx = col;
        gridBagConstraints.gridy = row;
        gridBagConstraints.gridwidth = columnNumber;
        gridBagConstraints.gridheight = rowNumber;
        gridBagConstraints.weightx = 1;
        return gridBagConstraints;
    }

    /**
     * Вывод игрового поля с минами
     *
     * @param model     Состояние игрового поля
     * @param mineCount текущее количество мин
     * @param timer     таймер
     * @param myTimer   задание для таймера
     * @return вывод игрового поля
     */
    private JPanel printGameField(Model model, JLabel mineCount, Timer timer, MyTimer myTimer) {
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
                                timer.schedule(myTimer, 0);
                            }

                            if (e.getButton() == 3) {
                                model.clickMove(finalI, finalJ, 2);
                                mineCount.setText(((Integer) model.getPrintCountMine()).toString());
                                if (model.getGameField().getMineCount() == 0) {
                                    myTimer.stop();
                                    getHighScoreWrite(myTimer.getTime(), model.getGameField().getDifficult());
                                }
                            } else {
                                model.clickMove(finalI, finalJ, 1);
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

    private boolean getHighScoreWrite(int time, Difficult difficult) {
        JDialog highScorePlane = new JDialog();
        HighScores highScores = new HighScores();

        try {
            highScores.confirmTime(time, difficult);
            JDialog inputName = new JDialog();


            JTextField input = new JTextField("Введите имя игрока.", 11);

            inputName.add(input, BorderLayout.NORTH);

            JButton confirm = new JButton("ОК");

            confirm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        highScores.add(new Player(input.getText(), time, difficult));
                        inputName.dispose();
                    } catch (IllegalArgumentException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            });

            inputName.add(confirm, BorderLayout.SOUTH);

            inputName.setPreferredSize(new Dimension(150, 100));
            inputName.pack();
            inputName.setVisible(true);
            inputName.setLocationRelativeTo(null);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            getNewPanel(getMainMenu());
        }
        return false;
    }

    public Container getPrintHighScoreTableInPlane(Difficult difficult) {
        JPanel highScoreTable = new JPanel();
        HighScores highScores = new HighScores();
        String fileName = highScores.getFileName(difficult.getName());

        try {
            ObjectInputStream readFile = highScores.openFile(fileName);
            Player[] highScoresTable = (Player[]) readFile.readObject();
            Object[] header = new Object[]{"№:", "Имя:", "Время:"};
            Object[][] data = new Object[highScoresTable.length][3];

            for (int i = 0; i < data.length; i++) {
                data[i][0] = i + 1;
                data[i][1] = highScoresTable[i].getName();
                data[i][2] = highScoresTable[i].getTime();
            }
            JTable table = new JTable(data,header);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );


            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            JScrollPane tableContainer = new JScrollPane(table);
            tableContainer.setPreferredSize(new Dimension(281,200));

            highScoreTable.setPreferredSize(new Dimension(320, 400));
            highScoreTable.add(tableContainer, BorderLayout.CENTER);
        } catch (IOException e) {
            System.out.println("Таблица еще пуста.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return highScoreTable;
    }
}
