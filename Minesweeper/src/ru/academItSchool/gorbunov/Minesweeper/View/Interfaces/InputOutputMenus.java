package ru.academItSchool.gorbunov.Minesweeper.View.Interfaces;

import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Difficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.Model.MyTimer;

public interface InputOutputMenus {
    String getMainMenu();

    String getSettingMenu();

    String getHeightScoreMenu();

    String getEndGameMenu();

    String getMenuMessage(int from, int to);

    int getInput(int from, int to, String message);

    void getPrintGame(Model model, Difficult difficult, MyTimer myTimer);

    int[] getCoordinate(GameField gameField);

    boolean getHighScoreWrite(MyTimer myTimer, Difficult difficult);
}
