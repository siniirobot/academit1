package ru.academItSchool.gorbunov.Minesweeper.Model.HighScore;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {
    private String name;
    private int time;
    private Difficult.nameDifficult difficult;

    /**
     * Конструктор по созданию игрока который определяет его имя, время игры, сложность.
     *
     * @param name      Имя игрока
     * @param time      Время игры игрока
     * @param difficult Сложность для игры
     */
    public Player(String name, int time, Difficult.nameDifficult difficult) {
        if (name.length() > 10) {
            throw new IllegalArgumentException("Введите имя Игрока длиной не больше 10 символов.");
        }
        this.name = name;
        this.time = time;
        this.difficult = difficult;
    }

    public Difficult.nameDifficult getDifficult() {
        return difficult;
    }


    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;

        return Objects.equals(name, player.name) &&
                Objects.equals(time, player.time) &&
                Objects.equals(difficult, player.difficult);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.name.hashCode();
        result = prime * result + this.time;
        result = prime * result + this.difficult.hashCode();
        return result;
    }
}
