package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class Norm implements Difficult {
    private nameDifficult name;
    private int columns;
    private int rows;
    private int mines;

    public Norm() {
        this.name = nameDifficult.NORM;
        this.columns = 16;
        this.rows = 16;
        this.mines = 1;
    }

    @Override
    public int getColumnCount() {
        return columns;
    }

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getMines() {
        return mines;
    }

    @Override
    public nameDifficult getName() {
        return this.name;
    }
}
