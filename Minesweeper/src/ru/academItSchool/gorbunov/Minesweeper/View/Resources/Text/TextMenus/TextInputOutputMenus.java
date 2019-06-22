package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.Timer;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.InputOutputMenus;

import java.util.Scanner;

public class TextInputOutputMenus implements InputOutputMenus {
    private Scanner scanner = new Scanner(System.in);

    public String getMainMenu() {
        return ("||//////////////////////||") + (System.lineSeparator())
                + ("||        САПЕР!        ||") + (System.lineSeparator())
                + ("||1) -   Начать игру.   ||") + (System.lineSeparator())
                + ("||2) - Таблица рекордов.||") + (System.lineSeparator())
                + ("||3) - Выход из игры.   ||") + (System.lineSeparator())
                + ("||//////////////////////||") + (System.lineSeparator());
    }

    public String getSettingMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||     ВЫБИРЕТЕ СЛОЖНОСТЬ     ||") + (System.lineSeparator()) +
                ("||1) - Легкая сложность.      ||") + (System.lineSeparator()) +
                ("||2) - Средняя сложность.     ||") + (System.lineSeparator()) +
                ("||3) - Высокая сложность.     ||") + (System.lineSeparator()) +
                ("||4) - Произвольная сложность.||") + (System.lineSeparator()) +
                ("||5) - Назад.                 ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public String getHeightScoreMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||     ВЫБИРЕТЕ СЛОЖНОСТЬ     ||") + (System.lineSeparator()) +
                ("||1) - Легкая сложность.      ||") + (System.lineSeparator()) +
                ("||2) - Средняя сложность.     ||") + (System.lineSeparator()) +
                ("||3) - Высокая сложность.     ||") + (System.lineSeparator()) +
                ("||4) - Назад.                 ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public String getEndGameMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||           Победа           ||") + (System.lineSeparator()) +
                ("||   Вы взорвали все бомбы!   ||") + (System.lineSeparator()) +
                ("||          Нажмите 1         ||") + (System.lineSeparator()) +
                ("||      для продолжения.      ||") + (System.lineSeparator()) +
                ("||        И 2 для выхода      ||") + (System.lineSeparator()) +
                ("||          из игры.          ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public void getPrintGame(Model model, Difficult difficult, Timer timer) {
        System.out.println("Сложность - " + difficult.getName());
        System.out.println("Колличество мин - " + model.getPrintCountMine());
        System.out.println("Время - " + timer.getTime());
        System.out.println(model.getGameField());
    }


    @Override
    public int[] getCoordinate(GameField gameField) {
        int[] coordinate = new int[3];
        int to = gameField.getGameField().length;
        String message = "Введите номер строки от 1 до ";

        coordinate[0] = getInput(getArrayChoosingElements(1, to), message + to) - 1;

        to = gameField.getGameField()[0].length;
        message = "Введите номер столбца от 1 до  ";

        coordinate[1] = getInput(getArrayChoosingElements(1, to), message + to) - 1;

        message = ("Введите 1- чтобы открыть ячейку, " + (System.lineSeparator()) +
                "2 - чтобы пометить ячейку флагом как мину, " + (System.lineSeparator()) +
                "2 - (повторно) чтобы пометить ячейку вопросом.");

        coordinate[2] = getInput(getArrayChoosingElements(1, 2), message);

        return coordinate;
    }

    @Override
    public void getHighScoreWrite(Timer timer, Difficult difficult) {
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        String name = "";

        while (!correct) {
            System.out.println("Введите имя игрока от 1 до 10 символов.");
            name = scanner.next();
            if (name.length() > 10 || name.length() < 1) {
                correct = true;
            }
        }

        Player player = new Player(name, timer.getTime(), difficult);
        HighScores highScores = new HighScores();
        highScores.add(player);
    }

    @Override
    public int getInput(String[] arrayChoosingElements, String message) {
        System.out.println(message);
        String input = scanner.next();
        for (String el : arrayChoosingElements) {
            if (input.equals(el)) {
                return Integer.parseInt(el);
            }
        }
        return getInput(arrayChoosingElements, message);
    }

    @Override
    public String getMenuMessage(int from, int to) {
        return "Выюирите пункт меню с " + from + " по " + to;
    }

    public String[] getArrayChoosingElements(int from, int to) {
        String[] menus = new String[to];
        for (int i = from - 1; i < to; i++) {
            menus[i] = ((Integer) (i + 1)).toString();
        }
        return menus;
    }
}
