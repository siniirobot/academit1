package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class Easy implements Difficult {
    private nameDifficult name;
    private int columns;
    private int rows;
    private int mines;

    public Easy() {
        this.name = nameDifficult.EASY;
        this.columns = 9;
        this.rows = 9;
        this.mines = 10;
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
    public nameDifficult getName() {
        return this.name;
    }
}
