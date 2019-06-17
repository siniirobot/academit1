
package ru.academItSchool.gorbunov.Minesweeper.Model.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.academItSchool.gorbunov.Minesweeper.Model.Difficult.Easy;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.HighScores;
import ru.academItSchool.gorbunov.Minesweeper.Model.HighScore.Player;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;

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

        CharactersText charactersText = new CharactersText();
        Easy easy = new Easy(charactersText);
        Player player = new Player("Xewewt",25,easy.getName());
        highScore.add(player);

        highScore.printHighScores(new Easy(new CharactersText()));
    }
}

