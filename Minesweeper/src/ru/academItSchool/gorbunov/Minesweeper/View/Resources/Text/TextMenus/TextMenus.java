package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.Timer;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Menus;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;

import java.util.Arrays;
import java.util.Scanner;

public class TextMenus implements Menus {
    private Scanner scanner = new Scanner(System.in);

    public String getMainMenu() {
        return ("||//////////////////////||") + (System.lineSeparator()) +
                ("||        САПЕР!        ||") + (System.lineSeparator()) +
                ("||1) -   Начать игру.   ||") + (System.lineSeparator()) +
                ("||2) - Таблица рекордов.||") + (System.lineSeparator()) +
                ("||//////////////////////||") + (System.lineSeparator());
    }

    public String getSettingMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||     ВЫБИРЕТЕ СЛОЖНОСТЬ     ||") + (System.lineSeparator()) +
                ("||1) - Легкая сложность.      ||") + (System.lineSeparator()) +
                ("||2) - Средняя сложность.     ||") + (System.lineSeparator()) +
                ("||3) - Высокая сложность.     ||") + (System.lineSeparator()) +
                ("||4) - Произвольная сложность.||") + (System.lineSeparator()) +
                ("||5) - Назад.                 ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public String getHeightScoreMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||     ВЫБИРЕТЕ СЛОЖНОСТЬ     ||") + (System.lineSeparator()) +
                ("||1) - Легкая сложность.      ||") + (System.lineSeparator()) +
                ("||2) - Средняя сложность.     ||") + (System.lineSeparator()) +
                ("||3) - Высокая сложность.     ||") + (System.lineSeparator()) +
                ("||4) - Назад.                 ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public String getEndGameMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||           Победа           ||") + (System.lineSeparator()) +
                ("||   Вы взорвали все бомбы!   ||") + (System.lineSeparator()) +
                ("||          Нажмите 1         ||") + (System.lineSeparator()) +
                ("||      для продолжения.      ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public Object getInput(Object[] buttons) {
        String numberMenu = scanner.next();
        while (!Arrays.asList(buttons).contains(numberMenu)) {
            System.out.println("Введите цифру - " + Arrays.toString(buttons));
            numberMenu = scanner.next();
        }
        return numberMenu;
    }

    public void getPrintGame(Model model, Difficult difficult) {
        Timer timer = new Timer();
        Thread threadForTimer = new Thread(timer);
        threadForTimer.start();

        System.out.println("Сложность - " + difficult.getName());
        System.out.println("Колличество мин - " + model.getPrintCountMine());
        System.out.println("Время - " + timer.getTime());
        System.out.println();
    }
}
