package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

public class Random implements Difficult {
    private Difficult.nameDifficult name;
    private int columns;
    private int rows;
    private int mines;

    public Random(int rows, int columns, int mines) {
        if (rows < 9 || rows > 24) {
            throw new IllegalArgumentException("Высота игрового поля должна быть не меньше 9 строк и не больше 24.");
        }

        if (columns < 9 || columns > 30) {
            throw new IllegalArgumentException("Ширина игрового поля должна быть не меньше 9 колонок и не больше 30.");
        }

        if (mines < 1 || mines > ((rows * columns) * 75) / 100) {
            throw new IllegalArgumentException("Колличество мин должно быть в пределах от 10 до 540");
        }

        this.name = Difficult.nameDifficult.RAND;
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
    public Difficult.nameDifficult getName() {
        return this.name;
    }
}
