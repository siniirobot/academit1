package ru.academItSchool.gorbunov.Minesweeper.Model.HighScore;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {
    private String name;
    private int time;
    private String difficult;

    public Player(String name, int time, String difficult) {
        this.name = name;
        this.time = time;
        this.difficult = difficult;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
