package ru.academItSchool.gorbunov.Minesweeper.Resources;

import java.io.*;
import java.util.Comparator;

public class HighScores {
    private Player[] highScores;
    private PlayerCompare playerCompare;
    private BufferedInputStream easyIn;
    private BufferedOutputStream easyOut;
    private BufferedInputStream normIn;
    private BufferedOutputStream normOut;
    private BufferedInputStream hardIn;
    private BufferedOutputStream hardOut;

    public HighScores(Player[] highScores) throws FileNotFoundException {
        this.highScores = highScores;
        this.playerCompare = new PlayerCompare();
        this.easyIn = new BufferedInputStream(new FileInputStream("Easy.txt"));
        this.easyOut = new BufferedOutputStream(new FileOutputStream("Easy.txt"));
        this.normIn = new BufferedInputStream(new FileInputStream("Norm.txt"));
        this.normOut = new BufferedOutputStream(new FileOutputStream("Norm.txt"));
        this.hardIn = new BufferedInputStream(new FileInputStream("Hard.txt"));
        this.hardOut = new BufferedOutputStream(new FileOutputStream("Hard.txt"));
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

    public BufferedInputStream getEasyIn() {
        return easyIn;
    }

    public void setEasyIn(BufferedInputStream easyIn) {
        this.easyIn = easyIn;
    }

    public BufferedOutputStream getEasyOut() {
        return easyOut;
    }

    public void setEasyOut(BufferedOutputStream easyOut) {
        this.easyOut = easyOut;
    }

    public BufferedInputStream getNormIn() {
        return normIn;
    }

    public void setNormIn(BufferedInputStream normIn) {
        this.normIn = normIn;
    }

    public BufferedOutputStream getNormOut() {
        return normOut;
    }

    public void setNormOut(BufferedOutputStream normOut) {
        this.normOut = normOut;
    }

    public BufferedInputStream getHardIn() {
        return hardIn;
    }

    public void setHardIn(BufferedInputStream hardIn) {
        this.hardIn = hardIn;
    }

    public BufferedOutputStream getHardOut() {
        return hardOut;
    }

    public void setHardOut(BufferedOutputStream hardOut) {
        this.hardOut = hardOut;
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
            byte[] players = new byte[10];

            if (in.available() == 0) {
                out.write((byte[]) players);
            }
            int read;
            byte[] res = new byte[in.available()];
            while ((read = in.read(res, 0, res.length)) != -1) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
