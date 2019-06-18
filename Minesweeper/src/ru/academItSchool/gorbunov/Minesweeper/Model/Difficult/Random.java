package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

public class Random implements Difficult {
    private Difficult.nameDifficult name;
    private GameField gameField;

    public Random(int height, int width, int mineCount, Characters characters) {
        if (height < 9 || height > 24) {
            throw new IllegalArgumentException("Высота игрового поля должна быть не меньше 9 строк и не больше 24.");
        }

        if (width < 9 || width > 30) {
            throw new IllegalArgumentException("Ширина игрового поля должна быть не меньше 9 колонок и не больше 30.");
        }

        if (mineCount < 10 || mineCount > ((height * width) * 85) / 100) {
            throw new IllegalArgumentException("Колличество мин должно быть в пределах от 1 до 688");
        }

        this.name = Difficult.nameDifficult.RAND;
        this.gameField = new GameField(height, width, mineCount, characters);
        this.gameField.fillMinesInField();
        this.gameField.fillNumbersInField();
    }

    @Override
    public Difficult.nameDifficult getName() {
        return this.name;
    }

    @Override
    public GameField getGameField() {
        return gameField;
    }
}
