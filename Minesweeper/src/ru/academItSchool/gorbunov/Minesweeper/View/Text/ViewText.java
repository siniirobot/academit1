package ru.academItSchool.gorbunov.Minesweeper.View.Text;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.CharactersText.CharactersText;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.TextInputOutput.TextInputOutputMenus;

import java.util.Timer;

public class ViewText {
    private TextInputOutputMenus inputOutputMenus = new TextInputOutputMenus();
    private CharactersText characters = new CharactersText();
    private HighScores highScores = new HighScores();

    /**
     * Перебор меню по средствам выбора пункта меню.
     */
    public void startGame() {
        System.out.println(inputOutputMenus.getMainMenu());
        int menuItemTo = 3;

        switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
            case 1:
                System.out.println(inputOutputMenus.getSettingMenu());
                menuItemTo = 5;

                switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
                    case 1:
                        EasyDifficult easyDifficult = new EasyDifficult();
                        getGameProcess(easyDifficult);
                        startGameAgain();
                        break;
                    case 2:
                        NormDifficult normDifficult = new NormDifficult();
                        getGameProcess(normDifficult);
                        startGameAgain();
                        break;
                    case 3:
                        HardDifficult hardDifficult = new HardDifficult();
                        getGameProcess(hardDifficult);
                        startGameAgain();
                        break;
                    case 4:
                        int lines = inputOutputMenus.getInput(9, 24,
                                "Введите количество строк от 9 до 24");

                        int columns = inputOutputMenus.getInput(9, 30,
                                "Введите количество столбцов от 9 до 30");

                        int maxMines = ((lines * columns) * 75) / 100;
                        int minesCount = inputOutputMenus.getInput(1, maxMines,
                                "Введите количество мин от 10 до " + maxMines);

                        ArbitraryDifficult arbitraryDifficult = new ArbitraryDifficult(lines, columns, minesCount);
                        getGameProcess(arbitraryDifficult);
                        startGameAgain();
                        break;
                    case 5:
                        startGame();
                        break;
                }
                break;
            case 2:
                System.out.println(inputOutputMenus.getHeightScoreMenu());
                menuItemTo = 4;
                switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
                    case 1:
                        highScores.printHighScores(new EasyDifficult().getName());
                        startGameAgain();
                        break;
                    case 2:
                        highScores.printHighScores(new NormDifficult().getName());
                        startGameAgain();
                        break;
                    case 3:
                        highScores.printHighScores(new HardDifficult().getName());
                        startGameAgain();
                        break;
                    case 4:
                        startGame();
                        break;
                }
            case 3:
                exitGame();
        }
    }

    /**
     * Начать вывод меню с начала.
     */
    private void startGameAgain() {
        System.out.println(inputOutputMenus.getEndGameMenu());
        switch (inputOutputMenus.getInput(1, 2, inputOutputMenus.getMenuMessage(1, 2))) {
            case 1:
                startGame();
            case 2:
                exitGame();
        }
    }

    /**
     * Завершение программы
     */
    private void exitGame() {
        System.exit(0);
    }

    /**
     * Вывод игрового поля а так же ввод координат мины
     *
     * @param difficult сложность игры
     */
    private void getGameProcess(Difficult difficult) {
        Model model = new Model(new GameField(difficult, characters));

        MyTimer myTimer = new MyTimer();
        Timer timer = new Timer();
        timer.schedule(myTimer, 0);

        try {
            while (model.getGameField().getMineCount() != 0) {
                System.out.println(inputOutputMenus.getPrintGame(model, difficult, myTimer));
                int[] coordinate = inputOutputMenus.getCoordinate(model.getGameField());
                model.clickMove(coordinate[0], coordinate[1], coordinate[2]);
            }
        } catch (Boom b) {
            System.out.println(b.getMessage());
            inputOutputMenus.getPrintGame(model, difficult, myTimer);
            myTimer.stop();
            return;
        }
        myTimer.stop();
        if (inputOutputMenus.getHighScoreWrite(myTimer.getTime(), difficult)) {
            highScores.printHighScores(difficult.getName());
        }
    }
}
