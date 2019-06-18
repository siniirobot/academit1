package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;

import java.io.Serializable;

public interface Difficult extends Serializable {
    enum nameDifficult {
        EASY,
        NORM,
        HARD;

        @Override
        public String toString() {
            if (super.equals(EASY)) {
                return "Легко";
            } else if (super.equals(NORM)) {
                return "Нормально";
            } else {
                return "Тяжело";
            }
        }
    }

    nameDifficult getName();

    GameField getGameField();
}
