package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;

import java.io.Serializable;

public interface Difficult extends Serializable {
    enum nameDifficult {
        EASY,
        NORM,
        HARD
    }
    nameDifficult getName();

    GameField getGameField();
}
