package ru.academItSchool.gorbunov.Minesweeper.Model.HighScore;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;

import java.io.*;

import static ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult.nameDifficult.*;

public class HighScores implements Serializable {

    private String getFileName(Difficult.nameDifficult difficult) {
        String file = "";

        switch (difficult) {
            case EASY:
                file = "Easy.txt";
                break;
            case NORM:
                file = "Norm.txt";
                break;
            case HARD:
                file = "Hard.txt";
                break;
        }

        return file;
    }

    private ObjectInputStream openFile(String difficult) throws IOException {
        return new ObjectInputStream(new FileInputStream(difficult));
    }

    private ObjectOutputStream closeFile(String difficult) throws IOException {
        return new ObjectOutputStream(new FileOutputStream(difficult));
    }

    public void add(Player player) {
        Player[] highScores = new Player[10];
        String fileName = getFileName(player.getDifficult());

        try {
            ObjectInputStream readFile = openFile(fileName);
            highScores = (Player[]) readFile.readObject();

            if (highScores[9] != null && highScores[9].getTime() < player.getTime()) {
                throw new IllegalArgumentException("Вы не смогли войти в таблицу рекордов.");
            }

            for (int i = highScores.length - 1; i > 0; i--) {
                if (highScores[i - 1] == null) {
                    continue;
                }

                if (highScores[i - 1].getTime() > (player.getTime())) {
                    highScores[i] = highScores[i - 1];
                    highScores[i - 1] = player;
                } else {
                    highScores[i] = player;
                    break;
                }
            }
        } catch (IOException e) {
            highScores[0] = player;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObjectOutputStream writeFile = closeFile(fileName);
            writeFile.writeObject(highScores);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printHighScores(Difficult difficult) {
        String fileName = getFileName(difficult.getName());

        try {
            ObjectInputStream readFile = openFile(fileName);
            Player[] highScores = (Player[]) readFile.readObject();
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Сложность - ").append(difficult.getName().toString()).append(System.lineSeparator());
            stringBuilder.append("    Имя:    ").append("    Время:    ").append(System.lineSeparator());
            stringBuilder.append("///////////////////////////////////////////").append(System.lineSeparator());
            for (int i = 0; i < highScores.length; i++) {
                if (highScores[i] != null) {
                    stringBuilder.append("// ").append(i + 1).append(" - ").append(highScores[i].getName()).append("    ")
                            .append(highScores[i].getTime()).append(" //").append(System.lineSeparator());
                }
            }
            stringBuilder.append("///////////////////////////////////////////").append(System.lineSeparator());
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Таблица еще пуста.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
