package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class EasyDifficult implements Difficult {
    private DifficultName name;
    private int columns;
    private int rows;
    private int mines;

    public EasyDifficult() {
        this.name = DifficultName.EASY;
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
    public DifficultName getName() {
        return this.name;
    }
}
