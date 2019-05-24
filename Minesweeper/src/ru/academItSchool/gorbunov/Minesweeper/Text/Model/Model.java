package ru.academItSchool.gorbunov.Minesweeper.Text.Model;

import ru.academItSchool.gorbunov.Minesweeper.Resources.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Resources.GameField.Cell;
import ru.academItSchool.gorbunov.Minesweeper.Resources.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Text.Model.Exceptions.Boom;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Model {

    public void tryGame() {
        Easy easy = new Easy();
        System.out.println(easy.getGameField());

        Scanner scanner = new Scanner(System.in);


        while (true) {
            int line = scanner.nextInt();
            int column = scanner.nextInt();
            String command = scanner.next();
            try {
                clickMove(command, easy.getGameField(), line, column);
            } catch (Boom e) {
                System.out.println(e);
            }
            System.out.println(easy.getGameField());
        }


    }

    public void clickMove(String command, GameField gameField, int line, int column) throws Boom {
        switch (command) {
            case "1":
                leftClickOnCell(gameField, line, column);
                break;
            case "2":
                rightClickOnCell(gameField, line, column);
        }
    }

    private void leftClickOnCell(GameField gameField, int line, int column) throws Boom {
        Cell cell = gameField.getGameField()[line][column];
        if (cell.isVisible()) {
            return;
        }

        if (cell.getCharacter().equals('\u0489')) {
            cell.setVisible(true);
            throw new Boom("Поздравляю вы взорвали себя!");
        } else if (!cell.getCharacter().equals('\u0020')) {
            cell.setVisible(true);
        } else {
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{line, column});

            while (!queue.isEmpty()) {
                Integer[] temp = queue.remove();
                int tempLine = temp[1];
                int tempColumn = temp[2];

                for (int i = -1; i <= 1; i++) {
                    if (i + tempLine < 0) {
                        i++;
                    }
                    if (i + tempLine == gameField.getGameField().length) {
                        continue;
                    }
                    for (int j = -1; j <= 1; j++) {
                        if (j + tempColumn < 0) {
                            j++;
                        }

                        if (j + tempColumn == gameField.getGameField()[i].length) {
                            continue;
                        }
                        gameField.getGameField()[i + tempLine][j + tempColumn].setVisible(true);

                        if (gameField.getGameField()[i + tempLine][j + tempColumn].getCharacter().equals('\u0020')) {
                            queue.add(new Integer[]{i + tempLine, j + tempColumn});
                        }
                    }
                }
            }
        }
    }

    private void rightClickOnCell(GameField gameField, int line, int column) {
        Cell cell = gameField.getGameField()[line][column];
        if (cell.isVisible()) {
            return;
        }

        if (cell.getCharacter().equals('\u06e9')) {
            cell.setCharacter('\u003f');
        }

        if (cell.getCharacter().equals('\u003f')) {
            cell.setCharacter('\u0020');
        }

        cell.setCharacter('\u06e9');
    }
}
