package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;

public class Easy implements Difficult {
    private String name;
    private GameField gameField;

    public Easy() {
        this.name = "easy";
        this.gameField = new GameField(9, 9, 10, new CharactersText());
        this.gameField.fillMinesInField();
        this.gameField.fillNumbersInField();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
}
