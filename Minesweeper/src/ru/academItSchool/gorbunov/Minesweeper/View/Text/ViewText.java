package ru.academItSchool.gorbunov.Minesweeper.View.Text;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.BoomException;
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
        int menuItemTo = 4;

        switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
            case 1:
                System.out.println(inputOutputMenus.getSettingMenu());
                menuItemTo = 5;

                switch (inputOutputMenus.getInput(1, menuItemTo, inputOutputMenus.getMenuMessage(1, menuItemTo))) {
                    case 1:
                        EasyDifficulty easyDifficult = new EasyDifficulty();
                        getGameProcess(easyDifficult);
                        startGameAgain();
                        break;
                    case 2:
                        NormDifficulty normDifficult = new NormDifficulty();
                        getGameProcess(normDifficult);
                        startGameAgain();
                        break;
                    case 3:
                        HardDifficulty hardDifficult = new HardDifficulty();
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

                        ArbitraryDifficulty arbitraryDifficulty = new ArbitraryDifficulty(lines, columns, minesCount);
                        getGameProcess(arbitraryDifficulty);
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
                        highScores.printHighScores(new EasyDifficulty().getName());
                        startGameAgain();
                        break;
                    case 2:
                        highScores.printHighScores(new NormDifficulty().getName());
                        startGameAgain();
                        break;
                    case 3:
                        highScores.printHighScores(new HardDifficulty().getName());
                        startGameAgain();
                        break;
                    case 4:
                        startGame();
                        break;
                }
            case 3:
                System.out.println(inputOutputMenus.getInformation());
                startGameAgain();
                break;
            case 4:
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
     * @param difficulty сложность игры
     */
    private void getGameProcess(Difficulty difficulty) {
        Model model = new Model(new GameField(difficulty, characters));

        MyTimer myTimer = new MyTimer();
        Timer timer = new Timer();
        timer.schedule(myTimer, 0);

        try {
            while (model.getGameField().getMinesCount() != 0) {
                System.out.println(inputOutputMenus.getPrintGame(model, difficulty, myTimer));
                int[] coordinate = inputOutputMenus.getCoordinate(model.getGameField());
                while (coordinate[2] == 4) {
                    coordinate = inputOutputMenus.getCoordinate(model.getGameField());
                }
                model.clickMove(coordinate[0], coordinate[1], coordinate[2]);
            }
        } catch (BoomException b) {
            System.out.println(b.getMessage());
            inputOutputMenus.getPrintGame(model, difficulty, myTimer);
            myTimer.stop();
            return;
        }
        myTimer.stop();
        if (inputOutputMenus.getHighScoreWrite(myTimer.getTime(), difficulty)) {
            highScores.printHighScores(difficulty.getName());
        }
    }
}
