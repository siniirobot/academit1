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
    private String getFileName(Difficult.nameDifficult difficult) {
        String file = "Minesweeper/src/ru/academItSchool/gorbunov/Minesweeper/Model/HighScore/";
        //String file = "src/ru/academItSchool/gorbunov/Minesweeper/Model/HighScore/";
        switch (difficult) {
            case EASY:
                file += "Easy.txt";
                break;
            case NORM:
                file += "Norm.txt";
                break;
            case HARD:
                file += "Hard.txt";
                break;
            case RAND:
                throw new IllegalArgumentException("Нет таблицы рекордов для произвольной сложности.");
        }

        return file;
    }

    /**
     * Открывает файл с пмомщью полученого ранее имя файла для сериализацмм.
     *
     * @param path имя сложности игрока
     * @return поток с открытым файлом
     */
    private ObjectInputStream openFile(String path) throws IOException {
        return new ObjectInputStream(new FileInputStream(path));
    }

    /**
     * Закрывет файл с сериализуемым объектом
     *
     * @param path имя сложности игрока
     * @return поток с закрытием файла
     */
    private ObjectOutputStream closeFile(String path) throws IOException {
        return new ObjectOutputStream(new FileOutputStream(path));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Печатает таблицу рекордов определенной сложности.
     *
     * @param difficult сложность.
     */
    public void printHighScores(Difficult.nameDifficult difficult) {
        String fileName = getFileName(difficult);

        try {
            ObjectInputStream readFile = openFile(fileName);
            Player[] highScores = (Player[]) readFile.readObject();
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Сложность - ").append(difficult.toString()).append(System.lineSeparator());
            stringBuilder.append("   №: ").append("   Имя:   ").append("Время:    ").append(System.lineSeparator());
            StringBuilder line = new StringBuilder("||=====================||" + System.lineSeparator());
            stringBuilder.append(line);
            for (int i = 0; i < highScores.length; i++) {
                if (highScores[i] != null) {
                    stringBuilder
                            .append(String.format("||%2d %10s %7d||", i + 1, highScores[i].getName(), highScores[i].getTime()))
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
