package ru.academItSchool.gorbunov.Minesweeper.Model.Tests;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.Model.Model;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.CharactersText.CharactersText;

import static org.testng.Assert.*;

public class ModelTest {
    @DataProvider(name = "GetPrintCount")
    public Object[][] create() {
        return new Object[][]{
                new Object[]{new GameField(4,4,2,new CharactersText()),2},
        };
    }

    @Test (dataProvider = "GetPrintCount")
    public void testGetPrintCountMine(GameField gameField, int result) {
        Model model = new Model(gameField);
        assertEquals(model.getPrintCountMine(),result);
    }

    @Test
    public void testGetGameField() {
    }

    @Test
    public void testClickMove() {
    }
}