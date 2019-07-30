package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import java.io.Serializable;

public interface Difficult extends Serializable {
    enum DifficultName {
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
            } else if (super.equals(HARD)) {
                return "Высокая";
            } else {
                return "Произвольная";
            }
        }
    }

    int getColumnCount();

    int getLineCount();

    int getMines();

    DifficultName getName();
}
