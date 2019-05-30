package ru.academItSchool.gorbunov.Minesweeper.Resources.Model;

import ru.academItSchool.gorbunov.Minesweeper.Resources.Characters.Characters;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Characters.Cell;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.Exceptions.Boom;

import java.util.LinkedList;
import java.util.Queue;

public class Model {
    private Characters characters = new Characters();

    public void clickMove(String command, GameField gameField, int line, int column) throws Boom {
        switch (command) {
            case "1":
                leftClickOnCell(gameField, line, column);
                break;
            case "2":
                rightClickOnCell(gameField, line, column);
        }
    }

    private void leftClickOnCell(GameField gameField, int line, int column) throws Boom {
        Cell cell = gameField.getGameField()[line][column];
        if (cell.isVisible()) {
            return;
        }

        if (cell.getChar() == characters.getCell()[10].getChar()) {
            cell.setVisible();
            throw new Boom("Поздравляю вы взорвали себя!");
        } else if (cell.getChar() != characters.getCell()[0].getChar()) {
            cell.setVisible();
        } else {
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{line, column});

            while (!queue.isEmpty()) {
                Integer[] temp = queue.remove();
                int tempLine = temp[1];
                int tempColumn = temp[2];

                for (int i = -1; i <= 1; i++) {
                    if (i + tempLine < 0) {
                        i++;
                    }
                    if (i + tempLine == gameField.getGameField().length) {
                        continue;
                    }
                    for (int j = -1; j <= 1; j++) {
                        if (j + tempColumn < 0) {
                            j++;
                        }

                        if (j + tempColumn == gameField.getGameField()[i].length) {
                            continue;
                        }
                        gameField.getGameField()[i + tempLine][j + tempColumn].setVisible();

                        if (gameField.getGameField()[i + tempLine][j + tempColumn].getChar() ==
                                characters.getCell()[0].getChar()) {
                            queue.add(new Integer[]{i + tempLine, j + tempColumn});
                        }
                    }
                }
            }
        }
    }

    private void rightClickOnCell(GameField gameField, int line, int column) {
        Cell cell = gameField.getGameField()[line][column];
        if (cell.isVisible()) {
            return;
        }

        if (cell.getChar() == characters.getCell()[11].getChar()) {
            gameField.getGameField()[line][column] = characters.getCell()[12];
            gameField.setMineCount(gameField.getMineCount() + 1);
        }

        if (cell.getChar() == characters.getCell()[12].getChar()) {
            gameField.getGameField()[line][column] = characters.getCell()[9];
        }

        gameField.getGameField()[line][column] = characters.getCell()[12];
        gameField.setMineCount(gameField.getMineCount() - 1);
    }
}
