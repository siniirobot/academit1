package ru.academItSchool.gorbunov.Minesweeper.Model;

import ru.academItSchool.gorbunov.Minesweeper.Resources.Characters;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;

import java.util.LinkedList;
import java.util.Queue;

public class Model {
    private Characters characters;
    private GameField gameField;
    private int printCountMine;

    public Model(Characters characters, GameField gameField) {
        this.characters = characters;
        this.gameField = gameField;
        this.printCountMine = gameField.getMineCount();
    }

    public int getPrintCountMine() {
        return this.printCountMine;
    }

    public void clickMove(String command, int line, int column) throws Boom {
        switch (command) {
            case "1":
                leftClickOnCell(line, column);
                break;
            case "2":
                rightClickOnCell(line, column);
        }
    }

    private void leftClickOnCell(int line, int column) throws Boom {
        if (gameField.getGameField()[line][column].isVisible()) {
            return;
        }

        if (gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[10].getContent())) {
            gameField.getGameField()[line][column].setVisible();
            gameField.getGameField()[line][column].setContent(characters.getCharacters()[10].getContent());
            throw new Boom("Вы взорвали себя.");
        } else if (!gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[0].getContent())) {
            gameField.getGameField()[line][column].setVisible();
        } else {
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{line, column});

            while (!queue.isEmpty()) {
                Integer[] temp = queue.remove();
                int tempLine = temp[0];
                int tempColumn = temp[1];

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

                        if (j + tempColumn == gameField.getGameField()[i + tempLine].length) {
                            continue;
                        }

                        if (!gameField.getGameField()[i + tempLine][j + tempColumn].getContent().equals(
                                characters.getCharacters()[0].getContent()) || (i == 0 && j == 0)) {
                            gameField.getGameField()[i + tempLine][j + tempColumn].setVisible();
                        }

                        if (!gameField.getGameField()[i + tempLine][j + tempColumn].isVisible()) {
                            queue.add(new Integer[]{i + tempLine, j + tempColumn});
                        }

                    }
                }
            }
        }
    }

    private void rightClickOnCell(int line, int column) {
        if (gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[11])) {
            gameField.getGameField()[line][column].setContent(characters.getCharacters()[12].getContent());
            if (gameField.getGameField()[line][column].isMine()) {
                gameField.setMineCount(gameField.getMineCount() + 1);
                this.printCountMine++;
            } else {
                this.printCountMine++;
            }
            return;
        }

        if (gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[12].getContent())) {
            gameField.getGameField()[line][column].setContent(characters.getCharacters()[9].getContent());
            if (gameField.getGameField()[line][column].isMine()) {
                gameField.setMineCount(gameField.getMineCount() + 1);
                this.printCountMine++;
            } else {
                this.printCountMine++;
            }
            return;
        }

        gameField.getGameField()[line][column].setContent(characters.getCharacters()[11].getContent());
        gameField.getGameField()[line][column].setVisible();
        if (gameField.getGameField()[line][column].isMine()) {
            gameField.setMineCount(gameField.getMineCount() - 1);
            this.printCountMine--;
        } else {
            this.printCountMine--;
        }
    }
}

/*
if (gameField.getGameField()[line][column].isVisible()) {
            return;
        }

        if (gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[10].getContent())) {
            gameField.getGameField()[line][column].setVisible();
            gameField.getGameField()[line][column].setContent(characters.getCharacters()[10].getContent());
            throw new Boom("Вы взорвали себя.");
        } else if (!gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[0].getContent())) {
            gameField.getGameField()[line][column].setVisible();
        } else {
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{line, column});

            while (!queue.isEmpty()) {
                Integer[] temp = queue.remove();
                int tempLine = temp[0];
                int tempColumn = temp[1];

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

                        if (j + tempColumn == gameField.getGameField()[i + tempLine].length) {
                            continue;
                        }

                        if (!gameField.getGameField()[i + tempLine][j + tempColumn].getContent().equals(
                                characters.getCharacters()[0].getContent()) || (i == 0 && j == 0)) {
                            gameField.getGameField()[i + tempLine][j + tempColumn].setVisible();
                        }

                        if (!gameField.getGameField()[i + tempLine][j + tempColumn].isVisible()) {
                            queue.add(new Integer[]{i + tempLine, j + tempColumn});
                        }

                    }
                }
            }
        }
 */
