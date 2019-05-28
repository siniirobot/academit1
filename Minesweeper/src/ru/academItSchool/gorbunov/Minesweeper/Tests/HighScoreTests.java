package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.HighScore.Player;

import java.io.IOException;
import java.sql.Time;

public class HighScoreTests {
    @DataProvider(name = "AddToTable")
    public Object[][] size() {
        return new Object[][]{
                new Object[] {new Player("PIT", Time.valueOf("15:05:15"),"easy")}
        };
    }

    @Test(dataProvider = "AddToTable")
    public void testSize(Player player) {
        HighScores highScore = new HighScores();

        highScore.add(player);
        highScore.add(new Player("siniirobot",Time.valueOf("25:04:22"),"easy"));

        highScore.printHighScores("hard");
        highScore.printHighScores("easy");
        highScore.printHighScores("norm");
    }
}
