package ru.academItSchool.gorbunov.Minesweeper.Resources.GameField;

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

    /*
    "\uD83D\uDEA9" - флажок
     */

    public void fillMinesInField() {
        int i = this.mineCount;
        while (i != 0) {
            for (int j = 0; i != 0; j = (int) (Math.random() * this.gameField.length - 1)) {
                int randomPlace = (int) (Math.random() * this.gameField[j].length - 1);

                if (this.gameField[j][randomPlace] != null) {
                    continue;
                }

                this.gameField[j][randomPlace] = new Cell('\uD83D');
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
                        if (this.gameField[i + k][j + m] != null && this.gameField[i + k][j + m].getCharacter().equals('\uD83D')) {
                            number++;
                        }
                    }
                }
                if (number == 0) {
                    this.gameField[i][j] = new Cell(' ');
                } else {
                    this.gameField[i][j] = new Cell(Character.forDigit(number, 10));
                }
            }
        }
    }
}
