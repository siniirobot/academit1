package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty.ArbitraryDifficulty;
import ru.academItSchool.gorbunov.Minesweeper.Model.Exceptions.BoomException;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.CharactersText.CharactersText;

import static org.testng.Assert.*;

public class ModelTest {
    private Model model = new Model(new GameField(new ArbitraryDifficulty(3, 3, 3), new CharactersText()));

    @DataProvider(name = "GetPrintCount")
    public Object[][] create() {
        return new Object[][]{
                new Object[]{new GameField(new ArbitraryDifficulty(2, 1, 2), new CharactersText()), 2, 1},
        };
    }

    @DataProvider(name = "Click")
    public Object[][] clickMove() {
        return new Object[][]{
                new Object[]{1, 1, 1},
                new Object[]{0, 0, 1},
                new Object[]{0, 1, 2},
                new Object[]{1, 0, 1},
                new Object[]{2, 2, 2},
                new Object[]{2, 2, 2},
                new Object[]{2, 2, 2},
        };
    }

    @Test(dataProvider = "GetPrintCount")
    public void testGetPrintCountMine(GameField gameField, int result, int result1) {
        Model model = new Model(gameField);
        assertEquals(model.getPrintCountMine(), result);

        try {
            model.clickMove(1, 0, 2);
        } catch (BoomException b) {
            System.out.println(model.getGameField().toString());
        }

        assertEquals(model.getPrintCountMine(), result1);
    }

    @Test(dataProvider = "Click")
    public void testClickMove(int line, int column, int command) {
        try {
            model.clickMove(line, column, command);
        } catch (BoomException b) {
            System.out.println(b.getMessage());
            System.out.println(model.getGameField().toString());
        }
        System.out.println(model.getGameField().toString());
    }
}