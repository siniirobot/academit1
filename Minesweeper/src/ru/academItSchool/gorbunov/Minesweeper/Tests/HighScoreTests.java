package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Resources.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Resources.Player;

import java.sql.Time;
import java.time.OffsetTime;

public class HighScoreTests {
    @DataProvider(name = "AddToTable")
    public Object[][] size() {
        return new Object[][]{
                new Object[] {new Player("PIT", Time.valueOf("15:05:15"),"easy")}
        };
    }

    @Test(dataProvider = "AddToTable")
    public void testSize(Player player){
        HighScores highScore = new HighScores();

        highScore.add(player);
        System.out.println(highScore);
    }
}
