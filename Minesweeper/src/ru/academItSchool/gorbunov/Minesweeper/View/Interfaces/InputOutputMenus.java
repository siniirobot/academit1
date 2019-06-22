package ru.academItSchool.gorbunov.Minesweeper.View.Interfaces;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.Timer;

public interface InputOutputMenus {
    String getMainMenu();

    String getSettingMenu();

    String getHeightScoreMenu();

    String getEndGameMenu();

    String getMenuMessage(int from, int to);

    int getInput(String[] arrayChoosingElements, String message);

    String[] getArrayChoosingElements(int from, int to);

    void getPrintGame(Model model, Difficult difficult, Timer timer);

    int[] getCoordinate(GameField gameField);
}
