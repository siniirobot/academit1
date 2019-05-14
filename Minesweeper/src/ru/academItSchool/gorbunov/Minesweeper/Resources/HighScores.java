package ru.academItSchool.gorbunov.Minesweeper.Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;

public class HighScores {
    Player[] highScores;
    PlayerCompare playerCompare = new PlayerCompare();
    FileInputStream easyIn = new FileInputStream("Easy.txt");
    PrintWriter easyOut = new PrintWriter("Easy.txt");

    public HighScores() throws FileNotFoundException {
        this.highScores = new Player[10];
    }

    public class PlayerCompare implements Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            return (o1.getTime().after(o2.getTime())) ? 1 : 0;
        }
    }

    public void add(Player player) {

    }
}
