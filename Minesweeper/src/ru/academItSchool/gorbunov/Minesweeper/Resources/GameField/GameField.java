package ru.academItSchool.gorbunov.Minesweeper.Resources.GameField;

import java.util.Arrays;

public class GameField {
    private Cell[][] gameField;
    private int mineCount;

    public GameField(int height, int width, int mineCount) {
        this.gameField = new Cell[height][width];
        this.mineCount = mineCount;
    }

    public GameField(int height, int width, int mineCount, Cell[][] matrixWithMine) {
        this.gameField = matrixWithMine;
        this.mineCount = mineCount;
    }

    public Cell[][] getGameField() {
        return gameField;
    }

    public void setGameField(Cell[][] gameField) {
        this.gameField = gameField;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public void fillMinesInField() {
        int i = this.mineCount;
        while (i != 0) {
            for (int j = 0; i != 0; j = (int) (Math.random() * this.gameField.length - 1)) {
                int randomPlace = (int) (Math.random() * this.gameField[j].length - 1);

                if (this.gameField[j][randomPlace] != null) {
                    continue;
                }

                this.gameField[j][randomPlace] = new Cell('\u0489',new int[]{j,randomPlace});
                i--;
            }
        }
    }

    public void fillNumbersInField() {
        for (int i = 0; i < this.gameField.length; i++) {
            for (int j = 0; j < this.gameField[i].length; j++) {
                if (this.gameField[i][j] != null) {
                    continue;
                }

                int number = 0;

                for (int k = -1; k <= 1; k++) {
                    if (i + k < 0) {
                        k++;
                    }
                    if (i + k == this.gameField.length) {
                        continue;
                    }
                    for (int m = -1; m <= 1; m++) {
                        if (j + m < 0) {
                            m++;
                        }

                        if (j + m == this.gameField[i].length) {
                            continue;
                        }
                        if (this.gameField[i + k][j + m] != null && this.gameField[i + k][j + m].getCharacter().equals('\u0489')) {
                            number++;
                        }
                    }
                }
                if (number == 0) {
                    this.gameField[i][j] = new Cell('\u0020',new int[] {i,j});
                } else {
                    this.gameField[i][j] = new Cell(Character.forDigit(number, 10),new int[]{i,j});
                }
            }
        }
    }

    @Override
    public String toString() {
        boolean prodaction = false;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder line = new StringBuilder();
        StringBuilder space = new StringBuilder("   ");

        stringBuilder.append(space).append(" |");

        for (int i = 1; i <= this.gameField.length; i++) {
            stringBuilder.append(String.format("%2d|",i));
        }

        stringBuilder.append(System.lineSeparator());

        for (int i = 0; i < this.gameField.length * 3 + 6; i++) {
            line.append("-");
        }

        line.append(System.lineSeparator());
        stringBuilder.append(line);

        for (int i = 0; i < this.gameField.length; i++) {
            stringBuilder.append(space).append(String.format("%2d|",i + 1));

            for (int j = 0; j < this.gameField[i].length; j++) {
                if (prodaction) {
                    stringBuilder.append(String.format("%2s|",this.gameField[i][j]));
                } else {
                    if (this.gameField[i][j].isVisible()) {
                        stringBuilder.append(this.gameField[i][j]).append("|");
                    } else {
                        stringBuilder.append(" ").append("| ");
                    }
                }
            }

            stringBuilder.append(System.lineSeparator());
        }

        stringBuilder.append(line);

        return stringBuilder.toString();
    }
}
