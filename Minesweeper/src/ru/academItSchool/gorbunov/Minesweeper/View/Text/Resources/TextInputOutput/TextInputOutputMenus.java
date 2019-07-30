package ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.TextInputOutput;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;

import java.util.Scanner;

public class TextInputOutputMenus {
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
                ("||          Нажмите 1         ||") + (System.lineSeparator()) +
                ("||      для продолжения.      ||") + (System.lineSeparator()) +
                ("||        И 2 для выхода      ||") + (System.lineSeparator()) +
                ("||          из игры.          ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public String getPrintGame(Model model, Difficult difficult, MyTimer myTimer) {
        return "Сложность - " + difficult.getName() + System.lineSeparator() +
                "Колличество мин - " + model.getPrintCountMine() + System.lineSeparator() +
                "Время - " + myTimer.getTime() + System.lineSeparator() +
                model.getGameField() + System.lineSeparator();
    }


    public int[] getCoordinate(GameField gameField) {
        int[] coordinate = new int[3];
        int to = gameField.getGameField().length;
        String message = "Введите номер строки от 1 до ";

        coordinate[0] = getInput(1, to, message + to) - 1;

        to = gameField.getGameField()[0].length;
        message = "Введите номер столбца от 1 до  ";

        coordinate[1] = getInput(1, to, message + to) - 1;

        message = ("Введите 1- чтобы открыть ячейку, " + (System.lineSeparator()) +
                "2 - чтобы пометить ячейку флагом как мину, " + (System.lineSeparator()) +
                "2 - (повторно) чтобы пометить ячейку вопросом.");

        coordinate[2] = getInput(1, 2, message);

        return coordinate;
    }

    public boolean getHighScoreWrite(int time, Difficult difficult) {
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;
        String name = "";

        while (!correct) {
            System.out.println("Введите имя игрока от 1 до 10 символов.");
            name = scanner.next();
            if (name.length() <= 10) {
                correct = true;
            }
        }

        Player player = new Player(name, time, difficult);
        HighScores highScores = new HighScores();
        try {
            highScores.confirmTime(time, difficult);
            highScores.add(player);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getInput(1, 2, getEndGameMenu());
            return false;
        }
        return true;
    }

    public int getInput(int from, int to, String message) {
        boolean correct = false;
        String input;
        int itemMenu = -1;

        while (!correct) {
            System.out.println(message);
            input = scanner.next();
            while (!input.matches("-?\\d+")) {
                System.out.println(message);
                input = scanner.next();
            }

            itemMenu = Integer.parseInt(input);

            for (int i = from; i <= to; i++) {
                if (itemMenu == i) {
                    correct = true;
                    break;
                }
            }
        }

        return itemMenu;
    }

    public String getMenuMessage(int from, int to) {
        return "Выберите пункт меню с " + from + " по " + to;
    }
}
