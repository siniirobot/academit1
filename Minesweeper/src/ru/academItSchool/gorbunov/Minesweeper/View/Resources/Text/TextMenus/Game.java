package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.EndGame;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;

import java.util.Scanner;

public class Game {
    public void startGame() throws Boom {

        Scanner scanner = new Scanner(System.in);
        TextInputOutputMenus textMenus = new TextInputOutputMenus();
        System.out.println(textMenus.getMainMenu());

        System.out.println("Введите номер меню.");
        String num = scanner.next();
        while (!(num.equals("1") || num.equals("2"))) {
            System.out.println("Введите номер меню.");
            num = scanner.next();
        }
        switch (num) {
            case "1":
                System.out.println(textMenus.getSettingMenu());
                System.out.println("Введите номер меню.");
                num = scanner.next();
                while (!(num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4"))) {
                    System.out.println("Введите номер меню.");
                    num = scanner.next();
                }
                switch (num) {
                    case "1":
                        Easy easy = new Easy();
                        Model model = new Model(new GameField(easy.getRowCount(),easy.getColumnCount(),easy.getMines(),new CharactersText()));
                        try {
                            while (true) {

                                System.out.println("Сложность: легко.         Количество мин: " + model.getPrintCountMine());
                                System.out.println(model.getGameField());
                                System.out.println("Введите колонку: ");
                                int column = scanner.nextInt();
                                System.out.println("Введите ряд");
                                int line = scanner.nextInt();
                                System.out.println("Введите 1 для открытия ячейки или 2 для пометки мины.");
                                int flag = scanner.nextInt();
                                model.clickMove(flag, line - 1, column - 1);
                            }
                        } catch (Boom b) {
                            System.out.println("Игра окончена" + b);
                        } /*catch (EndGame endGame) {
                            System.out.println(textMenus.getEndGameMenu());
                            String highScore = scanner.next();
                            while (!highScore.equals("1")) {
                                System.out.println("Нажмите 1!");
                                highScore = scanner.next();
                            }
                            System.out.println("Сложность: легко.         Количество мин: " + model.getPrintCountMine());
                            System.out.println(model.getGameField());
                            HighScores newPlayer = new HighScores();
                            newPlayer.add(new Player("siniirobot",55,easy));
                            newPlayer.printHighScores(easy.getName());
                        }*/
                }
        }
    }

}
