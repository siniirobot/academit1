package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class Hard implements Difficult {
    private nameDifficult name;
    private int columns;
    private int rows;
    private int mines;

    public Hard() {
        this.name = nameDifficult.HARD;
        this.columns = 24;
        this.rows = 24;
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

