package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import java.io.Serializable;

public interface Difficult extends Serializable {
    enum DifficultName {
        EASY("Легкая"),
        NORM("Нормальная"),
        HARD("Высокая"),
        RAND("Произвольная");

        private String name;

        DifficultName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    int getColumnCount();

    int getLineCount();

    int getMines();

    DifficultName getName();
}
