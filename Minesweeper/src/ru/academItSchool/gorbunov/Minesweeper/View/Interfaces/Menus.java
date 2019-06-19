package ru.academItSchool.gorbunov.Minesweeper.View.Interfaces;

public interface Menus {
    String getMainMenu();

    String getSettingMenu();

    String getHeightScoreMenu();

    String getEndGameMenu();

    Object getInput(Object[] buttons);
}
