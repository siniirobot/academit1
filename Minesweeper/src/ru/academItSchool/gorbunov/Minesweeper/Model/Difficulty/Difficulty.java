package ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty;

import java.io.Serializable;

public interface Difficulty extends Serializable {
    enum DifficultyName {
        EASY("Легкая"),
        NORM("Нормальная"),
        HARD("Высокая"),
        RAND("Произвольная");

        private String name;

        DifficultyName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    int getColumnsCount();

    int getLineCount();

    int getMines();

    DifficultyName getName();
}
