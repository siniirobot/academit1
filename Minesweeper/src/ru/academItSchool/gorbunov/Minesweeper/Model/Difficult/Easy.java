package ru.academItSchool.gorbunov.Minesweeper.Model.Difficult;

import ru.academItSchool.gorbunov.Minesweeper.Model.GameField.GameField;
import ru.academItSchool.gorbunov.Minesweeper.View.Interfaces.Characters;
import ru.academItSchool.gorbunov.Minesweeper.View.Resources.Text.CharactersText.CharactersText;

public class Easy implements Difficult {
    private nameDifficult name;
    private GameField gameField;

    public Easy(Characters characters) {
        this.name = nameDifficult.EASY;
        this.gameField = new GameField(9, 9, 10, characters);
        this.gameField.fillMinesInField();
        this.gameField.fillNumbersInField();
    }

    @Override
    public nameDifficult getName() {
        return this.name;
    }

    public void setName(nameDifficult name) {
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
