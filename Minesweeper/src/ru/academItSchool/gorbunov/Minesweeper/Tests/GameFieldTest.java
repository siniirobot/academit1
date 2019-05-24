package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Resources.GameField.Cell;
import ru.academItSchool.gorbunov.Minesweeper.Resources.GameField.GameField;

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
                {new Cell('\uD83D',new int[]{0,0}), null, null, null, null, null, new Cell('\uD83D',new int[]{0,6}), new Cell('\uD83D',new int[]{0,7}), null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, new Cell('\uD83D',new int[]{3,1}), null, null, new Cell('\uD83D',new int[]{3,4}), null, null, null, null},
                {null, null, null, null, null, new Cell('\uD83D',new int[]{4,5}), null, new Cell('\uD83D',new int[]{4,7}), null},
                {null, null, null, null, null, null, null, new Cell('\uD83D',new int[]{5,7}), null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, new Cell('\uD83D',new int[]{7,4}), new Cell('\uD83D',new int[]{7,5}), null, null, null,},
                {null, null, null, null, null, null, null, null, null},
        });

        GameField norm = new GameField(16,16,40);
        norm.fillMinesInField();
        norm.fillNumbersInField();

        easy.fillNumbersInField();

        System.out.println(norm);
    }
}
