package ru.academItSchool.gorbunov.Minesweeper.Model.GameField;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty.Difficulty;
import ru.academItSchool.gorbunov.Minesweeper.View.Cell;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

import java.util.Random;
import java.util.function.Consumer;

public class GameField {
    private Cell[][] gameField;
    private int mineCount;
    private Characters characters;
    private Difficulty difficulty;

    /**
     * Создание игрового поля по параметрам:
     *
     * @param difficulty сложность игры
     * @param characters - Используемый набор символов для отображения.
     */
    public GameField(Difficulty difficulty, Characters characters) {
        this.difficulty = difficulty;
        this.gameField = new Cell[difficulty.getLineCount()][difficulty.getColumnsCount()];
        this.mineCount = difficulty.getMines();
        this.characters = characters;
        fillMinesInField();
        fillNumbersInField();
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Characters getCharacters() {
        return characters;
    }

    public Cell[][] getGameField() {
        return gameField;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    /**
     * Заполнение игрового поля минами.
     */
    private void fillMinesInField() {
        Random rnd = new Random(System.currentTimeMillis());
        int i = this.mineCount;
        while (i != 0) {
            for (int j = 0; i != 0; j = rnd.nextInt(this.gameField.length)) {
                int randomPlace = rnd.nextInt(this.gameField[j].length);

                if (this.gameField[j][randomPlace] != null) {
                    continue;
                }

                this.gameField[j][randomPlace] = new Cell(this.characters.getCharacters()[10]);
                this.gameField[j][randomPlace].setMine();
                i--;
            }
        }
    }

    /**
     * Заполнение поля цифрами в зависимости от колличества мин.
     */
    private void fillNumbersInField() {
        for (int i = 0; i < this.gameField.length; i++) {
            for (int j = 0; j < this.gameField[i].length; j++) {
                if (this.gameField[i][j] != null) {
                    continue;
                }
                final int[] number = new int[]{0};

                getWalkAroundCell(i, j, cell -> {
                    if (cell.isMine()) {
                        number[0]++;
                    }
                });
                this.gameField[i][j] = new Cell(this.characters.getCharacters()[number[0]]);
            }
        }
    }

    /**
     * Выполняет обход вокруг клетки и выполняет действие с каждой клеткой через Consumer
     *
     * @param line     int линия
     * @param column   int колонка
     * @param consumer Consumer действие
     */
    public void getWalkAroundCell(int line, int column, Consumer<Cell> consumer) {
        for (int k = -1; k <= 1; k++) {
            if (line + k < 0) {
                k++;
            }
            if (line + k == gameField.length) {
                continue;
            }
            for (int m = -1; m <= 1; m++) {
                if (column + m < 0) {
                    m++;
                }

                if (column + m == this.gameField[line].length) {
                    continue;
                }

                if (this.gameField[line + k][column + m] == null || this.gameField[line + k][column + m].isVisible()) {
                    continue;
                }

                consumer.accept(this.gameField[line + k][column + m]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder line = new StringBuilder();
        StringBuilder space = new StringBuilder("   ");

        stringBuilder.append(space).append("  |");

        for (int i = 1; i <= this.gameField[0].length; i++) {
            stringBuilder.append(String.format("%2d|", i));
        }

        stringBuilder.append(System.lineSeparator());

        for (int i = 0; i < this.gameField[0].length * 3 + 6; i++) {
            line.append("-");
        }

        line.append(System.lineSeparator());
        stringBuilder.append(line);

        for (int i = 0; i < this.gameField.length; i++) {
            stringBuilder.append(space).append(String.format("%2d|", i + 1));

            for (int j = 0; j < this.gameField[i].length; j++) {
                if (this.gameField[i][j].isVisible()) {
                    stringBuilder.append(String.format("%2s|", this.gameField[i][j].getContent()));
                } else {
                    stringBuilder.append(String.format("%2s|", characters.getCharacters()[9]));
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(line);

        return stringBuilder.toString();
    }
}
