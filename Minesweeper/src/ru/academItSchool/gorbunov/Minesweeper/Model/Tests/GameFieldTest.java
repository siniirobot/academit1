
package ru.academItSchool.gorbunov.Minesweeper.Model.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;

public class GameFieldTest {
    @DataProvider(name = "FillMineInGameField")
    public Object[][] size() {
        return new Object[][]{
                new Object[]{9, 9, 10},
                new Object[]{16, 30, 99},
                new Object[]{24, 30, 468},
        };
    }

    @Test(dataProvider = "FillMineInGameField")
    public void testSize(int height, int width, int mineCount) {
        GameField norm = new GameField(height,width,mineCount, new CharactersText());
        norm.fillMinesInField();
        norm.fillNumbersInField();

        System.out.println(norm);
    }
}

