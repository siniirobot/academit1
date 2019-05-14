package ru.academItSchool.gorbunov.Minesweeper.Resources;

import java.util.Comparator;

public class HighScores {
    Player[] highScores;

    public HighScores() {
        this.highScores =new Player[10];
    }

    public class PlayerCompare implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            if (o1.equals(o2)) {
                return 0;
            }

            if (o1.getDifficult().equals(o2.getDifficult())) {

            }
        }
    }
    public void add(Player player) {

    }
}
