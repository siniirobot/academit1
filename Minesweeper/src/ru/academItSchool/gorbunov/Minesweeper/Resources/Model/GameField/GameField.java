package ru.academItSchool.gorbunov.Minesweeper.Resources.Model.GameField;

import ru.academItSchool.gorbunov.Minesweeper.Resources.Characters.Cell;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Characters.Characters;

public class GameField {
    private Cell[][] gameField;
    private int mineCount;
    private Characters characters = new Characters();

    public GameField(int height, int width, int mineCount) {
        this.gameField = new Cell[height][width];
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

                this.gameField[j][randomPlace] = this.characters.getCell()[10];
                i--;
            }
        }
    }

    public void fillNumbersInField() {
        Characters characters = new Characters();
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
                        if (this.gameField[i + k][j + m] != null &&
                                this.gameField[i + k][j + m].getChar() == characters.getCell()[10].getChar()) {
                            number++;
                        }
                    }
                }
                this.gameField[i][j] = this.characters.getCell()[number];
            }
        }
    }

    @Override
    public String toString() {
        Characters characters = new Characters();
        boolean prodaction = true;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder line = new StringBuilder();
        StringBuilder space = new StringBuilder("   ");

        stringBuilder.append(space).append(" |");

        for (int i = 1; i <= this.gameField.length; i++) {
            stringBuilder.append(String.format("%2d|", i));
        }

        stringBuilder.append(System.lineSeparator());

        for (int i = 0; i < this.gameField.length * 3 + 6; i++) {
            line.append("-");
        }

        line.append(System.lineSeparator());
        stringBuilder.append(line);

        for (int i = 0; i < this.gameField.length; i++) {
            stringBuilder.append(space).append(String.format("%2d|", i + 1));

            for (int j = 0; j < this.gameField[i].length; j++) {
                if (prodaction) {
                    stringBuilder.append(String.format("%2s|", this.gameField[i][j].getChar()));
                } else {
                    if (this.gameField[i][j].isVisible()) {
                        stringBuilder.append(String.format("%2s|", this.gameField[i][j].getChar()));
                    } else {
                        stringBuilder.append(String.format("%2s|",characters.getCell()[9].getChar()));
                    }
                }
            }

            stringBuilder.append(System.lineSeparator());
        }

        stringBuilder.append(line);

        return stringBuilder.toString();
    }
}
