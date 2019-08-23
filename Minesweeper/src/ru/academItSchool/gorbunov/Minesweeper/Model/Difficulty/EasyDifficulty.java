package ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty;

public class EasyDifficulty implements Difficulty {
    private DifficultyName name;
    private int columns;
    private int rows;
    private int mines;

    public EasyDifficulty() {
        this.name = DifficultyName.EASY;
        this.columns = 9;
        this.rows = 9;
        this.mines = 10;
    }

    @Override
    public int getColumnsCount() {
        return columns;
    }

    @Override
    public int getLinesCount() {
        return rows;
    }

    @Override
    public int getMines() {
        return mines;
    }

    @Override
    public DifficultyName getName() {
        return this.name;
    }
}
