package ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty;

public class HardDifficulty implements Difficulty {
    private DifficultyName name;
    private int columns;
    private int rows;
    private int mines;

    public HardDifficulty() {
        this.name = DifficultyName.HARD;
        this.columns = 24;
        this.rows = 24;
        this.mines = 99;
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

