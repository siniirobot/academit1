package ru.academItSchool.gorbunov.Minesweeper.View.GUI;


import ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.BoomException;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Timer;

import static java.awt.GridBagConstraints.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ViewGUI {
    private JFrame frame;
    private Characters characters;

    public ViewGUI() {
        this.frame = new JFrame("Minesweeper");
        this.characters = new CharactersImage();
    }

    /**
     * Создание фрейма
     */
    public void getGUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getCrossPlatformLookAndFeelClassName());
                frame.getContentPane().add(getMainMenu());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setIconImage(ImageIO.read(new File("Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper" +
                        "/View/GUI/Resources/CharactersImage/icon.png")));
                frame.setResizable(false);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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
     * -Информация о программе
     * -Выход из игры
     *
     * @return основное меню
     */
    private Container getMainMenu() {
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

        JButton about = new JButton("Информация");
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel aboutText = new JLabel("<html>" +
                        "<p style=\"text-align:center;margin-bottom: 1px;\"> Игра сапер</p>" +
                        "<p style=\"text-align:center;margin-bottom: 1px;\">скопирована учеником курсов Academ It School</p>" +
                        "<p style=\"text-align:center;margin-bottom: 1px;\">версия 0.1</p>" +
                        "<html>");

                JDialog aboutPanel = new JDialog(frame, frame.getTitle(), true);

                JButton confirm = new JButton("Ок");
                confirm.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        getNewPanel(getMainMenu());
                        aboutPanel.dispose();
                    }
                });

                aboutPanel.setLayout(new GridBagLayout());
                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.fill = NONE;

                aboutPanel.add(aboutText, addComponent(gridBagConstraints, 1, 1, 3, 3));
                aboutPanel.add(confirm, addComponent(gridBagConstraints, 5, 1, 1, 1));

                aboutPanel.setPreferredSize(new Dimension(300, 120));
                aboutPanel.pack();
                aboutPanel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                aboutPanel.setLocationRelativeTo(frame);
                aboutPanel.setVisible(true);
            }
        });

        JLabel title = new JLabel("САПЁР");
        title.setFont(new Font("AriaBOLD", Font.PLAIN, 36));

        JButton exit = new JButton("Выход из игры");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(startGame);
        buttonPanel.add(heightScoreMenu);
        buttonPanel.add(about);
        buttonPanel.add(exit);

        buttonPanel.setPreferredSize(new Dimension(200, 150));
        buttonPanel.setLayout(new GridLayout(4, 1));

        JPanel mainPanel = new JPanel();

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.setPreferredSize(new Dimension(250, 230));
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
        JButton easy = new JButton("Легкая");
        easy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getGameProcess(new EasyDifficulty()));
            }
        });

        JButton norm = new JButton("Нормальная");
        norm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getGameProcess(new NormDifficulty()));
            }
        });

        JButton hard = new JButton("Тяжелая");
        hard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getGameProcess(new HardDifficulty()));
            }
        });

        JButton arbitrary = new JButton("Произвольная");
        arbitrary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel height = new JLabel(
                        "<html>" +
                                "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите высоту</p>" +
                                "<p>игрового поля (9 - 24)</p>" +
                                "<html>");

                JLabel weight = new JLabel(
                        "<html>" +
                                "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите ширину</p>" +
                                "<p>игрового поля (9 - 30)</p>" +
                                "<html>");

                JTextField heightTextField = new JTextField("9", 11);
                JTextField weightTextField = new JTextField("9", 11);
                JTextField mineCountTextField = new JTextField("10", 11);

                int maxMines =
                        ((Integer.parseInt(heightTextField.getText()) * Integer.parseInt(weightTextField.getText())) * 75) / 100;

                JLabel mineCount = new JLabel(
                        "<html>" +
                                "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите количество мин</p>" +
                                "<p>на игровом поле (9 - " + maxMines + ")</p>" +
                                "<html>");


                heightTextField.getDocument().addDocumentListener(checkForRightInputForArbitraryDifficult(
                        24, heightTextField, weightTextField, mineCount
                ));
                weightTextField.getDocument().addDocumentListener(checkForRightInputForArbitraryDifficult(
                        30, weightTextField, heightTextField, mineCount
                ));

                JDialog chooseMenu = new JDialog(frame, frame.getTitle(), true);
                JButton input = new JButton("Ок");
                input.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            String height = heightTextField.getText();

                            String weight = weightTextField.getText();

                            String mineCount = mineCountTextField.getText();

                            getNewPanel(getGameProcess(new ArbitraryDifficulty(
                                    Integer.parseInt(height),
                                    Integer.parseInt(weight),
                                    Integer.parseInt(mineCount))));
                            chooseMenu.dispose();
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "Введите целочисленое значение");
                        }
                    }
                });

                JPanel textFieldPanel = new JPanel();

                textFieldPanel.add(height);
                textFieldPanel.add(heightTextField);
                textFieldPanel.add(weight);
                textFieldPanel.add(weightTextField);
                textFieldPanel.add(mineCount);
                textFieldPanel.add(mineCountTextField);

                textFieldPanel.setPreferredSize(new Dimension(120, 200));

                chooseMenu.add(textFieldPanel, BorderLayout.NORTH);
                chooseMenu.add(input, BorderLayout.SOUTH);

                chooseMenu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                chooseMenu.setPreferredSize(new Dimension(200, 270));
                chooseMenu.setResizable(false);
                chooseMenu.pack();
                chooseMenu.setLocationRelativeTo(frame);
                chooseMenu.setVisible(true);
            }
        });

        JLabel title = new JLabel("Выбирете сложность");
        title.setFont(new Font("AriaBOLD", Font.PLAIN, 18));

        JButton back = new JButton("Назад");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getMainMenu());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.setPreferredSize(new Dimension(200, 200));

        buttonPanel.add(easy);
        buttonPanel.add(norm);
        buttonPanel.add(hard);
        buttonPanel.add(arbitrary);
        buttonPanel.add(back);

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

    /**
     * Выводит игровое поле со всеми настройками
     *
     * @param difficulty сложность
     * @return игровое поле
     */
    private Container getGameProcess(Difficulty difficulty) {
        Model model = new Model(new GameField(difficulty, characters));

        JPanel mainPlane = new JPanel();
        mainPlane.setLayout(new GridBagLayout());

        JLabel time = new JLabel("0");
        Timer printTimer = new Timer();

        MyTimer myTimer = new MyTimer(time);

        JLabel mineCount = new JLabel();
        mineCount.setText(((Integer) model.getPrintCountMines()).toString());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = NONE;

        mainPlane.add(time,
                addComponent(gridBagConstraints, 0, 0, 1, 1));

        mainPlane.add(new JLabel(difficulty.getName().toString()),
                addComponent(gridBagConstraints, 0, 1, 1, 1));

        mainPlane.add(mineCount,
                addComponent(gridBagConstraints, 0, 2, 1, 1));

        mainPlane.add(printGameField(model, mineCount, printTimer, myTimer),
                addComponent(gridBagConstraints, 1, 0, 0, 3));

        frame.add(mainPlane);
        return mainPlane;
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
                                model.clickMove(finalI, finalJ, 3);
                                mineCount.setText(((Integer) model.getPrintCountMines()).toString());
                                if (model.getGameField().getMinesCount() == 0) {
                                    myTimer.stop();
                                    getHighScoreWrite(myTimer.getTime(), model.getGameField().getDifficulty());
                                }
                            } else {
                                model.clickMove(finalI, finalJ, 1);
                            }

                        } catch (BoomException boomException) {
                            for (int i = 0; i < jButtons.length; i++) {
                                for (int j = 0; j < jButtons[0].length; j++) {
                                    if (model.getGameField().getGameField()[i][j].isVisible()) {
                                        jButtons[i][j].setIcon((ImageIcon) model.getGameField().getGameField()[i][j].getContent());
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(null, boomException.getMessage());

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

    /**
     * @return Меню с таблицами рекордов по сложностям.
     */
    private Container getHeightScoreMenu() {
        JPanel mainPanel = new JPanel();
        JTabbedPane switchDifficult = new JTabbedPane();

        switchDifficult.add("Легко", getPrintHighScoreTableInPlane(new EasyDifficulty()));
        switchDifficult.add("Нормально", getPrintHighScoreTableInPlane(new NormDifficulty()));
        switchDifficult.add("Сложно", getPrintHighScoreTableInPlane(new HardDifficulty()));

        JButton back = new JButton("Назад");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getNewPanel(getMainMenu());
            }
        });
        mainPanel.add(switchDifficult, BorderLayout.NORTH);
        mainPanel.add(back, BorderLayout.SOUTH);
        mainPanel.setPreferredSize(new Dimension(300, 260));
        return mainPanel;
    }

    /**
     * Если лучше последнего результата,выводит окно с записью имени игрока и делает запись в таблицу рекордов
     * после чего выводит её.
     *
     * @param time      время игрока
     * @param difficulty сложность игры
     */
    private void getHighScoreWrite(int time, Difficulty difficulty) {
        JDialog highScorePlane = new JDialog(frame, frame.getTitle(), true);
        HighScores highScores = new HighScores();

        try {
            highScores.confirmTime(time, difficulty);
            JDialog inputName = new JDialog(frame, frame.getTitle(), true);

            JLabel inputRule = new JLabel("<html>" +
                    "<p style=\"text-align:center;margin-bottom: 1px;\"> Введите имя игрока</p>" +
                    "<p style=\"text-align:center;\">длиной не больше 10 символов</p>" +
                    "<html>");

            JTextField input = new JTextField("", 10);

            JButton confirm = new JButton("ОК");

            confirm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        highScores.add(new Player(input.getText(), time, difficulty));
                        inputName.dispose();

                        JButton getMainMenu = new JButton("Ок");
                        getMainMenu.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                highScorePlane.dispose();
                                getNewPanel(getMainMenu());
                            }
                        });

                        highScorePlane.setLayout(new GridBagLayout());

                        GridBagConstraints gridBagConstraints = new GridBagConstraints();
                        gridBagConstraints.fill = NONE;

                        highScorePlane.add(getPrintHighScoreTableInPlane(difficulty),
                                addComponent(gridBagConstraints, 0, 1, 3, 3));
                        highScorePlane.add(new JLabel(""),
                                addComponent(gridBagConstraints, 4, 1, 1, 1));
                        highScorePlane.add(getMainMenu,
                                addComponent(gridBagConstraints, 5, 1, 1, 1));

                        highScorePlane.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        highScorePlane.pack();
                        highScorePlane.setLocationRelativeTo(frame);
                        highScorePlane.setResizable(false);
                        highScorePlane.setVisible(true);
                    } catch (IllegalArgumentException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            });

            inputName.setLayout(new FlowLayout(FlowLayout.CENTER));
            inputName.add(inputRule);
            inputName.add(input);
            inputName.add(confirm);

            inputName.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            inputName.setPreferredSize(new Dimension(220, 125));
            inputName.pack();
            inputName.setLocationRelativeTo(frame);
            inputName.setResizable(false);
            inputName.setVisible(true);

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            getNewPanel(getMainMenu());
        }
    }

    /**
     * @param difficulty сложность таблицы рекордов
     * @return возвращает панель с таблицей рекордов
     */
    private Container getPrintHighScoreTableInPlane(Difficulty difficulty) {
        JPanel highScoreTable = new JPanel();
        HighScores highScores = new HighScores();
        String fileName = highScores.getFileName(difficulty.getName());

        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(fileName));
            Player[] highScoresTable = (Player[]) readFile.readObject();

            int highScoresRowCount = 0;
            for (; highScoresRowCount < highScoresTable.length; highScoresRowCount++) {
                if (highScoresTable[highScoresRowCount] == null) {
                    break;
                }
            }
            Object[] header = new Object[]{"№:", "Имя:", "Время:"};
            Object[][] data = new Object[highScoresRowCount][3];

            for (int i = 0; i < data.length; i++) {
                data[i][0] = i + 1;
                data[i][1] = highScoresTable[i].getName();
                data[i][2] = highScoresTable[i].getTime();
            }

            JTable table = new JTable(data, header);
            table.setEnabled(false);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

            table.getColumnModel().getColumn(1).setPreferredWidth(170);
            table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

            JScrollPane tableContainer = new JScrollPane(table);
            int highTable = highScoresRowCount * 17 + 22;
            tableContainer.setPreferredSize(new Dimension(283, highTable));

            highScoreTable.add(tableContainer, BorderLayout.CENTER);
        } catch (IOException e) {
            JLabel emptyTable = new JLabel("Таблица еще пуста.");
            highScoreTable.setPreferredSize(new Dimension(283, 193));
            highScoreTable.add(emptyTable, BorderLayout.CENTER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return highScoreTable;
    }
}
