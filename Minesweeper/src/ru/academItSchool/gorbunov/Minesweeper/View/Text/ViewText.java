package ru.academItSchool.gorbunov.Minesweeper.View.Text;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import java.util.Timer;

public class ViewText {
    private InputOutputMenus inputOutputMenus;
    private HighScores highScores = new HighScores();

    public ViewText(InputOutputMenus inputOutputMenus) {
        this.inputOutputMenus = inputOutputMenus;
    }

    /**
     * Перебор меню по средствам выбора пункта меню.
     * @param characters
     */
    public void startGame(Characters characters) {
        System.out.println(inputOutputMenus.getMainMenu());
        int menuItemTo = 3;

        switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
            case 1:
                System.out.println(inputOutputMenus.getSettingMenu());
                menuItemTo = 5;

                switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
                    case 1:
                        Easy easy = new Easy();
                        getGameProcess(easy, characters);
                        startGameAgain(characters);
                        break;
                    case 2:
                        Norm norm = new Norm();
                        getGameProcess(norm, characters);
                        startGameAgain(characters);
                        break;
                    case 3:
                        Hard hard = new Hard();
                        getGameProcess(hard, characters);
                        startGameAgain(characters);
                        break;
                    case 4:
                        int lines = inputOutputMenus.getInput(9, 24,
                                "Введите количество строк от 9 до 24");

                        int columns = inputOutputMenus.getInput(9, 30,
                                "Введите количество столбцов от 9 до 30");

                        int maxMines = ((lines * columns) * 75) / 100;
                        int minesCount = inputOutputMenus.getInput(1, maxMines,
                                "Введите количество мин от 10 до " + maxMines);

                        Random random = new Random(lines, columns, minesCount);
                        getGameProcess(random, characters);
                        startGameAgain(characters);
                        break;
                    case 5:
                        startGame(characters);
                        break;
                }
                break;
            case 2:
                System.out.println(inputOutputMenus.getHeightScoreMenu());
                menuItemTo = 4;
                switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
                    case 1:
                        highScores.printHighScores(new Easy().getName());
                        startGameAgain(characters);
                        break;
                    case 2:
                        highScores.printHighScores(new Norm().getName());
                        startGameAgain(characters);
                        break;
                    case 3:
                        highScores.printHighScores(new Hard().getName());
                        startGameAgain(characters);
                        break;
                    case 4:
                        startGame(characters);
                        break;
                }
            case 3:
                exitGame();
        }
    }

    /**
     * Начать вывод меню с начала.
     * @param characters
     */
    private void startGameAgain(Characters characters) {
        System.out.println(inputOutputMenus.getEndGameMenu());
        switch (inputOutputMenus.getInput(1, 2, inputOutputMenus.getMenuMessage(1, 2))) {
            case 1:
                startGame(characters);
            case 2:
                exitGame();
        }
    }

    /**
     * Завершение программы
     */
    private void exitGame() {
        System.exit(-1);
    }

    /**
     * Вывод игрового поля а так же ввод координат мины
     * @param difficult
     * @param characters
     */
    private void getGameProcess(Difficult difficult, Characters characters) {
        Model model = new Model(new GameField(difficult.getLineCount(), difficult.getColumnCount(), difficult.getMines(),
                characters));

        MyTimer myTimer = new MyTimer();
        Timer timer = new Timer();
        timer.schedule(myTimer,0);

        try {
            while (model.getGameField().getMineCount() != 0) {
                inputOutputMenus.getPrintGame(model, difficult, myTimer);
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
    }
}
