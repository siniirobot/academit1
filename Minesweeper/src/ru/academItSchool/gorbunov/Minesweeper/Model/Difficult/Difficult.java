package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;

import java.io.Serializable;

public interface Difficult extends Serializable {
    enum nameDifficult {
        EASY,
        NORM,
        HARD,
        RAND;

        @Override
        public String toString() {
            if (super.equals(EASY)) {
                return "Легкая";
            } else if (super.equals(NORM)) {
                return "Нормальноя";
            } else if (super.equals(HARD)){
                return "Высокая";
            }else {
                return "Произвольная";
            }
        }
    }
    int getColumnCount();

    int getRowCount();

    int getMines();

    nameDifficult getName();
}
