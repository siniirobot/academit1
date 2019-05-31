package ru.academItSchool.gorbunov.Minesweeper.Text.View;

import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.Exceptions.Boom;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.Model;

import java.util.Scanner;

public class Game {
    public void startGame() throws Boom {
        Scanner scanner = new Scanner(System.in);
        PrintMenus printMenus = new PrintMenus();
        System.out.println(printMenus.getMainMenu());

        System.out.println("Введите номер меню.");
        String num = scanner.next();
        while (!(num.equals("1") || num.equals("2"))) {
            System.out.println("Введите номер меню.");
            num = scanner.next();
        }
        switch (num) {
            case "1":
                System.out.println(printMenus.getSettingMenu());
                System.out.println("Введите номер меню.");
                num = scanner.next();
                while (!(num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4"))) {
                    System.out.println("Введите номер меню.");
                    num = scanner.next();
                }
                switch (num) {
                    case "1":
                        Easy easy = new Easy();
                        while (easy.getGameField().getMineCount() != 0) {
                            System.out.println("Сложность: легко.         Количество мин: " + easy.getGameField().getMineCount());
                            System.out.println(easy.getGameField());
                            System.out.println("Введите колонку: ");
                            int column = scanner.nextInt();
                            System.out.println("Введите ряд");
                            int line = scanner.nextInt();
                            System.out.println("Введите 1 для открытия ячейки или 2 для пометки мины.");
                            String flag = scanner.next();
                            Model model = new Model();
                            model.clickMove(flag,easy.getGameField(),line - 1,column - 1);
                        }
                }
        }
    }

}
