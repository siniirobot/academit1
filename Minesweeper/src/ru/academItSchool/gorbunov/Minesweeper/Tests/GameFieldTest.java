package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Resources.GameField.Cell;
import ru.academItSchool.gorbunov.Minesweeper.Resources.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Resources.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Player;

import java.io.IOException;
import java.sql.Time;

public class GameFieldTest {
    @DataProvider(name = "FillMineInGameField")
    public Object[][] size() {
        return new Object[][]{
                new Object[]{9, 9, 10}
        };
    }

    @Test(dataProvider = "FillMineInGameField")
    public void testSize(int height, int width, int mineCount) {
        GameField easy = new GameField(height, width, mineCount, new Cell[][]{
                {new Cell('\uD83D'), null, null, null, null, null, new Cell('\uD83D'), new Cell('\uD83D'), null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, new Cell('\uD83D'), null, null, new Cell('\uD83D'), null, null, null, null},
                {null, null, null, null, null, new Cell('\uD83D'), null, new Cell('\uD83D'), null},
                {null, null, null, null, null, null, null, new Cell('\uD83D'), null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, new Cell('\uD83D'), new Cell('\uD83D'), null, null, null,},
                {null, null, null, null, null, null, null, null, null},
        });

        GameField norm = new GameField(16,16,40);
        norm.fillMinesInField();
        norm.fillMinesInField();

        easy.fillNumbersInField();
    }
}
