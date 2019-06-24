package ru.academItSchool.gorbunov.Minesweeper.Model;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;

import java.util.LinkedList;
import java.util.Queue;

public class Model {
    private Characters characters;
    private GameField gameField;
    private int printCountMine;

    /**
     * Конструктор для создания модели.
     * @param gameField игровое поле.
     */
    public Model(GameField gameField) {
        this.characters = gameField.getCharacters();
        this.gameField = gameField;
        this.printCountMine = gameField.getMineCount();
    }

    /**
     * @return текущее колличество мин
     */
    public int getPrintCountMine() {
        return this.printCountMine;
    }

    /**
     * @return игровое поле.
     */
    public GameField getGameField() {
        return gameField;
    }

    /**
     * Контролирует ввод команд мыши, а так же координаты нажатия.
     * @param line - линия на которую нажали.
     * @param column - колонка на которую нажали.
     * @param command - комманда, левое или правое нажатие мыши.
     * @throws Boom - взрыв бомбы.
     */
    public void clickMove(int line, int column, int command) throws Boom {
        switch (command) {
            case 1:
                leftClickOnCell(line, column);
                break;
            case 2:
                rightClickOnCell(line, column);
        }
    }

    /**
     * Нажатие мыши левой кнопкой открывает клетку и делает её видимой для распечатки.
     * @param line - линия на которую нажали.
     * @param column - колонка на которую нажали.
     * @throws Boom - происходит взрыв и конец игры.
     */
    private void leftClickOnCell(int line, int column) throws Boom {
        if (gameField.getGameField()[line][column].isVisible()) {
            return;
        }

        if (gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[10])) {
            gameField.getGameField()[line][column].setVisible(true);
            for (Cell[] row : gameField.getGameField()) {
                for (Cell el : row) {
                    if (el.isMine()) {
                        el.setVisible(true);
                        el.setContent(characters.getCharacters()[10]);
                    }
                }
            }

            throw new Boom("Вы взорвали себя.");
        } else if (!gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[0])) {
            gameField.getGameField()[line][column].setVisible(true);
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
                                characters.getCharacters()[0]) || (i == 0 && j == 0)) {
                            gameField.getGameField()[i + tempLine][j + tempColumn].setVisible(true);
                        }

                        if (!gameField.getGameField()[i + tempLine][j + tempColumn].isVisible()) {
                            queue.add(new Integer[]{i + tempLine, j + tempColumn});
                        }

                    }
                }
            }
        }
    }

    /**
     * Ставит флажок и помечает миной это место.
     * При повторном нажатии ставит флажок.
     * Если количество флажков и мин совпадет будет выйгрешь.
     * @param line - линия на которую нажали.
     * @param column - колонка на которую нажали.
     */
    private void rightClickOnCell(int line, int column) {
        if (gameField.getGameField()[line][column].isVisible() &&
                !(gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[11]) ||
                        gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[12]))) {
            return;
        }

        if (gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[11])) {
            gameField.getGameField()[line][column].setContent(characters.getCharacters()[12]);
            getUpMineCount(gameField.getGameField()[line][column]);
            return;
        }

        if (gameField.getGameField()[line][column].getContent().equals(characters.getCharacters()[12])) {
            gameField.getCountMineInArea(line, column);
            gameField.getGameField()[line][column].setVisible(false);
            return;
        }

        gameField.getGameField()[line][column].setContent(characters.getCharacters()[11]);
        gameField.getGameField()[line][column].setVisible(true);
        getDownMineCount(gameField.getGameField()[line][column]);
    }

    /**
     * Поднимает количество мин если были отмечен не правильный флажок.
     * @param cell проверяймая ячейка
     */
    private void getUpMineCount(Cell cell) {
        if (cell.isMine()) {
            gameField.setMineCount(gameField.getMineCount() + 1);
            this.printCountMine++;
        } else {
            this.printCountMine++;
        }
    }

    /**
     * Уменьшает количество мин когда ячейка отмечена флажком.
     * @param cell проверяймая ячейка
     */
    private void getDownMineCount(Cell cell) {
        if (cell.isMine()) {
            gameField.setMineCount(gameField.getMineCount() - 1);
            this.printCountMine--;
        } else {
            this.printCountMine--;
        }
    }
}