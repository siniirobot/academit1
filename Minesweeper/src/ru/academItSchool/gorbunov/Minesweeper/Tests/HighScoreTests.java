
package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficulty.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.CharactersText.CharactersText;

public class HighScoreTests {
    @DataProvider(name = "CreateDifficult")
    public Object[][] create() {
        return new Object[][]{
                new Object[]{9, 20, 15, new CharactersText()},
                new Object[]{9, 20, 15, new CharactersImage()},
                new Object[]{-5, 20, 15, new CharactersText()},
                new Object[]{9, 35, 15, new CharactersImage()},
                new Object[]{9, 10, 9999, new CharactersImage()},
        };
    }

    @DataProvider(name = "AddToTable")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{"", 0, new EasyDifficulty()},
                new Object[]{"12", 1, new EasyDifficulty()},
                new Object[]{"Alex", 2, new EasyDifficulty()},
                new Object[]{"Eva", 26, new NormDifficulty()},
                new Object[]{"Irma", 78, new HardDifficulty()},
                new Object[]{"Cliam", 9999, new ArbitraryDifficulty(9, 9, 20)}
        };
    }

    @Test(dataProvider = "AddToTable")
    public void testAdd(String name, int time, Difficulty difficulty) {
        HighScores highScore = new HighScores();
        try {
            highScore.confirmTime(time, difficulty);
            Player player = new Player(name, time, difficulty);
            highScore.add(player);
            highScore.printHighScores(player.getDifficult());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test(dataProvider = "CreateDifficult")
    public void testCreate(int height, int width, int mineCount, Characters characters) {
        try {
            EasyDifficulty easyDifficult = new EasyDifficulty();
            NormDifficulty normDifficult = new NormDifficulty();
            HardDifficulty hardDifficult = new HardDifficulty();
            ArbitraryDifficulty arbitraryDifficulty = new ArbitraryDifficulty(height, width, mineCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}

