package ru.academItSchool.gorbunov.Minesweeper.View.Interfaces;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;

public interface InputOutputMenus {
    String getMainMenu();

    String getSettingMenu();

    String getHeightScoreMenu();

    String getEndGameMenu();

    int getInput(int from , int to);

    int getInput(String[] arrayChoosingElements, StringBuilder choosingElements);

    void getPrintGame(Model model, Difficult difficult);

    int[] getCoordinate(GameField gameField);
}
