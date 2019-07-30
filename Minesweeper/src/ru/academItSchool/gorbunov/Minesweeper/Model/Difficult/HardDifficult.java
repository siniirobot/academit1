package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class HardDifficult implements Difficult {
    private DifficultName name;
    private int columns;
    private int rows;
    private int mines;

    public HardDifficult() {
        this.name = DifficultName.HARD;
        this.columns = 24;
        this.rows = 24;
        this.mines = 99;
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

