package ru.academItSchool.gorbunov.Minesweeper.Model.GameField;

import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Cell;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

public class GameField {
    private Cell[][] gameField;
    private int mineCount;
    private Characters characters;

    /**
     * Создание игрового поля по параметрам:
     * @param height - количество строк,
     * @param width - колличесвто колонок,
     * @param mineCount -колличество мин,
     * @param characters - Используемый набор символов для отображения.
     */
    public GameField(int height, int width, int mineCount, Characters characters) {
        this.gameField = new Cell[height][width];
        this.mineCount = mineCount;
        this.characters = characters;
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
    public void fillMinesInField() {
        int i = this.mineCount;
        while (i != 0) {
            for (int j = 0; i != 0; j = (int) (Math.random() * this.gameField.length - 1)) {
                int randomPlace = (int) (Math.random() * this.gameField[j].length - 1);

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
    public void fillNumbersInField() {
        for (int i = 0; i < this.gameField.length; i++) {
            for (int j = 0; j < this.gameField[i].length; j++) {
                if (this.gameField[i][j] != null) {
                    continue;
                }
                getCountMineInArea(i, j);
            }
        }
    }

    /**
     * Вычислить колличество вокруг данного квадрата.
     * @param line координата
     * @param column координата
     */
    public void getCountMineInArea(int line, int column) {
        if (this.gameField[line][column] != null && this.gameField[line][column].isMine()) {
            this.gameField[line][column].setContent(this.characters.getCharacters()[10]);
            return;
        }

        int number = 0;

        for (int k = -1; k <= 1; k++) {
            if (line + k < 0) {
                k++;
            }
            if (line + k == this.gameField.length) {
                continue;
            }
            for (int m = -1; m <= 1; m++) {
                if (column + m < 0) {
                    m++;
                }

                if (column + m == this.gameField[line].length) {
                    continue;
                }

                if (this.gameField[line + k][column + m] != null && this.gameField[line + k][column + m].isMine()) {
                    number++;
                }
            }
        }
        this.gameField[line][column] = new Cell(this.characters.getCharacters()[number]);
    }

    @Override
    public String toString() {
        boolean prodaction = false;
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
                if (prodaction) {
                    stringBuilder.append(String.format("%2s|", this.gameField[i][j].getContent()));
                } else {
                    if (this.gameField[i][j].isVisible()) {
                        stringBuilder.append(String.format("%2s|", this.gameField[i][j].getContent()));
                    } else {
                        stringBuilder.append(String.format("%2s|", characters.getCharacters()[9]));
                    }
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(line);

        return stringBuilder.toString();
    }
}
