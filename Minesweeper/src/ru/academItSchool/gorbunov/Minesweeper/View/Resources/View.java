package ru.academItSchool.gorbunov.Minesweeper.View.Resources;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.Timer;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import java.util.Scanner;

public class View {
    private InputOutputMenus inputOutputMenus;
    private Model model;
    private HighScores highScores = new HighScores();

    public View(InputOutputMenus inputOutputMenus) {
        this.inputOutputMenus = inputOutputMenus;
    }

    public void startGame(Characters characters) {
        System.out.println(inputOutputMenus.getMainMenu());

        switch (inputOutputMenus.getInput(1, 2)) {
            case 1:
                System.out.println(inputOutputMenus.getSettingMenu());
                switch (inputOutputMenus.getInput(1, 5)) {
                    case 1:
                        Easy easy = new Easy();
                        getGameProcess(easy, characters);
                        highScores.printHighScores(easy.getName());
                        startGameAgain(characters);
                        break;
                    case 2:
                        Norm norm = new Norm();
                        getGameProcess(norm, characters);
                        highScores.printHighScores(norm.getName());
                        startGameAgain(characters);
                        break;
                    case 3:
                        Hard hard = new Hard();
                        getGameProcess(hard, characters);
                        highScores.printHighScores(hard.getName());
                        startGameAgain(characters);
                        break;
                    case 4:
                        System.out.println("Введите количество строк от 9 до 24");
                        int lines = inputOutputMenus.getInput(9, 24);

                        System.out.println("Введите количество столбцов от 9 до 30");
                        int columns = inputOutputMenus.getInput(9, 30);

                        int maxMines = ((lines * columns) * 75) / 100;
                        System.out.println("Введите количество строк от 9 до " + maxMines);
                        int minesCount = inputOutputMenus.getInput(9, maxMines);

                        Random random = new Random(lines, columns, minesCount);
                        getGameProcess(random, characters);
                        startGameAgain(characters);
                        break;
                    case 45:
                        startGame(characters);
                        break;
                }
                break;
            case 2:
                System.out.println(inputOutputMenus.getHeightScoreMenu());
                switch (inputOutputMenus.getInput(1, 4)) {
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
        }
    }

    private void startGameAgain(Characters characters) {
        System.out.println("Нажмите 1 для возврата в главное меню.");
        inputOutputMenus.getInput(1, 1);
        startGame(characters);
    }

    private void getGameProcess(Difficult difficult, Characters characters) {
        this.model = new Model(new GameField(difficult.getRowCount(), difficult.getRowCount(), difficult.getMines(), characters));
        this.model.getGameField().fillMinesInField();
        this.model.getGameField().fillNumbersInField();
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        thread.start();
        try {
            while (model.getGameField().getMineCount() != 0) {
                inputOutputMenus.getPrintGame(model, difficult, timer);
                int[] coordinate = inputOutputMenus.getCoordinate(model.getGameField());
                model.clickMove(coordinate[0], coordinate[1], coordinate[2]);
            }
        } catch (Boom b) {
            System.out.println(b.getMessage());
        }
        System.out.println("Введите имя игрока.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Player player = new Player(name, timer.getTime(), difficult);
        highScores.add(player);
    }
}
