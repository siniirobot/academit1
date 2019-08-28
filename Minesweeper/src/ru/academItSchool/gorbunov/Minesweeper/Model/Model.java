package ru.academItSchool.gorbunov.Minesweeper.Model;

import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.BoomException;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Model {
    private Characters characters;
    private GameField gameField;
    private int printCountMine;

    /**
     * Конструктор для создания модели.
     *
     * @param gameField игровое поле.
     */
    public Model(GameField gameField) {
        this.characters = gameField.getCharacters();
        this.gameField = gameField;
        this.printCountMine = gameField.getMinesCount();
    }

    /**
     * @return текущее колличество мин
     */
    public int getPrintCountMines() {
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
     *
     * @param line    - линия на которую нажали.
     * @param column  - колонка на которую нажали.
     * @param command - комманда, левое или правое нажатие мыши.
     * @throws BoomException - взрыв бомбы.
     */
    public void clickMove(int line, int column, int command) throws BoomException {
        switch (command) {
            case 1:
                leftClickOnCell(line, column);
                break;
            case 2:
                wheelClickOnCell(line, column);
                break;
            case 3:
                rightClickOnCell(line, column);
        }
    }

    /**
     * Нажатие мыши левой кнопкой открывает клетку и делает её видимой для распечатки.
     *
     * @param line   - линия на которую нажали.
     * @param column - колонка на которую нажали.
     * @throws BoomException - происходит взрыв и конец игры.
     */
    private void leftClickOnCell(int line, int column) throws BoomException {
        Cell cell = gameField.getGameField()[line][column];
        if (cell.getRealContent() == cell.getVisibleContent()) {
            return;
        }

        if (cell.getRealContent().equals(characters.getCharacters()[10])) {
            cell.setVisibleContent(cell.getRealContent());

            for (Cell[] rows : gameField.getGameField()) {
                for (Cell el : rows) {
                    if (el.isMine()) {
                        el.setRealContent(characters.getCharacters()[10]);
                    }
                }
            }

            throw new BoomException("Вы взорвали себя.");
        } else if (!cell.getRealContent().equals(characters.getCharacters()[0])) {
            cell.setVisibleContent(cell.getRealContent());
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
                        Cell tempCell = gameField.getGameField()[i + tempLine][j + tempColumn];

                        if (!tempCell.getRealContent().equals(characters.getCharacters()[0]) || (i == 0 && j == 0)) {
                            tempCell.setVisibleContent(tempCell.getRealContent());
                            continue;
                        }
                        Integer[] tempArr = new Integer[]{i + tempLine, j + tempColumn};
                        boolean contains = false;

                        if (tempCell.getVisibleContent() != tempCell.getRealContent()) {
                            for (Integer[] tempArray : queue) {
                                if (Arrays.equals(tempArr, tempArray)) {
                                    contains = true;
                                    break;
                                }
                            }

                            if (!contains) {
                                queue.add(tempArr);
                            }
                        }
                    }
                }
            }
        }
    }

    private void wheelClickOnCell(int line, int column) {
        Cell checkCell = gameField.getGameField()[line][column];
        if (checkCell.getVisibleContent() != checkCell.getRealContent() ||
                checkCell.getRealContent().equals(characters.getCharacters()[0])) {
            return;
        }

        final boolean[] needExit = {false};

        gameField.getWalkAroundCell(line, column, cell -> {
            if (cell.isMine() && cell.getVisibleContent().equals(characters.getCharacters()[9])) {
                needExit[0] = true;
            }
        });

        if (needExit[0]) {
            return;
        }

        gameField.getWalkAroundCell(line, column, cell -> {
            if (cell.getRealContent() != characters.getCharacters()[10]) {
                cell.setVisibleContent(cell.getRealContent());
                if (cell.getRealContent().equals(characters.getCharacters()[0])) {
                    final Queue<Cell> queue = new LinkedList<>();
                    queue.add(cell);
                    while (!queue.isEmpty()) {
                        Cell cellFromQueue = queue.remove();
                        gameField.getWalkAroundCell(cellFromQueue.getLine(), cellFromQueue.getColumn(), tempCell -> {
                            if (tempCell.getRealContent() != characters.getCharacters()[10]) {
                                tempCell.setVisibleContent(tempCell.getRealContent());
                                if (tempCell.getRealContent().equals(characters.getCharacters()[0])) {
                                    queue.add(tempCell);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    /**
     * Ставит флажок и помечает миной это место.
     * При повторном нажатии ставит флажок.
     * Если количество флажков и мин совпадет будет выйгрешь.
     *
     * @param line   - линия на которую нажали.
     * @param column - колонка на которую нажали.
     */
    private void rightClickOnCell(int line, int column) {
        Cell cell = gameField.getGameField()[line][column];
        if (cell.getVisibleContent() == cell.getRealContent() &&
                !(cell.getRealContent().equals(characters.getCharacters()[11]) ||
                        cell.getRealContent().equals(characters.getCharacters()[12]))) {
            return;
        }

        if (cell.getVisibleContent().equals(characters.getCharacters()[11])) {
            cell.setVisibleContent(characters.getCharacters()[12]);
            getUpMinesCount(cell);
            return;
        }

        if (cell.getVisibleContent().equals(characters.getCharacters()[12])) {
            cell.setVisibleContent(characters.getCharacters()[9]);
            return;
        }

        cell.setVisibleContent(characters.getCharacters()[11]);
        getDownMinesCount(cell);
    }

    /**
     * Поднимает количество мин если были отмечен не правильный флажок.
     *
     * @param cell проверяймая ячейка
     */
    private void getUpMinesCount(Cell cell) {
        if (cell.isMine()) {
            gameField.setMinesCount(gameField.getMinesCount() + 1);
            this.printCountMine++;
        } else {
            this.printCountMine++;
        }
    }

    /**
     * Уменьшает количество мин когда ячейка отмечена флажком.
     *
     * @param cell проверяймая ячейка
     */
    private void getDownMinesCount(Cell cell) {
        if (cell.isMine()) {
            gameField.setMinesCount(gameField.getMinesCount() - 1);
            this.printCountMine--;
        } else {
            this.printCountMine--;
        }
    }
}