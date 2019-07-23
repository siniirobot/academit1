
package ru.academItSchool.gorbunov.Minesweeper.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.*;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.GUI.Resources.CharactersImage.CharactersImage;
import ru.academItSchool.gorbunov.Minesweeper.View.Text.Resources.CharactersText.CharactersText;

import java.io.IOException;

public class HighScoreTests {
    @DataProvider(name = "CreateDifficult")
    public Object[][] create() throws IOException {
        return new Object[][]{
                new Object[]{9, 20, 15, new CharactersText()},
                new Object[]{9, 20, 15, new CharactersImage()},
                new Object[]{-5, 20, 15, new CharactersText()},
                new Object[]{9, 35, 15, new CharactersImage()},
                new Object[]{9, 10, 999, new CharactersImage()},
        };
    }

    @DataProvider(name = "AddToTable")
    public Object[][] add() {
        return new Object[][]{
                new Object[]{"", 999, new Easy()},
                new Object[]{"12454435154534", 74, new Easy()},
                new Object[]{"Alex", 999, new Easy()},
                new Object[]{"Eva", 999, new Norm()},
                new Object[]{"Irma", 999, new Hard()},
                new Object[]{"Cliam", 999, new Arbitrary(9,9,20)}
        };
    }

    @Test(dataProvider = "AddToTable")
    public void testAdd(String name, int time, Difficult difficult) {
        HighScores highScore = new HighScores();
        try{
            Player player = new Player(name, time, difficult);
            highScore.add(player);
            highScore.printHighScores(player.getDifficult());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test(dataProvider = "CreateDifficult")
    public void testCreate(int height, int width, int mineCount, Characters characters) {
        try {
            Easy easy = new Easy();
            Norm norm = new Norm();
            Hard hard = new Hard();
            Arbitrary arbitrary = new Arbitrary(height,width,mineCount);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

