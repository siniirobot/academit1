package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class NormDifficult implements Difficult {
    private DifficultName name;
    private int columns;
    private int rows;
    private int mines;

    public NormDifficult() {
        this.name = DifficultName.NORM;
        this.columns = 16;
        this.rows = 16;
        this.mines = 40;
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
