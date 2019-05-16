package ru.academItSchool.gorbunov.Minesweeper.Resources;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;

public class HighScores {
    private Player[] highScores;
    private PlayerCompare playerCompare;


    public HighScores(Player[] highScores) throws FileNotFoundException {
        this.highScores = highScores;
        this.playerCompare = new PlayerCompare();
    }

    public Player[] getHighScores() {
        return highScores;
    }

    public void setHighScores(Player[] highScores) {
        this.highScores = highScores;
    }

    public PlayerCompare getPlayerCompare() {
        return playerCompare;
    }

    public void setPlayerCompare(PlayerCompare playerCompare) {
        this.playerCompare = playerCompare;
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
        String file = "";

        switch (player.getDifficult()) {
            case "easy":
                file = "Easy.txt";
                break;
            case "norm":
                file = "Norm.txt";
                break;
            case "hard":
                file = "Hard.txt";
                break;
        }

        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out = new FileOutputStream(file)) {
            int read = 0;
            while ((read = in.read()) != -1) {
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner in = new Scanner(new FileInputStream(file));
             PrintWriter out = new PrintWriter(file)) {
            if (!in.hasNextLine()) {
                out.println("Имя 1 игрока - " + player.getName());
                out.println("Время 1 игрока - " + player.getTime());
            } else {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    for (int i = 1; i != 10; i++) {

                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
