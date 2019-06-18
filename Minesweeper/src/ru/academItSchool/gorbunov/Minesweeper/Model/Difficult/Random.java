package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

public class Random implements Difficult {
    private Difficult.nameDifficult name;
    private GameField gameField;

    public Random(int height, int width, int mineCount, Characters characters) {
        if (height < 4 || height > 24) {
            throw new IllegalArgumentException("Высота игрового поля должна быть не меньше 4 строк и не больше 24.");
        }

        if (width < 4 || width > 30) {
            throw new IllegalArgumentException("Ширина игрового поля должна быть не меньше 4 колонок и не больше 30.");
        }

        if (mineCount < 1 || mineCount > 688) {
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
