package ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.TextMenus;

public class PrintMenus {
    public String getTextMainMenu() {
        return ("||//////////////////////||") + (System.lineSeparator()) +
                ("||        САПЕР!        ||") + (System.lineSeparator()) +
                ("||1) -   Начать игру.   ||") + (System.lineSeparator()) +
                ("||2) - Таблица рекордов.||") + (System.lineSeparator()) +
                ("||//////////////////////||") + (System.lineSeparator());
    }

    public String getTextSettingMenu() {
        return ("||////////////////////////////||") + (System.lineSeparator()) +
                ("||     ВЫБИРЕТЕ СЛОЖНОСТЬ     ||") + (System.lineSeparator()) +
                ("||1) - Легкая сложность.      ||") + (System.lineSeparator()) +
                ("||2) - Средняя сложность.     ||") + (System.lineSeparator()) +
                ("||3) - Высокая сложность.     ||") + (System.lineSeparator()) +
                ("||4) - Произвольная сложность.||") + (System.lineSeparator()) +
                ("||5) - Назад.                 ||") + (System.lineSeparator()) +
                ("||////////////////////////////||") + (System.lineSeparator());
    }

    public String getTextHightScoreMenu() {
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
}
