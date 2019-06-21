package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
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

        System.out.println("Введите номер строки - ");
        coordinate[0] = getInput(1, gameField.getGameField().length) - 1;

        System.out.println("Введите номер столбца - ");
        coordinate[1] = getInput(1, gameField.getGameField()[0].length) - 1;

        System.out.println("Введите 1- чтобы открыть ячейку, " +
                "2 - чтобы пометить ячейку флагом как мину, " +
                "2 - (повторно) чтобы пометить ячейку вопросом.");
        coordinate[2] = getInput(1, 2);

        return coordinate;
    }

    public int getInput(int from, int to) {
        String[] arrayChoosingElements = getArrayChoosingElements(from, to);
        StringBuilder choosingElements = new StringBuilder();
        String input = scanner.next();
        for (String el : arrayChoosingElements) {
            if (input.equals(el)) {
                return Integer.parseInt(el);
            }
            choosingElements.append(el).append(" ");
        }
        System.out.println("Введите число :" + choosingElements);
        return getInput(arrayChoosingElements, choosingElements);
    }

    public int getInput(String[] arrayChoosingElements, StringBuilder choosingElements) {
        String input = scanner.next();
        for (String el : arrayChoosingElements) {
            if (input.equals(el)) {
                return Integer.parseInt(el);
            }
        }
        System.out.println("Введите число :" + choosingElements);
        return getInput(arrayChoosingElements, choosingElements);
    }

    private String[] getArrayChoosingElements(int from, int to) {
        String[] menus = new String[to];
        for (int i = from - 1; i < to; i++) {
            menus[i] = ((Integer) (i + 1)).toString();
        }
        return menus;
    }
}
