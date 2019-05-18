package ru.academItSchool.gorbunov.Minesweeper.Resources;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class HighScores {
    private Player[] highScores;


    public HighScores() {
        this.highScores = new Player[10];
    }

    public Player[] getHighScores() {
        return highScores;
    }

    public void setHighScores(Player[] highScores) {
        this.highScores = highScores;
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

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            if (in.available() == 0) {
                this.highScores[0] = player;
                out.writeObject(this.highScores);
            } else {
                this.highScores = (Player[]) in.readObject();

                if (this.highScores[9] != null && this.highScores[9].getTime().before(player.getTime())) {
                    throw new IllegalArgumentException("Вы не смогли войти в таблицу рекордов.");
                }

                Player exPlayer = null;

                for (int i = this.highScores.length - 1; i >= 0; i--) {
                    if (this.highScores[i] == null) {
                        continue;
                    }

                    if (this.highScores[i].getTime().after(player.getTime())) {
                        this.highScores[i] = exPlayer;
                        exPlayer = this.highScores[i--];
                    } else {
                        this.highScores[i] = player;
                    }
                }
            }

            out.writeObject(this.highScores);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.highScores[0].getDifficult()).append(System.lineSeparator());
        stringBuilder.append("    Имя:    ").append("    Время:    ").append(System.lineSeparator());
        stringBuilder.append("///////////////////////////////////////////").append(System.lineSeparator());
        for (Player player:this.highScores) {
            if (player != null) {
                stringBuilder.append("/ ").append(player.getName()).append("    ").append(player.getTime()).append(" /").append(System.lineSeparator());
            }
        }
        stringBuilder.append("///////////////////////////////////////////").append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
