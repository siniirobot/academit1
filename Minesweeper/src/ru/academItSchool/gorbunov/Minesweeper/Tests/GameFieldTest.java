package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.GameField.GameField;

public class GameFieldTest {
    @DataProvider(name = "FillMineInGameField")
    public Object[][] size() {
        return new Object[][]{
                new Object[]{9, 9, 10}
        };
    }

    @Test(dataProvider = "FillMineInGameField")
    public void testSize(int height, int width, int mineCount) {
        GameField norm = new GameField(16,16,40);
        norm.fillMinesInField();
        norm.fillNumbersInField();

        System.out.println(norm);
    }
}
