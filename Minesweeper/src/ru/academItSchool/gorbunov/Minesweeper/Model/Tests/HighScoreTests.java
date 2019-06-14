package ru.academItSchool.gorbunov.Minesweeper.Model.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;

public class HighScoreTests {
    @DataProvider(name = "AddToTable")
    public Object[][] size() {
        return new Object[][]{
                new Object[] {}
        };
    }

    @Test(dataProvider = "AddToTable")
    public void testSize() {
        HighScores highScore = new HighScores();

        highScore.add(new Player("Xewewt",0,"easy"));

        highScore.printHighScores("easy");
        highScore.printHighScores("norm");
        highScore.printHighScores("hard");
    }
}
