package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;

public class Hard implements Difficult {
    private nameDifficult name;
    private GameField gameField;

    public Hard(Characters characters) {
        this.name = nameDifficult.HARD;
        this.gameField = new GameField(16, 30, 99, characters);
        this.gameField.fillMinesInField();
        this.gameField.fillNumbersInField();
    }

    @Override
    public nameDifficult getName() {
        return this.name;
    }

    @Override
    public GameField getGameField() {
        return gameField;
    }
}

