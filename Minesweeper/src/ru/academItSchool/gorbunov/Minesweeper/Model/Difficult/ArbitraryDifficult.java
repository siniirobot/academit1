package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class ArbitraryDifficult implements Difficult {
    private DifficultName name;
    private int columns;
    private int rows;
    private int mines;

    public ArbitraryDifficult(int rows, int columns, int mines) {
        if (rows < 9 || rows > 24) {
            throw new IllegalArgumentException("Высота игрового поля должна быть не меньше 9 строк и не больше 24.");
        }

        if (columns < 9 || columns > 30) {
            throw new IllegalArgumentException("Ширина игрового поля должна быть не меньше 9 колонок и не больше 30.");
        }

        int maxMines = ((rows * columns) * 75) / 100;
        if (mines < 10 || mines > maxMines) {
            throw new IllegalArgumentException("Колличество мин должно быть в пределах от 10 до " + maxMines);
        }

        this.name = DifficultName.RAND;
        this.columns = columns;
        this.rows = rows;
        this.mines = mines;
    }

    @Override
    public int getColumnCount() {
        return columns;
    }

    @Override
    public int getLineCount() {
        return rows;
    }

    @Override
    public int getMines() {
        return mines;
    }

    @Override
    public DifficultName getName() {
        return this.name;
    }
}
