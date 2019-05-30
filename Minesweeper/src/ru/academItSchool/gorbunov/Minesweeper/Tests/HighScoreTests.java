package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Model.HighScore.Player;

public class HighScoreTests {
    @DataProvider(name = "AddToTable")
    public Object[][] size() {
        return new Object[][]{
                new Object[] {new Player("PIT", 25,"easy")}
        };
    }

    @Test(dataProvider = "AddToTable")
    public void testSize(Player player) {
        HighScores highScore = new HighScores();

        highScore.add(player);
        highScore.add(new Player("siniirobot",99,"easy"));

        highScore.printHighScores("easy");
        highScore.printHighScores("norm");
        highScore.printHighScores("hard");
    }
}
