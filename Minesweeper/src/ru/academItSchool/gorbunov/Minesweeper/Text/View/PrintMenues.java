package ru.academItSchool.gorbunov.Minesweeper.Text.View;

public class PrintMenues {
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
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public String getHightScoreMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||     ВЫБИРЕТЕ СЛОЖНОСТЬ     ||") + (System.lineSeparator()) +
                ("||1) - Легкая сложность.      ||") + (System.lineSeparator()) +
                ("||2) - Средняя сложность.     ||") + (System.lineSeparator()) +
                ("||3) - Высокая сложность.     ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }
}
