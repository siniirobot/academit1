package ru.academItSchool.gorbunov.Minesweeper.Model.HighScore;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;

import java.io.*;

public class HighScores implements Serializable {
    /**
     * Преобразует имя сложности в имя файла.
     *
     * @param difficult сложность игрока
     * @return имя файла
     */
    public String getFileName(Difficult.DifficultName difficult) {
        String file = "Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper/Model/HighScore/";
        //String file = "src/ru/academItSchool/gorbunov/Minesweeper/Model/HighScore/";
        switch (difficult) {
            case EASY:
                file += "EasyDifficult.txt";
                break;
            case NORM:
                file += "NormDifficult.txt";
                break;
            case HARD:
                file += "HardDifficult.txt";
                break;
            case RAND:
                throw new IllegalArgumentException("Нет таблицы рекордов для произвольной сложности.");
        }

        return file;
    }

    /**
     * Открывает файл ,десириализует объект из потока(В случае отсутсвия файла создает его и записывает игрока
     * первым в таблице.) Если добавляемый игрок по времени окозался хуже чем остальные игроки то выдается исключение
     * IllegalArgumentException, в противном случае идет перебор игроков до тех пор пока результат игрока не займет
     * свое место. После чего объект сериализуется и записывается заново.
     *
     * @param player Игрок
     */
    public void add(Player player) {
        Player[] highScores = new Player[10];
        String fileName = getFileName(player.getDifficult());

        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(fileName));
            highScores = (Player[]) readFile.readObject();

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
            ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(fileName));
            writeFile.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Проверяет возможность ввода игрока в таблицу, если не подходт выбрасывает исключение.
     *
     * @param time      время игры для сравнения с худшим результатом
     * @param difficult сложность игры в которой надо провести проверку
     */
    public void confirmTime(int time, Difficult difficult) {
        try {
            String fileName = getFileName(difficult.getName());
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(fileName));
            Player[] highScores = (Player[]) readFile.readObject();

            if (highScores[9] != null && highScores[9].getTime() < time) {
                throw new IllegalArgumentException("Вы не смогли войти в таблицу рекордов.");
            }
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }

    /**
     * Печатает таблицу рекордов определенной сложности.
     *
     * @param difficult сложность.
     */
    public void printHighScores(Difficult.DifficultName difficult) {
        String fileName = getFileName(difficult);

        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(fileName));
            Player[] highScores = (Player[]) readFile.readObject();
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Сложность - ").append(difficult.toString()).append(System.lineSeparator());
            stringBuilder.append("   №: ").append("   Имя:   ").append("Время:    ").append(System.lineSeparator());
            StringBuilder line = new StringBuilder("||======================||" + System.lineSeparator());
            stringBuilder.append(line);
            for (int i = 0; i < highScores.length; i++) {
                if (highScores[i] != null) {
                    stringBuilder
                            .append(String.format("||%2d %10s %8d||", i + 1, highScores[i].getName(), highScores[i].getTime()))
                            .append(System.lineSeparator());
                }
            }
            stringBuilder.append(line);
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Таблица еще пуста.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
