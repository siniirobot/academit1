
package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.ArbitraryDifficult;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.CharactersText.CharactersText;

import java.io.IOException;

public class GameFieldTest {
    @DataProvider(name = "CreateGameField")
    public Object[][] size() {
        return new Object[][]{
                new Object[]{2, 2, 2},
                new Object[]{9, 9, 10},
                new Object[]{16, 16, 40},
                new Object[]{24, 24, 99},
                new Object[]{24, 30, 150},
        };
    }

    @Test(dataProvider = "CreateGameField")
    public void testSize(int height, int width, int mineCount) throws IOException {
        GameField norm = new GameField(new ArbitraryDifficult(height, width, mineCount), new CharactersText());

        System.out.println(norm.openCell());

    }
}

